package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 投诉信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyComplainInfo extends BaseEntity<WyComplainInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String content;		// 投诉内容
	private String tousuUser;		// 投诉用户
	private String tousuTel;		// 投诉人电话
	private String tousuTime;		// 投诉时间
	private String luruUser;		// 录入人
	private String addTime;		// 录入时间
	private String isCall;		// 是否回电
	private String remark;		// 备注
	
	public WyComplainInfo() {
		super();
	}

	public WyComplainInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=1, max=40, message="投诉用户长度必须介于 1 和 40 之间")
	public String getTousuUser() {
		return tousuUser;
	}

	public void setTousuUser(String tousuUser) {
		this.tousuUser = tousuUser;
	}
	
	@Length(min=0, max=40, message="投诉人电话长度必须介于 0 和 40 之间")
	public String getTousuTel() {
		return tousuTel;
	}

	public void setTousuTel(String tousuTel) {
		this.tousuTel = tousuTel;
	}
	
	@Length(min=0, max=40, message="投诉时间长度必须介于 0 和 40 之间")
	public String getTousuTime() {
		return tousuTime;
	}

	public void setTousuTime(String tousuTime) {
		this.tousuTime = tousuTime;
	}
	
	@Length(min=0, max=40, message="录入人长度必须介于 0 和 40 之间")
	public String getLuruUser() {
		return luruUser;
	}

	public void setLuruUser(String luruUser) {
		this.luruUser = luruUser;
	}
	
	@Length(min=0, max=40, message="录入时间长度必须介于 0 和 40 之间")
	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
	@Length(min=0, max=40, message="是否回电长度必须介于 0 和 40 之间")
	public String getIsCall() {
		return isCall;
	}

	public void setIsCall(String isCall) {
		this.isCall = isCall;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}