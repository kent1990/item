/**
 * 日期获取
 */
function funShowDate() {
	var date = new Date();
	var dateStr = date.format("YYYY-MM-DD hh:mm").split(' ');
	var week = date.week();
	$e('minutes').innerHTML = dateStr[1];
	$e('week').innerHTML = week;
	$e('date').innerHTML = dateStr[0];

	setTimeout(funShowDate, 30);
}

function $c(_class){
	return document.getElementsByClassName(_class);
}

var myInterval = null;
//焦点定义
var moveObj = null;
var arrFocus = [] ;
arrFocus[0] = {
	focusId:0,
	startId:0,
	doFocus: function(){
		var obj = objScroll.MoveObj.arrFocus[0] ;
		$e('div_list0_' + obj.focusId).style.padding=27;
		$e('div_list0_' + obj.focusId).style.top="106px";
		$e('div_list0_' + obj.focusId).style.left="41px";
		$e('div_list0_' + obj.focusId).className='div_selected';
		clearInterval(myInterval);
		var i = 1;
		myInterval=setInterval(function(){
				$e('div_list0_' + obj.focusId).className='div_selected bg1_'+i;
				i++;
				if(i>2) i=1;
		}, 500);
	},
	doBlur: function(){
		var obj = objScroll.MoveObj.arrFocus[0] ;
		$e('div_list0_' + obj.focusId).className = "";
		$e('div_list0_' + obj.focusId).style.padding=0;
		$e('div_list0_' + obj.focusId).style.top="133px";
		$e('div_list0_' + obj.focusId).style.left="68px";
		clearInterval(myInterval);
	},
	limit:1,
	len:1,
	cols:1,
	next:{//跨区域所执行的操作
		right:[1],
		down:[2]
	}
};
arrFocus[1] = {
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[1] ;
			//$e('div_list1_' + obj.focusId).className = "focus_list";
			$e('div_list1_' + obj.focusId).style.padding=27;
			if(obj.focusId==0){
				$e('div_list1_' + obj.focusId).style.top="106px";
				$e('div_list1_' + obj.focusId).style.left="448px";
			}
			if(obj.focusId==1){
				$e('div_list1_' + obj.focusId).style.top="106px";
				$e('div_list1_' + obj.focusId).style.left="693px";
			}
			if(obj.focusId==2){
				$e('div_list1_' + obj.focusId).style.top="106px";
				$e('div_list1_' + obj.focusId).style.left="938px";
			}
			if(obj.focusId==3){
				$e('div_list1_' + obj.focusId).style.top="355px";
				$e('div_list1_' + obj.focusId).style.left="448px";
			}
			if(obj.focusId==4){
				$e('div_list1_' + obj.focusId).style.top="355px";
				$e('div_list1_' + obj.focusId).style.left="693px";
			}
			if(obj.focusId==5){
				$e('div_list1_' + obj.focusId).style.top="355px";
				$e('div_list1_' + obj.focusId).style.left="938px";
			}
			$e('div_list1_' + obj.focusId).className='div_selected';
			
			
			clearInterval(myInterval);
			var i = 1;
			myInterval=setInterval(function(){
					$e('div_list1_' + obj.focusId).className='div_selected bg2_'+i;
					i++;
					if(i>2) i=1;
			}, 500);
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[1] ;
			$e('div_list1_' + obj.focusId).className = "";
			$e('div_list1_' + obj.focusId).style.padding=0;
			if(obj.focusId==0){
				$e('div_list1_' + obj.focusId).style.top="133px";
				$e('div_list1_' + obj.focusId).style.left="475px";
			}
			if(obj.focusId==1){
				$e('div_list1_' + obj.focusId).style.top="133px";
				$e('div_list1_' + obj.focusId).style.left="720px";
			}
			if(obj.focusId==2){
				$e('div_list1_' + obj.focusId).style.top="133px";
				$e('div_list1_' + obj.focusId).style.left="965px";
			}
			if(obj.focusId==3){
				$e('div_list1_' + obj.focusId).style.top="382px";
				$e('div_list1_' + obj.focusId).style.left="475px";
			}
			if(obj.focusId==4){
				$e('div_list1_' + obj.focusId).style.top="382px";
				$e('div_list1_' + obj.focusId).style.left="720px";
			}
			if(obj.focusId==5){
				$e('div_list1_' + obj.focusId).style.top="382px";
				$e('div_list1_' + obj.focusId).style.left="965px";
			}			
			
			clearInterval(myInterval);
		},
		limit:6,
		len:6,
		cols:3,
		next:{//跨区域所执行的操作
			left:[0],
			down:[2]
		}
};
arrFocus[2] = {
		focusId:0,
		startId:0,
		doFocus: function(){
			var obj = objScroll.MoveObj.arrFocus[2] ;
			clearInterval(myInterval);
			var i = 1;
			myInterval=setInterval(function(){
					$e('div_list2_' + obj.focusId).className='bg3_'+i;
					i++;
					if(i>2) i=1;
			}, 500);
		},
		doBlur: function(){
			var obj = objScroll.MoveObj.arrFocus[2] ;
			$e('div_list2_' + obj.focusId).className = "";
			clearInterval(myInterval);
		},
		limit:1,
		len:1,
		cols:1,
		next:{//跨区域所执行的操作
			up:[1]			
		}
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
			window.location.href = dataList[0][0].url;
			return false ;
			break ;
		case key.numb2:
		case 50:
			window.location.href = dataList[1][0].url;
			return false ;
			break ;
		case key.numb3:
		case 51:
			window.location.href = dataList[1][1].url;
			return false ;
			break ;
		case key.numb4:
		case 52:
			window.location.href = dataList[1][2].url;
			return false ;
			break ;
		case key.numb5:
		case 53:
			window.location.href = dataList[1][3].url;
			return false ;
			break ;
		case key.numb6:
		case 54:
			window.location.href = dataList[1][4].url;
			return false ;
			break ;	
		case key.numb7:
		case 55:
			window.location.href = dataList[1][5].url;
			return false ;
			break ;
		case key.numb8:
		case 56:
			window.location.href = dataList[2][0].url;
			return false ;
			break ;
	}
}

