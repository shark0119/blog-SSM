package com.hfxt.web.controller.blogmessage;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

import com.hfxt.web.controller.BaseController;
@Controller("AnnouncementController")
@RequestMapping(value="/announcement")
public class AnnouncementController extends BaseController{
	
	@RequestMapping(value="/addAnnouncement",method=RequestMethod.GET)
	public ModelAndView addAnnouncement()throws Exception{
		return new ModelAndView("blogmessage/addAnnouncement");
	}
	
	@RequestMapping(value="/addAnnouncement",method=RequestMethod.POST)
	public ModelAndView addAnnouncMment(HttpServletRequest req)throws Exception{
		String content= req.getParameter("content");
		String title=req.getParameter("title");
		Map<String,String> hash=new HashMap<String, String>();
		String id=new Date().getTime()+"";
		hash.put("id", id);
		hash.put("title", title);
		hash.put("content", content);
		hash.put("createtime", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		Jedis jedis=new Jedis("localhost");
		if("OK".equals(jedis.hmset(id, hash))){
			jedis.lpush("announcement", id);
		}
		
		jedis.close();
		return new ModelAndView("redirect:announcementList?page=1");
	}
	
	@RequestMapping(value="/announcementList")
	public String announcementList(@RequestParam(value="page",required=false)long page,Model model){
	
		Jedis jedis=announcementService.getJedis();
		List<String> list=jedis.lrange("announcement", (page-1)*10, page*10-1);
		if(list.size()==0){
			page-=1;
			list=jedis.lrange("announcement", (page-1)*10, page*10);
		}
		List<Map<String,String>> announce=new ArrayList<Map<String,String>>();
		for(String key:list){
			announce.add(jedis.hgetAll(key));
		}
		model.addAttribute("listAnno", announce);
		model.addAttribute("page", page);
		jedis.close();
		return "blogmessage/announcementList";
	}
	
	@RequestMapping(value="/getNewAnnounce")
	public @ResponseBody Map<String,String> getNewAnnounce(){
		Jedis jedis=announcementService.getJedis();
		String newAnnounceName=jedis.lrange("announcement", 0, 1).size()>0?jedis.lrange("announcement", 0, 1).get(0):"";
		Map<String,String> newAnnounce=jedis.hgetAll(newAnnounceName);
		return newAnnounce;
	}
	
	@RequestMapping(value="/updateAnno",method=RequestMethod.GET)
	public String updateAnno(@RequestParam String id,Model model){
		Jedis jedis=announcementService.getJedis();
		model.addAttribute("anno", jedis.hgetAll(id));
		jedis.close();
		return "blogmessage/addAnnouncement";
	}
	
	@RequestMapping(value="/addAnnouncement",method=RequestMethod.POST,params="id")
	public ModelAndView updateAnnouncMment(@RequestParam(value="id") String id,HttpServletRequest req)throws Exception{
		String content= req.getParameter("content");
		String title=req.getParameter("title");
		Jedis jedis=new Jedis("localhost");
		jedis.hset(id, "title", title);
		jedis.hset(id, "content", content);
		jedis.hset(id, "createtime", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		jedis.close();
		return new ModelAndView("redirect:announcementList?page=1");
	}
	
	@RequestMapping(value="/delAnno")
	
	public @ResponseBody Map<String,String> delAnno(@RequestParam String id){
		Jedis jedis=new Jedis("localhost");
		jedis.lrem("announcement", 0, id);
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
		String[] ids=id.split(",");
		Jedis jedis=new Jedis("localhost");
		for(String i:ids){
			
			jedis.lrem("announcement", 0, i);
			jedis.del(i);
		
		}
		Map<String,String> requestMap=new HashMap<String, String>();
		requestMap.put("retCode", "0");
		jedis.close();
		
		return requestMap;
	}
	
	@RequestMapping(value="/publicBack")
	public String publicBack(Model model){
		
		return "/publicBack";
	}
	
	@RequestMapping(value="/getAnno")
	
	public @ResponseBody Map<String,String> getAnno(@RequestParam String id){
		Jedis jedis=new Jedis("localhost");
		Map<String,String> requestMap=jedis.hgetAll(id);
		requestMap.put("retCode", "0");
		jedis.close();
		return requestMap;
	}
	
	@RequestMapping(value="/frontAnno")
	public String getFrontAnno(Model model){
		Jedis jedis=new Jedis("localhost");
		List<String> list=jedis.lrange("announcement", 0, 10);
		
		List<Map<String,String>> announce=new ArrayList<Map<String,String>>();
		for(String key:list){
			announce.add(jedis.hgetAll(key));
		}
		model.addAttribute("listAnno", announce);
		jedis.close();
		return "blog/front/announcement";
	}
	
	
}
