package com.zhengke.common.util.object;

import java.io.Serializable;

public class CurrentUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String stationId;//服务点ID
	private String stationName;//服务点名称
	private String userName;//用户名
	private String userCardNo;//用户卡号
	private String phone;
	private String provinceId;//省份ID
	private String cityId;//城市ID
	private String countyId;//县区	
	private String addressDetail; //详细地址
	private Double userIntegral; // 用户积分
	private Double userBalance; //用户余额
	private String receiptTime; //收货方便时间
	private Short deliveryWay; // 提货方式(0：上门送，1：自取)
	private String tvnNo;//当前查看电视商城的用户的机顶盒tvnNo(用户ID)
	
	public CurrentUser() {
		super();
	}

	public CurrentUser(String stationId, String stationName,
			String provinceId, String cityId, String countyId, String tvnNo,
			String addressDetail,double userIntegral,Double userBalance,String receiptTime,Short deliveryWay) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.countyId = countyId;
		this.tvnNo = tvnNo;
		this.addressDetail = addressDetail; //详细地址
		this.userIntegral = userIntegral; // 用户积分
		this.userBalance = userBalance; //用户余额
		this.receiptTime = receiptTime; //收货方便时间
		this.deliveryWay = deliveryWay;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getTvnNo() {
		return tvnNo;
	}

	public void setTvnNo(String tvnNo) {
		this.tvnNo = tvnNo;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Double getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Double userIntegral) {
		this.userIntegral = userIntegral;
	}

	public Double getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}

	public String getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Short getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(Short deliveryWay) {
		this.deliveryWay = deliveryWay;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserCardNo() {
		return userCardNo;
	}

	public void setUserCardNo(String userCardNo) {
		this.userCardNo = userCardNo;
	}
}
