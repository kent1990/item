package com.zhengke.common.pojo;

/**
 * GoodsDetail entity. @author MyEclipse Persistence Tools
 */

public class GoodsDetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9193021703006891943L;
	private Integer goodsId;
	private Integer isNormal;
	private Integer commonGoodsId;
	private Double goodsPrice;
	private Integer status;
	private Integer awardedIntegral;
	private Integer integralBuy;
	private Integer goodsExchIntegral;
	private Double shippingFee;
	private Integer goodsRefund;
	private Double returnFee;
	private Integer createUserId;
	private String createTime;
	private String createUserName;

	// Constructors

	/** default constructor */
	public GoodsDetail() {
	}

	/** minimal constructor */
	public GoodsDetail(Integer isNormal, Integer commonGoodsId,
			Double goodsPrice, Integer status, Integer integralBuy,
			Double shippingFee, Integer createUserId, String createTime,
			String createUserName) {
		this.isNormal = isNormal;
		this.commonGoodsId = commonGoodsId;
		this.goodsPrice = goodsPrice;
		this.status = status;
		this.integralBuy = integralBuy;
		this.shippingFee = shippingFee;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.createUserName = createUserName;
	}

	/** full constructor */
	public GoodsDetail(Integer isNormal, Integer commonGoodsId,
			Double goodsPrice, Integer status, Integer awardedIntegral,
			Integer integralBuy, Integer goodsExchIntegral, Double shippingFee,
			Integer goodsRefund, Double returnFee, Integer createUserId,
			String createTime, String createUserName) {
		this.isNormal = isNormal;
		this.commonGoodsId = commonGoodsId;
		this.goodsPrice = goodsPrice;
		this.status = status;
		this.awardedIntegral = awardedIntegral;
		this.integralBuy = integralBuy;
		this.goodsExchIntegral = goodsExchIntegral;
		this.shippingFee = shippingFee;
		this.goodsRefund = goodsRefund;
		this.returnFee = returnFee;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.createUserName = createUserName;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getIsNormal() {
		return this.isNormal;
	}

	public void setIsNormal(Integer isNormal) {
		this.isNormal = isNormal;
	}

	public Integer getCommonGoodsId() {
		return this.commonGoodsId;
	}

	public void setCommonGoodsId(Integer commonGoodsId) {
		this.commonGoodsId = commonGoodsId;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAwardedIntegral() {
		return this.awardedIntegral;
	}

	public void setAwardedIntegral(Integer awardedIntegral) {
		this.awardedIntegral = awardedIntegral;
	}

	public Integer getIntegralBuy() {
		return this.integralBuy;
	}

	public void setIntegralBuy(Integer integralBuy) {
		this.integralBuy = integralBuy;
	}

	public Integer getGoodsExchIntegral() {
		return this.goodsExchIntegral;
	}

	public void setGoodsExchIntegral(Integer goodsExchIntegral) {
		this.goodsExchIntegral = goodsExchIntegral;
	}

	public Double getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Integer getGoodsRefund() {
		return this.goodsRefund;
	}

	public void setGoodsRefund(Integer goodsRefund) {
		this.goodsRefund = goodsRefund;
	}

	public Double getReturnFee() {
		return this.returnFee;
	}

	public void setReturnFee(Double returnFee) {
		this.returnFee = returnFee;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

}