function funKeyPressUp(){	
	objScroll.scrollUp();
}

function funKeyPressDown(){	
	objScroll.scrollDown();
}

function funKeyPressLeft(){
	objScroll.scrollLeft();
}

function funKeyPressRight(){
	objScroll.scrollRight();
}

function funKeyPressOk(){
	var moveObj = objScroll.MoveObj;
	var moveFocus = moveObj.arrFocus[moveObj.area];
	var startId = moveFocus.startId;
	var focusId = moveFocus.focusId;
	var area = moveObj.area;
    window.location.href = dataList[area][startId + focusId].url || "#";
}
function $e(id){
	return document.getElementById(id);
}
/* 焦点算法参数配置 */
var Options = {
	focusId : 0 ,
	startId : 0 ,
	limit : 9 ,
	step : 3, // 步长为2
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
			
		// 清除原有"div_0_index"标签数据
		for(var index = 0; index <arrFocus[0].limit; index++){
			var adom = "#div_list0_" +index;
			$(adom).empty();
		}

		for(var dataIndex = startId, index = 0; dataIndex <arrFocus[0].len; dataIndex++){
		    var flag = dataList[0][dataIndex].flag;
		    var pic_html="";
		    if(flag==0){
		    	pic_html = '<div><img src="viewRelative.do?path=' + dataList[0][dataIndex].pic_src + '" "/></div>';
		    }else{
		    	pic_html = '<div><img src="view.do?path=' + dataList[0][dataIndex].pic_src + '" "/></div>';
		    }
		    pic_html+='<div id="id_div_num_0" class="div_num_0"></div>';
		    var adom = "#div_list0_" +index;
			$(adom).append(pic_html);
		    index++;
		}	
	
		// 清除原有"div_0_index"标签数据
		for(var index = 0; index < arrFocus[1].limit; index++){
			var adom = "#div_list1_" +index;
			$(adom).empty();
		}

		for(var dataIndex = startId, index = 0; dataIndex < startId + arrFocus[1].len; dataIndex++){
			var flag = dataList[1][dataIndex].flag;
		    var pic_html="";
		    if(flag==0){
		    	pic_html = '<div><img src="viewRelative.do?path=' + dataList[1][dataIndex].pic_src + '" "/></div>';
		    }else{
		    	pic_html = '<div><img src="view.do?path=' + dataList[1][dataIndex].pic_src + '" "/></div>';
		    }
		    pic_html+='<div id="div_num1_'+index+'" class="div_num1_'+index+'"></div>';
		    var adom = "#div_list1_" +index;
			$(adom).append(pic_html);
		    index++;
		}
	
		// 清除原有"div_0_index"标签数据
		for(var index = 0; index < arrFocus[2].limit; index++){
			var adom = "#div_list2_" +index;
			$(adom).empty();
		}

		for(var dataIndex = startId, index = 0; dataIndex < startId + arrFocus[2].len; dataIndex++){
			var flag = dataList[2][dataIndex].flag;
		    var pic_html="";
		    if(flag==0){
		    	pic_html = '<div><img src="viewRelative.do?path=' + dataList[2][dataIndex].pic_src + '" "/></div>';
		    }else{
		    	pic_html = '<div><img src="view.do?path=' + dataList[2][dataIndex].pic_src + '" "/></div>';
		    }
		    pic_html+='<div class="div_num_8"></div>';
		    var adom = "#div_list2_" +index;
			$(adom).append(pic_html);
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
		
	}	
};

