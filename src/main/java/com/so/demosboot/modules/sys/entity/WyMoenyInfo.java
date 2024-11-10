package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 费用信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyMoenyInfo extends BaseEntity<WyMoenyInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String leadId;		// 户主编号
	private String payType;		// 费用类型
	private Double payMoney;		// 费用金额
	private String payContent;		// 消费说明
	private String payTime;		// 费用时间
	private String isPay;		// 是否已交
	
	public WyMoenyInfo() {
		super();
	}

	public WyMoenyInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=0, max=40, message="户主编号长度必须介于 0 和 40 之间")
	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	
	@Length(min=0, max=40, message="费用类型长度必须介于 0 和 40 之间")
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	
	public String getPayContent() {
		return payContent;
	}

	public void setPayContent(String payContent) {
		this.payContent = payContent;
	}
	
	@Length(min=0, max=40, message="费用时间长度必须介于 0 和 40 之间")
	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	
	@Length(min=1, max=10, message="是否已交长度必须介于 1 和 10 之间")
	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	
	private String houseId;
	private String houseName;		// 房间编号
	private String plotId;//小区编号
	private String plotName;//小区名称
	private String builId;//楼房名称
	private String builName;//楼房名称

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

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

	public String getBuilId() {
		return builId;
	}

	public void setBuilId(String builId) {
		this.builId = builId;
	}

	public String getBuilName() {
		return builName;
	}

	public void setBuilName(String builName) {
		this.builName = builName;
	}
	
	
}