package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 楼房信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyBuildingInfo extends BaseEntity<WyBuildingInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String plotId;		// 小区编号
	private String buildName;		// 楼房名称
	private Double buildArea;		// 楼房面积
	private String buildLocation;		// 楼房方位
	private String buildStatue;		// 楼房状态
	private String buildTime;		// 建筑日期
	private String remark;		// 备注
	
	public WyBuildingInfo() {
		super();
	}

	public WyBuildingInfo(String id){
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
	
	@Length(min=1, max=40, message="楼房名称长度必须介于 1 和 40 之间")
	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	
	@NotNull(message="楼房面积不能为空")
	public Double getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(Double buildArea) {
		this.buildArea = buildArea;
	}
	
	@Length(min=1, max=40, message="楼房方位长度必须介于 1 和 40 之间")
	public String getBuildLocation() {
		return buildLocation;
	}

	public void setBuildLocation(String buildLocation) {
		this.buildLocation = buildLocation;
	}
	
	@Length(min=1, max=40, message="楼房状态长度必须介于 1 和 40 之间")
	public String getBuildStatue() {
		return buildStatue;
	}

	public void setBuildStatue(String buildStatue) {
		this.buildStatue = buildStatue;
	}
	
	@Length(min=1, max=40, message="建筑日期长度必须介于 1 和 40 之间")
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

	private String plotName;//小区名称
	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
	
}