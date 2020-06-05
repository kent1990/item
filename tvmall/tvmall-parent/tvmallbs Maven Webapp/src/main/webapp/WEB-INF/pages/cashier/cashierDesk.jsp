<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
 <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
 <meta name="format-detection" content="telephone=no">
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="renderer" content="webkit">
 <title>收银台 </title>

   <link rel="stylesheet" href="css/business/midian.css" type="text/css"/>
	<link rel="stylesheet" href="css/business/mricode.pagination.css" type="text/css"/>
	<link href="js/common/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet"  type="text/css"/>
	<script type="text/javascript" src="js/common/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/common/mricode.pagination.js"></script>
	<script type="text/javascript" src="js/common/jquery.json-2.2.js"></script>
	<script type="text/javascript" src="js/common/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/treeCombox/treeCombox.js"></script>
	<script type="text/javascript" src="js/common/jquery.validate.min.js"></script>
	<script src="js/common/ztree/jquery.ztree.all.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/common/midian.js"></script>
</head>
  
  <body style="zoom: 1;">

	 <div class="x12" id="div_id" style="display: none;">
        <div class="x12 bgf5f5f5">
            <div class="x1"></div>
            <div class="x10 text-white">
                <div class="x12  text-gray">
                    <div class="x5 bheight padding-right border-right border-big  bg-white">
                        <div class="x12 padding-big">
                           
                            <div class="x12" id="huiyuancenter">
                                <div class="x12 padding-top padding-bottom">
                                    <ul class="buy-car line over-auto border" style="height: 400px;"></ul>
                                </div>
                                <div class="x12  height padding-bottom padding-top">
                                        <div class="x12 text-gray text-big">
                                            <div class="x6">件数：<span class="text-red">0</span></div>
                                            <div class="x6">合计：<span class="text-red">￥0.00</span></div>
                                        </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="x7 cheight  bg-white text-center" id="huiyuanright">
                            <div class="x12 padding-big"><img src="/imgs/bg-11.jpg" class="w100"></div>
                    </div>
                </div>
            </div>
    </div>

</div> 

<%-- <script type="text/javascript">
//进入消费收银界面就加载
            //var cpuhao=navigator.userAgent;
           /*  if(cpuhao.indexOf('GangHengKeJi')>=0){
                var jrxfsy=$('#div_id').html();
                JS_FK._cr(jrxfsy,'tuisongleirong');
            } */
</script> --%>
<!-- <div id="div_id"></div> -->
<style>
.listwidth{ border-radius: 4px;}
</style>
<div class="x12" style="background-color:#0B1121; min-width: 1000px;">
    <div class="navbar bg-black bg-inverse" id="layout-top" style="min-width: 1000px;">
        <div class="x7 padding-small text-large">
        收银台
               </div>
        <!-- <div class="x5">
            <div class="x12 text-big padding-small text-right"><a href="http://shop.hookwin.com/index.php/main">返回系统</a></div>
        </div> -->
    </div>

    <div class="x12 padding-small-top padding-left padding-right" id="layout-member" style="background-color: #FFFFFF;  min-width:1000px;">
        <!-- 会员信息展示区 -->
        <div class="x4 huiyuanzhanshi">
            <div class="x8 text-center text-large text-dot margin-bottom" id="no-member" style="display: block;">散客</div>
            <div class="x8 hidden" id="member-info">

                <div class="x3 padding-small-bottom">
                    <label>姓名：</label>
                    <span class="member-name" id="namex"></span>
                </div>
                <div class="x3 padding-small-bottom">
                    <label>会员级别：</label>
                    <span class="member-levelid"></span>
                </div>
                <div class="x3 padding-small-bottom">
                    <label>卡号：</label>
                    <span class="member-cardno"></span>
                </div>
                
                <div class="x3 padding-small-bottom cashier-member-info">
                    <label>手机：</label>
                    <span class="member-mobile" id="mobilex"></span>
                </div>
                <div class="x3 padding-small-bottom cashier-member-info">
                    <label>可用积分：</label>
                    <span class="member-points" id="pointsx"></span>
                </div>
                <div class="x6 padding-small-bottom cashier-balance">
                    <label>余额：</label>
                    <span class="member-money" id="moneyx"></span>
                     <a id="chongzhi" class="member-money-ranage button bg-dot button-little" href="javascript:void(0);" onclick="javascript:$showdialogs($(this));" data-toggle="click" data-mask="1" data-width="800px" data-url="">充值</a> 
                                            
                       <!-- <a class="member-charge-packages button bg-dot button-little" href="javascript:void(0);" onclick="javascript:$showdialogs($(this));" def-data-url="" data-toggle="click" data-mask="1" data-width="800px" data-url="">充次</a>
                        <a href="javascript:void(0);" class="member-packages button bg-dot button-little" onclick="javascript:$showdialogs($(this));" def-data-url="" data-toggle="click" data-mask="1" data-width="960px" data-url="">查看余次</a> -->
                                    </div>
            </div>

        </div>
        <div class="x8" style="width: 450px;">
            <div class="input-inline clearfix">
                <input type="text" class="input cashier-search-member" id="key-member" placeholder="手机/卡号" data-url="cashierDesk!queryMembers.do" value="">&nbsp;
                <button type="button" class="button bg-dot margin-small-left" style="float: left;" onclick="javascript:searchMember();">会员搜索</button>
                <button type="button" class="button bg-dot margin-small-left cashier-search-btn" style=" float: left;" onclick="javascript:removeMember();">散客</button>
                
                <button type="button" class="button bg-dot margin-small-left cashier-search-btn" style=" float: left;" data-toggle="click" data-mask="1" data-width="960px" data-url="vipsInfo!toAddTbMember.do" onclick="javascript:$showdialogs($(this));"><span class="icon-plus"></span> 新增会员</button>
            </div>
        </div>
    </div>
