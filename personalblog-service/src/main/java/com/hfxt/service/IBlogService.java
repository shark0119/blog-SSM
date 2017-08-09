package com.hfxt.service;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
import com.hfxt.domain.search.BlogSearch;
import com.hfxt.domain.vo.BlogVo;
import com.hfxt.domain.vo.BlogcontentVo;

import common.exception.CustomException;

import java.util.List;


public interface IBlogService {

  	// 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
	    /**
	     * 添加博客实体
	     * @param blog
	     * @return 成功返回博客ID，失败返回-1
	     * @throws CustomException
	     */
		public int addBlog(BlogVo blog)throws CustomException;
		//找到所有博客
		public List<BlogcontentVo> findAllBlog()throws CustomException;
		//删除单条博客
		public int deleteBlog(Integer blogContentId) throws CustomException;
		//根据ID修改博客
		public int updateBlog(BlogVo blogVo) throws CustomException;
		//查询所有草稿箱博客内容
		public List<BlogcontentVo> findAllDraftBlog() throws CustomException;
		//查询前台所有博客内容（公开为1，加密2）
		public List<BlogcontentVo> findAllPublicBlog() throws CustomException;
		//根据userId查询博客内容
		public List<BlogcontentVo> findBlogByUserId(Integer userId) throws CustomException;
		
		//根据userId查询所有草稿箱博客内容
		public List<BlogcontentVo> findAllDraftBlogByUserId(Integer userId) throws CustomException;
		
		//查询所有未审核博客内容
		public List<BlogcontentVo> findAllNotCheckBlog() throws CustomException;
		//根据blogid查询博客
		public BlogVo findBlogById(Integer blogId) throws CustomException;
		
		
		//前台index分页
		public List<BlogcontentVo> findIndexPage(Integer currentPage,Integer pageSize) throws CustomException;
		
		//计算blog中count
		public int findBlogCount() throws CustomException;
		
		//查询所有未审核博客内容
		public List<BlogcontentVo> findAllNotCheckBlogPage(Integer currentPage,Integer pageSize) throws CustomException;
		
		//计算blog中未审核or审核不通过count
		public int findBlogCountNotCheckOrNotpass() throws CustomException;
		
		//按栏目查找博客内容
		public List<BlogcontentVo> findBlogContentBySectionName(String sectionName) throws CustomException;
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	BlogVo getVo_Auto(Long id, int chooseRM) throws CustomException;
    
    /**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(Long id) throws CustomException;
    
    /**
	 * 查询所有记录的数量
	 */
	long queryCount_Auto(BlogSearch search) throws CustomException;

	/**
	 * 查询所有记录
	 */
	List<BlogVo> queryVos_Auto(BlogSearch search) throws CustomException;
    
    /**
	 * 查询单条记录
	 */
	BlogVo queryVo_Auto(BlogSearch search) throws CustomException;
    
    ////////////////////////////////////////////后台///////////////////////////////////////////

	/**
	 * 后台新增
	 */
	long save_AdminAdd(BlogVo addVo) throws CustomException;

	/**
	 * 后台删除
	 */
	long delete_AdminDelete(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	long edit_AdminEdit(BlogVo editVo) throws CustomException;

	/**
	 * 后台查看编辑
	 */
	BlogVo getVo_preAdminEdit(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	BlogVo getVo_AdminEdit(Long id) throws CustomException;

	/**
	 * 后台查看详情
	 */
	BlogVo getVo_AdminView(Long id) throws CustomException;
}
