(function(){
	var Move = function(){

	}

	Move.prototype = {
		arrFocus: null,
		area: 0,
		lastArea: 0,
		oldArea: -1,
		focusImg: null,
		focusDiv: null,
		init: function(){
			this.doMove(0);
		},
		setFocusDiv: function(focusDiv){
			this.focusDiv = focusDiv ;
		},
		setFocusImg: function(focusImg){
			this.focusImg = focusImg ;
		},
		setFocusArray: function(focusArray){
			this.arrFocus = focusArray ;
		},
		setArea: function(area){
			this.lastArea = this.area ;
			this.area = area ;
		},
		toArea: function(obj){
			this.setArea(obj[0]) ;
			if(obj[1] !== undefined)
				this.arrFocus[this.area].focusId = obj[1] ;
			this.doMove(0);
		},
		doMove: function(num){
			var buf = this.arrFocus[this.area].focusId + num ;
			if(buf >= 0 && buf < this.arrFocus[this.area].limit){
				var obj = this.arrFocus[this.area] ;
				var oldObj = this.arrFocus[this.oldArea] ;
				(this.oldArea != -1 && oldObj.doBlur) && oldObj.doBlur() ;
				if(this.area !== this.oldArea){
					this.oldArea = this.area ;
					if(this.focusImg){
						this.focusImg.src = obj.img ;
						this.focusImg.width = obj.width ;
						this.focusImg.height = obj.height ;
					}
				}
				this.arrFocus[this.area].focusId += num ;
				(obj.doFocus) && obj.doFocus();
				if(this.focusDiv){
					this.focusDiv.style.left = obj.left + (obj.focusId % obj.cols) * obj.changeLeft + 'px';
					this.focusDiv.style.top = obj.top + Math.floor(obj.focusId / obj.cols) * obj.changeTop + 'px';
				}
			}
		},
		on: function(dir){
			var obj = this.arrFocus[this.area] ;
			switch(dir){
				case "left":
					return (obj.focusId%obj.cols === 0) ? true : false ;
					break;
				case "right":
					return (obj.focusId%obj.cols === obj.cols - 1 || obj.focusId === Math.min(obj.limit-1,obj.len-obj.startId-1)) ? true : false ;
					break;
				case "up":
					return (obj.focusId < obj.cols) ? true : false ;
					break;
				case "down":
					return (obj.focusId+obj.cols > Math.min(obj.limit-1,obj.len-obj.startId-1)) ? true : false ;
					break;
			}
		},
		doLeft: function(){
			var obj = this.arrFocus[this.area] ;
			if(this.on('left')){
				(obj.hasOwnProperty('next') && obj.next.hasOwnProperty('left')) && this.toArea(obj.next.left);
			}else{
				this.doMove(-1);
			}
		},
		doRight: function(){
            var obj = this.arrFocus[this.area] ;
            if(this.on('right')){
                (obj.hasOwnProperty('next') && obj.next.hasOwnProperty('right')) && this.toArea(obj.next.right) ;
            }else{
                this.doMove(1);
            }
		},
		doUp: function(){
            var obj = this.arrFocus[this.area] ;
            if(this.on('up')){
                (obj.hasOwnProperty('next') && obj.next.hasOwnProperty('up')) && this.toArea(obj.next.up) ;
            }else{
                this.doMove(-(this.arrFocus[this.area].cols));
            }
		},
		doDown: function(){
            var obj = this.arrFocus[this.area] ;
            if(this.on('down')){
                (obj.hasOwnProperty('next') && obj.next.hasOwnProperty('down')) && this.toArea(obj.next.down) ;
            }else{
                this.doMove(this.arrFocus[this.area].cols);
            }
		}
	}
	window.SHBMove = Move ;
})(window)