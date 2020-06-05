package com.zhengke.common.pojo;

/**
 * MallGoodsBrand entity. @author MyEclipse Persistence Tools
 */

public class MallGoodsBrand implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer brandId;
	private String brandName;
	private String brandPic;
	private String brandStatus;
	private Integer createUserId;
	private String createUserName;
	private String createTime;

	// Constructors

	/** default constructor */
	public MallGoodsBrand() {
	}

	/** minimal constructor */
	public MallGoodsBrand(Integer brandId, String brandName, String brandPic,
			String brandStatus) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandPic = brandPic;
		this.brandStatus = brandStatus;
	}

	/** full constructor */
	public MallGoodsBrand(Integer brandId, String brandName, String brandPic,
			String brandStatus, Integer createUserId, String createUserName,
			String createTime) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandPic = brandPic;
		this.brandStatus = brandStatus;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandPic() {
		return this.brandPic;
	}

	public void setBrandPic(String brandPic) {
		this.brandPic = brandPic;
	}

	public String getBrandStatus() {
		return this.brandStatus;
	}

	public void setBrandStatus(String brandStatus) {
		this.brandStatus = brandStatus;
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

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}