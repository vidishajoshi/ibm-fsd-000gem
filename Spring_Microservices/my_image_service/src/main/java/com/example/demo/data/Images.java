package com.example.demo.data;


public class Images {

	private Long imageId;
	private String description;
	private String url;
	public Images(Long imageId, String description, String url) {
		super();
		this.imageId = imageId;
		this.description = description;
		this.url = url;
	}
	public Images() {
		super();
	}
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
