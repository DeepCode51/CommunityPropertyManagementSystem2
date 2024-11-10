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
import com.so.demosboot.modules.sys.entity.WyPlotInfo;
import com.so.demosboot.modules.sys.service.WyPlotInfoService;


/**
 * 小区信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyPlotInfo")
public class WyPlotInfoController{

	@Autowired
	private WyPlotInfoService wyPlotInfoService;
	
	@ModelAttribute
	public WyPlotInfo get(@RequestParam(required=false) String id) {
		WyPlotInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyPlotInfoService.getById(id);
		}else{
			entity = new WyPlotInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyPlotInfo wyPlotInfo, Model model) {
		PageHelper.startPage(wyPlotInfo.getPageNo(),10);
		List<WyPlotInfo> list = wyPlotInfoService.findList(wyPlotInfo);
		PageInfo<WyPlotInfo> pageInfo = new PageInfo<WyPlotInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/wyPlotInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyPlotInfo wyPlotInfo, Model model) {
		if (StringUtils.isNotEmpty(wyPlotInfo.getId())){
			wyPlotInfo = wyPlotInfoService.getById(wyPlotInfo.getId());
			model.addAttribute("wyPlotInfo",wyPlotInfo);
		}
		return "sys/wyPlotInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyPlotInfo wyPlotInfo,RedirectAttributes redirectAttributes) {
		wyPlotInfoService.save(wyPlotInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyPlotInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyPlotInfo wyPlotInfo, RedirectAttributes redirectAttributes) {
		wyPlotInfoService.delete(wyPlotInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyPlotInfo";
	}

}