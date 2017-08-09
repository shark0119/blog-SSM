package com.hfxt.web.controller.section;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.SectionVo;
import com.hfxt.web.controller.BaseController;
import common.model.JsonCrudModel;



@Controller("BlogSection.PageController")
@RequestMapping(PageController.Location)
public class PageController extends BaseController implements Serializable {

	private static final long serialVersionUID = 6219876708802336943L;

	public static final String Location = "/section";
	//404页面
	private static final String Page_404 = "../../resources/errors/404";

	private static final String LISt_PAGE = "/blog/back/section-manage";
	
	
	
	/**
	 * 查看处理的controller
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "manage" ,method=RequestMethod.GET )
	public String getallreplyComment(Model model) throws Exception{
		//创建list集合接收栏目属性
		List<SectionVo> sectionVos=sectionService.getAllSections();
		//创建 list 接收最新数据
		List<SectionVo> newsectionVos=new ArrayList<SectionVo>();
		//循环获取总数
		for(SectionVo sectionVo :sectionVos){
			log.debug(""+sectionVo.getSectionId());
			int count =sectionService.getAllSectionCount(sectionVo.getSectionId());
			sectionVo.setCount(count);
			newsectionVos.add(sectionVo);
		}
		model.addAttribute("sections", newsectionVos);
		return LISt_PAGE;
	}
	
	/**增加一个新栏目
	 * @param model
	 * @param sectionVo
	 * @return
	 */
	@RequestMapping(value="addsection", method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<SectionVo> addSection(Model model,SectionVo sectionVo){
		final JsonCrudModel<SectionVo> result = new JsonCrudModel<SectionVo>();
		sectionVo.setVisiable(0);
		try {
			int i=sectionService.addSection(sectionVo);
			if(i>0){
				//成功
				result.setStatus(JsonCrudModel.Status_Success);
			}else{
				//失败
				result.setStatus(JsonCrudModel.Status_Error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**根据id删除一个栏目
	 * @param model
	 * @param sectionid
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<SectionVo> deleteSection(Model model,Integer sectionid){
		final JsonCrudModel<SectionVo> result = new JsonCrudModel<SectionVo>();
			try {
				
				int i=sectionService.deleteSection(sectionid);
				
				if(i>0){
					//成功
					result.setStatus(JsonCrudModel.Status_Success);
				}else{
					//失败
					result.setStatus(JsonCrudModel.Status_Error);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	public JsonCrudModel<SectionVo> updateSection(Model model,Integer sectionid){
		final JsonCrudModel<SectionVo> result = new JsonCrudModel<SectionVo>();
		return result;
	}
	
	/**跳转到修该的页面
	 * @param model
	 * @param sectionid
	 * @return
	 */
	@RequestMapping(value="skipupdate",method=RequestMethod.GET)
	public String skipUpdate(Model model,Integer sectionid){
			//创建 list 接收最新数据
			List<SectionVo> newsectionVos = new ArrayList<SectionVo>();
			//创建一个用户实体
			SectionVo newSectionVo=new SectionVo();
			try {
				List<SectionVo> sectionVos=sectionService.getAllSections();
				//循环获取总数
				for(SectionVo sectionVo :sectionVos){
					//log.debug(""+sectionVo.getSectionId());
					int count =sectionService.getAllSectionCount(sectionVo.getSectionId());
					sectionVo.setCount(count);
					newsectionVos.add(sectionVo);
				}
				newSectionVo=sectionService.getSectionById(sectionid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//数据库列表
			model.addAttribute("sections", newsectionVos);
			//当前要修改的用户的实体
			model.addAttribute("section", newSectionVo);
			//判断当前需要进入的页面
			model.addAttribute("isupdate", 1);
		
		return LISt_PAGE;
	}
	/**修改栏目
	 * @param model
	 * @param sectionVo
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<SectionVo> updateSection(Model model,SectionVo sectionVo){
		final JsonCrudModel<SectionVo> result = new JsonCrudModel<SectionVo>();
		try {
			int i=sectionService.updateSection(sectionVo);
			
			if(i>0){
				//成功
				result.setStatus(JsonCrudModel.Status_Success);
			}else{
				//失败
				result.setStatus(JsonCrudModel.Status_Error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**查看当前栏目名是否存在
	 * @param sectionName
	 * @return
	 */
	@RequestMapping(value="isSectioNanme",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<SectionVo> isSection(String sectionName,Integer sectionId){
		final JsonCrudModel<SectionVo> result = new JsonCrudModel<SectionVo>();
		//知道要修改的用户的实体
		log.debug(""+sectionId);
		SectionVo oldsectionVo=new SectionVo();
		try {
			SectionVo sectionVo=sectionService.getSectionVoByName(sectionName);
			//log.debug(sectionVo.getDescription());
			if(sectionVo==null){
				//成功
				result.setStatus(JsonCrudModel.Status_Success);
			}else{
				//失败
				result.setStatus(JsonCrudModel.Status_Error);
			}
			oldsectionVo=sectionService.getSectionById(sectionId);
			if(oldsectionVo!=null){
				if(sectionName.equals(oldsectionVo.getSectionName())){
					//跳过
					result.setStatus(JsonCrudModel.Status_Success);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
