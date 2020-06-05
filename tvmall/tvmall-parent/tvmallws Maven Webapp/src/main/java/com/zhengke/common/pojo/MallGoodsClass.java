package com.zhengke.common.pojo;

/**
 * MallGoodsClass entity. @author MyEclipse Persistence Tools
 */

public class MallGoodsClass implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4772769620017815797L;
	private Integer gcId;
	private Integer typeId;
	private String gcName;
	private Integer gcParentId;
	private Short gcSort;
	private String gcDescription;
	private String gcPicPath;

	// Constructors

	/** default constructor */
	public MallGoodsClass() {
	}

	/** minimal constructor */
	public MallGoodsClass(String gcName, Integer gcParentId, Short gcSort) {
		this.gcName = gcName;
		this.gcParentId = gcParentId;
		this.gcSort = gcSort;
	}

	/** full constructor */
	public MallGoodsClass(Integer typeId, String gcName, Integer gcParentId,
			Short gcSort, String gcDescription, String gcPicPath) {
		this.typeId = typeId;
		this.gcName = gcName;
		this.gcParentId = gcParentId;
		this.gcSort = gcSort;
		this.gcDescription = gcDescription;
		this.gcPicPath = gcPicPath;
	}

	// Property accessors

	public Integer getGcId() {
		return this.gcId;
	}

	public void setGcId(Integer gcId) {
		this.gcId = gcId;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getGcName() {
		return this.gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public Integer getGcParentId() {
		return this.gcParentId;
	}

	public void setGcParentId(Integer gcParentId) {
		this.gcParentId = gcParentId;
	}

	public Short getGcSort() {
		return this.gcSort;
	}

	public void setGcSort(Short gcSort) {
		this.gcSort = gcSort;
	}

	public String getGcDescription() {
		return this.gcDescription;
	}

	public void setGcDescription(String gcDescription) {
		this.gcDescription = gcDescription;
	}

	public String getGcPicPath() {
		return this.gcPicPath;
	}

	public void setGcPicPath(String gcPicPath) {
		this.gcPicPath = gcPicPath;
	}

}