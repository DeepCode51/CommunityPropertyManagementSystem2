package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 户主信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyHouseLeader extends BaseEntity<WyHouseLeader> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String houseId;		// 房间编号
	private String peopleName;		// 户主名称
	private String sex;		// 性别
	private String tel;		// 联系电话
	private String inTime;		// 入住时间
	private Integer inPeoples;		// 入住人数
	private String isOut;		// 是否搬出
	private String outTime;		// 搬出时间
	private String remark;		// 备注
	
	public WyHouseLeader() {
		super();
	}

	public WyHouseLeader(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=40, message="房间编号长度必须介于 1 和 40 之间")
	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	
	@Length(min=1, max=40, message="户主名称长度必须介于 1 和 40 之间")
	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	
	@Length(min=1, max=20, message="性别长度必须介于 1 和 20 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=40, message="联系电话长度必须介于 1 和 40 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=1, max=40, message="入住时间长度必须介于 1 和 40 之间")
	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	
	@NotNull(message="入住人数不能为空")
	public Integer getInPeoples() {
		return inPeoples;
	}

	public void setInPeoples(Integer inPeoples) {
		this.inPeoples = inPeoples;
	}
	
	@Length(min=0, max=20, message="是否搬出长度必须介于 0 和 20 之间")
	public String getIsOut() {
		return isOut;
	}

	public void setIsOut(String isOut) {
		this.isOut = isOut;
	}
	
	@Length(min=0, max=40, message="搬出时间长度必须介于 0 和 40 之间")
	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	private String houseName;		// 房间编号
	private String plotId;//小区编号
	private String plotName;//小区名称
	private String builId;//楼房名称
	private String builName;//楼房名称

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