package com.hfxt.service.impl;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfxt.domain.search.BlogSearch;
import com.hfxt.domain.vo.BlogVo;
import com.hfxt.domain.vo.BlogcontentVo;
import com.hfxt.service.IBlogService;

import common.exception.CustomException;

@Service("service.impl.BlogServiceImpl")
public class BlogServiceImpl extends BaseService implements IBlogService {
  	

    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////

	//添加博客
	public int addBlog(BlogVo blog) throws CustomException {
		Integer currentId = -1;
		try {
				
			currentId = blogDao.getMaxId();
				if(currentId!=null){
					blog.setBlogId(++currentId);
					
				}else{
					currentId = 1;
					blog.setBlogId(currentId);
				}
			//向数据库添加记录，失败返回-1
			if (1 != blogDao.addBlog(blog))
				currentId = -1;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
		return currentId;
	}

	//查询所有博客
	public List<BlogcontentVo> findAllBlog() throws CustomException {
		try {
			 List<BlogcontentVo> BlogcontentVos=blogDao.findAllBlog();
			return BlogcontentVos;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	
	//删除单条博客
	public int deleteBlog(Integer blogContentId) throws CustomException {
		try {
		int result=blogDao.deleteBlog(blogContentId);
		if(result>0){
			blogcontentDao.deleteBlogContent(blogContentId);
		}
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
	//根据ID修改博客
	public int updateBlog(BlogVo blogVo) throws CustomException {
		try {
			int result=blogDao.updateBlog(blogVo);
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
	//查询所有草稿箱博客内容
	public List<BlogcontentVo> findAllDraftBlog() throws CustomException {
		try {
			 List<BlogcontentVo> BlogcontentVos=blogDao.findAllDraftBlog();
			return BlogcontentVos;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	//查询前台所有博客内容（公开为1，加密2）
	public List<BlogcontentVo> findAllPublicBlog() throws CustomException {
		try {
			 List<BlogcontentVo> BlogcontentVos=blogDao.findAllPublicBlog();
			return BlogcontentVos;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	//根据userId查询博客内容
	public List<BlogcontentVo> findBlogByUserId(Integer userId)
			throws CustomException {
		try {
			 List<BlogcontentVo> BlogcontentVos=blogDao.findBlogByUserId(userId);
			 return BlogcontentVos;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	//根据userId查询所有草稿箱博客内容
	public List<BlogcontentVo> findAllDraftBlogByUserId(Integer userId)
			throws CustomException {
		try {
			 List<BlogcontentVo> BlogcontentVos=blogDao.findAllDraftBlogByUserId(userId);
			 return BlogcontentVos;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	
	//查询所有未审核的文章
	public List<BlogcontentVo> findAllNotCheckBlog() throws CustomException {
		try {
			 List<BlogcontentVo> BlogcontentVos=blogDao.findAllNotCheckBlog();
			 return BlogcontentVos;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}

	
	public BlogVo findBlogById(Integer blogId) throws CustomException {
		try {
			BlogVo blogVo=blogDao.findBlogById(blogId);
			return blogVo;
		}
		catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage(), ex);
			}
			ex.printStackTrace();
			throw new CustomException(ex);
		}
	}
	
	

	public List<BlogcontentVo> findIndexPage(Integer currentPage,
			Integer pageSize) throws CustomException {
		try {
			List<BlogcontentVo> blogcontentVos=blogDao.findIndexPage(currentPage, pageSize);
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

	
	
	public int findBlogCount() throws CustomException {
		try {
			int count=blogDao.findBlogCount();
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

	
	public List<BlogcontentVo> findAllNotCheckBlogPage(Integer currentPage,
			Integer pageSize) throws CustomException {
		try {
			List<BlogcontentVo> blogcontentVos=blogDao.findAllNotCheckBlogPage(currentPage, pageSize);
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
	
	//计算blog中未审核or审核不通过count
	public int findBlogCountNotCheckOrNotpass() throws CustomException {
		try {
			int count=blogDao.findBlogCountNotCheckOrNotpass();
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
	
	//按栏目查找博客内容
	public List<BlogcontentVo> findBlogContentBySectionName(String sectionName)
			throws CustomException {
		try {
			List<BlogcontentVo> blogcontentVos=blogDao.findBlogContentBySectionName(sectionName);
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
	public BlogVo getVo_Auto(Long id, int chooseRM) throws CustomException {
		try {
			BlogVo result = blogDao.getVo_Auto(id, chooseRM);
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
			boolean result = blogDao.isExist_Auto(id);
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
	public long queryCount_Auto(BlogSearch search) throws CustomException {
		try {
			long count = blogDao.queryCount_Auto(search);
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
	public List<BlogVo> queryVos_Auto(BlogSearch search) throws CustomException {
		try {
			List<BlogVo> result = blogDao.queryVos_Auto(search);
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
	public BlogVo queryVo_Auto(BlogSearch search) throws CustomException {
		try {
			List<BlogVo> result = blogDao.queryVos_Auto(search);
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
	public long save_AdminAdd(BlogVo addVo) throws CustomException {
		try {
			long addResult = blogDao.saveSelective(addVo);
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
			// BlogVo vo = blogDao.getVo_Auto(id, BlogSearch.RM_Default);
			// if (vo == null) {
			// return -1l;
			// }
			long deleteResult = blogDao.delete(id);
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
	public long edit_AdminEdit(BlogVo editVo) throws CustomException {
		try {
			long editResult = blogDao.updateSelective(editVo);
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
	public BlogVo getVo_AdminView(Long id) throws CustomException {
		try {
			BlogVo vo = blogDao.getVo_AdminView(id,0);
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
	public BlogVo getVo_preAdminEdit(Long id) throws CustomException {
		try {
			BlogVo vo = blogDao.getVo_preAdminEdit(id,0);
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
	public BlogVo getVo_AdminEdit(Long id) throws CustomException {
		try {
			BlogVo vo = blogDao.getVo_AdminEdit(id,0);
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
