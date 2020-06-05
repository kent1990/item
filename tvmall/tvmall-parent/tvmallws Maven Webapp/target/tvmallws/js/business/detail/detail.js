function funShowDate() {
	var date = new Date();
	var dateStr = date.format("YYYY-MM-DD hh:mm").split(' ');
	var week = date.week();
	$e('minutes').innerHTML = dateStr[1];
	$e('week').innerHTML = week;
	$e('date').innerHTML = dateStr[0];
	
	setTimeout(funShowDate, 30);
}

//焦点定义
var moveObj = null;
var arrFocus = [] ;
arrFocus[0] = {
	focusId:1,
	startId:0,
	doFocus: function(){
		var obj = objScroll.MoveObj.arrFocus[0] ;
		clearInterval(myInterval);
		var i = 1;
		myInterval=setInterval(function(){
				$e('div_detail_' + obj.focusId).className = "focus_lists"+i;
				i++;
				if(i>2) i=1;
		}, 500);
		if(obj.focusId==1) {
			$e('div_detail_1').style.backgroundColor="#0096ff";
			$e('div_detail_1').focus();
		}else if(obj.focusId>=4){
			$e('div_detail_' + obj.focusId).style.backgroundColor = "#0096ff";
			//设置raido选中
			var flag = $e("flag").value;
			if(flag=="dw"){
				$e("way_detail_"+obj.focusId).checked=true;
			}
		}
		else
		$e('div_detail_'+obj.focusId).style.background= "url('images/detail/detail_"+obj.focusId+"_1.png')";
	},
	doBlur: function(){
		var obj = objScroll.MoveObj.arrFocus[0] ;
		$e('div_detail_' + obj.focusId).className = "";
		if(obj.focusId==1){
			$e('div_detail_1').style.backgroundColor="#5070a2";
			$e('div_detail_1').blur();
		} else if(obj.focusId>=4){
			$e('div_detail_' + obj.focusId).style.backgroundColor = "#5070a2";
		}
		else
			$e('div_detail_'+obj.focusId).style.background = "url('images/detail/detail_"+obj.focusId+"_0.png')";
	},
	limit:6,
	len:6,
	cols:6
};

/* 收货时间选择*/
arrFocus[1]={
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[1] ;
			clearInterval(myInterval);
			var i = 1;
			myInterval=setInterval(function(){
					$e('div_rt_' + obj.focusId).className = "focus_lists"+i;
					i++;
					if(i>2) i=1;
			}, 500);
			$e('div_rt_'+obj.focusId).style.backgroundColor="#0096ff";
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[1] ;
			$e('div_rt_'+obj.focusId).style.backgroundColor="";
			$e('div_rt_' + obj.focusId).className = "";
		},
		limit:8,
		len:8,
		cols:4
};
/* 供应商信息*/
var myInterval=null;
arrFocus[2]={
		focusId:0,
		startId:0,
		doFocus: function(){
			clearInterval(myInterval);
			var i = 1;
			myInterval=setInterval(function(){
					$e('brand').className = "focus_lists"+i;
					i++;
					if(i>2) i=1;
			}, 500);
			$e('brand').style.backgroundColor="#0096ff";
		},
		doBlur: function(){
			$e('brand').className = "";
			$e('brand').style.backgroundColor="";
		},
		limit:1,
		len:1,
		cols:1
};
arrFocus[3]={
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[3] ;
			clearInterval(myInterval);
			var i = 1;
			myInterval=setInterval(function(){
					$e('div_5_0').className = "focus_lists"+i;
					i++;
					if(i>2) i=1;
			}, 500);
			$e('div_5_0').style.backgroundColor="#0096ff";
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[3] ;
			$e('div_5_0').style.backgroundColor="";
			$e('div_5_0').className = "";
		},
		limit:1,
		len:1,
		cols:1
};
arrFocus[4]={
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[4] ;
			clearInterval(myInterval);
			var i = 1;
			myInterval=setInterval(function(){
					$e('div_6_0').className = "focus_lists"+i;
					i++;
					if(i>2) i=1;
			}, 500);
			$e('div_6_0').style.backgroundColor="#0096ff";
		},	
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[4] ;
			$e('div_6_0').style.backgroundColor="";
			$e('div_6_0').className = "";
		},
		limit:1,
		len:1,
		cols:1
};
/* 遥控器事件 处理JS */
function keyEvent(e){
	var keycode = (window.event)?event.keyCode : e.which ;
	switch(keycode){
		case key.Up:
		case 38:
			funKeyPressUp();
			return false ;
			break;
		case key.Down:
		case 40:
			funKeyPressDown();
			return false ;
			break;
		case key.Left:
		case 37:
			funKeyPressLeft();
			return false ;
			break;
		case key.Right:
		case 39:
			funKeyPressRight();
			return false ;
			break;
		case key.Ok:
		case 13:
			funKeyPressOk();
			return false ;
			break ;
		case key.Back:
		case 8:
			history.back();
			return false ;
			break ;
		case key.numb1:
		case 49:
			$e("div_detail_1").innerHTML=1;
			return false;
			break;
		case key.numb2:
		case 50:
			$e("div_detail_1").innerHTML=2;
			return false;
			break;
		case key.numb3:
		case 51:
			$e("div_detail_1").innerHTML=3;
			return false;
			break;
		case key.numb4:
		case 52:
			$e("div_detail_1").innerHTML=4;
			return false;
			break;
		case key.numb5:
		case 53:
			$e("div_detail_1").innerHTML=5;
			return false;
			break;
		case key.numb6:
		case 54:
			$e("div_detail_1").innerHTML=6;
			return false;
			break;
		case key.numb7:
		case 55:
			$e("div_detail_1").innerHTML=7;
			return false;
			break;
		case key.numb8:
		case 56:
			$e("div_detail_1").innerHTML=8;
			return false;
			break;
		case key.numb9:
		case 57:
			$e("div_detail_1").innerHTML=9;
			return false;
			break;	
	}
}

