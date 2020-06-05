package com.zhengke.common.pojo;



/**
 * TvUserIntegralLog entity. @author MyEclipse Persistence Tools
 */

public class TvUserIntegralLog  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -6142070822402262044L;
	private Integer id;
     private String userId;
     private Integer orderId;
     private Double integralNum;
     private Short sign;
     private String time;


    // Constructors

    /** default constructor */
    public TvUserIntegralLog() {
    }

    
    /** full constructor */
    public TvUserIntegralLog(String userId, Integer orderId, Double integralNum, Short sign, String time) {
        this.userId = userId;
        this.orderId = orderId;
        this.integralNum = integralNum;
        this.sign = sign;
        this.time = time;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getIntegralNum() {
        return this.integralNum;
    }
    
    public void setIntegralNum(Double integralNum) {
        this.integralNum = integralNum;
    }

    public Short getSign() {
        return this.sign;
    }
    
    public void setSign(Short sign) {
        this.sign = sign;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
   








}