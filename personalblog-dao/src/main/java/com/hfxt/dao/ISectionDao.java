package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.domain.search.SectionSearch;
import com.hfxt.domain.vo.SectionVo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public interface ISectionDao extends IBaseDao<SectionVo,Integer>{


    // 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
    
    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//获取所有的栏目
	public List<SectionVo> getAllSections() throws Exception;
	//增加栏目
	public int addSection(SectionVo sectionVo) throws Exception;
	//修改
	public int updateSection(SectionVo sectionVo) throws Exception;
	//删除(根据id)
	public int deleteSection(Integer sectionid) throws Exception;
	//根据SectionId查找当前引用此栏目的总数
	public int getAllSectionCount(Integer sectionid) throws Exception;
	//根据id找到该用户实体
	public SectionVo getSectionById(Integer sectionid) throws Exception;
	//根据栏目名找到该用户
	public SectionVo getSectionVoByName(String sectionName) throws Exception;
    
    /**
	 * 保存非空列 返回受影响行数
	 */
	long saveSelective(@Param("Vo") SectionVo vo);
    
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
	// long update(@Param("Vo") SectionVo vo);

	/**
	 * 修改非空列 返回受影响行数
	 */
	long updateSelective(@Param("Vo") SectionVo vo);

	/**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	SectionVo getVo_Auto(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(@Param("id") Long id);

	/**
	 * 查询数量
	 */
	long queryCount_Auto(@Param("SectionSearch") SectionSearch search);

	/**
	 * 查询记录集合
	 */
	List<SectionVo> queryVos_Auto(@Param("SectionSearch") SectionSearch search);

	/**
	 * 后台详情页查询
	 */
	SectionVo getVo_AdminView(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询编辑
	 */
	SectionVo getVo_preAdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台编辑查询
	 */
	SectionVo getVo_AdminEdit(@Param("id") Long id, @Param("chooseRM") int chooseRM);

	/**
	 * 后台查询数量
	 */
	long queryCount_AdminList(@Param("SectionSearch") SectionSearch search);

	/**
	 * 后台查询列表
	 */
	List<SectionVo> queryVos_AdminList(@Param("SectionSearch") SectionSearch search);
    
    
	
	
}