<script type="text/javascript">
$(function(){
    $('.huiyuanzhanshi').width($('#layout-member').width()-500);
    $(window).resize(function(){
        $('.huiyuanzhanshi').width($('#layout-member').width()-500);
    });
    $("input.treeCombox").zTreeCombox();
    //alert($('#layout-member').width()-340);
});
</script>
    <div class="x12 padding-small-top" id="layout-main" style="background-color: #0B1121;">
        <div class="x2 padding bg-white leftw radius" style="width: 280px;">
            <div class="x12 border-middle margin-bottom" id="layout-buy-order">
                <!-- 订单信息 -->
                <div class="x12">
                    <div class="x3 cashier-left-t">单号：</div>
                    <div class="x12"><span class="order-num text-little">${orderNum }</span></div>
                </div>
                <div class="x12">
                    <div class="x4 padding-small-top cashier-left-t1">商品数量：</div>
                    <div class="x8 text-right cashier-left-t"><span id="buy-car-goods-num" class="text-big text-dot">0</span></div>
                </div>
                <div class="x12">
                    <div class="x3 padding-small-top">合计：</div>
                    <div class="x9 text-right"><span id="buy-car-goods-money" class="text-big text-dot">0.00</span>元</div>
                </div>
            </div>

            <div class="x12 margin-bottom" id="layout-buy-input">
                <div class="">
                    <input class="input input-big text-default" id="key-put" placeholder="输入商品名称，回车键搜索" data-url="cashierDesk!queryGoodsByName.do">
                </div>
            </div>
            <form action="cashierDesk!toBilling.do" id="order-data" class="ajaxpost" method="post">
            <input type="hidden" name="memberId" id="t-member-id" value="">
            <input type="hidden" name="orderNum" id="t-order-num" value="${orderNum }" data-url="http://shop.hookwin.com/index.php/cashier/cashier_default/get_ordernum">
            <!-- <input type="hidden" name="orderId" value="" id="s-b-order-id"> -->
            <div class="x12">
                <input type="hidden" name="thebuylineindex" id="the-buy-line-index" value="" placeholder="当前选中产品的ID号">
                <ul class="buy-car line over-auto border" style="height: 534px;" id="layout-buy-car">
                    <li class="x12 border-bottom bg-E64E40 default-tpl hidden padding" data-selected="false" data-li-index="" onclick="javascript:clickBuyCar(this);">
                        <div class="x1 goods-index text-small">{data-goods-index}</div>
                        <div class="x11">
                            <div class="x12 text-small">名称：<strong>{data-goods-name}</strong></div>
                            <div class="x12">
                                <div class="x6 text-small">编号：{data-goods-code}</div>
                                <div class="x6 text-right text-small">
                                    <span>数量:</span>
                                    <span class="buy-num text-small">{data-goods-buynum}</span>
                                </div>
                            </div>
                            <div class="x12">
                                <div class="x6">
                                    <span>单价：￥</span>
                                    <span class="buy-price text-big">{data-goods-paymoney}</span>
                                </div>
                                <div class="x6 text-right">
                                    <span>合计：￥</span>
                                    <span class="buy-paymoney text-big">{data-goods-paymoney}</span>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="goods_id" class="goods-id" value="{data-goods-id}">
                        <input type="hidden" name="goods_price" class="goods-price" value="{data-goods-price}">
                        <input type="hidden" name="goods_num" class="buy-num" value="{data-goods-buynum}">
                    </li>
                </ul>
            </div>
            </form>
        </div>


        <div class="x1 padding-small-left padding-small-right centerw casier-cz-btn">
            <!-- 按钮区 -->
            <div class="x12 margin-small-bottom">
            <button class="button button-big bg-white button-block" onclick="javascript:clickPlus();">
            <span class="icon-plus"></span></button></div>
            <div class="x12 margin-small-bottom">
            <button class="button button-big bg-white button-block" onclick="javascript:clickMinus();">
            <span class="icon-minus"></span></button></div>

            <div class="x12 margin-small-bottom">
            <!-- <button class="button button-big bg-white button-block" onclick="javascript:toOrderPackages(this);" id="packages-order" data-url="" data-success-url="">充次结算</button> -->
            </div>
            <div class="x12 margin-small-bottom"><button class="button button-big bg-white button-block bg-dot" onclick="javascript:toOrder();">结算(/)</button></div>

            <div class="x12 margin-small-bottom"><button class="button button-big bg-white button-block" onclick="javascript:clickPlusNum();">数量(*)</button></div>
            <div class="x12 margin-small-bottom"><button class="button button-big bg-white button-block" onclick="javascript:clickDelete();">删除</button></div>
            <div class="x12 margin-small-bottom"><button class="button button-big bg-white button-block" onclick="javascript:removeBuyCar();">清空</button></div>
            <!--
            <div class="x12 margin-bottom"><button class="button button-large bg-white" onclick="javascript:x();">退货(t)</button></div>
            -->
            <div class="x12 margin-small-bottom">
            <!-- <button class="button button-big bg-white button-block" onclick="javascript:toTmpOrder();" id="to-tmp-order" data-url="">挂单</button> -->
            </div>
            <div class="x12 margin-small-bottom">
            <button class="button button-big bg-white button-block" onclick="javascript:toNotSettledOrder();" id="to-no-settled-order" data-url="cashierDesk!toWeiJieSuan.do">未完订单</button></div>

        </div>
        <div class="x9 rightw" style="min-width: 570px;">
            <div class="x12 bg-white margin-small-bottom padding-small-top padding-small-left padding-small-right radius" id="layout-goods-type" style="width: 100%;">
                  <div class="button-group border-red goods-types">
                   <!--  <button type="button" class="button margin-small-bottom active" onclick="javascript:goods_list(this);" data-url="http://shop.hookwin.com/index.php/cashier/cashier_default/goods_list/101100">示例分类</button>
                    <button type="button" class="button margin-small-bottom" onclick="javascript:goods_list(this);" data-url="http://shop.hookwin.com/index.php/cashier/cashier_default/goods_list/109395">大威德哇</button> -->
                   <!--  <button type="button" class="button margin-small-bottom" onclick="ajaxload('cashierDesk!queryGoodsType.do','_layout');">选择分类</button> -->
                  	<span class="button margin-small-bottom active">商品类：</span>
                    <input  type="text" id="goodClass" name="classId " class="treeCombox" style="height:34px;cursor:hand;" readonly value="" size="20"					
						dataUrl="cashierDesk!treeAllNodes.do"  callBack="javascript:selectCallback();" container="layout-main" class="treeCombox" placeholder="点击选择" /> 
                
                 </div> 
                
            </div>
           
    <div id="goods-list" class="x12 margin-bottom" style="width: 100%; height: 572px;">
    <div id="goods" class="x12 over-auto" id="layout-goods-list" style="height: 526px;">
  
 
  </div>
	
