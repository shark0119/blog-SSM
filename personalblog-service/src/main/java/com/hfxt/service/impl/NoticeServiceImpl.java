package com.hfxt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hfxt.domain.vo.NoticeVo;
import com.hfxt.service.INoticeService;

import common.utils.RedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

@Service("impl.service.NoticeServiceImpl")
public class NoticeServiceImpl implements INoticeService{
	
	// 通知： hashes  key:hash_#{blogId}_notice | field:notice.noticeId | value: notice
	// 个数： string  string_#{key}_count
	private Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	public boolean addNotice(NoticeVo notice, int receiverId) throws Exception {
		if (notice.getNoticeId() == null)
			notice.setNoticeId(UUID.randomUUID().toString());
		logger.debug("入参为：" + notice + receiverId);
		Jedis jedis = null;
		Transaction trans = null;
		try{
			jedis = RedisUtil.getJedis();
			String stringKey = "string_".concat(generateKey(receiverId).concat("_count"));
			trans = jedis.multi();
			if (notice.getState().equals(NoticeVo.STATE_UNREAD)){
				trans.incr(stringKey.getBytes());
			}else if (notice.getState().equals(NoticeVo.STATE_READED)){
				trans.decr(stringKey.getBytes());
			}
			Response<Long> result = trans.hset(generateKey(receiverId).getBytes(), 
					notice.getNoticeId().getBytes(), 
					JSON.toJSONString(notice).getBytes());
			trans.exec();
			return result.get() == 1;
		} catch (Exception e){
			e.printStackTrace();
			logger.info("保存通知发生异常" + e);
			if (trans != null)
				trans.discard();
			return false;
		} finally {
			if (jedis != null)
				RedisUtil.returnResource(jedis);
		}
	}

	public List<NoticeVo> getNoticeByUserId(int userId) throws Exception {
		logger.debug("入参为:" + userId);
		List <NoticeVo> notices = null;
		Jedis jedis = null;
		try{
			jedis = RedisUtil.getJedis();
			String key = generateKey(userId);
			Set<byte[]> fields = jedis.hkeys(key.getBytes());
			notices = new ArrayList<NoticeVo>();
			for (byte[] field : fields){
				try{
					notices.add(JSON.parseObject(new String (jedis.hget(key.getBytes(), field)), NoticeVo.class));
				} catch (Exception e){
					logger.info("发生异常" + e);
				}
			}
			return notices;
		} catch (Exception e){
			e.printStackTrace();
			logger.info("获取通知发生异常" + e);
			return null;
		} finally {
			if (jedis != null)
				RedisUtil.returnResource(jedis);
		}
	}

	public boolean deleteNotice(String noticeId, int receiverId) throws Exception {
		logger.debug("入参为:" + noticeId);
		Jedis jedis = null;
		Transaction trans = null;
		try{
			jedis = RedisUtil.getJedis();
			long count = 0; 
			if (getNotice(receiverId, noticeId, jedis).getState().equals(NoticeVo.STATE_UNREAD)){
				trans = jedis.multi();
				Response<Long> response = trans.hdel(generateKey(receiverId).getBytes(), noticeId.getBytes());
				String stringKey = "string_".concat(generateKey(receiverId).concat("_count"));
				trans.decr(stringKey.getBytes());
				trans.exec();
				count = response.get();
			}else{
				count = jedis.hdel(generateKey(receiverId).getBytes(), noticeId.getBytes());
			}
			return count == 1;
		} catch (Exception e){
			e.printStackTrace();
			logger.info("保存通知发生异常" + e);
			if (trans != null)
				trans.discard();
			return false;
		} finally {
			if (jedis != null)
				RedisUtil.returnResource(jedis);
		}
	}

	public int getUnreadNoticeCount(int receiverId) throws Exception {
		logger.debug("入参为：" + receiverId);
		Jedis jedis = null;
		try{
			jedis = RedisUtil.getJedis();
			String stringKey = "string_".concat(generateKey(receiverId).concat("_count"));
			byte[] result = jedis.get(stringKey.getBytes());
			return new Integer(new String(result));
		}catch (Exception e){
			e.printStackTrace();
			logger.info("获取总数失败" + e);
			return 0;
		} finally {
			if (jedis != null)
				RedisUtil.returnResource(jedis);
		}
	}

	public void deleteAllNotices(int receiverId) throws Exception {
		generateKey(receiverId);
		logger.debug("入参为：" + receiverId);
		Jedis jedis = null;
		Transaction trans = null;
		try{
			jedis = RedisUtil.getJedis();
			String stringKey = "string_".concat(generateKey(receiverId).concat("_count"));
			trans = jedis.multi();
			trans.del(generateKey(receiverId).getBytes());
			trans.del(stringKey.getBytes());
			trans.exec();
		}catch (Exception e){
			logger.info("获取总数失败" + e);
			if (trans != null)
				trans.discard();
		} finally {
			if (jedis != null)
				RedisUtil.returnResource(jedis);
		}
	}

	protected String generateKey (int id){
		return new String("hash_" + id + "_notice");
	}
	protected NoticeVo getNotice (int userId, String noticeId, Jedis jedis){		
		NoticeVo notice = null;
		String key = generateKey(userId);
		byte [] result = jedis.hget(key.getBytes(), noticeId.getBytes());
		notice = JSON.parseObject(new String(result), NoticeVo.class);
		return notice;
	}
}