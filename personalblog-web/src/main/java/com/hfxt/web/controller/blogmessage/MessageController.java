package com.hfxt.web.controller.blogmessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.web.controller.BaseController;

import redis.clients.jedis.Jedis;


@Controller
@RequestMapping(value="message")
public class MessageController extends BaseController{
	
	@RequestMapping(value="/runAddMsg")
	public String runAddMsg(@RequestParam(value="receiveId",required=false) String receiveId,Model model){
		model.addAttribute("receiveId", receiveId);
		return "blogmessage/addMsg";
	}
	
	@RequestMapping(value="/addMsg",method=RequestMethod.POST)
	public String addMsg(HttpServletRequest req,Model model){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		System.out.println(currentId);
		 String receiveId =req.getParameter("receiveId");
		 String title =req.getParameter("title");
		 String content =req.getParameter("content");
		Map<String,String> msg=new HashMap<String, String>();
		String id=receiveId+new Date().getTime();
		msg.put("id", id);
		msg.put("receiverId", receiveId);
		msg.put("sendId",currentId);
		msg.put("title", title);
		msg.put("content", content);
		msg.put("time",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		Jedis jedis=new Jedis("localhost");
		jedis.hmset(id, msg);
		jedis.lpush("msg::"+receiveId, id);
		jedis.sadd("msgcount::"+receiveId, id);
		req.getSession().setAttribute("receiveId", receiveId);
		jedis.close();
		return "redirect:getMsgList?page=1";
	}
	
	
	@RequestMapping(value="/getMsgList")
	public String getMsgList(@RequestParam(value="page",required=false)long page,Model model){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal(); 
		Jedis jedis=new Jedis("localhost");
		List<String> list=jedis.lrange("msg::"+currentId, (page-1)*10, page*10-1);
		while(list.size()==0&&page>1){
			page-=1;
			list=jedis.lrange("msg::"+currentId, (page-1)*10, page*10);
		}
		List<Map<String,String>> msg=new ArrayList<Map<String,String>>();
		for(String key:list){
			msg.add(jedis.hgetAll(key));
		}
		model.addAttribute("listMsg", msg);

		model.addAttribute("page", page);
		jedis.close();
		return "blogmessage/msgList";
	}
	
	@RequestMapping(value="/delMsg")
	public @ResponseBody Map<String,String> delAnno(@RequestParam String id){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		Jedis jedis=new Jedis("localhost");
		jedis.lrem("msg::"+currentId, 0, id);
		Map<String,String> requestMap=new HashMap<String, String>();
		if(jedis.del(id)>0){
			requestMap.put("retCode", "0");
		}else{
			requestMap.put("retCode", "1");
			requestMap.put("msg", "删除失败");
		}
		jedis.close();
		
		return requestMap;
	}
	
	@RequestMapping(value="/delAll")
	@ResponseBody
	public Map<String,String> delAll(@RequestParam String id){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		
		String[] ids=id.split(",");
		Jedis jedis=new Jedis("localhost");
		for(String i:ids){
			
			jedis.lrem("msg::"+currentId, 0, i);
			jedis.del(i);
		
		}
		Map<String,String> requestMap=new HashMap<String, String>();
		requestMap.put("retCode", "0");
		jedis.close();
		
		return requestMap;
	}
	
	@RequestMapping(value="/getMsg")
	public @ResponseBody Map<String,String> getMsg(@RequestParam String id){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		Jedis jedis=new Jedis("localhost");
		Map<String,String> requestMap=jedis.hgetAll(id);
		
		jedis.srem("msgcount::"+currentId, id);
		
		requestMap.put("retCode", "0");
		requestMap.put("msgCount", jedis.scard("msgcount::"+currentId).toString());
		jedis.close();
		return requestMap;
	}
	
	@RequestMapping(value="/getMsgCount")
	public @ResponseBody Map<String,String> getMsgCont(){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		Jedis jedis=new Jedis("localhost");
		Map<String,String> requestMap=new HashMap<String, String>();
		
		requestMap.put("msgCount", jedis.scard("msgcount::"+currentId).toString());
		jedis.close();
		return requestMap;
	}
	
	@RequestMapping(value="/messageAdmin")
	public String messageAdmin(Model model){
		Jedis jedis=announcementService.getJedis();
		List<Map> lists=new ArrayList<Map>();
		List<String> messageList=jedis.lrange("message", 0, 9);
		
		for(String key:messageList){
			Map<String,Object> msgList=new HashMap<String, Object>();
			Map<String,String> map=jedis.hgetAll(key);
			msgList.put("comment", map);
			List<String> listAnswer=jedis.lrange("ans::"+key, 0, 50);
			List<Map<String,String>> lm=new ArrayList<Map<String,String>>();
			for(String k:listAnswer){
				Map<String,String> m=jedis.hgetAll(k);
				lm.add(m);
			}
			msgList.put("ans", lm);
			lists.add(msgList);
		}
		model.addAttribute("message", lists);
		jedis.close();
		return "blog/front/blogMessage";
	}
	
	@RequestMapping(value="/messagePage")
	public String getMessagePage(Model model){
		
		return "blogmessage/message";
	}
	
	@RequestMapping(value="/sendMsgToAdmin")
	public @ResponseBody Map<String,String> sendMsgToAdmin(HttpServletRequest req){
		Map<String,String> model=new HashMap<String, String>();
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		if("".equals(currentId)||null==currentId){
			model.put("retCode", "101");
			return model;
		}
		String comment=req.getParameter("comment");
		String createtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Jedis jedis=announcementService.getJedis();
		Map<String,String> hash=new HashMap<String, String>();
		hash.put("id", currentId+createtime);
		hash.put("comment", comment);
		hash.put("createtime", createtime);
		hash.put("sendId", currentId);
		jedis.hmset(currentId+createtime, hash);
		jedis.lpush("message", currentId+createtime);
		jedis.lpush("message::"+currentId, currentId+createtime);
		jedis.sadd("msgcount::admin", currentId+createtime);
		jedis.close();
		
		model.put("retCode", "0");
		return model;
		
	}
	@RequiresAuthentication
	@RequestMapping(value="/getMessage")
	public  String getMessage(HttpServletRequest req,Model model){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		String role=userService.getRoleByName(currentId);
		Jedis jedis=announcementService.getJedis();
		List<Map> lists=new ArrayList<Map>();
		if(role.equals("admin")){
			List<String> messageList=jedis.lrange("message", 0, 9);
			
			for(String key:messageList){
				Map<String,Object> msgList=new HashMap<String, Object>();
				Map<String,String> map=jedis.hgetAll(key);
				msgList.put("comment", map);
				List<String> listAnswer=jedis.lrange("ans::"+key, 0, 50);
				List<Map<String,String>> lm=new ArrayList<Map<String,String>>();
				for(String k:listAnswer){
					Map<String,String> m=jedis.hgetAll(k);
					lm.add(m);
				}
				msgList.put("ans", lm);
				lists.add(msgList);
			}
		}else{
				List<String> messageList=jedis.lrange("message::"+currentId, 0, 9);
				
				for(String key:messageList){
					Map<String,Object> msgList=new HashMap<String, Object>();
					Map<String,String> map=jedis.hgetAll(key);
					msgList.put("comment", map);
					List<String> listAnswer=jedis.lrange("ans::"+key, 0, 50);
					List<Map<String,String>> lm=new ArrayList<Map<String,String>>();
					for(String k:listAnswer){
						Map<String,String> m=jedis.hgetAll(k);
						lm.add(m);
					}
					msgList.put("ans", lm);
					lists.add(msgList);
				}
			
		}
		model.addAttribute("message", lists);
		return "blogmessage/message";
	}
	
	@RequestMapping(value="/sendComments")
	public @ResponseBody Map<String,String> sendComment(HttpServletRequest req){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		String comment=req.getParameter("comment");
		String sendId=req.getParameter("sendId");
		System.out.println(comment);
		String id=req.getParameter("id");
		String createtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Jedis jedis=announcementService.getJedis();
		
		Map<String,String> hash=new HashMap<String, String>();
		hash.put("id", id);
		hash.put("comment", comment);
		hash.put("createtime", createtime);
		hash.put("sendId", currentId);
		jedis.hmset("ans::"+currentId+createtime, hash);
		
		jedis.rpush("ans::"+id, "ans::"+currentId+createtime);
		Map<String,String> resultMap=new HashMap<String, String>();
		resultMap.put("retCode", "0");
		if(userService.getRoleByName(currentId).equals("admin")){
			jedis.sadd("msgcount::"+sendId, "ans::"+currentId+createtime);
		}else{
			jedis.sadd("msgcount::admin", "ans::"+currentId+createtime);
		}
		jedis.close();
		return resultMap;
		
	}
	
	@RequestMapping(value="/getCount")
	public @ResponseBody Map<String,String> getCount(HttpServletRequest req){
		String currentId=(String) SecurityUtils.getSubject().getPrincipal();
		Jedis jedis=announcementService.getJedis();
		
	
		Map<String,String> resultMap=new HashMap<String, String>();
		
		if(userService.getRoleByName(currentId).equals("admin")){
			resultMap.put("count", jedis.scard("msgcount::admin").toString());
			jedis.del("msgcount::admin");
		}else{
			resultMap.put("count",jedis.sadd("msgcount::"+currentId).toString());
			jedis.del("msgcount::"+currentId);
		}
		jedis.close();
		
		return resultMap;
		
	}
	
}
