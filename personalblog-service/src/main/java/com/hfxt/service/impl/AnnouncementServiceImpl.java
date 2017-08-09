package com.hfxt.service.impl;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */

import java.util.List;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.hfxt.domain.search.AnnouncementSearch;
import com.hfxt.domain.vo.AnnouncementVo;
import com.hfxt.service.IAnnouncementService;

import common.exception.CustomException;
import common.utils.RedisUtil;

@Service("service.impl.AnnouncementServiceImpl")
public class AnnouncementServiceImpl extends BaseService implements IAnnouncementService {
  	

    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	
	public Jedis getJedis() {
		
		return RedisUtil.getMyJedis();
	};
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id + '_' + #chooseRM")
	public AnnouncementVo getVo_Auto(Long id, int chooseRM) throws CustomException {
		try {
			AnnouncementVo result = announcementDao.getVo_Auto(id, chooseRM);
			return result;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
    
    
    /**
	 * 传入id,判断是否存在该记录
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id")
	public boolean isExist_Auto(Long id) throws CustomException {
		try {
			boolean result = announcementDao.isExist_Auto(id);
			return result;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
    
    
    /**
	 * 查询所有记录的数量
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id")
	public long queryCount_Auto(AnnouncementSearch search) throws CustomException {
		try {
			long count = announcementDao.queryCount_Auto(search);
			return count;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	/**
	 * 查询所有记录
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #search.hashCode()")
	public List<AnnouncementVo> queryVos_Auto(AnnouncementSearch search) throws CustomException {
		try {
			List<AnnouncementVo> result = announcementDao.queryVos_Auto(search);
			return result;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
    
    /**
	 * 查询单条记录
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #search.hashCode()")
	public AnnouncementVo queryVo_Auto(AnnouncementSearch search) throws CustomException {
		try {
			List<AnnouncementVo> result = announcementDao.queryVos_Auto(search);
			return result == null || result.isEmpty() ? null : result.get(0);
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	/**
	 * 后台新增
	 */
	// @CacheEvict(value = "", allEntries = true, beforeInvocation = true)
	public long save_AdminAdd(AnnouncementVo addVo) throws CustomException {
		try {
			long addResult = announcementDao.saveSelective(addVo);
			return addResult;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	/**
	 * 后台删除
	 */
	// @CacheEvict(value = "", allEntries = true, beforeInvocation = true)
	public long delete_AdminDelete(Long id) throws CustomException {
		try {
			// AnnouncementVo vo = announcementDao.getVo_Auto(id, AnnouncementSearch.RM_Default);
			// if (vo == null) {
			// return -1l;
			// }
			long deleteResult = announcementDao.delete(id);
			return deleteResult;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	/**
	 * 后台编辑
	 */
	// @CacheEvict(value = "", allEntries = true, beforeInvocation = true)
	public long edit_AdminEdit(AnnouncementVo editVo) throws CustomException {
		try {
			long editResult = announcementDao.updateSelective(editVo);
			return editResult;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	/**
	 * 后台查看详情
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id")
	public AnnouncementVo getVo_AdminView(Long id) throws CustomException {
		try {
			AnnouncementVo vo = announcementDao.getVo_AdminView(id,0);
			return vo;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	/**
	 * 后台查询编辑
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id")
	public AnnouncementVo getVo_preAdminEdit(Long id) throws CustomException {
		try {
			AnnouncementVo vo = announcementDao.getVo_preAdminEdit(id,0);
			return vo;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	/**
	 * 后台编辑
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id")
	public AnnouncementVo getVo_AdminEdit(Long id) throws CustomException {
		try {
			AnnouncementVo vo = announcementDao.getVo_AdminEdit(id,0);
			return vo;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
 
}
