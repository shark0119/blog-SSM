package com.hfxt.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.hfxt.jedis.dao.IRedisBlogLivenessDao;
import com.hfxt.jedis.dao.impl.RedisBlogLivenessDao;
import com.hfxt.service.IJedisBlogLivenessService;

import common.utils.RedisUtil;

@Service("service.impl.JedisBlogLivenessService")
public class JedisBlogLivenessServiceImpl extends BaseService implements IJedisBlogLivenessService {

	private Logger logger = LoggerFactory.getLogger(JedisBlogLivenessServiceImpl.class);
	
	private IRedisBlogLivenessDao redisBlogLivenessDao ;
	public JedisBlogLivenessServiceImpl (){
		try {
			redisBlogLivenessDao = new RedisBlogLivenessDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 博客新增动态
	 * @param userId 用户ID
	 * @param ipAddress 用户所在IP地址
	 * @param blogId 博客ID
	 * @param index 四种指标
	 * @throws Exception
	 */
	public void blogAddLiveness(int userId, String ipAddress, int blogId, String index) throws Exception {
		if (!indexAvail(index))
			throw new Exception("博客暂无此指标");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		StringBuilder newLivenessField = new StringBuilder(ipAddress + "_" + userId + "_" + blogId);
		StringBuilder livenessKey = new StringBuilder(blogId + "_" + year + "_" + month);
		//对于点赞，点击和踩，同一IP的用户对于同一文章的操作只能有一次
		if (!index.equals(INDEX_COMMENT)){
			//添加成功
			if (redisBlogLivenessDao.add(new String(blogId + "_" + index), 
										newLivenessField.toString().replace(".", "_"),
										Integer.toString(blogId)))
				redisBlogLivenessDao.inc(livenessKey.toString(), index);
		} else {
			redisBlogLivenessDao.inc(new Integer(blogId).toString());
			redisBlogLivenessDao.inc(livenessKey.toString(), index);
		}
	}

	public void flush(int blogId) throws Exception {
		redisBlogLivenessDao.delete(blogId + "_" + INDEX_BAD);
		redisBlogLivenessDao.delete(blogId + "_" + INDEX_CLICK);
		redisBlogLivenessDao.delete(blogId + "");
		redisBlogLivenessDao.delete(blogId + "_" + INDEX_GOOD);
	}

	public int getBlogLivenessCount(int blogId, String index) throws Exception {
		logger.debug("获取博客动态总数，博客ID为：" + blogId + ",指标是：" + index);
		if (!indexAvail(index))
			throw new Exception("博客暂无此指标");
		Jedis jedis = null;
		try{
			int count = 0;
			jedis = RedisUtil.getJedis();
			Set <byte[]> keys = jedis.keys(new String(blogId + "*").getBytes());
			for (byte[] key : keys){
				logger.debug(jedis.type(key));
				if (jedis.type(key).equalsIgnoreCase("hash")){
					try {
						count += Integer.valueOf(new String(jedis.hget(key, index.getBytes())));
					} catch (Exception e) {	}
				}
			}
			return count;
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		} finally {
			if (jedis != null){
				RedisUtil.returnResource(jedis);
			}
		}
	}
	/**
	 * 博客动态自减，只在删除评论时使用
	 * @param blogId 博客ID
	 * @throws Exception
	 */
	public void blogDelComment (int blogId) throws Exception {
		redisBlogLivenessDao.decr( new Integer(blogId).toString() );
	}
	public int getBlogNewLivenessCount(int blogId, String index)
			throws Exception {
		logger.debug("博客ID为：" + blogId + ",指标是：" + index);
		Jedis jedis = null;
		if (!indexAvail(index))
			throw new Exception("博客暂无此指标");
		try{
			if (index.equals(INDEX_COMMENT)){
				byte [] result = redisBlogLivenessDao.get(blogId + "");
				if (result == null)
					logger.debug("result is null");
				else
					logger.debug("result is :" + new String(result));
				try{
					if (result == null || result.length == 0)
						return 0;
					String str = new String(result);
					return Integer.valueOf(str);
				} catch (Exception e){
					logger.debug("博客最新点赞数获取失败" + e);
					return 0;
				}
			}
			jedis = RedisUtil.getJedis();
			return new Long(jedis.hlen(blogId + "_" + index)).intValue();
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		} finally{
			if (jedis != null)
				RedisUtil.returnResource(jedis);
		}
	}

	private boolean indexAvail(String index) {
		if (!index.equals(IJedisBlogLivenessService.INDEX_BAD))
			if (!index.equals(IJedisBlogLivenessService.INDEX_CLICK))
				if (!index.equals(IJedisBlogLivenessService.INDEX_COMMENT))
					if (!index.equals(IJedisBlogLivenessService.INDEX_GOOD))
						return false;
		return true;
	}
	public void blogDrawGood(int userId, String ipAddress, int blogId) throws Exception {
		StringBuilder newLivenessField = new StringBuilder(ipAddress + "_" + userId + "_" + blogId);
		redisBlogLivenessDao.hdel(new String(blogId + "_" + INDEX_GOOD), newLivenessField.toString().replace(".", "_"));
	}
	public void blogDrawBad(int userId, String ipAddress, int blogId) throws Exception {
		StringBuilder newLivenessField = new StringBuilder(ipAddress + "_" + userId + "_" + blogId);
		redisBlogLivenessDao.hdel(new String(blogId + "_" + INDEX_BAD), newLivenessField.toString().replace(".", "_"));
	}
}