package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 房间信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyHouseInfo extends BaseEntity<WyHouseInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String buildId;		// 楼房编号
	private Integer floorNo;		// 楼层
	private String houseNo;		// 房号
	private String houseType;		// 房间类型
	private String finishType;		// 装修风格
	private String houseStatue;		// 房间状态（1，可入住，0已入住）
	
	public WyHouseInfo() {
		super();
	}

	public WyHouseInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=40, message="楼房编号长度必须介于 1 和 40 之间")
	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	
	@NotNull(message="楼层不能为空")
	public Integer getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}
	
	@Length(min=1, max=40, message="房号长度必须介于 1 和 40 之间")
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
	@Length(min=0, max=40, message="房间类型长度必须介于 0 和 40 之间")
	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
	@Length(min=0, max=40, message="装修风格长度必须介于 0 和 40 之间")
	public String getFinishType() {
		return finishType;
	}

	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}
	
	@Length(min=0, max=10, message="房间状态（1，可入住，0已入住）长度必须介于 0 和 10 之间")
	public String getHouseStatue() {
		return houseStatue;
	}

	public void setHouseStatue(String houseStatue) {
		this.houseStatue = houseStatue;
	}
	
	private String plotId;//小区编号
	private String plotName;//小区名称
	private String builName;//楼房名称

	public String getPlotId() {
		return plotId;
	}

	public void setPlotId(String plotId) {
		this.plotId = plotId;
	}

	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}

	public String getBuilName() {
		return builName;
	}

	public void setBuilName(String builName) {
		this.builName = builName;
	}
	
	
}