<script type="text/javascript">
    $(function(){
       autoFullHeight();
        $('.imgbyw').css('width',($('.listwidth').width()-$('.imgwidth').width()-10));
        $(window).resize(function(){
           $('.imgbyw').css('width',($('.listwidth').width()-$('.imgwidth').width()-10));
        });
    });
    
    function selectCallback(){
         $("#autoX12").remove();
		 $("#goods").after("<div id='autoX12' class='x12 padding-top text-right page-h'></div>");
		 	//商品分页
		$(".page-h").pagination({
			pageIndex:0,
			pageSize:5,
			showFirstLastBtn:true,
			firstBtnText:"首页",
			lastBtnText:"尾页",
			prevBtnText:"上一页",
			nextBtnText:"下一页",
			showInfo:true,
			infoFormat:"第{start}~{end}条                  共 {total}条",
			noInfoText:"没有数据记录",
			showJump:true,
			showPageSizes:true,
			pageSizeItems:[5,10,15,20],
			remote:{
					url:"cashierDesk!queryGoods.do",
					params:{"classId":$("#goodClass").attr("nodevalue")},
					pageParams:function(data){
						return {
							pageIndex:data.pageIndex*data.pageSize,
							pageSize:data.pageSize
						};
					},
				success:function(data){
					var index=$(".page-h").pagination("getPageIndex");
					var size=$(".page-h").pagination("getPageSize");
					var json=eval(data).model;
					
					$("#goods").empty();
					$.each(json,function(i,j){
					
					var goodsJson ={"goodsId":j[1],"goodsName":j[2],"goodsSellPrice":j[4],"goodsPromotionPrice":j[3]};
					//截取商品图片路径的第一张图片路径
					var imgPath	= j[0].substring(0,j[0].indexOf(";"));
						$goods=$(
							"商品编号：<div class='xb4 xs6 margin-small-bottom padding-small-right'"+ 
							"onclick='javascript:moreAddBuycar(this);' data-json="+$.toJSON(goodsJson)+">"+
    						"<div class='x12 bg-white padding-small listwidth'>"+
        					"<div class='x2 float-left imgwidth' style='width: 80px;'><img src='viewPic!viewDisk.do?path="+imgPath+"'"+
        					 "class='radius  border' style='width: 80px;height:80px;'></div>"+
        					"<div class='x10 media-body imgbyw padding-left' style='width: 190px;'>"+
				            "<div class='x12 text-small' title='3'>商品编号："+j[1]+"</div>"+
				            "<div class='x12 text-small'>商品名称："+j[2]+"</div>"+
				            "<div class='x6 text-left'>原价：￥<del>"+j[3]+"</del></div>"+
				            "<div class='x6 text-right'>促销价：￥<span class='text-big text-dot'>"+j[4]+"</span></div>"+
					        "</div></div></div>");
						$("#goods").append($goods);
						
					}); 
				}
			}
		});
	
		 		
    }
</script>

</div>

            <div class="x12 bg-white padding" id="status-info" style="width: 100%; display: none;">
                操作状态提示区            </div>
        </div>

    </div>

    <!-- 点击数量出来的浮层-->
    <div class="click-num">
      <div class="dialog">
        <div class="dialog-head">
          <span class="close rotate-hover"></span>
          <strong>请输入数量</strong>
        </div>
        <div class="dialog-body" style="height: 100px;">
          <input type="text" class="input input-big click-num-input" value="">
        </div>
        <div class="dialog-foot">
          <button type="button" class="button dialog-close">取消</button>
          <button type="button" class="button bg-green" onclick="javascript:sumClickPlusNum();">确认</button>
        </div>
      </div>
    </div>
    <!-- 搜索的时候，出来了多个商品-->
    <div class="search-more">
      <div class="dialog">
        <div class="dialog-head">
          <span class="close rotate-hover"></span>
          <strong>请选择商品</strong>
        </div>
        <div class="dialog-body line over-auto" style="height: 300px;">

        </div>
        <div class="dialog-foot">
          <button type="button" class="button dialog-close">取消</button>
          <button type="button" class="button bg-green" onclick="javascript:moreAddBuycar();">确认</button>
        </div>
      </div>
    </div>
    <!-- 搜索的时候，出来了多个会员-->
    <div class="member-more">
      <div class="dialog">
        <div class="dialog-head">
          <span class="close rotate-hover"></span>
          <strong>请选择会员</strong>
        </div>
        <div class="dialog-body line over-auto" style="height: 300px;">

        </div>
        <div class="dialog-foot">
          <button type="button" class="button dialog-close">取消</button>
          <button type="button" class="button bg-green" onclick="javascript:moreAddMember();">确认</button>
        </div>
      </div>
    </div>
