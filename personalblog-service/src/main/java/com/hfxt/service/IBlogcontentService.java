package com.hfxt.service;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
import java.util.List;

import com.hfxt.domain.search.BlogcontentSearch;
import com.hfxt.domain.vo.BlogcontentVo;

import common.exception.CustomException;


public interface IBlogcontentService {

  	// 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	    /**
	     * 添加博客内容
	     * @param blogcontent 博客内容详情
	     * @return 成功返回添加的博客内容ID 失敗返回-1
	     * @throws CustomException
	     */
		public int addBlogcontent(BlogcontentVo blogcontent) throws CustomException;
		//根据id查询博客内容
		public BlogcontentVo findContentById(Integer blogId) throws CustomException;
		//删除单条博客内容
		public int deleteBlogContent(Integer blogContentId) throws CustomException;
		//根据id修改博客内容
		public int updateBlogContent(BlogcontentVo blogcontentVo) throws CustomException;
		//根据blogcontentid查询博客内容
		public BlogcontentVo findContentByBctId(Integer blogcontentId) throws CustomException;
		//按标签名查找博客
		public List<BlogcontentVo> findBlogContentByLabelName(String LabelName) throws CustomException;
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	BlogcontentVo getVo_Auto(Long id, int chooseRM) throws CustomException;
    
    /**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(Long id) throws CustomException;
    
    /**
	 * 查询所有记录的数量
	 */
	long queryCount_Auto(BlogcontentSearch search) throws CustomException;

	/**
	 * 查询所有记录
	 */
	List<BlogcontentVo> queryVos_Auto(BlogcontentSearch search) throws CustomException;
    
    /**
	 * 查询单条记录
	 */
	BlogcontentVo queryVo_Auto(BlogcontentSearch search) throws CustomException;
    
    ////////////////////////////////////////////后台///////////////////////////////////////////

	/**
	 * 后台新增
	 */
	long save_AdminAdd(BlogcontentVo addVo) throws CustomException;

	/**
	 * 后台删除
	 */
	long delete_AdminDelete(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	long edit_AdminEdit(BlogcontentVo editVo) throws CustomException;

	/**
	 * 后台查看编辑
	 */
	BlogcontentVo getVo_preAdminEdit(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	BlogcontentVo getVo_AdminEdit(Long id) throws CustomException;

	/**
	 * 后台查看详情
	 */
	BlogcontentVo getVo_AdminView(Long id) throws CustomException;
}