//滚动信息
var marqueeInterval=new Array();  //定义一些常用而且要经常用到的变量
var marqueeId=1;
var marqueeDelay=marqueeContent[0];
var marqueeHeight=29;
//接下来的是定义一些要使用到的函数
function initMarquee() {
    var str=marqueeContent[1];
    var line=document.createElement('DIV');
    line.innerHTML=str;
    indexMsg.appendChild(line);
    marqueeId++;
    marqueeInterval[0]=setInterval("startMarquee()",marqueeDelay);
    }
function startMarquee() {
    var str=marqueeContent[marqueeId];
        marqueeId++;
    if(marqueeId>=marqueeContent.length) marqueeId=1;
    if(indexMsg.childNodes.length==1) {    	
    	 var nextLine=document.createElement('DIV');
         nextLine.innerHTML=str;
         indexMsg.appendChild(nextLine);
        }
    else {
    	indexMsg.childNodes[0].innerHTML=str;
    	indexMsg.appendChild(indexMsg.childNodes[0]);
    	indexMsg.scrollTop=0;
        }
    clearInterval(marqueeInterval[1]);
    marqueeInterval[1]=setInterval("scrollMarquee()",5000);
    }
function scrollMarquee() {
	indexMsg.scrollTop++;
    if(indexMsg.scrollTop%marqueeHeight==(marqueeHeight-1)){
        clearInterval(marqueeInterval[1]);
    }
}

var objScroll = new ScrollList();
//  带配置参数的初始化 @焦点 @渲染
objScroll.init(null, Renders, arrFocus);

function funInit(){
	funShowDate();

	objScroll.MoveObj.init();
    // mount data
    objScroll.MoveObj.arrFocus[0].len = objScroll.dataListLen;

	ScrollRender.setCont(objScroll, 0, 
        Math.min(objScroll.MoveObj.arrFocus[0].limit, objScroll.dataListLen));
	
    ScrollRender.updatePage(objScroll);
	
    document.onkeydown = keyEvent ;
    initMarquee();
}
window.onload = funInit ;