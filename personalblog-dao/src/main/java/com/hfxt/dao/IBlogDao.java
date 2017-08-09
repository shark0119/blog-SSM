package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.domain.search.BlogSearch;
import com.hfxt.domain.vo.BlogVo;
import com.hfxt.domain.vo.BlogcontentVo;
import com.hfxt.dao.IBaseDao;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public interface IBlogDao extends IBaseDao<BlogVo,Integer>{


    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	//添加博客
	public int addBlog(BlogVo blog);
	//查询所有博客内容
	public List<BlogcontentVo> findAllBlog();
	//删除单条博客
	public int deleteBlog(Integer blogContentId);
	//根据ID修改博客
	public int updateBlog(BlogVo blogVo);
	//查询所有草稿箱博客内容
	public List<BlogcontentVo> findAllDraftBlog();
	//查询前台所有博客内容（公开为1，加密2）
	public List<BlogcontentVo> findAllPublicBlog();
	//获取最大id手动插入到blog表中
	public Integer getMaxId();
	
	//根据userId查询博客内容
	public List<BlogcontentVo> findBlogByUserId(Integer userId);
	
	//根据userId查询所有草稿箱博客内容
	public List<BlogcontentVo> findAllDraftBlogByUserId(Integer userId);
   
	//查询所有未审核博客内容
	public List<BlogcontentVo> findAllNotCheckBlog();
	
	//根据blogid查询博客
	public BlogVo findBlogById(Integer blogId);
	
	//前台index分页
	public List<BlogcontentVo> findIndexPage(Integer currentPage,Integer pageSize);
	
	//计算blog中count
	public int findBlogCount();
	
	
	//查询所有未审核博客内容
	public List<BlogcontentVo> findAllNotCheckBlogPage(Integer currentPage,Integer pageSize);
	
	
	//计算blog中未审核or审核不通过count
	public int findBlogCountNotCheckOrNotpass();
	
	
	//按栏目查找博客内容
	public List<BlogcontentVo> findBlogContentBySectionName(String sectionName);
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    /**
	 * 保存非空列 返回受影响行数
	 */
	long saveSelective(@Param("Vo") BlogVo vo);
    
    /**
	 * 删除 返回受影响行数
	 */
	long delete(@Param("id") Long id);

	/**
	 * 删除所有记录,返回受影响的行数
	 */
	long deleteAll();

	/**
	 * 修改 返回受影响行数
	 */
	// long update(@Param("Vo") BlogVo vo);

	/**
	 * 修改非空列 返回受影响行数
	 */
	long updateSelective(@Param("Vo") BlogVo vo);

	/**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	BlogVo getVo_Auto(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(@Param("id") Long id);

	/**
	 * 查询数量
	 */
	long queryCount_Auto(@Param("BlogSearch") BlogSearch search);

	/**
	 * 查询记录集合
	 */
	List<BlogVo> queryVos_Auto(@Param("BlogSearch") BlogSearch search);

	/**
	 * 后台详情页查询
	 */
	BlogVo getVo_AdminView(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询编辑
	 */
	BlogVo getVo_preAdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台编辑查询
	 */
	BlogVo getVo_AdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询数量
	 */
	long queryCount_AdminList(@Param("BlogSearch") BlogSearch search);

	/**
	 * 后台查询列表
	 */
	List<BlogVo> queryVos_AdminList(@Param("BlogSearch") BlogSearch search);

    
    
	
	
}

