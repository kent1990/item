
function funShowDate() {
	var date = new Date();
	var dateStr = date.format("YYYY-MM-DD hh:mm").split(' ');
	var week = date.week();
	$e('minutes').innerHTML = dateStr[1];

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
		$e('div_0_' + obj.focusId).className = "focus_list";
		

	},
	doBlur: function(){
		var obj = objScroll.MoveObj.arrFocus[0] ;
		$e('div_0_' + obj.focusId).className = "";

	},
	limit:8,
	len:8,
	cols:4
	

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
			//history.back();
			window.location.href ="tv!login.do?tvn_no="+tvnNo;
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

	var c = $(".focus_list").attr("number");
	var d = start + c;
    window.location.href ="tv!view.do?ym="+ym+"&tvn_no="+tvnNo+"&pageNum="+d;
    
	
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
	dataListLen : shown,
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
	setCont : function($this){

		/* add  your Content DOM code */

		// 1 get data from dataList
		 
		// 2 create data DOM
		
		// 3 append data DOM

		// $this.log("Renders--------------- setCont Content DOM");


		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];

		// 清除原有"div_0_index"标签数据
		/*for(var index = 0; index < $this.limit; index++){
			var adom = "#div_0_" +index;
			$(adom).empty();
		}
*/
		
		// var dataLimit = Math.min(startId + focusId + $this.limit, $this.dataListLen);
		
		/*$this.log("Renders--------------- setCont Content DOM:			len: " + len + "starId: " + startId);

		for(var dataIndex = startId, index = 0; dataIndex < startId + len; dataIndex++){
		    var pic_html = '<div class="pic" style="background:url(' + dataList[dataIndex].pic_src + ') no-repeat;background-position:30% 10%;background-size:500px auto;"></div>';
//		    var desc_html = '<div class="desc"><div class="price">' + dataList[dataIndex].price + '</div><div class="name">' + dataList[dataIndex].name + '</div></div>';          
		    var adom = "#div_0_" +index;
		    
		    $(adom).append(pic_html);
		    index++;
		}
*/
		
	},

	scrollToDo : function($this){
		/* remove older custom render code */
		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];
		moveFocus.doBlur();
	},

	scrollDone : function($this){

		$this.log("scrollDone------" + "startId: " + $this.MoveObj.arrFocus[0].startId + " focusId: " + $this.MoveObj.arrFocus[0].focusId);

		/* add custom render code */
		var moveObj = $this.MoveObj;
		var moveFocus = moveObj.arrFocus[moveObj.area];
		moveFocus.doFocus();
		
	},

	// 翻页触发动作
	pageAction : function($this, startId, len){
		$this.log("pageTrigger pageAction------" + "startId: " + startId + " len: " + len);
		this.setCont($this);
	},

    /*updatePage : function($this){
        $('#pageIndex').html($this.page.curPageIndex + 1);
        $('#pageNum').html($this.page.NUM);
    }*/

};


var objScroll = new ScrollList();
//  带配置参数的初始化 @焦点 @渲染
objScroll.init(Options, Renders, arrFocus);



function funInit(){

	funShowDate();

	objScroll.MoveObj.init();
    // mount data
    objScroll.MoveObj.arrFocus[0].len = objScroll.dataListLen;

	ScrollRender.setCont(objScroll, 0, 
        Math.min(objScroll.MoveObj.arrFocus[0].limit, objScroll.dataListLen));
	
    ScrollRender.updatePage(objScroll);
	
    document.onkeydown = keyEvent ;
}
window.onload = funInit ;