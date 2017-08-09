package com.hfxt.service;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
import com.hfxt.domain.search.AnnouncementSearch;
import com.hfxt.domain.vo.AnnouncementVo;

import common.exception.CustomException;

import java.util.List;

import redis.clients.jedis.Jedis;


public interface IAnnouncementService {

  	// 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	Jedis getJedis();
	AnnouncementVo getVo_Auto(Long id, int chooseRM) throws CustomException;
    
    /**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(Long id) throws CustomException;
    
    /**
	 * 查询所有记录的数量
	 */
	long queryCount_Auto(AnnouncementSearch search) throws CustomException;

	/**
	 * 查询所有记录
	 */
	List<AnnouncementVo> queryVos_Auto(AnnouncementSearch search) throws CustomException;
    
    /**
	 * 查询单条记录
	 */
	AnnouncementVo queryVo_Auto(AnnouncementSearch search) throws CustomException;
    
    ////////////////////////////////////////////后台///////////////////////////////////////////

	/**
	 * 后台新增
	 */
	long save_AdminAdd(AnnouncementVo addVo) throws CustomException;

	/**
	 * 后台删除
	 */
	long delete_AdminDelete(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	long edit_AdminEdit(AnnouncementVo editVo) throws CustomException;

	/**
	 * 后台查看编辑
	 */
	AnnouncementVo getVo_preAdminEdit(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	AnnouncementVo getVo_AdminEdit(Long id) throws CustomException;

	/**
	 * 后台查看详情
	 */
	AnnouncementVo getVo_AdminView(Long id) throws CustomException;
}
