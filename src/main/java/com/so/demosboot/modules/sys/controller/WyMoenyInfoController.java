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
import com.so.demosboot.modules.sys.entity.WyHouseLeader;
import com.so.demosboot.modules.sys.entity.WyMoenyInfo;
import com.so.demosboot.modules.sys.service.WyHouseLeaderService;
import com.so.demosboot.modules.sys.service.WyMoenyInfoService;


/**
 * 费用信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyMoenyInfo")
public class WyMoenyInfoController{

	@Autowired
	private WyMoenyInfoService wyMoenyInfoService;
	@Autowired
	private WyHouseLeaderService wyHouseLeaderService;
	
	@ModelAttribute
	public WyMoenyInfo get(@RequestParam(required=false) String id) {
		WyMoenyInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyMoenyInfoService.getById(id);
		}else{
			entity = new WyMoenyInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyMoenyInfo wyMoenyInfo, Model model) {
		PageHelper.startPage(wyMoenyInfo.getPageNo(),10);
		List<WyMoenyInfo> list = wyMoenyInfoService.findList(wyMoenyInfo);
		PageInfo<WyMoenyInfo> pageInfo = new PageInfo<WyMoenyInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/wyMoenyInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyMoenyInfo wyMoenyInfo, Model model) {
		if (StringUtils.isNotEmpty(wyMoenyInfo.getId())){
			wyMoenyInfo = wyMoenyInfoService.getById(wyMoenyInfo.getId());
			model.addAttribute("wyMoenyInfo",wyMoenyInfo);
		}
		return "sys/wyMoenyInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyMoenyInfo wyMoenyInfo,RedirectAttributes redirectAttributes) {
		wyMoenyInfoService.save(wyMoenyInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyHouseLeader/moneyInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyMoenyInfo wyMoenyInfo, RedirectAttributes redirectAttributes) {
		wyMoenyInfoService.delete(wyMoenyInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyMoenyInfo";
	}

}