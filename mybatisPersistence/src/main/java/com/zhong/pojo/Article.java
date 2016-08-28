package com.zhong.pojo;

public class Article {

	private String id;
	private String userId;
	private String title;
	private String content;
	private Double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double pricel) {
		this.price = pricel;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content + ", pricel="
				+ price + "]";
	}

}
