//焦点定义
var moveObj = null;
var arrFocus = [];
arrFocus[0] = {
	focusId : 0,
	startId : 0,
	doFocus : function () {
		var obj = moveObj.arrFocus[0];
		
	},
	doBlur : function () {
		var obj = moveObj.arrFocus[0];
		
	},
	limit : 1,
	len : 1,
	cols : 1
	
};

function keyEvent(e) {
	var keycode = (window.event) ? event.keyCode : e.which;
	switch (keycode) {
	case key.Up:
	case 38:
		//funKeyPressLeft();
		return false;
		break;
	case key.Down:
	case 40:
		//funKeyPressRight();
		return false;
		break;
	case key.Left:
	case 37:
		funKeyPressLeft();
		return false;
		break;
	case key.Right:
	case 39:
		funKeyPressRight();
		return false;
		break;
	case key.Ok:
	case 13:
		funKeyPressOk();
		return false;
		break;
	case key.Back:
	case 8:
		history.back();
		return false;
		break;
	}
}

function funKeyPressLeft(){
		curImgid-=1;
		if(curImgid<=0) {
			curImgid=imgLength;
		}
		$("#pageIndex").text(curImgid) ;
		$("#display").attr("src","view.do?path="+dataList.images[curImgid-1]+"&type=single");
}

function funKeyPressRight(){
		curImgid+=1;
		if(curImgid>imgLength) {
			curImgid=1;
		}
		$("#pageIndex").text(curImgid);
		$("#display").attr("src","view.do?path="+dataList.images[curImgid-1]+"&type=single");
}
var imgLength=null;//1;//标示返回图片个数
var curImgid=1;//标示当前图片的顺序

function $e(id){
	return document.getElementById(id) ;
}
//获取信息
function setData(){
	imgLength = dataList.total;
	$("#pageIndex").text(curImgid);
	$("#pageNum").text(imgLength);	
	//返回json格式的数据，填充至页面	
	$("#display").attr("src","view.do?path="+dataList.images[curImgid-1]+"&type=single");
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