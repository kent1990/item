package com.zhengke.common.pojo;

public class ReturnVisit implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String visitId;
	private String visitCard;
	private String visitName;
	private String visitPhone;
	private String visitHomePhone;
	private String visitAddress;
	private Double visitIntegral;
	private Double visitBalance;
	private Integer status;
	private String visitContent;
	private String createTime;
	private String visitTime;
	private String visitAdmin;
	
	
	public ReturnVisit() {
	}
	
	
	
	public ReturnVisit(Integer id, String visitId, String visitCard,
			String visitName, String visitPhone, String visitHomePhone,
			String visitAddress, Double visitIntegral, Double visitBalance,
			Integer status, String visitContent, String createTime,
			String visitTime, String visitAdmin) {
		super();
		this.id = id;
		this.visitId = visitId;
		this.visitCard = visitCard;
		this.visitName = visitName;
		this.visitPhone = visitPhone;
		this.visitHomePhone = visitHomePhone;
		this.visitAddress = visitAddress;
		this.visitIntegral = visitIntegral;
		this.visitBalance = visitBalance;
		this.status = status;
		this.visitContent = visitContent;
		this.createTime = createTime;
		this.visitTime = visitTime;
		this.visitAdmin = visitAdmin;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getVisitCard() {
		return visitCard;
	}
	public void setVisitCard(String visitCard) {
		this.visitCard = visitCard;
	}
	public String getVisitName() {
		return visitName;
	}
	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}
	public String getVisitPhone() {
		return visitPhone;
	}
	public void setVisitPhone(String visitPhone) {
		this.visitPhone = visitPhone;
	}
	public String getVisitHomePhone() {
		return visitHomePhone;
	}
	public void setVisitHomePhone(String visitHomePhone) {
		this.visitHomePhone = visitHomePhone;
	}
	public String getVisitAddress() {
		return visitAddress;
	}
	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}
	public Double getVisitIntegral() {
		return visitIntegral;
	}
	public void setVisitIntegral(Double visitIntegral) {
		this.visitIntegral = visitIntegral;
	}
	public Double getVisitBalance() {
		return visitBalance;
	}
	public void setVisitBalance(Double visitBalance) {
		this.visitBalance = visitBalance;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getVisitContent() {
		return visitContent;
	}
	public void setVisitContent(String visitContent) {
		this.visitContent = visitContent;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public String getVisitAdmin() {
		return visitAdmin;
	}
	public void setVisitAdmin(String visitAdmin) {
		this.visitAdmin = visitAdmin;
	}
}