function funKeyPressUp(){	
	var moveObj = objScroll.MoveObj;
	var moveFocus = moveObj.arrFocus[moveObj.area];
	var startId = moveFocus.startId;
	var focusId = moveFocus.focusId; 
	var timeIsDisplay = $e("setTime").style.display;
	if(timeIsDisplay=="block")
		objScroll.scrollUp();
	if(moveObj.area==0){
		if(focusId<4){
			moveObj.setArea(2);
			moveObj.doMove(0);
		}
	}
}

function funKeyPressDown(){	
	var moveObj = objScroll.MoveObj;
	var timeIsDisplay = $e("setTime").style.display;
	if(timeIsDisplay=="block")
		objScroll.scrollDown();
	if(moveObj.area==2){
		moveObj.setArea(0);
		moveObj.doMove(0);
	}
}

function funKeyPressLeft(){
	var moveObj = objScroll.MoveObj;
	var moveFocus = moveObj.arrFocus[moveObj.area];
	var startId = moveFocus.startId;
	var focusId = moveFocus.focusId; 
	if(focusId==4)
		return;
	else
		objScroll.scrollLeft();
}

function funKeyPressRight(){
	var moveObj = objScroll.MoveObj;
	var moveFocus = moveObj.arrFocus[moveObj.area];
	var startId = moveFocus.startId;
	var focusId = moveFocus.focusId; 
	if(focusId==3)
		return;
	else
		objScroll.scrollRight();
}

