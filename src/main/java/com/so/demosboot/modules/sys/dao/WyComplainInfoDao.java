package com.so.demosboot.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.sys.entity.WyComplainInfo;

/**
 * 投诉信息DAO接口
 * @author so
 * @version V1.0
 */
@Mapper
public interface WyComplainInfoDao extends BaseDao<WyComplainInfo> {
	
}