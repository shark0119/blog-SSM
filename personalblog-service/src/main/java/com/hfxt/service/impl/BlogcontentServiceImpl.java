package com.hfxt.service.impl;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfxt.domain.search.BlogcontentSearch;
import com.hfxt.domain.vo.BlogcontentVo;
import com.hfxt.service.IBlogcontentService;

import common.exception.CustomException;

@Service("service.impl.BlogcontentServiceImpl")
public class BlogcontentServiceImpl extends BaseService implements IBlogcontentService {

    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	//增加博客内容
	public int addBlogcontent(BlogcontentVo blogcontent)throws CustomException {
		Integer currentId = -1;
		try {
			currentId = blogcontentDao.getMaxId();
			currentId = blogDao.getMaxId();
			if(currentId!=null){
				blogcontent.setBlogContentId(++currentId);
				
			}else{
				currentId = 1;
				blogcontent.setBlogContentId(currentId);
			}
			//向数据库添加记录，失败返回-1
			if (1 != blogcontentDao.addBlogcontent(blogcontent))
				currentId = -1;
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
		return currentId;
	}
	//根据id查询博客内容
	public BlogcontentVo findContentById(Integer blogId)
			throws CustomException {
		try {
			BlogcontentVo blogcontentVo=blogcontentDao.findContentById(blogId);
	        return blogcontentVo;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	//删除单条博客内容
	public int deleteBlogContent(Integer blogContentId) throws CustomException {
		try {
			int result=blogcontentDao.deleteBlogContent(blogContentId);
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
	//根据blogContentid修改博客
	public int updateBlogContent(BlogcontentVo blogcontentVo) throws CustomException {
		try {
			int result=blogcontentDao.updateBlogContent(blogcontentVo);
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
	//根据blogcontentId获取博客
	public BlogcontentVo findContentByBctId(Integer blogcontentId)
			throws CustomException {
		try {
			BlogcontentVo blogcontentVo=blogcontentDao.findContentByBctId(blogcontentId);
	        return blogcontentVo;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	
	
	
	public List<BlogcontentVo> findBlogContentByLabelName(String LabelName)
			throws CustomException {
		try {
			List<BlogcontentVo> blogcontentVos=blogcontentDao.findBlogContentByLabelName(LabelName);
	        return blogcontentVos;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id + '_' + #chooseRM")
	public BlogcontentVo getVo_Auto(Long id, int chooseRM) throws CustomException {
		try {
			BlogcontentVo result = blogcontentDao.getVo_Auto(id, chooseRM);
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
			boolean result = blogcontentDao.isExist_Auto(id);
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
	public long queryCount_Auto(BlogcontentSearch search) throws CustomException {
		try {
			long count = blogcontentDao.queryCount_Auto(search);
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
	public List<BlogcontentVo> queryVos_Auto(BlogcontentSearch search) throws CustomException {
		try {
			List<BlogcontentVo> result = blogcontentDao.queryVos_Auto(search);
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
	public BlogcontentVo queryVo_Auto(BlogcontentSearch search) throws CustomException {
		try {
			List<BlogcontentVo> result = blogcontentDao.queryVos_Auto(search);
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
	public long save_AdminAdd(BlogcontentVo addVo) throws CustomException {
		try {
			long addResult = blogcontentDao.saveSelective(addVo);
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
			// BlogcontentVo vo = blogcontentDao.getVo_Auto(id, BlogcontentSearch.RM_Default);
			// if (vo == null) {
			// return -1l;
			// }
			long deleteResult = blogcontentDao.delete(id);
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
	public long edit_AdminEdit(BlogcontentVo editVo) throws CustomException {
		try {
			long editResult = blogcontentDao.updateSelective(editVo);
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
	public BlogcontentVo getVo_AdminView(Long id) throws CustomException {
		try {
			BlogcontentVo vo = blogcontentDao.getVo_AdminView(id,0);
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
	public BlogcontentVo getVo_preAdminEdit(Long id) throws CustomException {
		try {
			BlogcontentVo vo = blogcontentDao.getVo_preAdminEdit(id,0);
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
	public BlogcontentVo getVo_AdminEdit(Long id) throws CustomException {
		try {
			BlogcontentVo vo = blogcontentDao.getVo_AdminEdit(id,0);
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
