<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container">
		<div class="orders_window">
			<div class="orders_title">
				<div>订单预览</div>
				<div class="orders_line">
					<img src="images/detail/orders_line.png" height="1" width="800">
				</div>
			</div>
			<div class="orders_detail">
				<div class="orders_contact">
					<div class="orders_tel">
						<div>
							<span>收货人：</span><span>${userName}</span>
						</div>
						<div>
							<span>联系方式：</span><span>${phone }</span>
						</div>
						<div class="clear"></div>
					</div>
					<div>
						<span>收货地址：</span><span>${address}</span>
					</div>
				</div>
				<div class="orders_desc">
					<ul>
						 <!-- <li>
							<div>
								<span>商家：</span><span>华润万家</span>
							</div>
							<div>
								<span>商品编号：</span><span>BC230068</span>
							</div>
							<div class="clear"></div>
						</li>  -->
						<li>
							<div>
								<span>商品名称：</span><span>${goodsName }</span>
								<input type="hidden" name="goodsId" id="goodsId" value="${goodsId}"/>
								<input type="hidden" name="type" id="type" value="${type}"/>
							</div>
							<div>
								<span>数量：</span><span>${number }</span>
								<input type="hidden" name="number" id="number" value="${number}"/>
								<input type="hidden" name="flag" id="flag" value="${flag}"/>
							</div>
							<div class="clear"></div>
						</li>
						<li>
							<div>
								
								<s:if test="#type==3">
									<span>单个所需积分：</span><span>${price }</span>
								</s:if>
								<s:elseif test="#type==7">
									<span>单个所需积分：</span><span>${price }</span>
								</s:elseif>
								<s:else>
									<s:if test="#price!=null">
									<span>单价（元）：</span><span>${price }</span>
									</s:if>
								</s:else>
							</div>
							<div>
								<s:if test="#type==3">
									<span>商品总积分：</span><span>${total}</span>
								</s:if>
								<s:elseif test="#type==7">
									<span>商品总积分：</span><span>${total}</span>
								</s:elseif>
								<s:else>
									<s:if test="#total!=null">
									<span>商品总价（元）：</span><span>${total}</span>
									</s:if>
								</s:else>
							</div>
							<div class="clear"></div>
						</li>
						<li>
							<%-- <s:if test="#type==3">
								<span>订单总价（分）：</span><span>${total2}</span>
							</s:if>
							<s:elseif test="#type==7">
								<span>订单总价（分）：</span><span>${total2}</span>
							</s:elseif>
							<s:else>
								<s:if test="#total!=null">
								<span>订单总价（元）：</span><span>${total2}</span>
								</s:if>
							</s:else> --%>
							<div>
								<span>商品规格：</span><span>${specifications }</span>
							</div>
							<div>
								<span>提货方式：</span><span>${deliverWay eq "1" ? "自取" : "送货上门"}</span>
							</div>
							<div class="clear"></div>
						</li>
						<li>
							<s:if test="#deliverWay==0">
								<div>
									<span>配送积分：</span><span>${shippingFee }</span>
								</div>
							</s:if>
							<s:if test="#sendIntegral!=null">
							<s:if test="#sendIntegral!=0">
							<s:if test="#type!=1">
							<s:if test="#type!=5">
								<div>
									<span>赠送积分：</span><span>${sendIntegral }</span>
								</div>
							</s:if>
							</s:if>
							</s:if>
							</s:if>
							<div class="clear"></div>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<div class="orders_operate">
					<div id='div_detail_4'>确认</div>
					<div id='div_detail_5'>取消</div>
					<span id="orderMsg"></span>
				</div>
			</div>
		</div>
	</div>