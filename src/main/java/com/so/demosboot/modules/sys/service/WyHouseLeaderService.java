package com.so.demosboot.modules.sys.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.so.demosboot.common.baseData.BaseService;
import com.so.demosboot.common.utils.IdGenUtil;
import com.so.demosboot.modules.sys.dao.WyHouseInfoDao;
import com.so.demosboot.modules.sys.dao.WyHouseLeaderDao;
import com.so.demosboot.modules.sys.entity.WyHouseInfo;
import com.so.demosboot.modules.sys.entity.WyHouseLeader;

/**
 * 户主信息Service
 * @author so
 * @version V1.0
 */
@Service
@Transactional
public class WyHouseLeaderService extends BaseService<WyHouseLeaderDao, WyHouseLeader> {

	@Autowired
	WyHouseInfoDao wyHouseInfoDao;
	
	@Override
	public void save(WyHouseLeader entity) {
		WyHouseInfo houseInfo = wyHouseInfoDao.getById(entity.getHouseId());
		if (StringUtils.isEmpty(entity.getId())){
			entity.setId(IdGenUtil.getRandomNumr());
			dao.insert(entity);
			//更新对应房子的状态为不可入住
			houseInfo.setHouseStatue("0");
			wyHouseInfoDao.update(houseInfo);
		}else{
			if ("1".equals(entity.getIsOut())) {
				houseInfo.setHouseStatue("1");
				wyHouseInfoDao.update(houseInfo);
			}
			dao.update(entity);
		}
	}
	
}