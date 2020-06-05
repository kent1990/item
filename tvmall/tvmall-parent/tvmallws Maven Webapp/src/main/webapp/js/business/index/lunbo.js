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
	doFocus : function () {
		var obj = moveObj.arrFocus[0];
		
	},
	doBlur : function () {
		var obj = moveObj.arrFocus[0];
		
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
			//funKeyPressUp();
			return false ;
			break;
		case key.Down:
		case 40:
			//funKeyPressDown();
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


	function funKeyPressLeft(){
		if(curImgid!=1){
			curImgid-=1;
		}	
		showOrHiddenArrow();
		
	}

	function funKeyPressRight(){
		if(curImgid!=imgLength){
			curImgid+=1;
		}	
		showOrHiddenArrow();
		
	}
	var imgLength=null;//1;//标示返回图片个数
	var curImgid=1;//标示当前图片的顺序
	//左右箭头是否显示
	 function showOrHiddenArrow(){		
	 

	 
	(curImgid > 1) ? $('pre').style.visibility = "visible" : $('pre').style.visibility = "hidden" ;
		(curImgid < imgLength) ? $('next').style.visibility = "visible" : $('next').style.visibility = "hidden" ;	 
	}


function $e(id){
	return document.getElementById(id);
}


//获取信息
function setData(){
	//返回json格式的数据，填充至页面
	imgLength = data.total;
	funShowDate();
	showOrHiddenArrow();
	$(oUlplay_img).attr("src","view.do?path="+data[curImgid-1])
	
}
function funInit(){	
	setData();
	moveObj = new SHBMove();
	moveObj.setFocusArray(arrFocus);
	//将默认聚焦到0区域0id改为其他区域的第几个id
	moveObj.setArea(0);
	moveObj.arrFocus[0].focusId = 0;	
	moveObj.init();
	document.onkeydown = keyEvent;
}
window.onload = funInit;
}