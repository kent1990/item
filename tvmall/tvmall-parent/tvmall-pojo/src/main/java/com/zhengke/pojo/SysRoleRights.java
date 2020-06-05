package com.zhengke.pojo;


/**
 * SysRoleRights entity. @author MyEclipse Persistence Tools
 */

public class SysRoleRights implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer roleRightId;
	private Integer roleId;
	private Integer popedomId;
	private String createTime;
	private Integer createUserId;
	private String createUserName;

	// Constructors

	/** default constructor */
	public SysRoleRights() {
	}

	/** minimal constructor */
	public SysRoleRights(Integer roleId, Integer popedomId, String createTime) {
		this.roleId = roleId;
		this.popedomId = popedomId;
		this.createTime = createTime;
	}

	/** full constructor */
	public SysRoleRights(Integer roleId, Integer popedomId,
			String createTime, Integer createUserId, String createUserName) {
		this.roleId = roleId;
		this.popedomId = popedomId;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
	}

	// Property accessors

	public Integer getRoleRightId() {
		return this.roleRightId;
	}

	public void setRoleRightId(Integer roleRightId) {
		this.roleRightId = roleRightId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPopedomId() {
		return this.popedomId;
	}

	public void setPopedomId(Integer popedomId) {
		this.popedomId = popedomId;
	}

	public String getCreateDate() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

}