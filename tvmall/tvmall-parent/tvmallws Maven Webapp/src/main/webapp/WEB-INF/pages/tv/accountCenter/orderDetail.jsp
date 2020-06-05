<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container2">
		<div class="orders_window">
			<input type="hidden" id="goodsId" value="${goodsId }">
			<input type="hidden" id="num" value="${num }">
			<input type="hidden" id="type" value="${type }">
			<div class="orders_title">
				<div>订单详情</div>
				<div class="orders_line">
					<img src="images/detail/orders_line.png" height="1" width="800">
				</div>
			</div>
			<div class="orders_detail">
				<div class="orders_contact">
					<div class="orders_tel">
						<div>
							<span>订单编号：</span><span>${list[0]}</span>
						</div>
						<div>
							<span>订单状态：</span><span>${state }</span>
						</div>
						
						<div class="clear"></div>
					</div>
					<div>
						<%-- <span>生成时间：</span><span>${list[1] }</span> --%>
						<span>收货地址：</span><span>${list[10] }</span>
					</div>
				</div>
				<div class="orders_desc">
					<ul>
						<li>
							<div>
								<span>商品名称：</span><span>${list[7] }</span>
							</div>
							<div>
								<span>提货方式：</span><span>${list[5] eq "1" ? "自取" : "送货上门"}</span>
							</div>
							<div class="clear"></div>
						</li>
						<li>
							<div>
							<s:if test="#type==3">
								<span>商品总价（分）：</span><span>${list[13] }</span>
							</s:if>
							<s:elseif test="#type==7">
								<span>商品总价（分）：</span><span>${list[13] }</span>
							</s:elseif>
							<s:else>
								<span>商品总价（元）：</span><span>${list[13] }</span>
							</s:else>
							</div>
							<div>
								<span>商品类型：</span><span>${goodsType}</span>
							</div>
							<div class="clear"></div>
						</li>
						<li>
							<div>
								<span>赠送积分：</span><span>${list[4]}</span>
							</div>
							<div>
								<span>数量：</span><span>${list[8] }</span>
							</div>
							<div class="clear"></div>
						</li>
						<li>
							<div>
								<span>服务点：</span><span>${list[9] }</span>
							</div>
							<s:if test="#list[3]!=null">
								<div>
									<span>配送积分：</span><span>${list[3] }</span>
								</div>
							</s:if>
							<div class="clear"></div>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<div class="orders_operate">
					<div id='div_4_0'>再次购买</div>
					<div id='div_4_1'>确定</div>
					<span id="orderMsg"></span>
				</div>
			</div>
		</div>
	</div>
