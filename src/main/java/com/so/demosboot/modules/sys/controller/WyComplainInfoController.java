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

import javax.servlet.http.HttpServletRequest;

import com.so.demosboot.common.utils.DateUtils;
import com.so.demosboot.common.utils.StringUtils;
import com.so.demosboot.modules.sys.entity.WyComplainInfo;
import com.so.demosboot.modules.sys.service.WyComplainInfoService;
import com.so.demosboot.modules.sys.utils.UserUtil;


/**
 * 投诉信息Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/wyComplainInfo")
public class WyComplainInfoController{

	@Autowired
	private WyComplainInfoService wyComplainInfoService;
	
	@ModelAttribute
	public WyComplainInfo get(@RequestParam(required=false) String id) {
		WyComplainInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wyComplainInfoService.getById(id);
		}else{
			entity = new WyComplainInfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(WyComplainInfo wyComplainInfo, Model model) {
		PageHelper.startPage(wyComplainInfo.getPageNo(),10);
		List<WyComplainInfo> list = wyComplainInfoService.findList(wyComplainInfo);
		PageInfo<WyComplainInfo> pageInfo = new PageInfo<WyComplainInfo>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/wyComplainInfoList";
	}

	@RequestMapping(value = "form")
	public String form(WyComplainInfo wyComplainInfo, Model model) {
		if (StringUtils.isNotEmpty(wyComplainInfo.getId())){
			wyComplainInfo = wyComplainInfoService.getById(wyComplainInfo.getId());
			model.addAttribute("wyComplainInfo",wyComplainInfo);
		}
		return "sys/wyComplainInfoForm";
	}

	@RequestMapping(value = "save")
	public String save(WyComplainInfo wyComplainInfo,RedirectAttributes redirectAttributes,HttpServletRequest request) {
		if (StringUtils.isEmpty(wyComplainInfo.getId())) {
			wyComplainInfo.setLuruUser(UserUtil.currentUser(request).getUsername());
			wyComplainInfo.setAddTime(DateUtils.getDateTime());
		}
		wyComplainInfoService.save(wyComplainInfo);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/wyComplainInfo";
	}
	
	@RequestMapping(value = "delete")
	public String delete(WyComplainInfo wyComplainInfo, RedirectAttributes redirectAttributes) {
		wyComplainInfoService.delete(wyComplainInfo.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/wyComplainInfo";
	}

}