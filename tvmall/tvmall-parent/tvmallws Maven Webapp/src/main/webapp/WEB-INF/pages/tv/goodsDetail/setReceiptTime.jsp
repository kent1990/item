<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container">
		<div class="orders_window" style="height: 220px;">
			<div class="orders_title">
				<div>设置方便收货时间</div>
				<div class="orders_line">
					<img src="images/detail/orders_line.png" height="1" width="800">
				</div>
			 </div>
			 <div class="orders_detail">  
			    <div id="div_rt_0">08:00~09:00</div>
			    <div id="div_rt_1">08:00~09:00</div>
			    <div id="div_rt_2">08:00~09:00</div>
			    <div id="div_rt_3">08:00~09:00</div>
			    <div id="div_rt_4">08:00~09:00</div>
			    <div id="div_rt_5">08:00~09:00</div>
			    <div id="div_rt_6">08:00~09:00</div>
			    <div id="div_rt_7">08:00~09:00</div>
			    <div id="page"><span id="pageIndex"></span>/<span id="pageNum"></span></div>
			</div>
		</div>
</div>
<script type="text/javascript">
				objScroll.MoveObj.arrFocus[1].len = objScroll.dataListLen;
    			//ScrollRender.setCont(objScroll, 0,Math.min(objScroll.MoveObj.arrFocus[1].limit, objScroll.dataListLen));
    			//ScrollRender.updatePage(objScroll);
    		
    			var moveObj = objScroll.MoveObj;    		
    			moveObj.setArea(1);
    			moveObj.doMove(0);
    		
    		
</script>
