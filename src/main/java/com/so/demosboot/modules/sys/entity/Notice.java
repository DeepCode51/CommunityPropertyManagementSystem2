package com.so.demosboot.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 系统通知Entity
 * @author so
 * @version 2019-04-06
 */
public class Notice extends BaseEntity<Notice> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;		// 标题
	private String noticeType;		// 通知类型
	private String content;		// 内容
	private String author;		// 作者
	private String publishTime;		// 发布时间
	private Integer looks;		// 查看次数
	private String noticeStatue;		// 通知状态
	
	public Notice() {
		super();
	}

	public Notice(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=100, message="标题长度必须介于 1 和 100 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=1, max=40, message="通知类型长度必须介于 1 和 40 之间")
	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=1, max=40, message="作者长度必须介于 1 和 40 之间")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Length(min=1, max=40, message="发布时间长度必须介于 1 和 40 之间")
	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	
	@NotNull(message="查看次数不能为空")
	public Integer getLooks() {
		return looks;
	}

	public void setLooks(Integer looks) {
		this.looks = looks;
	}
	
	@Length(min=0, max=40, message="通知状态长度必须介于 0 和 40 之间")
	public String getNoticeStatue() {
		return noticeStatue;
	}

	public void setNoticeStatue(String noticeStatue) {
		this.noticeStatue = noticeStatue;
	}
	
}