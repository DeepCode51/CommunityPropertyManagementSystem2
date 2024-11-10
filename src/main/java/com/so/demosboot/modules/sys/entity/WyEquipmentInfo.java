package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 设备信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyEquipmentInfo extends BaseEntity<WyEquipmentInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;		// 设备名称
	private String plotId;		// 小区编号
	private String isGood;		// 完好程度
	private String addTime;		// 添加时间
	private String remark;		// 备注
	
	public WyEquipmentInfo() {
		super();
	}

	public WyEquipmentInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=100, message="设备名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=40, message="小区编号长度必须介于 1 和 40 之间")
	public String getPlotId() {
		return plotId;
	}

	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}
	
	@Length(min=1, max=40, message="完好程度长度必须介于 1 和 40 之间")
	public String getIsGood() {
		return isGood;
	}

	public void setIsGood(String isGood) {
		this.isGood = isGood;
	}
	
	@Length(min=1, max=40, message="添加时间长度必须介于 1 和 40 之间")
	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String plotName;//小区名称
	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
}