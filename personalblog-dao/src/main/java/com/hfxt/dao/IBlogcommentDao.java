package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.domain.search.BlogcommentSearch;
import com.hfxt.domain.vo.BlogcommentVo;
import com.hfxt.domain.vo.UserVo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public interface IBlogcommentDao extends IBaseDao<BlogcommentVo,Integer>{


    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
    
    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//查询当前博客的所有的评论(博客id)
		public List<BlogcommentVo> getCommentsByBlogId(Integer blogid) throws Exception;
		//查找当前评论下所有的回复的评论(当前评论对应的Id)
		public List<BlogcommentVo> getReplyCommentByCommentId(Integer commentid) throws Exception;
		//增加一条评论
		public int addComment(BlogcommentVo comment ) throws Exception;
		//回复一条评论
		public int addReplyComment(BlogcommentVo comment) throws Exception;
		//删除一条主评评论
		public int deleteBlogComment(Integer commentId);
		//查询当前微博主评论的个数
		public int getAllCountByBlogId(Integer BlogId);
		//根据引用的回复的id找到需要的对象
		public UserVo getUserByrelCommentId(Integer refCommentId) throws Exception;
		//根据id找这条评论
		public BlogcommentVo getCommentById(Integer commentId) throws Exception;
		//分页显示当前的主评论
		public List<BlogcommentVo> getBlogCommentByPage(Integer currentPage,Integer pageSize,Integer blogId ) throws Exception;
		//查询当前数据库中最大的id
		public Integer getCommentMaxId() throws Exception;
    /**
	 * 保存非空列 返回受影响行数
	 */
	long saveSelective(@Param("Vo") BlogcommentVo vo);
    
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
	// long update(@Param("Vo") BlogcommentVo vo);

	/**
	 * 修改非空列 返回受影响行数
	 */
	long updateSelective(@Param("Vo") BlogcommentVo vo);

	/**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	BlogcommentVo getVo_Auto(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(@Param("id") Long id);

	/**
	 * 查询数量
	 */
	long queryCount_Auto(@Param("BlogcommentSearch") BlogcommentSearch search);

	/**
	 * 查询记录集合
	 */
	List<BlogcommentVo> queryVos_Auto(@Param("BlogcommentSearch") BlogcommentSearch search);

	/**
	 * 后台详情页查询
	 */
	BlogcommentVo getVo_AdminView(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询编辑
	 */
	BlogcommentVo getVo_preAdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台编辑查询
	 */
	BlogcommentVo getVo_AdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询数量
	 */
	long queryCount_AdminList(@Param("BlogcommentSearch") BlogcommentSearch search);

	/**
	 * 后台查询列表
	 */
	List<BlogcommentVo> queryVos_AdminList(@Param("BlogcommentSearch") BlogcommentSearch search);
    
    
	
	
}

