<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container2">
		<div class="orders_window">
			<div class="orders_title">
				<div>供应商详情</div>
				<div class="orders_line">
					<img src="images/detail/orders_line.png" height="1" width="800">
				</div>
			</div>
			<div class="orders_detail">
				<div class="orders_contact">
					<div class="orders_tel">
						<div>
							<span>供应商名称：${ms.supplierName }</span><span></span>
						</div>
						<div>
							<span></span><span></span>
						</div>
						<div class="clear"></div>
					</div>
					<div>
						<%-- <span>生成时间：</span><span>${list[1] }</span> --%>
						<span>供应商地址：</span><span>${ms.supplierAdderss }</span>
					</div>
				</div>
				<div class="orders_desc">
					<ul>
						<li>
							<div>
								<span>联系人姓名：</span><span>${ms.contactsName }</span>
							</div>
							<div>
								<span>供应商电话：</span><span>${ms.contactsPhone }</span>
							</div>
							<div>
								<span>供应商代码：</span><span>${ms.supplierCode }</span>
							</div>
							<div>
								<span>邮编：</span><span>${ms.postalCode }</span>
							</div>
							<div class="clear"></div>
						</li>
						<li>
							<!-- <div>
								<span>供应商代码：</span><span></span>
							</div> -->
							<div>
								<span></span><span></span>
							</div>
							<div class="clear"></div>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<div class="orders_operate">
					<div id='div_5_0'>返回</div>
					<span id="orderMsg"></span>
				</div>
			</div>
		</div>
	</div>
