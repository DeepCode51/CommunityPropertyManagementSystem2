package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 住户报修信息Entity
 * @author so
 * @version 2019-04-20
 */
public class WyHouseFixInfo extends BaseEntity<WyHouseFixInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String plotId;		// 小区编号
	private String buildId;		// 楼房编号
	private String houseId;		// 房号
	private String leader;		// 报修人
	private String tel;		// 联系电话
	private String content;		// 报修说明
	private String reportTime;		// 报修时间
	private String isFix;		// 是否处理
	private String fixUser;		// 维修人
	private String fixTime;		// 维修时间
	private String fixContent;		// 维修说明
	
	public WyHouseFixInfo() {
		super();
	}

	public WyHouseFixInfo(String id){
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
	
	@Length(min=1, max=40, message="楼房编号长度必须介于 1 和 40 之间")
	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	
	@Length(min=1, max=40, message="房号长度必须介于 1 和 40 之间")
	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	
	@Length(min=1, max=40, message="报修人长度必须介于 1 和 40 之间")
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	@Length(min=1, max=40, message="联系电话长度必须介于 1 和 40 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=1, max=40, message="报修时间长度必须介于 1 和 40 之间")
	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	
	@Length(min=0, max=10, message="是否处理长度必须介于 0 和 10 之间")
	public String getIsFix() {
		return isFix;
	}

	public void setIsFix(String isFix) {
		this.isFix = isFix;
	}
	
	@Length(min=0, max=40, message="维修人长度必须介于 0 和 40 之间")
	public String getFixUser() {
		return fixUser;
	}

	public void setFixUser(String fixUser) {
		this.fixUser = fixUser;
	}
	
	@Length(min=0, max=40, message="维修时间长度必须介于 0 和 40 之间")
	public String getFixTime() {
		return fixTime;
	}

	public void setFixTime(String fixTime) {
		this.fixTime = fixTime;
	}
	
	public String getFixContent() {
		return fixContent;
	}

	public void setFixContent(String fixContent) {
		this.fixContent = fixContent;
	}
	
}