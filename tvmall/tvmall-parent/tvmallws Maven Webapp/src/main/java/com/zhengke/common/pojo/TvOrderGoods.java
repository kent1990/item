package com.zhengke.common.pojo;

/**
 * TvOrderGoods entity. @author MyEclipse Persistence Tools
 */

public class TvOrderGoods implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer recordId;
	private Integer orderId;
	private Integer goodsId;
	private String goodsName;
	private String specifications;
	private Double goodsPrice;
	private Short goodsNum;
	private String goodsTime;
	private Integer servicePointId;
	private Double integralRate;
	private String goodsImage;
	private Double goodsPayPrice;
	private String userId;
	private Short goodsType;
	private Short isReturn;
	private Short isDelivery;
	private Integer returnCost;
	private Short state;

	// Constructors

	/** default constructor */
	public TvOrderGoods() {
	}

	/** minimal constructor */
	public TvOrderGoods(Integer orderId, Integer goodsId, String goodsName,
			String specifications, Double goodsPrice, Short goodsNum,
			String goodsTime, Integer servicePointId, String userId,
			Short goodsType, Short state) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.specifications = specifications;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.goodsTime = goodsTime;
		this.servicePointId = servicePointId;
		this.userId = userId;
		this.goodsType = goodsType;
		this.state = state;
	}

	/** full constructor */
	public TvOrderGoods(Integer orderId, Integer goodsId, String goodsName,
			String specifications, Double goodsPrice, Short goodsNum,
			String goodsTime, Integer servicePointId, Double integralRate,
			String goodsImage, Double goodsPayPrice, String userId,
			Short goodsType, Short isReturn, Short isDelivery,
			Integer returnCost, Short state) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.specifications = specifications;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.goodsTime = goodsTime;
		this.servicePointId = servicePointId;
		this.integralRate = integralRate;
		this.goodsImage = goodsImage;
		this.goodsPayPrice = goodsPayPrice;
		this.userId = userId;
		this.goodsType = goodsType;
		this.isReturn = isReturn;
		this.isDelivery = isDelivery;
		this.returnCost = returnCost;
		this.state = state;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Short getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(Short goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsTime() {
		return this.goodsTime;
	}

	public void setGoodsTime(String goodsTime) {
		this.goodsTime = goodsTime;
	}

	public Integer getServicePointId() {
		return this.servicePointId;
	}

	public void setServicePointId(Integer servicePointId) {
		this.servicePointId = servicePointId;
	}

	public Double getIntegralRate() {
		return this.integralRate;
	}

	public void setIntegralRate(Double integralRate) {
		this.integralRate = integralRate;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public Double getGoodsPayPrice() {
		return this.goodsPayPrice;
	}

	public void setGoodsPayPrice(Double goodsPayPrice) {
		this.goodsPayPrice = goodsPayPrice;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Short getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(Short goodsType) {
		this.goodsType = goodsType;
	}

	public Short getIsReturn() {
		return this.isReturn;
	}

	public void setIsReturn(Short isReturn) {
		this.isReturn = isReturn;
	}

	public Short getIsDelivery() {
		return this.isDelivery;
	}

	public void setIsDelivery(Short isDelivery) {
		this.isDelivery = isDelivery;
	}

	public Integer getReturnCost() {
		return this.returnCost;
	}

	public void setReturnCost(Integer returnCost) {
		this.returnCost = returnCost;
	}

	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

}