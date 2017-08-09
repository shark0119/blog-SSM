package com.hfxt.service;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
import java.util.List;
import java.util.Map;

import com.hfxt.domain.search.BlogcommentSearch;
import com.hfxt.domain.vo.BlogcommentVo;
import com.hfxt.domain.vo.UserVo;
import common.exception.CustomException;


public interface IBlogcommentService {

  	// 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//查找当前评论下所有的回复的评论(当前评论对应的Id)
		public List<BlogcommentVo> getReplyCommentByCommentId(Integer id) throws Exception;
		/**
		 * 根据文章ID 来查询评论树
		 * @param blogId 文章ID
		 * @return Map集合，键为主评论， 值为子评论集合
		 * @throws Exception
		 */
		public Map<BlogcommentVo, List<BlogcommentVo>> getReplayCommentByCommentIdMap (Integer blogId) throws Exception;
		/**
		 * 使用递归调用自己获取所有的集合
		 * @param commentId 当前评论的id
		 * @throws Exception
		 */
		public void getReplyCommentByCommentId (Integer commentId, List<BlogcommentVo> comments)throws Exception;
			
		/**
		 * 有关这条评论的所有评论的id
		 * @param commentId
		 * @param comments 当前评论的ID
		 * @throws Exception
		 */
		public void getAllCommentIdByComeentId(Integer commentId,List<Integer> commentsId) throws Exception;
		
		/**
		 * 根据commentID删除当前的评论
		 * @param commentId
		 * @return
		 * @throws Exception
		 */
		public int deleteAllCommentByCommentId(Integer commentId) throws Exception;
		
		/**
		 * 获取当前博文的主评论数
		 * @param BlogId
		 * @return
		 * @throws Exception
		 */
		public int getAllCountByBlogId(Integer BlogId) throws Exception;
		
		/**
		 * 增加一条主评论
		 * @param comment
		 * @return 影响的行数
		 * @throws Exception
		 */
		public int addComment(BlogcommentVo comment) throws Exception;
		/**回复一条评论
		 * @param comment
		 * @return
		 * @throws Exception
		 */
		public int addReplyComment(BlogcommentVo comment) throws Exception;
		
		/**根据引用的评论的ID找到需要回复的人
		 * @param refCommentId
		 * @return
		 * @throws Exception
		 */
		public UserVo getUserByrelCommentId(Integer refCommentId) throws Exception;
		
		/**
		 * 根据id找到该评论
		 * @param commentId
		 * @return
		 * @throws Exception
		 */
		public BlogcommentVo getCommentById(Integer commentId) throws Exception;
		
		/**
		 * 分页查找主评论
		 * @param currentPage 当前页
		 * @param pageSize 页数
		 * @param blogId 博客的id
		 * @return 主评论的集合
		 * @throws Exception
		 */
		public List<BlogcommentVo> getBlogCommentByPage(Integer currentPage,Integer pageSize,Integer blogId ) throws Exception;
		
		
		/**分页获取评论数
		 * @param currentPage
		 * @param pageSize
		 * @param blogId
		 * @return
		 * @throws Exception
		 */
		public Map<BlogcommentVo, List<BlogcommentVo>> getReplayCommentByCommentIdMap (Integer currentPage,Integer pageSize,Integer blogId) throws Exception;
		/**
		 * 获取当前最大的ID
		 * @return
		 * @throws Exception
		 */
		public Integer getCommentMaxId() throws Exception;
		
		
		
		
		
		
		
		
    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	BlogcommentVo getVo_Auto(Long id, int chooseRM) throws CustomException;
    
    /**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(Long id) throws CustomException;
    
    /**
	 * 查询所有记录的数量
	 */
	long queryCount_Auto(BlogcommentSearch search) throws CustomException;

	/**
	 * 查询所有记录
	 */
	List<BlogcommentVo> queryVos_Auto(BlogcommentSearch search) throws CustomException;
    
    /**
	 * 查询单条记录
	 */
	BlogcommentVo queryVo_Auto(BlogcommentSearch search) throws CustomException;
    
    ////////////////////////////////////////////后台///////////////////////////////////////////

	/**
	 * 后台新增
	 */
	long save_AdminAdd(BlogcommentVo addVo) throws CustomException;

	/**
	 * 后台删除
	 */
	long delete_AdminDelete(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	long edit_AdminEdit(BlogcommentVo editVo) throws CustomException;

	/**
	 * 后台查看编辑
	 */
	BlogcommentVo getVo_preAdminEdit(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	BlogcommentVo getVo_AdminEdit(Long id) throws CustomException;

	/**
	 * 后台查看详情
	 */
	BlogcommentVo getVo_AdminView(Long id) throws CustomException;
}