</div>
<script type="text/javascript">
/****** 充次成功后的回调 ***/
function packagesSuccess(jsondata,memberId){
   var json_obj = $.evalJSON(jsondata);
   //console.info(json_obj);
   var $the_buy_car_line = $('.buy-car li');
    //扣掉被充次抵掉的数量
    $the_buy_car_line.each(function(){
        var $the_li = $(this);
        if(!$the_li.hasClass('default-tpl')){
            $(json_obj).each(function(){
                if($(this)[0].goods_id==$the_li.find('.goods-id').val()){
                    var sy_num =  parseInt(parseInt($the_li.find('.buy-num').text())-parseInt($(this)[0].buy_num));//抵掉后剩余的数量
                    //console.info(parseInt($the_li.find('.buy-num').text()),parseInt($(this)[0].buy_num),sy_num);
                        sy_num2 = Math.max(0,sy_num);
                        //console.info($($the_li).find('.buy-paymoney').text());
                    var sy_money = sy_num2*parseFloat($($the_li).find('.buy-price').text()); //抵掉后该支付的钱
                    $the_li.find('span[class~=buy-paymoney]').text(sy_money.toFixed(2));
                    $the_li.find('span[class~=buy-num]').text(sy_num2);
                    $the_li.find('input[class~=buy-num]').val(sy_num2);
                    if(sy_num2==0){
                         // 全部抵完了，移出这行
                         $the_li.remove();
                    }
                    //将未完的给下条继续抵掉
                    $(this)[0].buy_num=(sy_num>0)?(0):(Math.abs(sy_num));
                }
           });
        }
    });
    //重新合计
    sumBuyCar();
    //检查还有没有剩余的，如果有，就等到继续收银，如果没有，就弹出收银成功的通知页面
    if($('.buy-car li').length>1){
        closeDialogs();
        return false;
    }else{
        //将数据转换为url参数
        var param = parseParam(json_obj);
        $.Hidemsg();
        //打开一个浮层来显示
        var b = {};
        b['data-toggle']='click';
        b['data-url']=$('#packages-order').attr('data-success-url')+"?packages_print=1&t_member_id="+memberId+"&"+param;
        b['data-mask']='1';
        b['data-width']='300px';
        var $win = $showdialogs($(b));
    }
}
/****** 自动铺满全屏高度 ***/
function autoFullHeight(){
    //var full_height = $(window).height();
    var full_height=window.innerHeight;
    var layout_main = full_height-$('#layout-top').height()-$('#layout-member').height()-30;
    //$('#layout-main').height(layout_main);
    var layout_buy_car = layout_main-$('#layout-buy-order').height()-$('#layout-buy-input').height()-22;
    $('#layout-buy-car').height(layout_buy_car);
    var goods_list_height = layout_main-$('#layout-goods-type').height()-$('#status-info').height()-56;
    $('#goods-list').height(goods_list_height);
    $('#layout-goods-list').height($('#goods-list').height()-$('#layout-page').height()-10);
}
/****** 点击产品分类 *****/
function goods_list(xthis){
    if(xthis==undefined){
        var $xthis = $('.goods-types').children('button').first();
    }else{
        var $xthis = $(xthis);
    }
    if($xthis.length==0){
        return false;
    }
    var uri = $xthis.attr('data-url');
    $('#goods-list').html('');
    $.get(uri,function(data){
        $('#goods-list').html(data);
        $xthis.siblings().removeClass('active');
        $xthis.addClass('active');
    });
}
/**** 刷新收银 ****/
function refCashier(){
    removeMember();//会员变成散客
    removeBuyCar();//左边购物车清空
    getNextOrdernum();//重新获取一个新订单号
    $('#s-b-order-id').val('');//挂单号清空
    //关闭所有浮层
    $('.dialog-mask').remove();
    $('.dialog-win').remove();
}
/*** 充次结算按钮 **/
function toOrderPackages(xthis){
    //检查是不是已经弹出一个了
    var $dialogwin_input = $('.dialog-win');
    if($dialogwin_input.length>0){
        return false;
    }
    //将数据拿去后台生成一个订单，
    var $form = $('#order-data');
    //$form.submit();
    //return false;
    var $post_data = $form.serializeArray();
    //console.info($post_data);
    //打开一个浮层来显示
    var b = {};
    b['data-toggle']='click';
    b['data-url']=$("#packages-order").attr('data-url');
    b['data-mask']='1';
    b['data-postdata']=$post_data;
    b['data-width']='800px';
    var $win = $showdialogs($(b));
    $win.find('.click-num-input').val('').focus();
}
/*** 结算按钮 **/
function toOrder(){
	var goodList = $("#layout-buy-car>li").length;
	//alert(goodList);
	if (goodList==1) {
			$.Showmsg("你一个商品都没有买，好吧");
			setTimeout(function() {
                            $.Hidemsg();
    				    }, 3500);
		return;
	}
	
	
    shopTuiSongZhiPing();

    //检查是不是已经弹出一个了
    var $dialogwin_input = $('.dialog-win');
    if($dialogwin_input.length>0){
        return false;
    }
    //将数据拿去后台生成一个订单，
    var $form = $('#order-data');
    //$form.submit();
    //return false;

    var $post_data = $form.serializeArray();
    //console.info($post_data);
    //打开一个浮层来显示
    var b = {};
    b['data-toggle']='click';
    b['data-url']=$form.attr('action');
    b['data-mask']='1';
    b['data-postdata']=$post_data;
    b['data-width']='800px';
    var $win = $showdialogs($(b));
    $win.find('.click-num-input').val('').focus();
}
/*** 挂单按钮 **/
function toTmpOrder(){
    //检查是不是已经弹出一个了
    var $dialogwin_input = $('.dialog-win');
    if($dialogwin_input.length>0){
        return false;
    }
    //将数据拿去后台生成一个订单，
    var $form = $('#order-data');
    var $post_data = $form.serializeArray();
    //打开一个浮层来显示
    var b = {};
    b['data-toggle']='click';
    b['data-url']=$('#to-tmp-order').attr('data-url');
    b['data-mask']='1';
    b['data-postdata']=$post_data;
    b['data-width']='960px';
    var $win = $showdialogs($(b));
    $win.find('.click-num-input').val('').focus();
}
/*** 处理未支付完成的订单按钮 **/
function toNotSettledOrder(){
    //检查是不是已经弹出一个了
    var $dialogwin_input = $('.dialog-win');
    if($dialogwin_input.length>0){
        return false;
    }
    //将数据拿去后台生成一个订单，
    var $form = $('#order-data');
    var $post_data = $form.serializeArray();
    //打开一个浮层来显示
    var b = {};
    b['data-toggle']='click';
    b['data-url']=$('#to-no-settled-order').attr('data-url');
    b['data-mask']='1';
    b['data-postdata']=$post_data;
    b['data-width']='1060px';
    var $win = $showdialogs($(b));
    $win.find('.click-num-input').val('').focus();
}
/****** 挂单成功，或选择一个挂单  *****/
function toTmpOrderAdd(xthis){
    var $row = $(xthis);
    //先刷新重新收银
    removeMember();//会员变成散客
    removeBuyCar();//左边购物车清空
    var json_obj = $.evalJSON($row.attr('data-json'));
    //console.info(json_obj);
    $(json_obj.goods_detail).each(function(){
        //console.info($(this),$(this)[0].goods_id);
        addBuyCar(($(this)[0].goods_info),$(this)[0].buy_num);
    });
    $('#s-b-order-id').val(json_obj.s_b_order_id);
    //会员信息
    if(json_obj.member_info.length!=0){
        addMember(json_obj.member_info);
    }
    //重新合计
    sumBuyCar();
    closeDialogs();
    shopTuiSongZhiPing();
}
/****** 获取下一个订单号  *******/
function getNextOrdernum(){
    var $order_obj = $('#t-order-num');
    var uri = $order_obj.attr('data-url');
    $.get(uri,function(data,s,xhr){
    	var sessionStatus = xhr.getResponseHeader("sessionstatus");
    	var redirectLocation = xhr.getResponseHeader("location");
   		if(sessionStatus=="sessionTimeOut"){				      
      		$.Showmsg(data.message);
      		window.setTimeout(function(){
      			window.location=redirectLocation;
      		},2000);
      		return;
     	}
        $order_obj.val(data.order_num);
        $('.order-num').text(data.order_num);
    },'json');
}
/***** 移出会员信息变成散客 ****/
function removeMember(){
    var $member_info = $('#member-info');
    $member_info.find('.member-name').text('');
    $member_info.find('.member-levelid').text('');
    $member_info.find('.member-cardno').text('');
    $member_info.find('.member-idcard').text('');
    $member_info.find('.member-mobile').text('');
    $member_info.find('.member-points').text('');
    $member_info.find('.member-money').text('');


    //输入会员资料到表单
    $('#t-member-id').val('');
	
    //改变2个按钮的功能
    $member_info.find('.member-money-ranage').attr('data-url','');
    $member_info.find('.member-packages').attr('data-url','');

    //隐掉散客
    $('#no-member').show();
    //显示会员信息
    $member_info.addClass('hidden');

    $('#key-member').val('');//清空会员搜索框内容
    $('#key-put').val('').focus(); //焦点回到商品默认到输入框

}
/***** 写入会员信息进表单 ****/
function addMember(jsondata){
    var $member_info = $('#member-info');
    $member_info.find('.member-name').text(jsondata[0]);
    $member_info.find('.member-levelid').text(jsondata[1]);
    $member_info.find('.member-cardno').text(jsondata[2]);
    
    $member_info.find('.member-mobile').text(jsondata[3]);
    $member_info.find('.member-points').text(jsondata[4]);
    $member_info.find('.member-money').text(jsondata[5]);

    //输入会员资料到表单
    $('#t-member-id').val(jsondata[6]);
    
    $('#chongzhi').attr("data-url","recharge!toRecharge.do?memberId="+jsondata[6]);
    
	
	
    //改变2个按钮的功能
    
    $member_info.find('.member-packages').attr('data-url',$member_info.find('.member-packages').attr('def-data-url')+'/'+jsondata.t_member_id+'/'+jsondata.t_member_id);

    //隐掉散客
    $('#no-member').hide();
    //显示会员信息
    $member_info.removeClass('hidden');

    $('#key-member').val('');//清空会员搜索框内容
    $('#key-put').val('').focus(); //焦点回到商品默认到输入框

}
/*** 更多会员点击或回画进入buy-car **/
function moreAddMember(xthis){
    if(xthis==undefined){
        var $obj = $('.more-member li[data-selected=true]');
    }else{
         var $obj = $(xthis);
    }
     var jsondata = $.evalJSON($obj.attr('data-json'));
    addMember(jsondata);
    //关闭浮层
    closeDialogs($obj.closest('.dialog-win'));
}
/***** 会员搜索 *****/
function searchMember(){

    var $key_put = $('#key-member');
    var key_str = $key_put.val().replace(/(^\s*)|(\s*$)/g, "");
    var uir = $key_put.attr('data-url')+"?parameter="+encodeURIComponent(key_str);
    $.get(uir,function(data,s,xhr){
        var sessionStatus = xhr.getResponseHeader("sessionstatus");
	   	var redirectLocation = xhr.getResponseHeader("location");
  		if(sessionStatus=="sessionTimeOut"){				      
     		$.Showmsg(data.message);
     		window.setTimeout(function(){
     			window.location=redirectLocation;
     		},2000);
     		return;
    	}
        //console.info(data.length);
        if(data.model.length==0){
            //没有找到商品
            //statusInfo("没有找到符合条件的会员【"+key_str+"】，请核查该会员是否存在或已被冻结、禁用！");
            $.Showmsg("没有找到符合条件的会员【"+key_str+"】，请核查该会员是否存在或已被冻结、禁用！");
            $('#no-member').show();
           var cpuhao=navigator.userAgent;
           /*  if(cpuhao.indexOf('GangHengKeJi')>=0){
                var huiyuanx="散客";
                JS_FK._cr(huiyuanx,'tuisongleirong2');
            } */
            
			$("#member-info").remove();
            return false;
        }
        if(data.model.length==1){
            //只有一条记录，直接压入会员信息
            addMember(data.model[0]);
            var cpuhao=navigator.userAgent;
           /*  if(cpuhao.indexOf('GangHengKeJi')>=0){
                var huiyuanx="<div class='x12 height text-big'><div class='x6'>会员："+data.model[0][0]+"</div><div class='x6'>手机号："+data.model[0][0]+"</div></div><div class='x12  height  text-big'><div class='x6'>余额："+data.model[0][0]+"</div><div class='x6'>会员积分："+data.model[0][0]+"</div></div>";
                JS_FK._cr(huiyuanx,'tuisongleirong2');
            } */
        }else{
            //有多个商品记录弹出下拉浮层来选择 选中后放入到会员信息()
            var li_html = "<ul class='more-member x12'>";
            for(i=0;i<data.model.length;i++){
                //console.info($.toJSON(data[i]));
                li_html += "<li class='x12 border-bottom margin-little padding-bottom' onclick='javascript:moreAddMember(this);' data-json=\'";
                li_html += $.toJSON(data.model[i]);
                li_html += "\'>";
                li_html += "<div class='x1'>"+(i+1)+"</div>";
                li_html += "<div class='x11'>";
                li_html += "<div class='x12'>"+data.model[i][0]+"</div>";
                li_html += "<div class='x6'>"+data.model[i][3]+"</div>";
                li_html += "<div class='x6'>"+data.model[i][2]+"</div>";
                li_html += "</div>";
                li_html += "</li>";
            }
            li_html += "</ul>";

            //打开一个浮层来加载
            var b = {};
            b["data-toggle"]="click";
            b["data-target"]=".member-more";
            b["data-mask"]="1";
            b["data-width"]="600px";
            var $win = $showdialogs($(b));
            $win.find(".dialog-body").html(li_html);
            //把第一个的设置为选中
            $win.find("ul[class~=more-member]>li").mouseover(function(){
                 $(this).addClass("bg-E64E40");
            }).mouseout(function(){
              $(this).removeClass("bg-E64E40");
            });
           /// var $new = $win.find("ul[class~=more-member]>li").first();
           /// $new.attr("data-selected","true");
           // $new.addClass("bg-E64E40");
            return false;
        };
    },"json");
}
/***** 写入信息到状态栏  ***/
function statusInfo(msg){
    $('#status-info').fadeIn().html(msg);
    setTimeout(function(){
        $('#status-info').fadeOut();
    },3000);
}
/***** 合计buy-car中的数量和金额 *****/
function sumBuyCar(){
    var $the_buy_car_line = $('.buy-car li');
    var buy_num = 0;
    var buy_money = 0;
    //计算数量，和金额合计
    $the_buy_car_line.each(function(index){
        var $the_li = $(this);
        if(!$the_li.hasClass('default-tpl')){
            buy_num += parseInt($(this).find('.buy-num').text());
            buy_money += parseFloat($(this).find('.buy-paymoney').text());
            //重新给序号整个值
            $the_li.find('.goods-index').text(index+1);
            $the_li.find('input[class~=goods-id]').prop('name','goodsId['+(index)+']');
            $the_li.find('input[class~=goods-price]').prop('name','goodsPrice['+(index)+']');
            $the_li.find('input[class~=buy-num]').prop('name','goodsBuyNum['+(index)+']'); 
        }
    });
    //console.info(buy_num,buy_money);
    $('#buy-car-goods-num').text(buy_num.toFixed(0));
    $('#buy-car-goods-money').text(buy_money.toFixed(2));
}
/** 将数据列表清空，为下一次收银作准备 **/
function removeBuyCar(){
    var $the_buy_car_line = $('.buy-car li');
    $the_buy_car_line.each(function(){
        var $the_li = $(this);
        if(!$the_li.hasClass('default-tpl')){
            $the_li.remove();
        }
    });
    $('#key-put').val('').focus();
    sumBuyCar();//合计一下数量
    shopTuiSongZhiPing();
}
/** 将数据输进列表中 **/
function addBuyCar(jsondata,buy_num){
    //console.info('压进去',jsondata);
    if(typeof(buy_num)=='undefined'){
        buy_num=1;
    }
    //取得模板
    var $default_tpl = $('.buy-car li[class~=default-tpl]');
    var $new_tpl = $default_tpl.clone();
    var new_li_str = $new_tpl.html();
    var li_index = $('.buy-car li').length;//序号
    //console.info($default_tpl,new_li_str);
    //替换里面的变量

    var isExists = false;
    $('.buy-car').find('.goods-id').each(function(){
       if($(this).val()==jsondata.goodsId && jsondata.goodsId!=null && jsondata.goodsId!="") {
            var goodsIndex = $(this).parent().find('.goods-index').text();
            //处理数据的效果
            $('.buy-car li').removeClass('bg-E64E40').attr('data-selected','false');
            $('#the-buy-line-index').val(goodsIndex);
            $(this).parent().attr('data-selected','true');
            $(this).parent().attr('data-li-index',goodsIndex);
            $(this).parent().addClass('bg-E64E40');
            clickPlus();
            isExists = true;
       }
    });
    if(isExists){
        return false;
    }
    new_li_str = new_li_str.replace(/\{data-goods-index\}/gi,li_index);//序号
    new_li_str = new_li_str.replace(/\{data-goods-id\}/gi,jsondata.goodsId);//
    new_li_str = new_li_str.replace(/\{data-goods-code\}/gi,jsondata.goodsId);//

    //new_li_str = new_li_str.replace(/\{data-goods-name\}/gi,jsondata.goods_name.substr(0,12)+'...');//
    new_li_str = new_li_str.replace(/\{data-goods-name\}/gi,jsondata.goodsName);//
    new_li_str = new_li_str.replace(/\{data-goods-price\}/gi,jsondata.goodsSellPrice);//
    new_li_str = new_li_str.replace(/\{data-goods-buynum\}/gi,buy_num);//
    if (jsondata.pay_price) {
        new_li_str = new_li_str.replace(/\{data-goods-paymoney\}/gi,jsondata.goodsPromotionPrice);//
    }else{
        new_li_str = new_li_str.replace(/\{data-goods-paymoney\}/gi,jsondata.goodsSellPrice);//
    }
    new_li_str = new_li_str.replace(/\{.+\}/gi,'-');//
    //console.info("================"+new_li_str);

    //处理数据的效果
    $('.buy-car li').removeClass('bg-E64E40').attr('data-selected','false');
    $('#the-buy-line-index').val(li_index);
    //自己的效果
    $new_tpl.html(new_li_str);
    
    $new_tpl.removeClass('default-tpl').removeClass('hidden');
    $new_tpl.attr('data-selected','true');
    $new_tpl.attr('data-li-index',li_index);
    $new_tpl.addClass('bg-E64E40');
    //console.info("----------------------"+$new_tpl.html());
    $default_tpl.before($new_tpl);
    //console.info(">>>>>>>>>>>>>>>>>>>>>>"+$new_tpl.html());
    $('#key-put').val('').focus();
    sumBuyCar();//合计一下数量
    //滚动条到最下面
    $('.buy-car').scrollTop($('.buy-car').scrollTop()+100000);
}
/** 输入框回车 **/
function keyPut(){
    var $key_put = $('#key-put');
    var key_str = $key_put.val().replace(/(^\s*)|(\s*$)/g, "");
    
    if(key_str==''){
        //如果输入框内没有东西，就返回
        return false;
    }
   /*  var isMoney = new RegExp("^([0-9]+[\.]{1}[0-9]{1,2})$");
    //console.info(key_str,isMoney.test(key_str));
    if(isMoney.test(key_str)){
        //console.info('这是钱');
        var no_code_goods = {'goodsSellPrice':$key_put.val(),'goodsId':'','goods_code':'','goodsName':'无码商品'};
        addBuyCar(no_code_goods);
        return true;
    } */
    
   /*  var isPinyin = new RegExp("^([a-zA-Z]+)$");
    if(isPinyin.test(key_str)){
        //是字母就当成助记码传入给后台
        var uir = $key_put.attr('data-url')+'?pinyin='+key_str;
    }else{
        //当成条码传入给后台
        var uir = $key_put.attr('data-url')+'?code='+key_str;
    } */
    //console.info('找服务器要');
    //如果是条码或助记码，就去 找服务器要
var uir = $key_put.attr('data-url')+'?goodsName='+key_str;
 
    $.get(uir,function(result,s,xhr){
    	var sessionStatus = xhr.getResponseHeader("sessionstatus");
    	var redirectLocation = xhr.getResponseHeader("location");
   		if(sessionStatus=="sessionTimeOut"){				      
      		$.Showmsg(result.message);
      		window.setTimeout(function(){
      			window.location=redirectLocation;
      		},2000);
      		return;
     	}
        //console.info(data.length);
        var data = result.model;
        if(data==null||data.length==0){
            //没有找到商品
            statusInfo('没有找到符合条件的商品【'+key_str+'】');
            return false;
        }
        if(data.length==1){
            //只有一条记录，直接压入bug-car
            addBuyCar(data[0]);
        }else{
            //有多个商品记录弹出下拉浮层来选择 选中后addBuyCar()

            var li_html = '<ul class="more-goods x12">';
            for(i=0;i<data.length;i++){
                //console.info($.toJSON(data[i]));\
                
                var price = 0.00;
                if (data[i].goodsPromotionPrice==null||goodsPromotionPrice==0.00||goodsPromotionPrice=="") {
					price = data[i].goodsSellPrice;
				}else{
					price = data[i].goodsPromotionPrice;
				}
				
                li_html += '<li class="x12 border-bottom margin-little padding-bottom" onclick="javascript:moreAddBuycar(this);" data-json=\'';
                li_html += $.toJSON(data[i]);
                li_html += '\'>';
                li_html += '<div class="x1">'+(i+1)+'</div>';
                li_html += '<div class="x11">';
                li_html += '<div class="x12">'+data[i].goodsName+'</div>';
                li_html += '<div class="x6">'+data[i].goodsId+'</div>';
                li_html += '<div class="x6">售价:'+price+' 元</div>';
                li_html += '</div>';
                li_html += '</li>';
            }
            li_html += '</ul>';

            //打开一个浮层来加载
            var b = {};
            b['data-toggle']='click';
            b['data-target']='.search-more';
            b['data-mask']='1';
            b['data-width']='600px';
            var $win = $showdialogs($(b));
            $win.find('.dialog-body').html(li_html);
            //把第一个的设置为选中
            var $new = $win.find('ul[class~=more-goods]>li').first();
            $new.attr('data-selected','true');
            $new.addClass('bg-E64E40');
            return false;
        }
    },'json');
    return true;
}
/*** 更多商品点击或回画进入buy-car **/
function moreAddBuycar(xthis){

    if(xthis==undefined){

        var $obj = $('.more-goods li[data-selected=true]');


    }else{
        shopTuiSongZhiPing();
         var $obj = $(xthis);


    }
    var jsondata = $.evalJSON($obj.attr('data-json'));
    addBuyCar(jsondata);
    shopTuiSongZhiPing();
    //关闭浮层
    closeDialogs($obj.closest('.dialog-win'));
}
function  shopTuiSongZhiPing(){

        //进入消费收银界面推送
            var cpuhao=navigator.userAgent;
           /*  if(cpuhao.indexOf('GangHengKeJi')>=0){

                var jrxfsy='<div class="x12"><ul class="buy-car line over-auto border" style="height: 400px;" id="layout-buy-car">'+$('#layout-buy-car').html()+'</ul></div><div class="x12  height padding-bottom padding-top"><div class="x12 text-gray"><div class="x6">件数：<span class="text-red">'+$('#buy-car-goods-num').text()+'</span></div><div class="x6">合计：<span class="text-red">￥'+$('#buy-car-goods-money').text()+'</span></div></div></div>';
                JS_FK._cr(jrxfsy,'tuisongleirong3');
            } */
}

