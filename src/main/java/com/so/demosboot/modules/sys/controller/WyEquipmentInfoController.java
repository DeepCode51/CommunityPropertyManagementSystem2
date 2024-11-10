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
import com.so.demosboot.modules.sys.entity.WyEquipmentInfo;
import com.so.demosboot.modules.sys.entity.WyPlotInfo;
import com.so.demosboot.modules.sys.service.WyEquipmentInfoService;
import com.so.demosboot.modules.sys.service.WyPlotInfoService;


/**
 * 设备信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyEquipmentInfo")
public class WyEquipmentInfoController{

	@Autowired
	private WyEquipmentInfoService wyEquipmentInfoService;
	@Autowired
	private WyPlotInfoService wyPlotInfoService;
	
	@ModelAttribute
	public WyEquipmentInfo get(@RequestParam(required=false) String id) {
		WyEquipmentInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyEquipmentInfoService.getById(id);
		}else{
			entity = new WyEquipmentInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyEquipmentInfo wyEquipmentInfo, Model model) {
		PageHelper.startPage(wyEquipmentInfo.getPageNo(),10);
		List<WyEquipmentInfo> list = wyEquipmentInfoService.findList(wyEquipmentInfo);
		PageInfo<WyEquipmentInfo> pageInfo = new PageInfo<WyEquipmentInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		List<WyPlotInfo> findList = wyPlotInfoService.findList(new WyPlotInfo());
		model.addAttribute("wyPlotInfos",findList);
		return "sys/wyEquipmentInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyEquipmentInfo wyEquipmentInfo, Model model) {
		if (StringUtils.isNotEmpty(wyEquipmentInfo.getId())){
			wyEquipmentInfo = wyEquipmentInfoService.getById(wyEquipmentInfo.getId());
			model.addAttribute("wyEquipmentInfo",wyEquipmentInfo);
		}
		List<WyPlotInfo> findList = wyPlotInfoService.findList(new WyPlotInfo());
		model.addAttribute("wyPlotInfos",findList);
		return "sys/wyEquipmentInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyEquipmentInfo wyEquipmentInfo,RedirectAttributes redirectAttributes) {
		wyEquipmentInfoService.save(wyEquipmentInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyEquipmentInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyEquipmentInfo wyEquipmentInfo, RedirectAttributes redirectAttributes) {
		wyEquipmentInfoService.delete(wyEquipmentInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyEquipmentInfo";
	}

}