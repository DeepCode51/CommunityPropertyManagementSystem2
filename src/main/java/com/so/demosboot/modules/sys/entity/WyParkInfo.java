package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 停车位信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyParkInfo extends BaseEntity<WyParkInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String plotId;		// 小区编号
	private String parkNo;		// 停车位编号
	private String parkType;		// 停车位类型
	private String carNo;		// 车牌号
	private String drivers;		// 车主姓名
	private String tel;		// 联系电话
	private String parkStatue;		// 停车位状态（0.未使用 1.使用）
	
	public WyParkInfo() {
		super();
	}

	public WyParkInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=40, message="小区编号长度必须介于 1 和 40 之间")
	public String getPlotId() {
		return plotId;
	}

	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}
	
	@Length(min=1, max=40, message="停车位编号长度必须介于 1 和 40 之间")
	public String getParkNo() {
		return parkNo;
	}

	public void setParkNo(String parkNo) {
		this.parkNo = parkNo;
	}
	
	@Length(min=1, max=40, message="停车位类型长度必须介于 1 和 40 之间")
	public String getParkType() {
		return parkType;
	}

	public void setParkType(String parkType) {
		this.parkType = parkType;
	}
	
	@Length(min=0, max=40, message="车牌号长度必须介于 0 和 40 之间")
	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	@Length(min=0, max=40, message="车主姓名长度必须介于 0 和 40 之间")
	public String getDrivers() {
		return drivers;
	}

	public void setDrivers(String drivers) {
		this.drivers = drivers;
	}
	
	@Length(min=0, max=40, message="联系电话长度必须介于 0 和 40 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getParkStatue() {
		return parkStatue;
	}

	public void setParkStatue(String parkStatue) {
		this.parkStatue = parkStatue;
	}
	private String plotName;//小区名称
	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
}