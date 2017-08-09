package com.hfxt.service;

import java.util.List;

import com.hfxt.domain.vo.LabelVo;


public interface ILabelService {

	/**
	 * 为博客增加标签
	 * @param blogId 博客ID
	 * @param labels 标签ID
	 * @return 受影响的行数
	 * @throws Exception
	 */
	int addLabelForBlog (int blogId, int userId, String[] labels) throws Exception;
	/**
	 * 根据博客ID来删除所有标签
	 * @param blogId 博客ID
	 * @return 受影响的行数
	 * @throws Exception
	 */
	int deleteLabelByBlogId (int blogId) throws Exception;
	/**
	 * 根据博客ID来删除部分标签
	 * @param blogId 博客ID
	 * @param deletedLabelId 待删除的标签
	 * @return 受影响的行数
	 * @throws Exception
	 */
	int deleteLabelByBlogId (int blogId, List<Integer> deletedLabelId) throws Exception;
	/**
	 * 删除标签，并删除该用户下所有博客的该标签
	 * @param userId 当前执行删除操作的用户
	 * @param deletedLabelId 待删除的标签集合
	 * @return 受影响的行数
	 * @throws Exception
	 */
	int deleteLabelByUserId (int userId, List<Integer> deletedLabelId) throws Exception;
	/**
	 * 查询到指定博客的所有标签
	 * @param blogId 博客ID
	 * @return 博客集合
	 * @throws Exception
	 */
	List<LabelVo> getLabelsByBlogId (int blogId) throws Exception;
	/**
	 * 根据创建者来查询所有的标签
	 * @param 用户ID 
	 * @return 标签集合
	 * @throws Exception
	 */
	List<LabelVo> getLabelsByUserId (int userId) throws Exception;
}
