package com.so.demosboot.modules.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.sys.entity.WyParkInfo;
import com.so.demosboot.modules.sys.entity.WyPlotInfo;
import com.so.demosboot.modules.sys.service.WyParkInfoService;
import com.so.demosboot.modules.sys.service.WyPlotInfoService;


/**
 * 停车位信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyParkInfo")
public class WyParkInfoController{

	@Autowired
	private WyParkInfoService wyParkInfoService;
	@Autowired
	private WyPlotInfoService wyPlotInfoService;
	
	@ModelAttribute
	public WyParkInfo get(@RequestParam(required=false) String id) {
		WyParkInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyParkInfoService.getById(id);
		}else{
			entity = new WyParkInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyParkInfo wyParkInfo, Model model) {
		PageHelper.startPage(wyParkInfo.getPageNo(),10);
		List<WyParkInfo> list = wyParkInfoService.findList(wyParkInfo);
		PageInfo<WyParkInfo> pageInfo = new PageInfo<WyParkInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		List<WyPlotInfo> findList = wyPlotInfoService.findList(new WyPlotInfo());
		model.addAttribute("wyPlotInfos",findList);
		return "sys/wyParkInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyParkInfo wyParkInfo, Model model) {
		if (StringUtils.isNotEmpty(wyParkInfo.getId())){
			wyParkInfo = wyParkInfoService.getById(wyParkInfo.getId());
			model.addAttribute("wyParkInfo",wyParkInfo);
		}
		List<WyPlotInfo> findList = wyPlotInfoService.findList(new WyPlotInfo());
		model.addAttribute("wyPlotInfos",findList);
		return "sys/wyParkInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyParkInfo wyParkInfo,RedirectAttributes redirectAttributes) {
		wyParkInfoService.save(wyParkInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyParkInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyParkInfo wyParkInfo, RedirectAttributes redirectAttributes) {
		wyParkInfoService.delete(wyParkInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyParkInfo";
	}

}