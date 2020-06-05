<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>详情页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/operate.css">
    <link href="css/carousel.css" rel="stylesheet">
	<link href="css/carousel.theme.css" rel="stylesheet">
  </head>
  
  <body class="body">
	<div class="container">
		<!--详细-->
		<div class="content_detail">
			<!--标题、时间-->
			<div>
				<div class="detail_title_arrow">
					<img src="images/arrow.png" height="29" width="15">
				</div>
				<div class="detail_title_tit">
					电视商圈 | 品牌商品 | 商品详情
				</div>
				<div class="detail_time">
                	<div class="time_minutes">
                    	<div id="minutes"></div>
                    </div>
                	<div class="time_across">
                    	<img src="images/across_line.png" width="2" height="50">
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
            	<div id="owl-demo" class="owl-carousel detail_left">
                    <a class="item">
                    	<img src="images/detail_pic1.png" alt="">
                    </a>
                    <a class="item">
                    	<img src="images/detail_pic2.png" alt="">
                    </a>
                    <a class="item">
                    	<img src="images/detail_pic3.png" alt="">
                   	</a>
            	</div>
                <!--轮播结束-->
				<!--产品介绍-->
				<div class="detail_right">
					<div class="detail_goods_name">
						小营寨  蛋黄点心等真空包装 特产礼盒 嘉兴点心礼盒
					</div>
					<div class="detail_cost">
						<div class="detail_list_left">
							<span>优惠特价：</span>
							<span class="detail_discount">￥45.9</span>
						</div>
						<div class="detail_list_right">
							<span>配送费：</span>
							<span>￥3.0</span>
						</div>
						<div class="clear"></div>
					</div>
					<div class="detail_discount_cost">
						<div class="detail_list_left detail_pay_count">
							<div class="detail_count_text">数量：</div>
							<div class="detail_count_operate">
								<div class="detail_count_add"></div>
								<div class="detail_count_inp">
									<input type="text" name="" value="2">
								</div>
								<div class="detail_count_minus"></div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="detail_discount_pay"></div>
						<div class="clear"></div>
					</div>
					<div class="detail_infor">
						<div class="detail_infor_line">
							<img src="images/information.png" height="25" width="478">
						</div>
						<div class="detail_infor_list">
							<div>
								<div class="detail_list_left">
									<span>产品名称：</span>
									<span>祥龙礼盒</span>
								</div>
								<div class="detail_list_right">
									<span>规格：</span>
									<span>100gX8只</span>
								</div>
								<div class="clear"></div>
							</div>
							<div>
								<div class="detail_list_left">
									<span>净含量：</span>
									<span>800克</span>
								</div>
								<div class="detail_list_right">
									<span>保质期：</span>
									<span>九个月</span>
								</div>
								<div class="clear"></div>
							</div>
							<div class="detail_list_contain">
								<div>礼盒内配：</div>
								<div>100gX2鲜肉粽，100gX2蛋黄肉粽，100gX2栗子肉粽，100gX2蜜枣粽</div>
								<div class="clear"></div>
							</div>
							<div class="detail_list_property">
								<div>储存方法：</div>
								<div>25℃以下，避光存放</div>
								<div class="clear"></div>
							</div>
							<div class="detail_list_property">
								<div>注意：</div>
								<div>如发现内袋破损、胀包，请勿使用</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
				</div>
				<!--产品介绍结束-->
				<div class="clear"></div>
			</div>
			<!--详情结束-->
		</div>
		<!--详细结束-->
	</div>
	<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="js/keyValueDefine.js"></script>
	<script type="text/javascript" src="js/lib_shb_date.js"></script>
	<script type="text/javascript" src="js/detailDataAjax.js"></script>
	<script type="text/javascript" src="js/wb_ScrollList.min.js"></script>
	<script type="text/javascript" src="js/detail.js"></script>
	<script type="text/javascript" src="js/jquery-v1.9.1.js"></script>
	<script type="text/javascript" src="js/carousel.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#owl-demo').owlCarousel({
				items: 1,
				autoPlay: true
			});
		});
	</script>
   </body>
</html>
