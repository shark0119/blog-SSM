package com.hfxt.service;

public interface IMailService {
	
	/**
	 * 发送email
	 * @param receEmialAddress 接收人的email的地址
	 * @param title 标题
	 * @param receEmialAddress email地址
	 * @param subject 主题
	 * @param content 发送的内容
	 * @throws Exception 发送失败抛异常
	 */
	public void sendEmail(String receEmialAddress, String subject, String content) throws Exception ;
	
	/**
	 * 发送手机信息
	 * @param recePhoneNum 接收人的手机号
	 * @param content 发送的短信内容
	 * @return 返回值具体意义见  http://sms.webchinese.com.cn/api.shtml
	 * @throws Exception 发送失败抛异常
	 */
	public String sendEms (String recePhoneNum, String content) throws Exception;
}
