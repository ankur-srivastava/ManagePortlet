/**
 * 
 */
package com.models;

import java.io.Serializable;

/**
 * @author ankursrivastava
 *
 */
public class AdListingCustomModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long adId;
	
	private String adTitle;
	
	private String adDescription;
	
	private String adCatName;
	
	private String adCityName;
	
	private String createdDate;
	
	private String serviceType;
	
	private String userName;
	
	private String userPhone;
	
	private String userEmail;
	
	private String thumbnailImageURL;
	
	private String imageTitle;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (adId ^ (adId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdListingCustomModel other = (AdListingCustomModel) obj;
		if (adId != other.adId)
			return false;
		return true;
	}

	public long getAdId() {
		return adId;
	}

	public void setAdId(long adId) {
		this.adId = adId;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdDescription() {
		return adDescription;
	}

	public void setAdDescription(String adDescription) {
		this.adDescription = adDescription;
	}

	public String getAdCatName() {
		return adCatName;
	}

	public void setAdCatName(String adCatName) {
		this.adCatName = adCatName;
	}

	public String getAdCityName() {
		return adCityName;
	}

	public void setAdCityName(String adCityName) {
		this.adCityName = adCityName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getThumbnailImageURL() {
		return thumbnailImageURL;
	}

	public void setThumbnailImageURL(String thumbnailImageURL) {
		this.thumbnailImageURL = thumbnailImageURL;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}
}
