package com.zhengke.common.pojo;

/**
 * SysDictionary entity. @author MyEclipse Persistence Tools
 */

public class SysDictionary implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811668362558692110L;
	private String dicId;
	private String dicName;
	private Integer createrId;
	private String createTime;
	private Integer alterId;
	private String alterTime;

	// Constructors

	/** default constructor */
	public SysDictionary() {
	}

	/** minimal constructor */
	public SysDictionary(String dicId, String dicName, Integer createrId,
			String createTime) {
		this.dicId = dicId;
		this.dicName = dicName;
		this.createrId = createrId;
		this.createTime = createTime;
	}

	/** full constructor */
	public SysDictionary(String dicId, String dicName, Integer createrId,
			String createTime, Integer alterId, String alterTime) {
		this.dicId = dicId;
		this.dicName = dicName;
		this.createrId = createrId;
		this.createTime = createTime;
		this.alterId = alterId;
		this.alterTime = alterTime;
	}

	// Property accessors

	public String getDicId() {
		return this.dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	public String getDicName() {
		return this.dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public Integer getCreaterId() {
		return this.createrId;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getAlterId() {
		return this.alterId;
	}

	public void setAlterId(Integer alterId) {
		this.alterId = alterId;
	}

	public String getAlterTime() {
		return this.alterTime;
	}

	public void setAlterTime(String alterTime) {
		this.alterTime = alterTime;
	}

}