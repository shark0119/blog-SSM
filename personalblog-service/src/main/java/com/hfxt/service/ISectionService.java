package com.hfxt.service;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
import java.util.List;

import com.hfxt.domain.search.SectionSearch;
import com.hfxt.domain.vo.SectionVo;
import common.exception.CustomException;


public interface ISectionService {

  	// 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//获取所有的栏目
		public List<SectionVo> getAllSections() throws Exception;
		//增加栏目
		public int addSection(SectionVo section) throws Exception;
		//修改
		public int updateSection(SectionVo section) throws Exception;
		//删除(根据id)
		public int deleteSection(Integer sectionid) throws Exception;
		//根据SectionId查找当前引用此栏目的总数
		public int getAllSectionCount(Integer sectionid) throws Exception;
		//根据id找到该用户实体
		public SectionVo getSectionById(Integer sectionid) throws Exception;
		//根据栏目名找到该用户
		public SectionVo getSectionVoByName(String sectionName) throws Exception;
    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	SectionVo getVo_Auto(Long id, int chooseRM) throws CustomException;
    
    /**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(Long id) throws CustomException;
    
    /**
	 * 查询所有记录的数量
	 */
	long queryCount_Auto(SectionSearch search) throws CustomException;

	/**
	 * 查询所有记录
	 */
	List<SectionVo> queryVos_Auto(SectionSearch search) throws CustomException;
    
    /**
	 * 查询单条记录
	 */
	SectionVo queryVo_Auto(SectionSearch search) throws CustomException;
    
    ////////////////////////////////////////////后台///////////////////////////////////////////

	/**
	 * 后台新增
	 */
	long save_AdminAdd(SectionVo addVo) throws CustomException;

	/**
	 * 后台删除
	 */
	long delete_AdminDelete(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	long edit_AdminEdit(SectionVo editVo) throws CustomException;

	/**
	 * 后台查看编辑
	 */
	SectionVo getVo_preAdminEdit(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	SectionVo getVo_AdminEdit(Long id) throws CustomException;

	/**
	 * 后台查看详情
	 */
	SectionVo getVo_AdminView(Long id) throws CustomException;
}
