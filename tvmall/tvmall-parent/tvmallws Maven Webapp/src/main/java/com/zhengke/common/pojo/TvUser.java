package com.zhengke.common.pojo;

/**
 * TvUser entity. @author MyEclipse Persistence Tools
 */

public class TvUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7008473577125764905L;
	private String userId;
	private String userName;
	private String userPhone;
	private String userCardNumber;
	private String userHomePhone;
	private Short statu;
	private Integer provinceId;
	private Integer cityId;
	private Integer servicePointId;
	private String addressDetail;
	private Double userIntegral;
	private Double userBalance;
	private String receiptTime;
	private Short deliveryWay;
	private String createTime;
	private String loginName;
	private String loginPwd;
	private String lastLoginIp;
	private String lastLoginTime;
	private Integer loginTimes;
	private String userPost;
	private Integer createUserId;
	private String createUserName;
	private Integer updateUserId;
	private String updateUserName;
	private String updateTime;
	private Integer createUseId;

	// Constructors

	/** default constructor */
	public TvUser() {
	}

	/** minimal constructor */
	public TvUser(String userId, String userPhone, Integer provinceId,
			Integer cityId, String addressDetail) {
		this.userId = userId;
		this.userPhone = userPhone;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.addressDetail = addressDetail;
	}

	/** full constructor */
	public TvUser(String userId, String userName, String userPhone,
			String userCardNumber, String userHomePhone, Short statu,
			Integer provinceId, Integer cityId, Integer servicePointId,
			String addressDetail, Double userIntegral, Double userBalance,
			String receiptTime, Short deliveryWay, String createTime,
			String loginName, String loginPwd, String lastLoginIp,
			String lastLoginTime, Integer loginTimes, String userPost,
			Integer createUserId, String createUserName, Integer updateUserId,
			String updateUserName, String updateTime, Integer createUseId) {
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userCardNumber = userCardNumber;
		this.userHomePhone = userHomePhone;
		this.statu = statu;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.servicePointId = servicePointId;
		this.addressDetail = addressDetail;
		this.userIntegral = userIntegral;
		this.userBalance = userBalance;
		this.receiptTime = receiptTime;
		this.deliveryWay = deliveryWay;
		this.createTime = createTime;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginTime = lastLoginTime;
		this.loginTimes = loginTimes;
		this.userPost = userPost;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
		this.updateTime = updateTime;
		this.createUseId = createUseId;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserCardNumber() {
		return this.userCardNumber;
	}

	public void setUserCardNumber(String userCardNumber) {
		this.userCardNumber = userCardNumber;
	}

	public String getUserHomePhone() {
		return this.userHomePhone;
	}

	public void setUserHomePhone(String userHomePhone) {
		this.userHomePhone = userHomePhone;
	}

	public Short getStatu() {
		return this.statu;
	}

	public void setStatu(Short statu) {
		this.statu = statu;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getServicePointId() {
		return this.servicePointId;
	}

	public void setServicePointId(Integer servicePointId) {
		this.servicePointId = servicePointId;
	}

	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Double getUserIntegral() {
		return this.userIntegral;
	}

	public void setUserIntegral(Double userIntegral) {
		this.userIntegral = userIntegral;
	}

	public Double getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}

	public String getReceiptTime() {
		return this.receiptTime;
	}

	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Short getDeliveryWay() {
		return this.deliveryWay;
	}

	public void setDeliveryWay(Short deliveryWay) {
		this.deliveryWay = deliveryWay;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getUserPost() {
		return this.userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Integer getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateUseId() {
		return this.createUseId;
	}

	public void setCreateUseId(Integer createUseId) {
		this.createUseId = createUseId;
	}

}