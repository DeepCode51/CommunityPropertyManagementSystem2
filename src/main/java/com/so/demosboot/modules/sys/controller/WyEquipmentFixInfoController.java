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
import com.so.demosboot.modules.sys.entity.WyEquipmentFixInfo;
import com.so.demosboot.modules.sys.service.WyEquipmentFixInfoService;


/**
 * 设备维修信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyEquipmentFixInfo")
public class WyEquipmentFixInfoController{

	@Autowired
	private WyEquipmentFixInfoService wyEquipmentFixInfoService;
	
	@ModelAttribute
	public WyEquipmentFixInfo get(@RequestParam(required=false) String id) {
		WyEquipmentFixInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyEquipmentFixInfoService.getById(id);
		}else{
			entity = new WyEquipmentFixInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyEquipmentFixInfo wyEquipmentFixInfo, Model model) {
		PageHelper.startPage(wyEquipmentFixInfo.getPageNo(),10);
		List<WyEquipmentFixInfo> list = wyEquipmentFixInfoService.findList(wyEquipmentFixInfo);
		PageInfo<WyEquipmentFixInfo> pageInfo = new PageInfo<WyEquipmentFixInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/wyEquipmentFixInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyEquipmentFixInfo wyEquipmentFixInfo, Model model) {
		if (StringUtils.isNotEmpty(wyEquipmentFixInfo.getId())){
			wyEquipmentFixInfo = wyEquipmentFixInfoService.getById(wyEquipmentFixInfo.getId());
			model.addAttribute("wyEquipmentFixInfo",wyEquipmentFixInfo);
		}
		return "sys/wyEquipmentFixInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyEquipmentFixInfo wyEquipmentFixInfo,RedirectAttributes redirectAttributes) {
		wyEquipmentFixInfoService.save(wyEquipmentFixInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyEquipmentFixInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyEquipmentFixInfo wyEquipmentFixInfo, RedirectAttributes redirectAttributes) {
		wyEquipmentFixInfoService.delete(wyEquipmentFixInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyEquipmentFixInfo";
	}

}