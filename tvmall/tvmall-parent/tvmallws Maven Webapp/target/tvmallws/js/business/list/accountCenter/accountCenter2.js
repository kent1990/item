function funShowDate() {
	var date = new Date();
	var dateStr = date.format("YYYY-MM-DD hh:mm").split(' ');
	var week = date.week();
	$e('minutes').innerHTML = dateStr[1];
	$e('week').innerHTML = week;
	$e('date').innerHTML = dateStr[0];

	setTimeout(funShowDate, 30);
}
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
	}
}
//焦点定义
var moveObj = null;
var arrFocus = [] ;
arrFocus[0] = {
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[0] ;
			$e('container_mid_'+obj.focusId).className = "container_mid_"+obj.focusId+"_0";
			if(obj.focusId==0){
				$e('container').style.display = "block";
				$e('container1').style.display = "none";
				$e('container2').style.display = "none";
				this.next.down = [1];
				objScroll.dataListLen = dataList[0].length;
				arrFocus[1].len = dataList[0].length;
				objScroll.limit = 7;
				objScroll.MoveObj.arrFocus[1].limit = 7;
				
				//objScroll = new ScrollList();
				//objScroll.init(Options2, Renders, arrFocus);
				
				//objScroll.MoveObj.arrFocus[1].len = objScroll.dataListLen;
				ScrollRender.setCont(objScroll, 0,Math.min(objScroll.MoveObj.arrFocus[1].limit,  objScroll.dataListLen));
				ScrollRender.updatePage(objScroll);				
			}
			else if(obj.focusId==1){
				$e('flag').value = "1";
				$e('container').style.display = "none";
				$e('container1').style.display = "block";
				$e('container2').style.display = "none";				
				this.next.down = [2];
				objScroll.dataListLen = dataList[1].length;
				arrFocus[2].len = dataList[1].length;
				objScroll.limit = 6;
				objScroll.MoveObj.arrFocus[2].limit = 6;
				
				//objScroll = new new ScrollList();
				//objScroll.init(Options3, Renders, arrFocus);				
				//objScroll.MoveObj.arrFocus[2].len = objScroll.dataListLen;
				//ScrollRender.setCont(objScroll, 0,Math.min(objScroll.MoveObj.arrFocus[2].limit,objScroll.dataListLen));
				//ScrollRender.updatePage(objScroll);
			}
			else if(obj.focusId==2){
				$e('flag').value = "2";	
				$e('container').style.display = "none";
				$e('container1').style.display = "none";
				$e('container2').style.display = "block";	
				this.next.down = [3];
				objScroll.dataListLen = dataList[2].length;
				arrFocus[3].len = dataList[2].length;
				objScroll.limit = 8;
				objScroll.MoveObj.arrFocus[3].limit = 8;
				
				//objScroll = new ScrollList();
				//objScroll.init(Options4, Renders, arrFocus);				
				//objScroll.MoveObj.arrFocus[3].len =objScroll.dataListLen;
				//ScrollRender.setCont(objScroll, 0,Math.min(objScroll.MoveObj.arrFocus[3].limit,objScroll.dataListLen));
				//ScrollRender.updatePage(objScroll);
			}		
			
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[0] ;
			var moveObj = objScroll.MoveObj;
			if(moveObj.area==0){
				$e('container_mid_'+obj.focusId).className = "container_mid_"+obj.focusId;
			}else{
				$e('container_mid_'+obj.focusId).className = "container_mid_"+obj.focusId+"_1";
			}
		},
		limit:3,
		len:3,
		cols:3,
		next:{
			down:[1]
		}
	};

	arrFocus[1] = {
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[1] ;
			$e('div_0_' + obj.focusId).className = "focus_list";
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[1] ;
			$e('div_0_' + obj.focusId).className = "";
		},
		limit:7,
		len:7,
		cols:1,
		next:{
			up:[0]
		}
	};
	arrFocus[2] = {
			focusId:0,
			startId:0,
			doFocus: function(){
				var obj = objScroll.MoveObj.arrFocus[2] ;
				$e('div_1_' + obj.focusId).className = "focus_list";
			},
			doBlur: function(){
				var obj = objScroll.MoveObj.arrFocus[2] ;
				$e('div_1_' + obj.focusId).className = "";
			},
			limit:6,
			len:6,
			cols:1,
			next:{
				up:[0]
			}
	};
	arrFocus[3] = {
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[3] ;
			$e('div_2_' + obj.focusId).className = "focus_list";
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[3] ;
			$e('div_2_' + obj.focusId).className = "";
		},
		limit:8,
		len:8,
		cols:1,
		next:{
			up:[0]
		}
	};
	arrFocus[4] = {
			focusId:0,
			startId:0,
			doFocus: function(){
				var obj = objScroll.MoveObj.arrFocus[4] ;
				$e('div_4_' + obj.focusId).className = "focus_list";
			},
			doBlur: function(){
				var obj = objScroll.MoveObj.arrFocus[4] ;
				$e('div_4_' + obj.focusId).className = "";
			},
			limit:2,
			len:2,
			cols:2,
	};

	/* 焦点算法参数配置 */
	var Options = {
			focusId : 0 ,
			startId : 0 ,
			limit : 3 ,
			step : 1, // 步长为2
			dataListLen : 3,
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
	var Options2 = {
			focusId : 0 ,
			startId : 0 ,
			limit : 7 ,
			step : 1, // 步长为2
			dataListLen : dataList[0].length,
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

	var Options3 = {
			focusId : 0 ,
			startId : 0 ,
			limit : 6 ,
			step : 1, // 步长为2
			dataListLen : dataList[1].length,
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
	var Options4 = {
			focusId : 0 ,
			startId : 0 ,
			limit : 8 ,
			step : 1, // 步长为2
			dataListLen : dataList[2].length,
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
function funKeyPressUp(){
	var moveObj = objScroll.MoveObj;
	objScroll.scrollUp();
}

function funKeyPressDown(){	
	var moveObj = objScroll.MoveObj;
	var moveFocus = moveObj.arrFocus[moveObj.area];
	var startId = moveFocus.startId;
	var focusId = moveFocus.focusId;

	objScroll.scrollDown();
}

function funKeyPressLeft(){
	var moveObj = objScroll.MoveObj;
	
	objScroll.scrollLeft();		
}

function funKeyPressRight(){
	var moveObj = objScroll.MoveObj;
	objScroll.scrollRight();
}

function funKeyPressOk(){
	var moveObj = objScroll.MoveObj;
	if(moveObj.area==1){
		var moveFocus = moveObj.arrFocus[moveObj.area];
		var startId = moveFocus.startId;
		var focusId = moveFocus.focusId;
		var orderId = dataList[0][startId + focusId].orderId;
		$e("startId").value=startId;
		$e("focusId").value=focusId;
		$.ajax({
    		url:"toOrderDetail.do",
    		data:{"orderId":orderId},
    		dataType:"html",
    		success:function(html){
    			popDiv();
    			$e("msgDiv").innerHTML = html;
    			//选中确定按钮
    			var moveObj = objScroll.MoveObj;
    			moveObj.setArea(4);
    			moveObj.doMove(0);
    		}    		
    	});
	}
	if(moveObj.area==3){
		var moveFocus = moveObj.arrFocus[moveObj.area];
		var startId = moveFocus.startId;
		var focusId = moveFocus.focusId;
		var deployId = $e('deployId'+focusId).value;
		var deployInfo = $e('deployInfo'+focusId).value;
		$.ajax({
			url:"setDeliveryTime.do",
			type:"post",
			data:{"deployId":deployId,"deployInfo":deployInfo},
			dataType:"json",
			success:function(json){
				$("#message").html(json.message);
		      	setInterval(
		      		function(){
		      			$("#message").html("");
			      	},
		      	3000);
		      	clearInterval(); 
			}
		});   
	}
	if(moveObj.area==4){
		var moveFocus = moveObj.arrFocus[moveObj.area];
		var startId = moveFocus.startId;
		var focusId = moveFocus.focusId;
		var orderId = dataList[0][startId + focusId].orderId;
		var goodsId = $e("goodsId").value;
		var orderNumber = $e("num").value;
		if(focusId==0){
			window.location.href = "toGoodsDetail.do?goodsId="+goodsId+"&r="+Math.random()
			+"&orderNumber="+orderNumber;   
		}else{
			hideDiv();
			var startId = $e("startId").value;
			var focusId = $e("focusId").value;
			moveObj.toArea([1,parseInt(focusId)]);
		}
	}
}

function $e(id){
	return document.getElementById(id);
}


/* 渲染内容定义 */
var Renders = {
    /*  @$this: objsrcoll
        @startId： 从datalist中获取数据的开始位置
        @len： 从datalist中获取数据的长度
    */
	setCont : function($this,startId, len){
		/* add  your Content DOM code */
		// 1 get data from dataList
		// 2 create data DOM
		// 3 append data DOM
		// $this.log("Renders--------------- setCont Content DOM");
		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];
		var startId = moveFocus.startId;
		var focusId = moveFocus.focusId;
		
		// 清除原有"div_0_index"标签数据
		
		//$this.log("Renders--------------- setCont Content DOM:			len: " + len + "starId: " + startId);
		var flag = $e('flag').value;
		 //if(focusId==0){	
		 	for(var index = 0; index < $this.limit; index++){
				var adom = "#div_0_" +index;
				$(adom).empty();
			}
			for(var dataIndex = startId, index = 0; dataIndex < startId + len; dataIndex++){
				var desc_html = 
					'<div class="desc"><div class="orderSn">'
					+ dataList[0][dataIndex].orderSn + 
					'</div><div class="orderTime">'+
					dataList[0][dataIndex].orderTime+
					'</div><div class="orderState">'
					+ dataList[0][dataIndex].orderState+
					'</div><div class="orderAmount">' 
					+ dataList[0][dataIndex].orderAmount+ 
					'</div></div>';          
				
				var adom = "#div_0_" +index;			
				$(adom).append(desc_html);
				index++;
			}		
		//}
		// if(focusId==1){
			for(var index = 0; index < $this.limit; index++){
				var adom = "#div_1_" +index;
				$(adom).empty();
			}
			for(var dataIndex = startId, index = 0; dataIndex < startId + len; dataIndex++){
			    var desc_html = 
			    '<div class="desc"><div class="orderSn">'
			    	+ dataList[1][dataIndex].sign + 
			    '</div><div class="orderTime">'+
			    	dataList[1][dataIndex].inteNum+
			    '</div><div class="orderState">'
			    	+ dataList[1][dataIndex].inteTime+
			    '</div></div>';          
			
				var adom = "#div_1_" +index;			
			    $(adom).append(desc_html);
			    index++;
			}		
		//}
		// if(focusId==2){
			for(var index = 0; index < $this.limit; index++){
				var adom = "#div_2_" +index;
				$(adom).empty();
			}
			for(var dataIndex = startId,index = 0; dataIndex < startId + len; dataIndex++){
				if(dataIndex==0){
					var desc_html = 
					    '<div class="desc"><div class="orderSn">'
					    	+ dataList[2][dataIndex].deployInfo + 
					    '<input type="hidden" name="deployId" id="deployId'+index+'" value="'+dataList[2][dataIndex].deployId+'"/>'+
					    '<input type="hidden" name="deployInfo" id="deployInfo'+index+'" value="'+dataList[2][dataIndex].deployInfo+'"/>'
					    +'</div></div>'; 
					var adom = "#div_2_" +index;			
					$(adom).append(desc_html);
				}else{
					var desc_html = 
						'<div class="desc"><div class="orderSn">时间段：'
						+ dataList[2][dataIndex].deployInfo +
						'<input type="hidden" name="deployId" id="deployId'+index+'" value="'+dataList[2][dataIndex].deployId+'"/>'+
					    '<input type="hidden" name="deployInfo" id="deployInfo'+index+'" value="'+dataList[2][dataIndex].deployInfo+'"/>'+
						'</div></div>';     
					var adom = "#div_2_" +index;			
					$(adom).append(desc_html);
				}
			    index++;
			}
		 //}
		
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
	// 翻页触发动作
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
	//显示时间
	funShowDate();
	//初始化ObjScroll
	objScroll.MoveObj.init();
    // mount data
	//objScroll.MoveObj.arrFocus[0].len = objScroll.dataListLen;
	//objScroll.MoveObj.arrFocus[1].len = dataList[0].length;
	//ScrollRender.setCont(objScroll, 0,Math.min(objScroll.limit, objScroll.dataListLen));
    //ScrollRender.updatePage(objScroll);
    document.onkeydown = keyEvent ;
}

window.onload = funInit ;


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
