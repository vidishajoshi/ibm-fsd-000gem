package com.example.demo.data;

import java.util.List;

public class Gallery {

	private Long gallery_id;
	private List<Object> images;
	
	public Gallery(Long gallery_id, List<Object> images) {
		super();
		this.gallery_id = gallery_id;
		this.images = images;
	}
	public Gallery() {
		super();
	}
	public Long getGallery_id() {
		return gallery_id;
	}
	public void setGallery_id(Long gallery_id) {
		this.gallery_id = gallery_id;
	}
	public List<Object> getImages() {
		return images;
	}
	public void setImages(List<Object> images) {
		this.images = images;
	}
	
	
}
