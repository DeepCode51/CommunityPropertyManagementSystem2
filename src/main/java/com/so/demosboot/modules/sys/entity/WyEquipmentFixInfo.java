package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 设备维修信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyEquipmentFixInfo extends BaseEntity<WyEquipmentFixInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;		// 设备名称
	private String fixContent;		// 维修内容
	private String fixUser;		// 维修人
	private String fixTime;		// 维修时间
	
	public WyEquipmentFixInfo() {
		super();
	}

	public WyEquipmentFixInfo(String id){
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
	
	public String getFixContent() {
		return fixContent;
	}

	public void setFixContent(String fixContent) {
		this.fixContent = fixContent;
	}
	
	@Length(min=1, max=50, message="维修人长度必须介于 1 和 50 之间")
	public String getFixUser() {
		return fixUser;
	}

	public void setFixUser(String fixUser) {
		this.fixUser = fixUser;
	}
	
	@Length(min=1, max=40, message="维修时间长度必须介于 1 和 40 之间")
	public String getFixTime() {
		return fixTime;
	}

	public void setFixTime(String fixTime) {
		this.fixTime = fixTime;
	}
	
}