function funKeyPressOk(){
	var moveObj = objScroll.MoveObj;
	var moveFocus = moveObj.arrFocus[moveObj.area];
	var startId = moveFocus.startId;
	var focusId = moveFocus.focusId; 
	var timeIsDisplay = $e("setTime").style.display;
	if(moveObj.area==2){
		var supplierId = $e("supplier").value;
		$.ajax({
    		url:"toSupplierDetail.do",
    		data:{"supplierId":supplierId},
    		dataType:"html",
    		success:function(html){
    			popDiv();
    			$e("msgDiv").innerHTML = html;
    			//选中确定按钮
    			var moveObj = objScroll.MoveObj;
    			moveObj.setArea(3);
    			moveObj.doMove(0);
    		}    		
    	});   
	}else if(moveObj.area==3){
		hideDiv();
		moveObj.setArea(2);
		moveObj.doMove(0);
	}else if(moveObj.area==4){
		history.back(-1);
	}else if(timeIsDisplay=="block"){
		var way = $e("way_detail_5").value;
		var goodsId = $e("goodsId").value;
		var number = eval($e('div_detail_1').innerHTML);
		var type = $e("type").value;
		var shippingFee = $e('shippingFee').value; 
    	var goodsPrice = $e('goodsPrice').value; 
		var pos = focusId+objScroll.page.curPageIndex*arrFocus[1].limit;
		$.ajax({
			url:"setReceiptTime.do",
			data:{"goodsId":goodsId,"number":number,"way":way,"time":dataList[pos].paramValue},
			dataType:"json",
			success:function(json){
				if(json.statusCode=="200"){
			      	$("#msg").html(json.message);
			      	$e("setTime").style.display = "none";
			      	
			    	$.ajax({
			    		url:"toOrderPage.do",
			    		data:{"goodsId":goodsId,"number":number,"type":type,"shippingFee":shippingFee,"goodsPrice":goodsPrice},
			    		dataType:"html",
			    		success:function(html){
			    			popDiv();
			    			$e("msgDiv").innerHTML = html;
			    			//选中确定按钮
			    			var moveObj = objScroll.MoveObj;
			    			moveObj.setArea(0);
							moveObj.doMove(4);
							moveObj.doRight(this);
			    		}    		
			    	});
			      	
			      }else if(json.statusCode=="300"){
			     	 $("#msg").html(json.message);
			      }
			}			
		});		
	}else {
	    if(focusId==0){
	    	if($e('div_detail_1').innerHTML){
	    		var number = eval($e('div_detail_1').innerHTML);
	    		if(number<=0) 
	    			$e('div_detail_1').innerHTML=1;
	    		else if(number>1)
	    			$e('div_detail_1').innerHTML=eval($e('div_detail_1').innerHTML)-1;
	    	}else
	    		$e('div_detail_1').innerHTML=1;
	    }
	    if(focusId==2)
	    	$e('div_detail_1').innerHTML=eval($e('div_detail_1').innerHTML)+1;
	    if(focusId==3){//去结算
	    	var goodsId = $e("goodsId").value;
	    	var number = eval($e('div_detail_1').innerHTML); 
	    	var type = $e('type').value; 
	    	var shippingFee = $e('shippingFee').value; 
	    	var goodsPrice = $e('goodsPrice').value; 
	    	var specifications = $e('specifications').value; 
	    	$.ajax({
	    		url:"toOrderPage.do",
	    		data:{"goodsId":goodsId,"number":number,"type":type,"shippingFee":shippingFee,"goodsPrice":goodsPrice,"specifications":specifications},
	    		dataType:"html",
	    		success:function(html){
	    			popDiv();
	    			$e("msgDiv").innerHTML = html;
	    			//选中确定按钮
	    			var moveObj = objScroll.MoveObj;
	    			moveObj.doRight(this);
	    		}    		
	    	});			
	    }
	    if(focusId==4){
	    	var flag = $e("flag").value;
	    	if(flag=="normal"){//生成订单
	    		var goodsId = $e("goodsId").value;
	    		var number = eval($e('div_detail_1').innerHTML);
	    		var type = $e("type").value;
	    		var shippingFee = $e('shippingFee').value; 
		    	var goodsPrice = $e('goodsPrice').value; 
		    	var specifications = $e('specifications').value; 
	    		$.ajax({
	    			url:"createOrder.do",
	    			data:{"goodsId":goodsId,"number":number,"type":type,"shippingFee":shippingFee,"goodsPrice":goodsPrice,"specifications":specifications},
	    			dataType:"json",
	    			success:function(json){
	    				if(json.statusCode=="200"){	    			      	
	    			      	$e('msgDiv').style.display = "none";
	    		    		$e("tips").style.display = "block"; 
	    					var moveObj = objScroll.MoveObj;
	    					moveObj.setArea(4);
	    					moveObj.doMove(0);   					
	    					
	    				}else if(json.statusCode=="300"){
	    					$("#orderMsg").html(json.message);
	    				}     			
	    			}	    			
	    		});
	    		
	    	}else if(flag=="dw"){//收货方式设置
	    		var way = $e("way_detail_4").value;
	    		var goodsId = $e("way_goodsId").value;
	    		var number = $e("way_number").value;
	    		$.ajax({
	    			url:"doSetDeliveryWay.do",
	    			data:{"way":way,"goodsId":goodsId,"number":number},
	    			dataType:"json",
	    			success:function(json){
	    				if(json.statusCode=="200"){
	    			      	$("#errorMsg").html(json.message);
	    			      	var moveObj = objScroll.MoveObj;
	    		    		moveObj.doLeft(this);
	    		    		funKeyPressOk();
	    			      }else if(json.statusCode=="300"){
	    			     	 $("#errorMsg").html(json.message);
	    			      }     				
	    			}    			
	    		});
	    	}  	
	    }
	    if(focusId==5){	//选中确定按钮
	    	var flag = $e("flag").value;
	    	if(flag=="normal"){//取消订单预览
	    		hideDiv();
	    		var moveObj = objScroll.MoveObj;
	    		moveObj.doLeft(this);
	    		moveObj.doLeft(this);
	    	}else if(flag=="dw"){//收货方式设置
	    		var way = $e("way_detail_5").value;
	    		var goodsId = $e("goodsId").value;
	    		var number = eval($e('div_detail_1').innerHTML);
	    		$e('msgDiv').style.display = "none";
	    		$e("setTime").style.display = "block";    		
	    		
				objScroll.MoveObj.arrFocus[1].len = objScroll.dataListLen;
				ScrollRender.setCont(objScroll, 0,Math.min(objScroll.MoveObj.arrFocus[1].limit, objScroll.dataListLen));
				ScrollRender.updatePage(objScroll);	
				
				var moveObj = objScroll.MoveObj;    		
				moveObj.setArea(1);
				moveObj.doMove(0);
	    	}  
	    }
	}
}
/**
 * 弹出遮罩层
 */
