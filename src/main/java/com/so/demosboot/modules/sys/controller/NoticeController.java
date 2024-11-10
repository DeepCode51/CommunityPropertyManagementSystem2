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
import com.so.demosboot.modules.sys.entity.Notice;
import com.so.demosboot.modules.sys.service.NoticeService;
import com.so.demosboot.modules.sys.utils.UserUtil;


/**
 * 系统通知Controller
 * @author so
 * @version v1.0
 */
@Controller
@RequestMapping(value = "/sys/notice")
public class NoticeController{

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute
	public Notice get(@RequestParam(required=false) String id) {
		Notice entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = noticeService.getById(id);
		}else{
			entity = new Notice();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Notice notice, Model model) {
		PageHelper.startPage(notice.getPageNo(),10);
		List<Notice> list = noticeService.findList(notice);
		PageInfo<Notice> pageInfo = new PageInfo<Notice>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/noticeList";
	}

	@RequestMapping(value = "form")
	public String form(Notice notice, Model model) {
		if (StringUtils.isNotEmpty(notice.getId())){
			notice = noticeService.getById(notice.getId());
			model.addAttribute("notice",notice);
		}
		return "sys/noticeForm";
	}

	@RequestMapping(value = "save")
	public String save(Notice notice,RedirectAttributes redirectAttributes,HttpServletRequest request) {
		if (StringUtils.isEmpty(notice.getId())) {
			notice.setLooks(0);
			notice.setAuthor(UserUtil.currentUser(request).getUsername());
			notice.setPublishTime(DateUtils.getDateTime());
		}
		noticeService.save(notice);
		redirectAttributes.addFlashAttribute("msg", "保存记录成功！");
		return "redirect:"+"/sys/notice";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Notice notice, RedirectAttributes redirectAttributes) {
		noticeService.delete(notice.getId());
		redirectAttributes.addFlashAttribute("msg", "删除记录成功！");
		return "redirect:"+"/sys/notice";
	}

	@RequestMapping(value = "detail")
	public String detail(Notice notice, Model model) {
		notice.setLooks(notice.getLooks()+1);
		noticeService.save(notice);
		return "sys/noticeDetail";
	}
}