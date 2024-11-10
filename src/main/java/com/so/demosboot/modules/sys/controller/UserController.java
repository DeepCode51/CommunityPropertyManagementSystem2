package com.so.demosboot.modules.sys.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.so.demosboot.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.so.demosboot.modules.sys.entity.User;
import com.so.demosboot.modules.sys.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sys/user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 列表查询
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String findList(User user, Model model){
		PageHelper.startPage(user.getPageNo(),10);
		List<User> list = userService.findList(user);
		PageInfo<User> pageInfo = new PageInfo<User>(list, 10);
		model.addAttribute("pageInfo",pageInfo);
		return "sys/userList";
	}

	/**
	 * 表单跳转
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/form")
	public String form(User user, Model model){
		if (StringUtils.isNotEmpty(user.getId())){
			user = userService.getById(user.getId());
			model.addAttribute("user",user);
		}
		return "sys/userForm";
	}

	/**
	 * 新增修改
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "save")
	public String save(User user,RedirectAttributes redirectAttributes) {
		userService.save(user);
		redirectAttributes.addFlashAttribute("msg", "保存成功！");
		return "redirect:"+"/sys/user/list";
	}

	/**
	 * 删除
	 * @param user
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(User user,RedirectAttributes redirectAttributes){
		userService.delete(user.getId());
		redirectAttributes.addFlashAttribute("msg", "删除成功！");
		return "redirect:"+"/sys/user/list";
	}

	/**
	 * 登录
	 * @param user
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request,Model model){
		User login = userService.login(user);
		if (login!=null){
			request.getSession().setAttribute("login",login);
			return "redirect:"+"/index";
		}else{
			model.addAttribute("msg","用户名或密码错误！");
			return "sys/login";
		}
	}

	@GetMapping("/regit")
	public String regit(){
		return "sys/register";
	}
	
	
	@PostMapping("/regit")
	public String regit(User user, HttpServletRequest request,Model model,RedirectAttributes redirectAttributes){
		User query = new User();
		query.setUsername(user.getUsername());
		List<User> findList = userService.findList(query);
		if (findList!=null && findList.size()>0) {
			model.addAttribute("msg", "注册失败,用户名已存在");
			return "sys/register";
		}else{
			try {
				user.setRole("2");
				userService.save(user);
				redirectAttributes.addFlashAttribute("msg", "注册成功！");
				return "redirect:"+"/login";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "注册失败，服务异常！");
				return "sys/register";
			}
		}
	}
	
	/**
	 * 安全退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:"+"/login";
	}
}
