<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container">
		<div class="orders_window" style="height: 220px;top:450px;">
			<div class="orders_title">
				<div>设置收货方式</div>
				<div class="orders_line">
					<img src="images/detail/orders_line.png" height="1" width="800">
				</div>
			
				        <div id="div_detail_4" style="margin-top:25px;"><input id="way_detail_4" type="radio" name="way" value="1"/>自取</div>
				        <div id="div_detail_5" style="margin-top:25px;"><input id="way_detail_5" type="radio" name="way" value="0"/>送货上门</div>
				        <input type="hidden" name="flag" id="flag" value="${flag }"/>			       
				        <input type="hidden" name="goodsId" id="way_goodsId" value="${goodsId }"/>	
				        <input type="hidden" name="number" id="way_number" value="${number }"/>	
				        <span id="errorMsg"></span>		       
						<span id="info" style="font-size:18px;padding-left:50px;">初次下单需要设定收货方式。如需更改收货方式请到“我的账户-送货信息”中进行修改。</span>
			</div>
		</div>
</div>
