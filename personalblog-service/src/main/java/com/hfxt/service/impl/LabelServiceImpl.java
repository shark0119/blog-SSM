package com.hfxt.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hfxt.domain.vo.LabelVo;
import com.hfxt.service.ILabelService;



@Service("service.impl.LabelServiceImpl")
public class LabelServiceImpl extends BaseService implements ILabelService {
	private Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);

	/**
	 * 为博客增加标签
	 * 标签必须是已存在的否则无法存储
	 * @param blogId 博客ID
	 * @param labels 标签
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int addLabelForBlog (int blogId, int userId, String[] labels) throws Exception{
		//为博客增加标签
		int count  = 0;
		LabelVo temp = null;
		if(labels!=null){
		for (String label : labels){
			//1.获取
			//  (LabelVo)  labelDao.get(label.getName())
			temp = labelDao.getLabelByLabelName (label);
			//1_1. 如果不存在,为该用户添加标签
			if (temp == null){
				//保存到标签表和用户标签表
				temp = new LabelVo();
				temp.setLabelName(label);
				if(labelDao.saveLabel (temp)>0){
					temp = labelDao.getLabelByLabelName (label);
					labelDao.saveLabelForUser (temp.getLabelId(), userId);
				}else{
					logger.info("标签" + label + "，保存失败");
					continue;
				}
			}
		}
			//2.保存博客标签表
			count += labelDao.saveLabelForBlog (temp.getLabelId(), blogId);
			//2_1. 成功 count++;
		}
		return count;
	}
	/**
	 * 根据博客ID来删除所有标签
	 * 将博客标签表下所有该博客相关记录删除
	 * @param blogId 博客ID
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deleteLabelByBlogId (int blogId) throws Exception{
		return labelDao.deleteLabelByBlogId(blogId, null);
	}
	/**
	 * 根据博客ID来删除部分标签
	 * 维护博客标签表
	 * @param blogId 博客ID
	 * @param deletedLabelId 待删除的标签ID
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deleteLabelByBlogId (int blogId, List<Integer> deletedLabelId) throws Exception{
		int count = 0;
		for (int labelId : deletedLabelId){
			count += labelDao.deleteLabelByBlogId(blogId, labelId);
		}
		return count;
	}
	/**
	 * 删除标签，并删除该用户下所有博客的该标签
	 * 维护用户标签表
	 * @param userId 当前执行删除操作的用户
	 * @param deletedLabelId 待删除的标签集合
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int deleteLabelByUserId (int userId, List<Integer> deletedLabelId) throws Exception{
		/**
		 * 维护用户标签表
		 */
		int count = 0;
		for (int labelId : deletedLabelId){
			count += labelDao.deleteLabelByUserId(userId, labelId);
		}
		return count;
	}
	/**
	 * 查询到指定博客的所有标签
	 * @param blogId 博客ID
	 * @return 博客集合
	 * @throws Exception
	 */
	public List<LabelVo> getLabelsByBlogId (int blogId) throws Exception{
		return labelDao.getLabelsByBlogId(blogId);
	}
	/**
	 * 根据创建者来查询所有的标签
	 * @param 用户ID 
	 * @return 标签集合
	 * @throws Exception
	 */
	public List<LabelVo> getLabelsByUserId (int userId) throws Exception{
		return labelDao.getLabelsByUserId(userId);
	}
}