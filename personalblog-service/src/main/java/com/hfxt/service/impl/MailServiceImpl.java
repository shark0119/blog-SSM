package com.hfxt.service.impl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.hfxt.service.IMailService;

@Service("service.impl.MailServiceImpl")
public class MailServiceImpl implements IMailService {

	private static Logger logger = Logger.getLogger(MailServiceImpl.class);
	
	@Autowired
	public SimpleMailMessage activationMailMessage;
	@Autowired
	public JavaMailSenderImpl mailSender;

	/**
	 * 已测试
	 */
	public String sendEms(String recePhoneNum, String content) throws Exception {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.api.smschinese.cn");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", "huhai"), new NameValuePair("Key", "974d28369bb2dc0aa153"),
				new NameValuePair("smsMob", recePhoneNum), new NameValuePair("smsText", content) };
		post.setRequestBody(data);
		client.executeMethod(post);
		String result = new String(post.getResponseBodyAsString().getBytes());
		post.releaseConnection();
		return result;
	}
	
	public void sendEmail(String receEmialAddress, String subject, String content) throws Exception {
		activationMailMessage.setTo(receEmialAddress);
		activationMailMessage.setText(content);
		activationMailMessage.setSubject(subject);
		mailSender.send(activationMailMessage);
		logger.info("activation:"+ receEmialAddress + " and content is:" + content);
	}
}
