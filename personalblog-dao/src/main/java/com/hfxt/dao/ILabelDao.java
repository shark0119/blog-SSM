package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.domain.vo.LabelVo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */

public interface ILabelDao extends IBaseDao<LabelVo,Integer>{

	/**
	 * 根据标签名获取标签实体
	 * @param labelName
	 * @return 失败返回null 成功返回相应实体
	 */
	LabelVo getLabelByLabelName(String labelName);

	/**
	 * 保存标签
	 * @param label 待保存的标签实体
	 * @return 失败返回null
	 */
	Integer saveLabel(LabelVo label);

	/**
	 * 向用户标签表添加元素
	 * @param labelId
	 * @param userId
	 * @return 失败返回false成功返回true
	 */
	Integer saveLabelForUser(@Param("labelId")Integer labelId, @Param("userId")Integer userId);

	/**
	 * 向博客标签表添加元素
	 * @param labelId
	 * @param blogId
	 * @return
	 */
	Integer saveLabelForBlog(@Param("labelId")Integer labelId, @Param("blogId")Integer blogId);

	/**
	 * 删除博客标签表中的指定元素
	 * @param blogId 博客ID
	 * @param labelId 标签ID
	 * @return 返回受影响的行数
	 */
	Integer deleteLabelByBlogId(@Param("labelId")Integer labelId, @Param("blogId")Integer blogId);
    
	/**
	 * 删除用户标签表中的指定元素
	 * @param userId 用户ID
	 * @param labelId 标签ID
	 * @return 受影响的行数
	 */
	Integer deleteLabelByUserId(@Param("labelId")Integer labelId, @Param("userId")Integer userId);
	
	/**
	 * 获取对应博客的所有标签
	 * @param blogId 博客ID
	 * @return 标签列表
	 */
	List<LabelVo> getLabelsByBlogId(Integer blogId);
	
	/**
	 * 获取某个用户创建的所有标签
	 * @param userId 用户ID
	 * @return 标签列表
	 */
	List<LabelVo> getLabelsByUserId(Integer userId);
}
