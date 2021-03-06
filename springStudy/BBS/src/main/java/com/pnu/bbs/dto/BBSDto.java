package com.pnu.bbs.dto;

import java.sql.Timestamp;

public class BBSDto {
	private int articleNum;
	private String id;
	private String title;
	private String content;
	private int hit;
	private Timestamp writeDate;
	
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
		return "BBSDto [articleNum=" + articleNum + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", hit=" + hit + ", writeDate=" + writeDate + "]";
	}	
}