/** 点击buy-car **/
function clickBuyCar(xthis){
    //处理数据的效果
    $('.buy-car li').removeClass('bg-E64E40').attr('data-selected','false');
    $('#the-buy-line-index').val($(xthis).attr('data-li-index'));
    //自己的效果
    $(xthis).attr('data-selected','true');
    $(xthis).addClass('bg-E64E40');
    $('#key-put').val('').focus();
}
/** 点击+号 **/
function clickPlus(){
    //console.info('开始加号');
    var $the_buy_car_line = $('.buy-car li[data-selected=true]');
    //取得现有的数量
    var buy_num = parseInt($the_buy_car_line.find('span[class~=buy-num]').text())+1;
    //取得现有的单价
    var buy_price = parseFloat($the_buy_car_line.find('span[class~=buy-price]').text());
    var buy_paymoney = (buy_num*buy_price).toFixed(2);
    $the_buy_car_line.find('span[class~=buy-paymoney]').text(buy_paymoney);
    $the_buy_car_line.find('span[class~=buy-num]').text(buy_num);
    $the_buy_car_line.find('input[class~=buy-num]').val(buy_num);
    $('#key-put').val('').focus();
    sumBuyCar();//合计一下数量
    shopTuiSongZhiPing();
}
/** 点击-号 **/
function clickMinus(){
    var $the_buy_car_line = $('.buy-car li[data-selected=true]');
    //取得现有的数量
    var buy_num = parseInt($the_buy_car_line.find('span[class~=buy-num]').text())-1;
    if(buy_num<=0){
        //将选中效果移到上面一个
        var $new = $the_buy_car_line.prev();
        if($new.length==0){
            $new = $the_buy_car_line.next();
        }
        if($new.length>0 && !$new.hasClass('default-tpl')){
            $new.attr('data-selected','true');
            $new.addClass('bg-E64E40');
            $('#the-buy-line-index').val($new.attr('data-li-index'));
        }
        //删除现在的，
        $the_buy_car_line.remove();
    }
    //取得现有的单价
    var buy_price = parseFloat($the_buy_car_line.find('span[class~=buy-price]').text());
    var buy_paymoney = (buy_num*buy_price).toFixed(2);
    $the_buy_car_line.find('span[class~=buy-paymoney]').text(buy_paymoney);
    $the_buy_car_line.find('span[class~=buy-num]').text(buy_num);
    $the_buy_car_line.find('input[class~=buy-num]').val(buy_num);
    $('#key-put').val('').focus();
    sumBuyCar();//合计一下数量
    shopTuiSongZhiPing();
}
/*** 删除当前的购买 **/
function clickDelete(){
     var $the_buy_car_line = $('.buy-car li[data-selected=true]');
    //将选中效果移到上面一个
    var $new = $the_buy_car_line.prev();
    if($new.length==0){
        $new = $the_buy_car_line.next();
    }
    if($new.length>0 && !$new.hasClass('default-tpl')){
        $new.attr('data-selected','true');
        $new.addClass('bg-E64E40');
        $('#the-buy-line-index').val($new.attr('data-li-index'));
    }
    //删除现在的，
    $the_buy_car_line.remove();
    //将焦点移加输入框
    $('#key-put').val('').focus();
    sumBuyCar();//合计一下数量
    shopTuiSongZhiPing();
}
/*** 输入数量 **/
function clickPlusNum(){
    //检查是不是已经弹出一个了
    var $dialogwin_input = $('.dialog-win');
    if($dialogwin_input.length>0){
        return false;
    }
    //当前选中的对像
    var $the_buy_car_line = $('.buy-car li[data-selected=true]');
    //console.info($the_buy_car_line.length);
    if($the_buy_car_line.length==0){
        return false;
    }
    //打开一个浮层来加载
    var b = {};
    b['data-toggle']='click';
    b['data-target']='.click-num';
    b['data-mask']='1';
    b['data-width']='300px';
    var $win = $showdialogs($(b));

    $win.find('.click-num-input').val('').focus();

}
/*** 输入数量的浮层执行动作 ***/
function sumClickPlusNum(){
    var $the_buy_car_line = $('.buy-car li[data-selected=true]');
    //取得输入的数量
    var $dialogwin_input = $('.dialog-win .click-num-input');
    var buy_num = parseInt($dialogwin_input.val());
    //console.info(isNaN(buy_num));
    if(isNaN(buy_num)==true){
        return false;
    }
    if((buy_num)<=0){
        return false;
    }
    //取得现有的单价
    var buy_price = parseFloat($the_buy_car_line.find('span[class~=buy-price]').text());
    var buy_paymoney = (buy_num*buy_price).toFixed(2);
    $the_buy_car_line.find('span[class~=buy-paymoney]').text(buy_paymoney);
    $the_buy_car_line.find('span[class~=buy-num]').text(buy_num);
    $the_buy_car_line.find('input[class~=buy-num]').val(buy_num);
    $('#key-put').val('').focus();
    closeDialogs($dialogwin_input.closest('.dialog-win'));
    sumBuyCar();//合计一下数量
    shopTuiSongZhiPing();
}
/**** 关闭最上面的一个浮层 *****/
function closeDialogs(xthis){
     var $last_dialog = (xthis);
    if(xthis==undefined){
        //最找最后一个来窗口来关闭
        $last_dialog = $('.dialog-win').last();
    }
    //console.info($last_dialog);
    $('.dialog-mask[masklayout='+$last_dialog.attr('masklayout')+']').remove();
    $last_dialog.remove();
}

