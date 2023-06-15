package com.jupiter002.model;

public class BoardDto {
	private int id;
	private String userId;
	private String name;
	private String title;
	private String contents;
	private String regdate;
	private int hit;
	
	
	
	public BoardDto() {			//기본생성자
		super();				//부모상속
	}
	public BoardDto(int id, String userId, String name, String title, String contents, String regdate, int hit) {		//매개변수를 사용하는 생성자
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.title = title;
		this.contents = contents;
		this.regdate = regdate;
		this.hit = hit;
	}
	public int getId() {					//getter, setter
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	@Override				//toString overriding
	public String toString() {
		return "BoardDto [id=" + id + ", userId=" + userId + ", name=" + name + ", title=" + title + ", contents="
				+ contents + ", regdate=" + regdate + ", hit=" + hit + "]";
	}
	
	
	
}
