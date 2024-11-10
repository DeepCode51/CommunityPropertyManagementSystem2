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
import com.so.demosboot.modules.sys.entity.WyHouseFixInfo;
import com.so.demosboot.modules.sys.service.WyHouseFixInfoService;


/**
 * 住户报修信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyHouseFixInfo")
public class WyHouseFixInfoController{

	@Autowired
	private WyHouseFixInfoService wyHouseFixInfoService;
	
	@ModelAttribute
	public WyHouseFixInfo get(@RequestParam(required=false) String id) {
		WyHouseFixInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyHouseFixInfoService.getById(id);
		}else{
			entity = new WyHouseFixInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyHouseFixInfo wyHouseFixInfo, Model model) {
		PageHelper.startPage(wyHouseFixInfo.getPageNo(),10);
		List<WyHouseFixInfo> list = wyHouseFixInfoService.findList(wyHouseFixInfo);
		PageInfo<WyHouseFixInfo> pageInfo = new PageInfo<WyHouseFixInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/wyHouseFixInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyHouseFixInfo wyHouseFixInfo, Model model) {
		if (StringUtils.isNotEmpty(wyHouseFixInfo.getId())){
			wyHouseFixInfo = wyHouseFixInfoService.getById(wyHouseFixInfo.getId());
			model.addAttribute("wyHouseFixInfo",wyHouseFixInfo);
		}
		return "sys/wyHouseFixInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyHouseFixInfo wyHouseFixInfo,RedirectAttributes redirectAttributes) {
		wyHouseFixInfoService.save(wyHouseFixInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyHouseFixInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyHouseFixInfo wyHouseFixInfo, RedirectAttributes redirectAttributes) {
		wyHouseFixInfoService.delete(wyHouseFixInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyHouseFixInfo";
	}

}