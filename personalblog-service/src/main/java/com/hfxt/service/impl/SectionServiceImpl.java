package com.hfxt.service.impl;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfxt.domain.search.SectionSearch;
import com.hfxt.domain.vo.SectionVo;
import com.hfxt.service.ISectionService;
import common.exception.CustomException;

@Service("service.impl.SectionServiceImpl")
public class SectionServiceImpl extends BaseService implements ISectionService {
  	

    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id + '_' + #chooseRM")
	public SectionVo getVo_Auto(Long id, int chooseRM) throws CustomException {
		try {
			SectionVo result = sectionDao.getVo_Auto(id, chooseRM);
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
			boolean result = sectionDao.isExist_Auto(id);
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
	public long queryCount_Auto(SectionSearch search) throws CustomException {
		try {
			long count = sectionDao.queryCount_Auto(search);
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
	public List<SectionVo> queryVos_Auto(SectionSearch search) throws CustomException {
		try {
			List<SectionVo> result = sectionDao.queryVos_Auto(search);
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
	public SectionVo queryVo_Auto(SectionSearch search) throws CustomException {
		try {
			List<SectionVo> result = sectionDao.queryVos_Auto(search);
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
	public long save_AdminAdd(SectionVo addVo) throws CustomException {
		try {
			long addResult = sectionDao.saveSelective(addVo);
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
			// SectionVo vo = sectionDao.getVo_Auto(id, SectionSearch.RM_Default);
			// if (vo == null) {
			// return -1l;
			// }
			long deleteResult = sectionDao.delete(id);
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
	public long edit_AdminEdit(SectionVo editVo) throws CustomException {
		try {
			long editResult = sectionDao.updateSelective(editVo);
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
	public SectionVo getVo_AdminView(Long id) throws CustomException {
		try {
			SectionVo vo = sectionDao.getVo_AdminView(id,0);
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
	public SectionVo getVo_preAdminEdit(Long id) throws CustomException {
		try {
			SectionVo vo = sectionDao.getVo_preAdminEdit(id,0);
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
	public SectionVo getVo_AdminEdit(Long id) throws CustomException {
		try {
			SectionVo vo = sectionDao.getVo_AdminEdit(id,0);
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


	public List<SectionVo> getAllSections() throws Exception {
		// TODO Auto-generated method stub
		return sectionDao.getAllSections();
	}


	public int addSection(SectionVo section) throws Exception {
		// TODO Auto-generated method stub
		return sectionDao.addSection(section);
	}


	public int updateSection(SectionVo section) throws Exception {
		// TODO Auto-generated method stub
		return sectionDao.updateSection(section);
	}


	public int deleteSection(Integer sectionid) throws Exception {
		// TODO Auto-generated method stub
		return sectionDao.deleteSection(sectionid);
	}


	public int getAllSectionCount(Integer sectionid) throws Exception {
		return sectionDao.getAllSectionCount(sectionid);
	}


	public SectionVo getSectionById(Integer sectionid) throws Exception {
		// TODO Auto-generated method stub
		return sectionDao.getSectionById(sectionid);
	}


	public SectionVo getSectionVoByName(String sectionName) throws Exception {
		// TODO Auto-generated method stub
		return sectionDao.getSectionVoByName(sectionName);
	}
 
}