function popDiv(){
	$e('bgDiv').style.display = "block";
	$e('msgDiv').style.display = "block";
	
	var backdiv = $e('bgDiv');
	backdiv.style.width = document.body.scrollWidth;
	backdiv.style.height = document.height;
}
/**
 * 关闭遮罩层
 */
function hideDiv(){
	$e('bgDiv').style.display = "none";
	$e('msgDiv').style.display = "none";
}

function $e(id){
	return document.getElementById(id);
}

/* 焦点算法参数配置 */
var Options = {
	focusId : 0 ,
	startId : 0 ,
	limit : 8 ,
	step : 4, // 步长为2
	dataListLen : dataList.length,
	//  是否显示页码
	pageShow : true, // 当 pageShow为false时，bar、progress设置无效
	// 页码条
	bar : {
		el : $('#bar'),
		len : 500 // unit: px
	},
	DEBUG : false,
	// 进度块
	progress : {
		el : $('#inner_bar'),
	}
};

/* 渲染内容定义 */
var Renders = {
    /*  @$this: objsrcoll
        @startId： 从datalist中获取数据的开始位置
        @len： 从datalist中获取数据的长度
    */
	setCont : function($this, startId, len){
		/* add  your Content DOM code */
		// 1 get data from dataList
		// 2 create data DOM
		// 3 append data DOM
		// $this.log("Renders--------------- setCont Content DOM");
		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];
		
		for(var index = 0; index < $this.limit; index++){
			var adom = "#div_rt_" +index;
			$(adom).empty();
		}
		for(var dataIndex = startId, index = 0; dataIndex < startId + len; dataIndex++){
			var html = dataList[dataIndex].paramValue;				
			var adom = "#div_rt_" +index;			
		    $(adom).append(html);
		    index++;
		}		
	},

	scrollToDo : function($this){
		/* remove older custom render code */
		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];
		moveFocus.doBlur();
	},

	scrollDone : function($this){
		/* add custom render code */
		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];
		moveFocus.doFocus();
	},
	pageAction : function($this,startId, len){
		
		this.setCont($this,startId, len);
	},
    updatePage : function($this){
    	$('#pageIndex').html($this.page.curPageIndex + 1);
        $('#pageNum').html($this.page.NUM);
    }
};

var objScroll = new ScrollList();
//  带配置参数的初始化 @焦点 @渲染
objScroll.init(Options, Renders, arrFocus);

function funInit(){
	funShowDate();
	objScroll.MoveObj.init();
    document.onkeydown = keyEvent ;
    scrollController();//轮播图片
}
window.onload = funInit ;