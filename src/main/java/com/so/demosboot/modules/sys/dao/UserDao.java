package com.so.demosboot.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.sys.entity.User;

@Mapper
public interface UserDao extends BaseDao<User> {

    public User login(User user);

}
