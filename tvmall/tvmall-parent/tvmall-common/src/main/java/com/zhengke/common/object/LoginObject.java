package com.zhengke.common.object;

public class LoginObject implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userId; // 管理员id
	private String loginName; // 管理员登陆代码
	private String userName; // 管理员姓名
	private String lastLoginIp; // 上次登录IP地址
	private String loginTimes; // 登录次数
	private String lastLoginTime; // 上次登录时间
	private String crtLoginTime; // 本次登录时间
	private String crtLoginIp; // 本次登录的ip地址
	private String provinceId; // 省级
	private String cityId; // 市级
	private String servicePointId; // 服务点
	

	/** default constructor */
	public LoginObject() {
		super();
	}

	/** full constructor */
	public LoginObject(Integer userId, String loginName, String userName,
			String lastLoginIp, String loginTimes, String lastLoginTime,
			String crtLoginTime, String crtLoginIp,String provinceId,
			String cityId,String servicePointId) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.userName = userName;
		this.lastLoginIp = lastLoginIp;
		this.loginTimes = loginTimes;
		this.lastLoginTime = lastLoginTime;
		this.crtLoginTime = crtLoginTime;
		this.crtLoginIp = crtLoginIp;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.servicePointId = servicePointId;
	}

	/** Property accessors */
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getCrtLoginTime() {
		return crtLoginTime;
	}

	public void setCrtLoginTime(String crtLoginTime) {
		this.crtLoginTime = crtLoginTime;
	}

	public String getCrtLoginIp() {
		return crtLoginIp;
	}

	public void setCrtLoginIp(String crtLoginIp) {
		this.crtLoginIp = crtLoginIp;
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

	public String getServicePointId() {
		return servicePointId;
	}

	public void setServicePointId(String servicePointId) {
		this.servicePointId = servicePointId;
	}
	
}
