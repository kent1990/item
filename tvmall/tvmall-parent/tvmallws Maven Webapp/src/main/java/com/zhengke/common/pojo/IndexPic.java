package com.zhengke.common.pojo;

/**
 * IndexPic entity. @author MyEclipse Persistence Tools
 */

public class IndexPic implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4981086506064489258L;
	private Integer id;
	private String name;
	private String picPath;
	private String defaultPic;
	private String updateTime;
	private String updateUser;

	// Constructors

	/** default constructor */
	public IndexPic() {
	}

	/** full constructor */
	public IndexPic(String name, String picPath, String defaultPic,
			String updateTime, String updateUser) {
		this.name = name;
		this.picPath = picPath;
		this.defaultPic = defaultPic;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}

	public IndexPic(Integer id, String name, String picPath,
			String defaultPic) {
		super();
		this.id = id;
		this.name = name;
		this.picPath = picPath;
		this.defaultPic = defaultPic;	
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getDefaultPic() {
		return this.defaultPic;
	}

	public void setDefaultPic(String defaultPic) {
		this.defaultPic = defaultPic;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}