/*** 主界面上下箭头 **/
function clickUpDown(){
    var $obj = $('.buy-car li[data-selected=true]');
    if(event.keyCode == 38){
        //上
        var $new = $obj.prev();
        //滚动条的改变
        $('.buy-car').scrollTop($('.buy-car').scrollTop()-$obj.height());
    }else{
        //下
        var $new = $obj.next();
        //滚动条的改变
        $('.buy-car').scrollTop($('.buy-car').scrollTop()+$obj.height());
    }
    if($new.length==0 || $new.hasClass('default-tpl')){
        return false;
    }
    //console.info($new.length);
    $obj.attr('data-selected','false');
    $obj.removeClass('bg-E64E40');
    //改变效果
    $new.attr('data-selected','true');
    $new.addClass('bg-E64E40');
    //改变现在选中的数据记录
    $('#the-buy-line-index').val($new.attr('data-li-index'));

    $('#key-put').val('').focus(); //焦点默认到输入框
    return true;
}
/*** 浮层商品选择上下箭头 **/
function clickDialogUpDown(){
    var $obj = $('.more-goods li[data-selected=true]');
    //console.info($obj);
    if(event.keyCode == 38){
        //上
        var $new = $obj.prev();
        //滚动条的改变
        $obj.closest('.dialog-body').scrollTop($obj.closest('.dialog-body').scrollTop()-$obj.height());
    }else{
        //下
        var $new = $obj.next();
        //滚动条的改变
        $obj.closest('.dialog-body').scrollTop($obj.closest('.dialog-body').scrollTop()+$obj.height());
    }
    //console.info($new.length);
    if($new.length==0){
        return false;
    }
    $obj.attr('data-selected','false');
    $obj.removeClass('bg-E64E40');
    //改变效果
    $new.attr('data-selected','true');
    $new.addClass('bg-E64E40');
    return true;
}
/*** 浮层会员的选择上下箭头 **/
function clickDialogMemberUpDown(){
    //console.info('vv');
    var $obj = $('.more-member li[data-selected=true]');
    if(event.keyCode == 38){
        //上
        var $new = $obj.prev();
        //滚动条的改变
        $obj.closest('.dialog-body').scrollTop($obj.closest('.dialog-body').scrollTop()-$obj.height());
    }else{
        //下
        var $new = $obj.next();
        //滚动条的改变
        $obj.closest('.dialog-body').scrollTop($obj.closest('.dialog-body').scrollTop()+$obj.height());
    }
    if($new.length==0){
        return false;
    }
    $obj.attr('data-selected','false');
    $obj.removeClass('bg-E64E40');
    //改变效果
    $new.attr('data-selected','true');
    $new.addClass('bg-E64E40');
    return true;
}
$(function(){
    $('.rightw').width($(window).width()-450);
    $(window).resize(function(){
        autoFullHeight();
            $('.rightw').width($(window).width()-450);
        });
    autoFullHeight();//全屏
    $("body").keydown(function(event) {
        /////////////////// 以下是对回车键的处理
        ////console.info(event.keyCode);
        switch(event.keyCode){
            //case 73:
//                // i 未结算订单
//                event.preventDefault();//移出原有功能
//                toNotSettledOrder();
//            break;
            case 107:
                //+号
                event.preventDefault();//移出原有功能
                clickPlus();
            break;
            case 109:
                //-号
                event.preventDefault();//移出原有功能
                clickMinus();
            break;
            case 38:
                //上箭头
                event.preventDefault();//移出原有功能
                if($('.more-goods li').length>0){
                    clickDialogUpDown();
                }else if($('.more-member li').length>0){
                    //会员选择浮层如果有
                    clickDialogMemberUpDown();
                }else{
                    clickUpDown();
                }
            break;
            case 40:
                //下箭头
                event.preventDefault();//移出原有功能
                if($('.more-goods li').length>0){
                    //商品浮层如果有，
                    clickDialogUpDown();
                }else if($('.more-member li').length>0){
                    //会员选择浮层如果有
                    clickDialogMemberUpDown();
                }else{
                    clickUpDown();
                }
            break;
            case 106:
                //*号
                event.preventDefault();//移出原有功能
                clickPlusNum();
            break;
            case 111:
                // /号 结算
                event.preventDefault();//移出原有功能
                toOrder();
            break;

            //case 81:
//                // q 充次结算
//                event.preventDefault();//移出原有功能
//                toOrderPackages();
//            break;
           // case 71:
//                // g 挂单操作
//                event.preventDefault();//移出原有功能
//                toTmpOrder()();
//            break;
            //case 68:
//                //d 删除当前行
//                event.preventDefault();//移出原有功能
//                clickDelete();
//            break;
            //case 67:
//                //c 清空
//                event.preventDefault();//移出原有功能
//                 removeBuyCar();
//            break;
//
            case 27:
                //esc，关闭顶部浮层
                event.preventDefault();//移出原有功能
                closeDialogs();
            break;
            case 32:
                //空格，回到输入框焦点
                event.preventDefault();//移出原有功能
                $('#key-member').val('').focus(); //焦点默认到输入框
            break;
            case 13:
                //回车
                if($('.dialog-win .success-dialogs').length>0){
                    //在支付页成功页按下回车
                    event.preventDefault();//移出原有功能
                    $('.dialog-win .success-dialogs').click();
                    return false;
                }else if($('.pay-dialog').length>0){
                    //在支付页按下回车
                    event.preventDefault();//移出原有功能
                    $('.pay-dialog').submit();
                    return false;
                }else if($('.dialog-win .pay-order-confirm .pay-method[pay-method=2]').length>0){
                    //在结算界面按下回车，默认为现金结算
                    event.preventDefault();//移出原有功能
                    $('.dialog-win .pay-order-confirm .pay-method[pay-method=2]').click();
                    return false;
                }else if($('.dialog-win .click-num-input').length>0){
                    //是不是数量输浮层下按的回车
                    event.preventDefault();//移出原有功能
                    sumClickPlusNum();
                    return false;
                }else if($('.dialog-win .more-goods').length>0){
                    //在更多商品页按回车
                    event.preventDefault();//移出原有功能
                    moreAddBuycar();
                    return false;
                }else if($('.dialog-win .more-member').length>0){
                    //在更多会员页按回车
                    event.preventDefault();//移出原有功能
                    moreAddMember();
                    return false;
                }else if($('#key-member').val()!=''){
                    //会员搜索框不为空时按回车
                    event.preventDefault();//移出原有功能
                    searchMember();
                    return false;
                }else if(keyPut()){
                    //主输入框的回车动作
                    event.preventDefault();//移出原有功能
                    return false;
                }else{
                    //收银台界面按回车也默认到输入框
                    $('#key-put').val('').focus(); //焦点默认到输入框
                }
            break;
        }
    });
    //默认找服务器先要一个订单来
    //getNextOrdernum();
    //默认加载第一个分类的图片
    //goods_list();
    $('#key-put').val('').focus(); //焦点默认到输入框
});
	
  $(function(){
	var message = "${message}";
	if (message=="success") {
		 $.Showmsg("支付成功！");	
	}
	setTimeout(function() {
        $.Hidemsg();
   	}, 2000);
	
});



</script><!--小票打印-->
<div id="sys-print-ticket" style="display: none;" data-url="">

</div>

</body>
</html>
