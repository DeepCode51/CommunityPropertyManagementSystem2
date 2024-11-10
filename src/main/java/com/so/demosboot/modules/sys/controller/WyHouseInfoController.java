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
import com.so.demosboot.modules.sys.entity.WyHouseInfo;
import com.so.demosboot.modules.sys.service.WyHouseInfoService;


/**
 * 房间信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyHouseInfo")
public class WyHouseInfoController{

	@Autowired
	private WyHouseInfoService wyHouseInfoService;
	
	@ModelAttribute
	public WyHouseInfo get(@RequestParam(required=false) String id) {
		WyHouseInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyHouseInfoService.getById(id);
		}else{
			entity = new WyHouseInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyHouseInfo wyHouseInfo, Model model) {
		PageHelper.startPage(wyHouseInfo.getPageNo(),10);
		List<WyHouseInfo> list = wyHouseInfoService.findList(wyHouseInfo);
		PageInfo<WyHouseInfo> pageInfo = new PageInfo<WyHouseInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/wyHouseInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyHouseInfo wyHouseInfo, Model model) {
		if (StringUtils.isNotEmpty(wyHouseInfo.getId())){
			wyHouseInfo = wyHouseInfoService.getById(wyHouseInfo.getId());
			model.addAttribute("wyHouseInfo",wyHouseInfo);
		}
		return "sys/wyHouseInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyHouseInfo wyHouseInfo,RedirectAttributes redirectAttributes) {
		wyHouseInfoService.save(wyHouseInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyHouseInfo?buildId="+wyHouseInfo.getBuildId();
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyHouseInfo wyHouseInfo, RedirectAttributes redirectAttributes) {
		wyHouseInfoService.delete(wyHouseInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyHouseInfo?buildId="+wyHouseInfo.getBuildId();
	}

	@ResponseBody
	@RequestMapping(value = "getByBuildId")
	public List<WyHouseInfo> getByBuildId(WyHouseInfo wyHouseInfo, Model model) {
		List<WyHouseInfo> list = new ArrayList<WyHouseInfo>();
		wyHouseInfo.setHouseStatue("1");//只查可以入住的
		list = wyHouseInfoService.findList(wyHouseInfo);
		return list;
	}
}