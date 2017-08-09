package com.hfxt.service;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
import com.hfxt.domain.search.MessageSearch;
import com.hfxt.domain.vo.MessageVo;

import common.exception.CustomException;
import java.util.List;


public interface IMessageService {

  	// 新添加的方法写在这里 //////////////////////////////////////////////////////////////////////////////////////////////////
	
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
	 * 根据主键查询一条记录,通过'__chooseRM'控制返回的列
	 */
	MessageVo getVo_Auto(Long id, int chooseRM) throws CustomException;
    
    /**
	 * 传入id,判断是否存在该记录
	 */
	boolean isExist_Auto(Long id) throws CustomException;
    
    /**
	 * 查询所有记录的数量
	 */
	long queryCount_Auto(MessageSearch search) throws CustomException;

	/**
	 * 查询所有记录
	 */
	List<MessageVo> queryVos_Auto(MessageSearch search) throws CustomException;
    
    /**
	 * 查询单条记录
	 */
	MessageVo queryVo_Auto(MessageSearch search) throws CustomException;
    
    ////////////////////////////////////////////后台///////////////////////////////////////////

	/**
	 * 后台新增
	 */
	long save_AdminAdd(MessageVo addVo) throws CustomException;

	/**
	 * 后台删除
	 */
	long delete_AdminDelete(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	long edit_AdminEdit(MessageVo editVo) throws CustomException;

	/**
	 * 后台查看编辑
	 */
	MessageVo getVo_preAdminEdit(Long id) throws CustomException;

	/**
	 * 后台编辑
	 */
	MessageVo getVo_AdminEdit(Long id) throws CustomException;

	/**
	 * 后台查看详情
	 */
	MessageVo getVo_AdminView(Long id) throws CustomException;
}
