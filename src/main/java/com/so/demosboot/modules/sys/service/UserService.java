package com.so.demosboot.modules.sys.service;


import org.springframework.stereotype.Service;

import com.so.demosboot.common.baseData.BaseService;
import com.so.demosboot.modules.sys.dao.UserDao;
import com.so.demosboot.modules.sys.entity.User;

@Service
public class UserService extends BaseService<UserDao, User> {
	
	public User login (User user){
	    return dao.login(user);
    }
}
