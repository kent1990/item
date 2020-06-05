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
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[0] ;
			$e('container_mid_2').className = "container_mid_2_0";
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[0] ;
			$e('container_mid_2').className = "container_mid_2_1";
		},
		limit:1,
		len:1,
		cols:1
};

arrFocus[1] = {
	focusId:0,
	startId:0,
	doFocus: function(){
		var obj = objScroll.MoveObj.arrFocus[1] ;
		//$e('div_0_' + obj.focusId).className = "focus_list";
		$e('div_0_' + obj.focusId).style.background = "url('images/common/list_select.png') bottom no-repeat";
	},
	doBlur: function(){
		var obj = objScroll.MoveObj.arrFocus[1] ;
		//$e('div_0_' + obj.focusId).className = "";
		$e('div_0_' + obj.focusId).style.background = "url('images/common/list_line.png') bottom no-repeat";
	},
	limit:8,
	len:8,
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
			window.location.href = "home.do?tvnNo="+$e("tvnNo").value; 
			return false ;
			break ;
	}
}

function funKeyPressUp(){
	var moveObj = objScroll.MoveObj;
	if(moveObj.area==1){
		var moveObj = objScroll.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];
		var startId = moveFocus.startId;
		var focusId = moveFocus.focusId;
		if(focusId==0 && objScroll.page.curPageIndex==0){
			moveObj.setArea(0);
			moveObj.doMove(0);
		}
		objScroll.scrollUp();
	}
}

function funKeyPressDown(){	
	var moveObj = objScroll.MoveObj;
	if(moveObj.area==0){
		moveObj.setArea(1);
		moveObj.doMove(0);	
	}else{
		objScroll.scrollDown();
	}
}

function funKeyPressLeft(){
	var moveObj = objScroll.MoveObj;
	if(moveObj.area==0){
		window.location.href = "toUserCenter.do"; 
	}
}

function funKeyPressRight(){
	var moveObj = objScroll.MoveObj;
	if(moveObj.area==0){
		//window.location.href = "toAccountCenter.do"; 
	}
}

function funKeyPressOk(){
	var moveObj = objScroll.MoveObj;
	if(moveObj.area==1){
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
}

function $e(id){
	return document.getElementById(id);
}

/* 焦点算法参数配置 */
var Options = {
		focusId : 0 ,
		startId : 0 ,
		limit : 8 ,
		step : 1, // 步长为2
		//dataListLen : dataList.length,
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
	setCont : function($this,startId, len){
		/* add  your Content DOM code */
		// 1 get data from dataList
		// 2 create data DOM
		// 3 append data DOM
		// $this.log("Renders--------------- setCont Content DOM");
		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];

		// 清除原有"div_0_index"标签数据
		for(var index = 0; index < $this.limit; index++){
			var adom = "#div_0_" +index;
			$(adom).empty();
		}
		//$this.log("Renders--------------- setCont Content DOM:			len: " + len + "starId: " + startId);
		for(var dataIndex = startId,index = 0; dataIndex < startId + len; dataIndex++){
			if(dataIndex==0){
				var desc_html = 
				    '<div class="desc"><div class="orderSn">'
				    	+ dataList[dataIndex].deployInfo + 
				    '<input type="hidden" name="deployId" id="deployId'+index+'" value="'+dataList[dataIndex].deployId+'"/>'+
				    '<input type="hidden" name="deployInfo" id="deployInfo'+index+'" value="'+dataList[dataIndex].deployInfo+'"/>'
				    +'</div></div>'; 
				var adom = "#div_0_" +index;			
				$(adom).append(desc_html);
				$(adom).css("background","url('images/common/list_line.png') bottom no-repeat");
			}else{
				var desc_html = 
					'<div class="desc"><div class="orderSn">时间段：'
					+ dataList[dataIndex].deployInfo +
					'<input type="hidden" name="deployId" id="deployId'+index+'" value="'+dataList[dataIndex].deployId+'"/>'+
				    '<input type="hidden" name="deployInfo" id="deployInfo'+index+'" value="'+dataList[dataIndex].deployInfo+'"/>'+
					'</div></div>';     
				var adom = "#div_0_" +index;			
				$(adom).append(desc_html);
				$(adom).css("background","url('images/common/list_line.png') bottom no-repeat");
			}
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
	objScroll.MoveObj.arrFocus[1].len = objScroll.dataListLen;
	ScrollRender.setCont(objScroll, 0,Math.min(objScroll.MoveObj.arrFocus[1].limit, objScroll.dataListLen));
    ScrollRender.updatePage(objScroll);
    document.onkeydown = keyEvent ;
}
window.onload = funInit ;






