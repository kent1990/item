package com.zhengke.common.pojo;

/**
 * TvUserOpera entity. @author MyEclipse Persistence Tools
 */

public class TvUserOpera implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer userId;
	private String userName;
	private String text;
	private Integer type;
	private String time;

	// Constructors

	/** default constructor */
	public TvUserOpera() {
	}

	/** full constructor */
	public TvUserOpera(String id, Integer userId, String userName, String text,
			Integer type, String time) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.text = text;
		this.type = type;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}