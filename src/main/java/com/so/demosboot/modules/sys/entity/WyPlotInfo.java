package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 小区信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyPlotInfo extends BaseEntity<WyPlotInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String plotName;		// 小区名称
	private String buildTime;		// 成立时间
	private String remark;		// 备注
	
	public WyPlotInfo() {
		super();
	}

	public WyPlotInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=100, message="小区名称长度必须介于 1 和 100 之间")
	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
	
	@Length(min=1, max=40, message="成立时间长度必须介于 1 和 40 之间")
	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}