<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>详情页</title>
	<link rel="stylesheet" type="text/css" href="css/common/common.css">
	<link rel="stylesheet" type="text/css" href="css/business/detail/detail.css">
	<link rel="stylesheet" type="text/css" href="css/business/detail/myScroll.css">
<!--     <link href="css/common/carousel/carousel.css" rel="stylesheet">
	<link href="css/common/carousel/carousel.theme.css" rel="stylesheet"> -->
</head>

<body class="body" style="background-color: #264677;background-image: none;">
	<input type="hidden" id="type" name="type" value="${type}"/>
	<input type="hidden" id="shippingFee" name="shippingFee" value="${shippingFee}"/>
	<input type="hidden" id="goodsPrice" name="goodsPrice" value="${commonPrice}"/>
	<input type="hidden" id="specifications" name="specifications" value="${specifications}"/>
	<div class="container">
		<!--详细-->
		<div class="content_detail">
			<!--标题、时间-->
			<div>
				<div class="detail_title_arrow">
					<img src="images/common/arrow.png" height="29" width="15">
				</div>
				<div class="detail_title_tit">
					电视商圈 |${pageTitle}
				</div>
				<div class="detail_time">
                	<div class="time_minutes">
                    	<div id="minutes"></div>
                    </div>
                	<div class="time_across">
                    	<img src="images/common/across_line.png" width="2" height="50">
                    </div>
                    <div class="time_date">
                        <div id="week"></div>
                        <div id="date"></div>
                    </div>
                    <div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<!--标题、时间结束-->
			<!--详情-->
			<div class="detail_details">
                <!--轮播-->
            	<div id="playBox" class="detail_left">
                 	<div class="smalltitle">
				      <ul>
				          <s:iterator value="picList" status="sta" var="obj">
				        	<s:if test="sta.index==0">
				        		<li class="thistitle"></li> 
				        	</s:if>
				        	<s:else>
				        		<li></li> 				        	
				        	</s:else>
				          </s:iterator>
				      </ul>
				    </div>
				    <ul class="oUlplay">				      
				       <s:iterator value="picList" var="obj">
                  			 <li><a>
                    			<img src="view.do?path=${obj}" alt=""/>
                   	 		</a></li>       		
                  		</s:iterator>
				    </ul>
               	</div>
                <!--轮播结束-->
				<!--产品介绍-->
				<div class="detail_right">
				  <s:if test="#show==0">
					<div class="detail_goods_name">
						${goodsName} 
						${specifications}
					</div>
					<div class="detail_supplier">
					   <span>供应商:</span>
					   <span id="brand">${supplierName}</span>
					   <s:if test="#deliveryWay==0">
						<s:if test="#awardedIntegral!=null">
						<s:if test="#awardedIntegral!=0">
							<div class="detail_list_right">
								<span>赠送积分：</span>
								<span>${awardedIntegral}</span>
							</div>
						</s:if>
						</s:if>
						</s:if>
					   <input type="hidden" id="supplier" value="${supplierId}">
					</div>
					<div class="detail_cost">
						<div class="detail_list_left">
							<span>价格：</span>
							<span class="detail_discount">${goodsPrice}</span>
						</div>
						<s:if test="#deliveryWay==0">
							<div class="detail_list_right">
								<span>配送扣除积分：</span>
								<span>${shippingFee}</span>
							</div>
						</s:if>
						<s:elseif test="#awardedIntegral!=null">
						<s:if test="#awardedIntegral!=0">
							<div class="detail_list_right">
								<span>赠送积分：</span>
								<span>${awardedIntegral}</span>
							</div>
						</s:if>
						</s:elseif>
						<div class="clear"></div>
					</div>
				  </s:if>				  
				  <s:else>
				  	<div class="detail_goods_name">
						${goodsName} 
						<%--<s:if test="#deliveryWay==0">
						<s:if test="#awardedIntegral!=null">
						<s:if test="#awardedIntegral!=0">
							<div class="detail_list_right">
								<span>赠送积分：</span>
								<span>${awardedIntegral}</span>
							</div>
						</s:if>
						</s:if>
						</s:if>--%>
						${specifications}
					</div>
					<div class="detail_supplier">
					   <span>供应商:</span>
					   <span id="brand">${supplierName}</span>
					   <s:if test="#deliveryWay==0">
							<div class="detail_list_right">
								<span>配送扣除积分：</span>
								<span>${shippingFee}分</span>
							</div>
						</s:if>
						<s:elseif test="#awardedIntegral!=null">
						<s:if test="#awardedIntegral!=0">
						<s:if test="#type!=1">
						<s:if test="#type!=5">
							<div class="detail_list_right">
								<span>赠送积分：</span>
								<span>${awardedIntegral}分</span>
							</div>
						</s:if>
						</s:if>
						</s:if>
						</s:elseif>
					   <input type="hidden" id="supplier" value="${supplierId}">
					</div>
					<div class="detail_cost">
						<s:if test="#type==3">
						<div class="detail_list_left">
							<span>价格：</span>
							<span class="detail_discount">${goodsPrice}</span>
						</div>
						<div class="detail_list_right">
							<span>所需积分：</span>
							<span class="detail_discount">${commonPrice}分</span>
						</div>
						</s:if>
						<s:else>
						<div class="detail_list_left">
							<span>优惠特价：</span>
							<span class="detail_discount">${goodsPrice}</span>
						</div>
						<div class="detail_list_right">
							<span>原价：</span>
							<span class="detail_discount"><s>${commonPrice}</s></span>
						</div>
						</s:else>
						<div class="clear"></div>
					</div>
				  </s:else>
					<div class="detail_discount_cost">
					  <form action="">
						<div class="detail_list_left detail_pay_count">
							<div class="detail_count_text">数量：</div>
							<div class="detail_count_operate">
								<div id="div_detail_0" ></div>
								 <div id="div_detail_1">1</div>
										<%-- <input type="text" id="number" name="number" value="${orderNumber }" /> --%>
										<input type="hidden" id="goodsId" name="goodsId" value="${goodsId}"/>
								<div id="div_detail_2" class="detail_count_add"></div>
							</div>
							<div class="clear"></div>
						</div>
					  </form>
						<div id="div_detail_3" ></div>
						<div class="clear"></div>
					</div>
					<div class="detail_infor">
						<img src="view.do?path=${infoPicPath}" height="320" width="560">
					</div>
				</div>
				<!--产品介绍结束-->
				<div class="clear"></div>
			</div>
			<!--详情结束-->
		</div>
		<!--详细结束-->
	</div>
	<div id="bgDiv" ></div>
	<div id="msgDiv"></div>
	<div id="setTime">
		<div class="container">
				<div class="orders_window" style="height: 220px;top:450px;">
					<div class="orders_title">
						<div>设置方便收货时间</div>
						<div class="orders_line">
							<img src="images/detail/orders_line.png" height="1" width="800">
						</div>
					 </div>
					 <div class="orders_detail">  
					    <div id="div_rt_0"></div>
					    <div id="div_rt_1"></div>
					    <div id="div_rt_2"></div>
					    <div id="div_rt_3"></div>
					    <div id="div_rt_4"></div>
					    <div id="div_rt_5"></div>
					    <div id="div_rt_6"></div>
					    <div id="div_rt_7"></div>
					    <span id="msg"></span>
					    <div id="page"><span id="pageIndex"></span>/<span id="pageNum"></span></div>
					</div>
				</div>
				<input id="time" type="hidden" name="time" value="${time}"/>
		</div>	
	</div>
	<div id="tips">
		<div class="container">
    	 <div class="orders_window" style="height: 220px;">
  			<div class="orders_title">
				<div>提示</div>
				<div class="orders_line">
					<img src="images/detail/orders_line.png" height="1" width="800">
				</div>
			</div>
			<div class="orders_detail">
				<div class="orders_desc">
					<div class="orders_sel">
    					您的订单已生成！
    				</div>
    			</div>
    		</div>
    		<div class="orders_operate">
					<div id='div_6_0'>确认</div>			
			</div>
    	 </div>
  		</div>
  </div>
<script type="text/javascript" src="js/common/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/common/tvcommon/keyValueDefine.js"></script>
<script type="text/javascript" src="js/common/tvcommon/lib_shb_date.js"></script>
<script type="text/javascript" src="js/common/tvcommon/ScrollList.js"></script>
<script type="text/javascript" src="queryReceiptTime.do?r=${tmp}"></script>
<script type="text/javascript" src="js/common/tvcommon/wb_ScrollList.min.js"></script>
<script type="text/javascript" src="js/business/detail/myScroll.js"></script>
<script type="text/javascript" src="js/business/detail/detail.js"></script>
<%--  <script type="text/javascript" src="js/common/jquery-v1.9.1.js"></script> --%>
<%-- <script type="text/javascript" src="js/common/carousel.js"></script> --%>
<%-- <script type="text/javascript">
	$(function(){
		$('#owl-demo').owlCarousel({
			items: 1,
			autoPlay: true				
		});
	});
</script>  --%>
</body>
</html>
