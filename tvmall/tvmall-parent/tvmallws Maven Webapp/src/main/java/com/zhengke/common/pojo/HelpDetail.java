package com.zhengke.common.pojo;

/**
 * HelpDetail entity. @author MyEclipse Persistence Tools
 */

public class HelpDetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5333859854040513464L;
	private Integer id;
	private Integer helpId;
	private String helpPicPath;
	private Short helpOrder;

	// Constructors

	/** default constructor */
	public HelpDetail() {
	}

	/** minimal constructor */
	public HelpDetail(Integer helpId) {
		this.helpId = helpId;
	}

	/** full constructor */
	public HelpDetail(Integer helpId, String helpPicPath, Short order) {
		this.helpId = helpId;
		this.helpPicPath = helpPicPath;
		this.helpOrder = order;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHelpId() {
		return this.helpId;
	}

	public void setHelpId(Integer helpId) {
		this.helpId = helpId;
	}

	public String getHelpPicPath() {
		return this.helpPicPath;
	}

	public void setHelpPicPath(String helpPicPath) {
		this.helpPicPath = helpPicPath;
	}

	public Short getHelpOrder() {
		return this.helpOrder;
	}

	public void setHelpOrder(Short order) {
		this.helpOrder = order;
	}

}