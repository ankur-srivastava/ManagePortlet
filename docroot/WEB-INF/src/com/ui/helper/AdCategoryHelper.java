package com.ui.helper;

import java.io.Serializable;

public class AdCategoryHelper implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long catId;
	private long cityId;
	private String serviceType;
	
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

}
