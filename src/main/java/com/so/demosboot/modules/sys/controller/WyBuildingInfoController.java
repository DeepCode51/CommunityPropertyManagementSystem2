package com.so.demosboot.modules.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.sys.entity.WyBuildingInfo;
import com.so.demosboot.modules.sys.entity.WyPlotInfo;
import com.so.demosboot.modules.sys.service.WyBuildingInfoService;
import com.so.demosboot.modules.sys.service.WyPlotInfoService;


/**
 * 楼房信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyBuildingInfo")
public class WyBuildingInfoController{

	@Autowired
	private WyBuildingInfoService wyBuildingInfoService;
	
	@Autowired
	private WyPlotInfoService wyPlotInfoService;
	
	@ModelAttribute
	public WyBuildingInfo get(@RequestParam(required=false) String id) {
		WyBuildingInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyBuildingInfoService.getById(id);
		}else{
			entity = new WyBuildingInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyBuildingInfo wyBuildingInfo, Model model) {
		PageHelper.startPage(wyBuildingInfo.getPageNo(),10);
		List<WyBuildingInfo> list = wyBuildingInfoService.findList(wyBuildingInfo);
		PageInfo<WyBuildingInfo> pageInfo = new PageInfo<WyBuildingInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		
		List<WyPlotInfo> findList = wyPlotInfoService.findList(new WyPlotInfo());
		model.addAttribute("wyPlotInfos",findList);
		return "sys/wyBuildingInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyBuildingInfo wyBuildingInfo, Model model) {
		if (StringUtils.isNotEmpty(wyBuildingInfo.getId())){
			wyBuildingInfo = wyBuildingInfoService.getById(wyBuildingInfo.getId());
			model.addAttribute("wyBuildingInfo",wyBuildingInfo);
		}
		
		List<WyPlotInfo> findList = wyPlotInfoService.findList(new WyPlotInfo());
		model.addAttribute("wyPlotInfos",findList);
		return "sys/wyBuildingInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyBuildingInfo wyBuildingInfo,RedirectAttributes redirectAttributes) {
		wyBuildingInfoService.save(wyBuildingInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyBuildingInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyBuildingInfo wyBuildingInfo, RedirectAttributes redirectAttributes) {
		wyBuildingInfoService.delete(wyBuildingInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyBuildingInfo";
	}
	
	@ResponseBody
	@RequestMapping(value = "getByPlotId")
	public List<WyBuildingInfo> getByPlotId(WyBuildingInfo wyBuildingInfo, Model model) {
		List<WyBuildingInfo> list = new ArrayList<WyBuildingInfo>();
		list = wyBuildingInfoService.findList(wyBuildingInfo);
		return list;
	}

}