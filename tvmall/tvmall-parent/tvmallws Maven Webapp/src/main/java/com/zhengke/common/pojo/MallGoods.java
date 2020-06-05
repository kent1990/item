package com.zhengke.common.pojo;

/**
 * MallGoods entity. @author MyEclipse Persistence Tools
 */

public class MallGoods implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer goodsId;
	private String goodsName;
	private Integer typeId;
	private String typeName;
	private Integer gcId1;
	private Integer gcId2;
	private Integer gcId3;
	private Integer brandId;
	private Double purchasePrice;
	private Double goodsSellPrice;
	private Short isPromotion;
	private Double goodsPromotionPrice;
	private Short isVirtual;
	private Short isBale;
	private Integer baleId;
	private Short isExperie;
	private Short status;
	private String specifications;
	private Integer goodsSaleNum;
	private Integer goodsStorage;
	private Integer goodsDestineQuota;
	private String goodsInfo;
	private String goodsDetails;
	private Double awardedIntegral;
	private Short integralBuy;
	private Double goodsExchIntegral;
	private Double integralRate;
	private Double shippingFee;
	private Short goodsRefund;
	private Double returnFee;
	private String picPath1;
	private String picPath2;
	private String picPath3;
	private String picPath4;
	private String picPath5;
	private String thumbPicPath;
	private Integer createUserId;
	private String createUserName;
	private String createTime;
	private String netContent;
	private String shelfLife;
	private String storageMethod;
	private String caution;

	// Constructors

	/** default constructor */
	public MallGoods() {
		
	}
	public MallGoods(Integer goodsId,String thumbPicPath,String goodsName,Double goodsPromotionPrice) {
		this.goodsId = goodsId;
		this.thumbPicPath = thumbPicPath;
		this.goodsName = goodsName;
		this.goodsPromotionPrice = goodsPromotionPrice;
	}
	/** minimal constructor */
	public MallGoods(String goodsName, Integer typeId, String typeName,
			Integer gcId1, Integer brandId, Double purchasePrice,
			Double goodsSellPrice, Short isPromotion, Short isBale,
			Short isExperie, Short status, Integer goodsSaleNum, Integer goodsStorage,
			Integer goodsDestineQuota, String goodsInfo, String goodsDetails,
			Double awardedIntegral, Short integralBuy,
			Double goodsExchIntegral, Double integralRate, Double shippingFee,
			Short goodsRefund, Double returnFee) {
		this.goodsName = goodsName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.gcId1 = gcId1;
		this.brandId = brandId;
		this.purchasePrice = purchasePrice;
		this.goodsSellPrice = goodsSellPrice;
		this.isPromotion = isPromotion;
		this.isBale = isBale;
		this.isExperie = isExperie;
		this.status = status;
		this.goodsSaleNum = goodsSaleNum;
		this.goodsStorage = goodsStorage;
		this.goodsDestineQuota = goodsDestineQuota;
		this.goodsInfo = goodsInfo;
		this.goodsDetails = goodsDetails;
		this.awardedIntegral = awardedIntegral;
		this.integralBuy = integralBuy;
		this.goodsExchIntegral = goodsExchIntegral;
		this.integralRate = integralRate;
		this.shippingFee = shippingFee;
		this.goodsRefund = goodsRefund;
		this.returnFee = returnFee;
	}

	/** full constructor */
	public MallGoods(String goodsName, Integer typeId, String typeName,
			Integer gcId1, Integer gcId2, Integer gcId3, Integer brandId,
			Double purchasePrice, Double goodsSellPrice, Short isPromotion,
			Double goodsPromotionPrice, Short isBale, Short isExperie,String caution,
			Short status, Integer goodsSaleNum,String specifications,String storageMethod,
			Integer goodsStorage, Integer goodsDestineQuota, String goodsInfo,
			String goodsDetails, Double awardedIntegral, Short integralBuy,
			Double goodsExchIntegral, Double integralRate, Double shippingFee,
			Short goodsRefund, Double returnFee, String picPath1,String picPath2,
			String picPath3,String picPath4,String picPath5,String shelfLife,
			String thumbPicPath, Integer createUserId, String createUserName,
			String createTime,Integer baleId,Short isVirtual,String netContent) {
		this.goodsName = goodsName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.gcId1 = gcId1;
		this.gcId2 = gcId2;
		this.gcId3 = gcId3;
		this.brandId = brandId;
		this.purchasePrice = purchasePrice;
		this.goodsSellPrice = goodsSellPrice;
		this.isPromotion = isPromotion;
		this.goodsPromotionPrice = goodsPromotionPrice;
		this.isBale = isBale;
		this.isExperie = isExperie;
		this.status = status;
		this.goodsSaleNum = goodsSaleNum;
		this.goodsStorage = goodsStorage;
		this.goodsDestineQuota = goodsDestineQuota;
		this.goodsInfo = goodsInfo;
		this.goodsDetails = goodsDetails;
		this.awardedIntegral = awardedIntegral;
		this.integralBuy = integralBuy;
		this.goodsExchIntegral = goodsExchIntegral;
		this.integralRate = integralRate;
		this.shippingFee = shippingFee;
		this.goodsRefund = goodsRefund;
		this.returnFee = returnFee;
		this.picPath1 = picPath1;
		this.picPath2 = picPath2;
		this.picPath3 = picPath3;
		this.picPath4 = picPath4;
		this.picPath5 = picPath5;
		this.thumbPicPath = thumbPicPath;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createTime = createTime;
		this.baleId = baleId;
		this.isVirtual = isVirtual;
		this.specifications = specifications;
		this.netContent = netContent;
		this.shelfLife = shelfLife;
		this.storageMethod = storageMethod;
		this.caution = caution;
	}

	// Property accessors

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

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getGcId1() {
		return this.gcId1;
	}

	public void setGcId1(Integer gcId1) {
		this.gcId1 = gcId1;
	}

	public Integer getGcId2() {
		return this.gcId2;
	}

	public void setGcId2(Integer gcId2) {
		this.gcId2 = gcId2;
	}

	public Integer getGcId3() {
		return this.gcId3;
	}

	public void setGcId3(Integer gcId3) {
		this.gcId3 = gcId3;
	}

	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getGoodsSellPrice() {
		return this.goodsSellPrice;
	}

	public void setGoodsSellPrice(Double goodsSellPrice) {
		this.goodsSellPrice = goodsSellPrice;
	}

	public Short getIsPromotion() {
		return this.isPromotion;
	}

	public void setIsPromotion(Short isPromotion) {
		this.isPromotion = isPromotion;
	}

	public Double getGoodsPromotionPrice() {
		return this.goodsPromotionPrice;
	}

	public void setGoodsPromotionPrice(Double goodsPromotionPrice) {
		this.goodsPromotionPrice = goodsPromotionPrice;
	}

	public Short getIsBale() {
		return this.isBale;
	}

	public void setIsBale(Short isBale) {
		this.isBale = isBale;
	}

	public Short getIsExperie() {
		return this.isExperie;
	}

	public void setIsExperie(Short isExperie) {
		this.isExperie = isExperie;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getGoodsSaleNum() {
		return this.goodsSaleNum;
	}

	public void setGoodsSaleNum(Integer goodsSaleNum) {
		this.goodsSaleNum = goodsSaleNum;
	}

	public Integer getGoodsStorage() {
		return this.goodsStorage;
	}

	public void setGoodsStorage(Integer goodsStorage) {
		this.goodsStorage = goodsStorage;
	}

	public Integer getGoodsDestineQuota() {
		return goodsDestineQuota;
	}

	public void setGoodsDestineQuota(Integer goodsDestineQuota) {
		this.goodsDestineQuota = goodsDestineQuota;
	}

	public String getGoodsInfo() {
		return this.goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getGoodsDetails() {
		return this.goodsDetails;
	}

	public void setGoodsDetails(String goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public Double getAwardedIntegral() {
		return this.awardedIntegral;
	}

	public void setAwardedIntegral(Double awardedIntegral) {
		this.awardedIntegral = awardedIntegral;
	}

	public Short getIntegralBuy() {
		return this.integralBuy;
	}

	public void setIntegralBuy(Short integralBuy) {
		this.integralBuy = integralBuy;
	}

	public Double getGoodsExchIntegral() {
		return this.goodsExchIntegral;
	}

	public void setGoodsExchIntegral(Double goodsExchIntegral) {
		this.goodsExchIntegral = goodsExchIntegral;
	}

	public Double getIntegralRate() {
		return this.integralRate;
	}

	public void setIntegralRate(Double integralRate) {
		this.integralRate = integralRate;
	}

	public Double getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Short getGoodsRefund() {
		return this.goodsRefund;
	}

	public void setGoodsRefund(Short goodsRefund) {
		this.goodsRefund = goodsRefund;
	}

	public Double getReturnFee() {
		return this.returnFee;
	}

	public void setReturnFee(Double returnFee) {
		this.returnFee = returnFee;
	}

	public String getPicPath1() {
		return this.picPath1;
	}

	public void setPicPath1(String picPath1) {
		this.picPath1 = picPath1;
	}

	public String getPicPath2() {
		return picPath2;
	}

	public void setPicPath2(String picPath2) {
		this.picPath2 = picPath2;
	}

	public String getPicPath3() {
		return picPath3;
	}

	public void setPicPath3(String picPath3) {
		this.picPath3 = picPath3;
	}

	public String getPicPath4() {
		return picPath4;
	}

	public void setPicPath4(String picPath4) {
		this.picPath4 = picPath4;
	}

	public String getPicPath5() {
		return picPath5;
	}

	public void setPicPath5(String picPath5) {
		this.picPath5 = picPath5;
	}

	public String getThumbPicPath() {
		return this.thumbPicPath;
	}

	public void setThumbPicPath(String thumbPicPath) {
		this.thumbPicPath = thumbPicPath;
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

	public Short getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(Short isVirtual) {
		this.isVirtual = isVirtual;
	}

	public Integer getBaleId() {
		return baleId;
	}

	public void setBaleId(Integer baleId) {
		this.baleId = baleId;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getNetContent() {
		return netContent;
	}

	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getStorageMethod() {
		return storageMethod;
	}

	public void setStorageMethod(String storageMethod) {
		this.storageMethod = storageMethod;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

}