package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.domain.search.BlogcontentSearch;
import com.hfxt.domain.vo.BlogcontentVo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public interface IBlogcontentDao extends IBaseDao<BlogcontentVo,Integer>{


    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	    //添加博客内容
		public int addBlogcontent(BlogcontentVo blogcontent);
		//获取最大id手动插入到blog表中
		public Integer getMaxId();
		//根据blogid查询博客内容
		public BlogcontentVo findContentById(Integer blogId);
		//删除单条博客内容
		public int deleteBlogContent(Integer blogContentId);
		//根据id修改博客内容
		public int updateBlogContent(BlogcontentVo blogcontentVo);
		//根据blogcontentid查询博客内容
		public BlogcontentVo findContentByBctId(Integer blogcontentId);
		//按标签名查找博客
		public List<BlogcontentVo> findBlogContentByLabelName(String LabelName);
		
		
		// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    /**
	 * 保存非空列 返回受影响行数
	 */
	long saveSelective(@Param("Vo") BlogcontentVo vo);
    
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
	// long update(@Param("Vo") BlogcontentVo vo);

	/**
	 * 修改非空列 返回受影响行数
	 */
	long updateSelective(@Param("Vo") BlogcontentVo vo);

	/**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	BlogcontentVo getVo_Auto(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(@Param("id") Long id);

	/**
	 * 查询数量
	 */
	long queryCount_Auto(@Param("BlogcontentSearch") BlogcontentSearch search);

	/**
	 * 查询记录集合
	 */
	List<BlogcontentVo> queryVos_Auto(@Param("BlogcontentSearch") BlogcontentSearch search);

	/**
	 * 后台详情页查询
	 */
	BlogcontentVo getVo_AdminView(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询编辑
	 */
	BlogcontentVo getVo_preAdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台编辑查询
	 */
	BlogcontentVo getVo_AdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询数量
	 */
	long queryCount_AdminList(@Param("BlogcontentSearch") BlogcontentSearch search);

	/**
	 * 后台查询列表
	 */
	List<BlogcontentVo> queryVos_AdminList(@Param("BlogcontentSearch") BlogcontentSearch search);
    
    
	
	
}

