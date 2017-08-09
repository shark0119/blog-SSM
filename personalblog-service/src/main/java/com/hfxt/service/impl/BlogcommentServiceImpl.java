package com.hfxt.service.impl;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hfxt.domain.search.BlogcommentSearch;
import com.hfxt.domain.vo.BlogcommentVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.service.IBlogcommentService;
import common.exception.CustomException;

@Service("service.impl.BlogcommentServiceImpl")
public class BlogcommentServiceImpl extends BaseService implements IBlogcommentService {
  	

    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
	
    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	// @Cacheable(value = "", key = "#root.targetClass.simpleName + #root.methodName + #id + '_' + #chooseRM")
	public BlogcommentVo getVo_Auto(Long id, int chooseRM) throws CustomException {
		try {
			BlogcommentVo result = blogcommentDao.getVo_Auto(id, chooseRM);
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
			boolean result = blogcommentDao.isExist_Auto(id);
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
	public long queryCount_Auto(BlogcommentSearch search) throws CustomException {
		try {
			long count = blogcommentDao.queryCount_Auto(search);
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
	public List<BlogcommentVo> queryVos_Auto(BlogcommentSearch search) throws CustomException {
		try {
			List<BlogcommentVo> result = blogcommentDao.queryVos_Auto(search);
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
	public BlogcommentVo queryVo_Auto(BlogcommentSearch search) throws CustomException {
		try {
			List<BlogcommentVo> result = blogcommentDao.queryVos_Auto(search);
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
	public long save_AdminAdd(BlogcommentVo addVo) throws CustomException {
		try {
			long addResult = blogcommentDao.saveSelective(addVo);
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
			// BlogcommentVo vo = blogcommentDao.getVo_Auto(id, BlogcommentSearch.RM_Default);
			// if (vo == null) {
			// return -1l;
			// }
			long deleteResult = blogcommentDao.delete(id);
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
	public long edit_AdminEdit(BlogcommentVo editVo) throws CustomException {
		try {
			long editResult = blogcommentDao.updateSelective(editVo);
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
	public BlogcommentVo getVo_AdminView(Long id) throws CustomException {
		try {
			BlogcommentVo vo = blogcommentDao.getVo_AdminView(id,0);
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
	public BlogcommentVo getVo_preAdminEdit(Long id) throws CustomException {
		try {
			BlogcommentVo vo = blogcommentDao.getVo_preAdminEdit(id,0);
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
	public BlogcommentVo getVo_AdminEdit(Long id) throws CustomException {
		try {
			BlogcommentVo vo = blogcommentDao.getVo_AdminEdit(id,0);
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


	/* 查找当前评论下所有的回复的评论(当前评论对应的Id)
	 * @param2017-7-27
	 */
	public List<BlogcommentVo> getReplyCommentByCommentId(Integer id)
			throws Exception {
		// TODO Auto-generated method stub
		return blogcommentDao.getReplyCommentByCommentId(id);
	}


	/* 根据文章ID 来查询评论树
	 * @param2017-7-27
	 */
	public Map<BlogcommentVo, List<BlogcommentVo>> getReplayCommentByCommentIdMap(
			Integer blogId) throws Exception {
		//创建一个map
		Map<BlogcommentVo, List<BlogcommentVo>> totalComments=
				new LinkedHashMap<BlogcommentVo, List<BlogcommentVo>>();
		List <BlogcommentVo> mainComments = blogcommentDao.getCommentsByBlogId(blogId);
		//取出每个元素
		List <BlogcommentVo> subComments;
		for(BlogcommentVo vo:mainComments){
			subComments = new ArrayList<BlogcommentVo>();
			this.getReplyCommentByCommentId(vo.getCommentId(), subComments);
			totalComments.put(vo, subComments);
		}
		return totalComments;
	}


	/* 解析评论树
	 * @param2017-7-27
	 */
	public void getReplyCommentByCommentId(Integer commentId,
			List<BlogcommentVo> comments) throws Exception {
		//取出当前评论下的所有的集合
		List<BlogcommentVo> comment1s=this.getReplyCommentByCommentId(commentId);
		//拿出每个元素放入list中
		for(BlogcommentVo vo:comment1s){
			//加入到list中
			comments.add(vo);
			//递归调用自己
			getReplyCommentByCommentId(vo.getCommentId(), comments);
		}
	}


	/* 获取当前评论树的所有子id
	 * @param2017-7-27
	 */
	public void getAllCommentIdByComeentId(Integer commentId,
			List<Integer> commentsId) throws Exception {
		//获取当前主评论下的所有的子评论的id
		List<BlogcommentVo> comments=this.getReplyCommentByCommentId(commentId);
		//取出每个元素加入到list中
		for(BlogcommentVo vo :comments){
			commentsId.add(vo.getCommentId());
			//递归调用自己
			getAllCommentIdByComeentId(vo.getCommentId(), commentsId);
		}
		
	}


	/* 根据ID删除该条评论
	 * @param2017-7-27
	 */
	public int deleteAllCommentByCommentId(Integer commentId) throws Exception {
		// TODO Auto-generated method stub
		return blogcommentDao.deleteBlogComment(commentId);
	}


	/* 获取主评论数
	 * @param2017-7-27
	 */
	public int getAllCountByBlogId(Integer BlogId) throws Exception {
		return blogcommentDao.getAllCountByBlogId(BlogId);
	}


	/* 增加一条朱评论
	 * @param2017-7-29
	 */
	public int addComment(BlogcommentVo comment) throws Exception {
		
		return blogcommentDao.addComment(comment);
	}


	/* 回复一条评论
	 * @param2017-7-29
	 */
	public int addReplyComment(BlogcommentVo comment) throws Exception {
		return blogcommentDao.addReplyComment(comment);
	}


	/* 找到需要回复的人
	 * @param2017-8-1
	 */
	public UserVo getUserByrelCommentId(Integer refCommentId) throws Exception {
		return blogcommentDao.getUserByrelCommentId(refCommentId);
	}


	/* 根据id找到
	 * @param2017-8-1
	 */
	public BlogcommentVo getCommentById(Integer commentId) throws Exception {
		return blogcommentDao.getCommentById(commentId);
	}


	/* 分页查找主评论
	 * @param2017-8-3
	 */
	public List<BlogcommentVo> getBlogCommentByPage(Integer currentPage,
			Integer pageSize, Integer blogId) throws Exception {
		return blogcommentDao.getBlogCommentByPage(currentPage, pageSize, blogId);
	}


	/* 分页获取评论树
	 * @param2017-8-3
	 */
	public Map<BlogcommentVo, List<BlogcommentVo>> getReplayCommentByCommentIdMap(
			Integer currentPage, Integer pageSize, Integer blogId)
			throws Exception {
		
		//创建一个map
				Map<BlogcommentVo, List<BlogcommentVo>> totalComments=
						new LinkedHashMap<BlogcommentVo, List<BlogcommentVo>>();
				List <BlogcommentVo> mainComments = this.getBlogCommentByPage(currentPage, pageSize, blogId);
				//取出每个元素
				List <BlogcommentVo> subComments;
				for(BlogcommentVo vo:mainComments){
					subComments = new ArrayList<BlogcommentVo>();
					this.getReplyCommentByCommentId(vo.getCommentId(), subComments);
					totalComments.put(vo, subComments);
				}
				return totalComments;
	}


	/* 获取当前最大的id
	 * @param2017-8-6
	 */
	public Integer getCommentMaxId() throws Exception {
		// TODO Auto-generated method stub
		return blogcommentDao.getCommentMaxId();
	}
 
}
