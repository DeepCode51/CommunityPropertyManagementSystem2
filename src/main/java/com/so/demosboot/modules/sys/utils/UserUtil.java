package com.so.demosboot.modules.sys.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.so.demosboot.modules.sys.entity.User;

/**
 * 
 * @author S0
 *
 */
public class UserUtil {
	
	/**
	 * 获取当前登录的用户
	 * @param request
	 * @return
	 */
	public static User currentUser(HttpServletRequest request){
		User user = null;
		Object attribute = request.getSession().getAttribute("login");
		if (attribute!=null && attribute  instanceof User) {
			user = (User) attribute;
			return user;
		}
		return user;
	}
	
	
}
