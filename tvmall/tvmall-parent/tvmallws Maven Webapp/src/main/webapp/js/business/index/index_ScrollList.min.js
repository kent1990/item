(function($, exports) {
	function $e(id) {
		return document.getElementById(id);
	}
	var Move = function() {
	}
	Move.prototype = {
		arrFocus : null,
		area : 0,
		lastArea : 0,
		oldArea : -1,
		focusImg : null,
		focusDiv : null,
		init : function() {
			this.doMove(0);
		},
		setFocusDiv : function(focusDiv) {
			this.focusDiv = focusDiv;
		},
		setFocusImg : function(focusImg) {
			this.focusImg = focusImg;
		},
		setFocusArray : function(focusArray) {
			this.arrFocus = focusArray;
		},
		setArea : function(area) {
			this.lastArea = this.area;
			this.area = area;
		},
		toArea : function(obj) {
			this.setArea(obj[0]);
			if (obj[1] !== undefined)
				this.arrFocus[this.area].focusId = obj[1];
			this.doMove(0);
		},
		doMove : function(num) {
			var buf = this.arrFocus[this.area].focusId + num;
			if (buf >= 0 && buf < this.arrFocus[this.area].limit) {
				var obj = this.arrFocus[this.area];
				var oldObj = this.arrFocus[this.oldArea];
				(this.oldArea != -1 && oldObj.doBlur) && oldObj.doBlur();
				if (this.area !== this.oldArea) {
					this.oldArea = this.area;
					if (this.focusImg) {
						this.focusImg.src = obj.img;
						this.focusImg.width = obj.width;
						this.focusImg.height = obj.height;
					}
				}
				this.arrFocus[this.area].focusId += num;
				(obj.doFocus) && obj.doFocus();
				if (this.focusDiv) {
					this.focusDiv.style.left = obj.left
							+ (obj.focusId % obj.cols) * obj.changeLeft + 'px';
					this.focusDiv.style.top = obj.top
							+ Math.floor(obj.focusId / obj.cols)
							* obj.changeTop + 'px';
				}
			}
		},
		on : function(dir) {
			var obj = this.arrFocus[this.area];
			switch (dir) {
			case "left":
				return (obj.focusId % obj.cols === 0) ? true : false;
				break;
			case "right":
				return (obj.focusId % obj.cols === obj.cols - 1 || obj.focusId === Math
						.min(obj.limit - 1, obj.len - obj.startId - 1)) ? true
						: false;
				break;
			case "up":
				return (obj.focusId < obj.cols) ? true : false;
				break;
			case "down":
				return (obj.focusId + obj.cols > Math.min(obj.limit - 1,
						obj.len - obj.startId - 1)) ? true : false;
				break;
			}
		},
		doLeft : function($this) {
			var obj = this.arrFocus[this.area];
			if (this.on('left')) {
				(obj.hasOwnProperty('next') && obj.next.hasOwnProperty('left'))
						&& this.toArea(obj.next.left);
				if ($this.pagetrigger && $this.pageAction) {
					!$this.pageTriggerByUpDown && $this.pageAction('left');
				}
			} else {
				this.doMove(-1);
			}
		},
		doRight : function($this) {
			var obj = this.arrFocus[this.area];
			if (this.on('right')) {
				(obj.hasOwnProperty('next') && obj.next.hasOwnProperty('right'))
						&& this.toArea(obj.next.right);
				if ($this.pagetrigger && $this.pageAction) {
					!$this.pageTriggerByUpDown && $this.pageAction('right');
				}
			} else {
				this.doMove(1);
			}
		},
		doUp : function($this) {
			var obj = this.arrFocus[this.area];
			if (this.on('up')) {
				(obj.hasOwnProperty('next') && obj.next.hasOwnProperty('up'))
						&& this.toArea(obj.next.up);
				if ($this.pagetrigger && $this.pageAction) {
					$this.pagetrigger && $this.pageTriggerByUpDown
							&& $this.pageAction('up');
				}
			} else {
				this.doMove(-(this.arrFocus[this.area].cols));
			}
		},
		doDown : function($this) {
			var obj = this.arrFocus[this.area];
			if (this.on('down')) {
				(obj.hasOwnProperty('next') && obj.next.hasOwnProperty('down'))
						&& this.toArea(obj.next.down);
				if ($this.pageAction) {
					$this.pageTriggerByUpDown && $this.pageAction('down');
				}
			} else {
				this.doMove(this.arrFocus[this.area].cols);
			}
		}
	}
	exports.SHBMove = Move;
	var RenderDom = {
		pre : function() {
			return $e("pre");
		},
		next : function() {
			return $e("next");
		},
	};
	var ScrollRender = {
		setCont : function($this) {
		},
		hasPreNext : function($this) {
		},
		scrollToDo : function($this) {
		},
		scrollDone : function($this) {
		},
		pageAction : function($this) {
		},
		updatePage : function($this) {
		}
	};
	var DefaultOptions = {
		focusId : 0,
		startId : 0,
		dataListLen : dataList ? dataList.length : 0,
		pagetrigger : true,
		pageTriggerByUpDown : true,
		pageShow : false,
		bar : {
			el : $('#bar'),
			len : 500
		},
		progress : {
			el : $('#inner_bar'),
		},
		DEBUG : false
	};
	var ScrollList = function() {
		$.extend(true, this, DefaultOptions);
	};
	ScrollList.fn = ScrollList.prototype;
	ScrollList.prototype = {
		init : function(Settings, Renders, ArrFocus) {
			$.extend(true, this, Settings);
			var moveObj = new SHBMove();
			moveObj.setFocusArray(ArrFocus);
			$.extend(true, this.MoveObj, moveObj);
			this.focusId = this.MoveObj.arrFocus[this.MoveObj.area].focusId;
			this.startId = this.MoveObj.arrFocus[this.MoveObj.area].startId;
			$.extend(true, ScrollRender, Renders);
			this.setPageInfo();
			return this;
		},
		MoveObj : {},
		scrollUp : function() {
			ScrollRender.scrollToDo(this);
			this.MoveObj.doUp(this);
			ScrollRender.scrollDone(this);
			ScrollRender.hasPreNext(this.MoveObj.startId, this.MoveObj.focusId,
					this.MoveObj.limit);
			return this;
		},
		updateFocus : function(startId, focusId) {
			var moveObj = this.MoveObj;
			moveObj.arrFocus[moveObj.area].startId = startId;
			moveObj.arrFocus[moveObj.area].focusId = focusId;
			this.log("updateFocus: startID: "
					+ moveObj.arrFocus[moveObj.area].startId + " focusId: "
					+ moveObj.arrFocus[moveObj.area].focusId);
		},
		scrollDown : function() {
			ScrollRender.scrollToDo(this);
			this.MoveObj.doDown(this);
			ScrollRender.scrollDone(this);
			ScrollRender.hasPreNext(this.MoveObj.startId, this.MoveObj.focusId);
			return this;
		},
		scrollRight : function() {
			ScrollRender.scrollToDo(this);
			this.MoveObj.doRight(this);
			ScrollRender.scrollDone(this);
			ScrollRender.hasPreNext(this.MoveObj.startId, this.MoveObj.focusId);
			return this;
		},
		scrollLeft : function() {
			ScrollRender.scrollToDo(this);
			this.MoveObj.doLeft(this);
			ScrollRender.scrollDone(this);
			ScrollRender.hasPreNext(this.MoveObj.startId, this.MoveObj.focusId);
			return this;
		},
		pageAction : function(action) {
			this.log("pageTrigger: " + action);
			switch (action) {
			case "right":
			case "down": {
				if (this.page.curPageIndex + 1 < this.page.NUM) {
					var moveObj = this.MoveObj;
					var moveFocus = moveObj.arrFocus[moveObj.area];
					var startId = moveFocus.startId;
					var focusId = moveFocus.focusId;
					var limit = moveFocus.limit;
					var len = limit;
					if (startId + focusId + limit + 1 >= this.dataListLen) {
						moveFocus.startId += limit;
						moveFocus.focusId = this.dataListLen % limit - 1;
						len = moveFocus.focusId + 1;
					} else {
						moveFocus.startId += limit;
						len = Math.min(limit, this.dataListLen
								- moveFocus.startId);
					}
					moveFocus.limit = len;
					ScrollRender.pageAction(this, moveFocus.startId, len);
					if (this.pageShow) {
						this.calcPage(1).showPage();
					} else {
						this.calcPage(1);
					}
					ScrollRender.updatePage(this);
				}
				break;
			}
			case "left":
			case "up": {
				if (this.page.curPageIndex > 0) {
					var moveObj = this.MoveObj;
					var moveFocus = moveObj.arrFocus[moveObj.area];
					var startId = moveFocus.startId;
					var focusId = moveFocus.focusId;
					var limit = this.limit;
					var len = limit;
					if (startId + focusId - limit >= 0) {
						moveFocus.startId -= limit;
						moveFocus.focusId = 0;
						len = limit;
					}
					moveFocus.limit = len;
					ScrollRender.pageAction(this, moveFocus.startId, len);
					if (this.pageShow) {
						this.calcPage(-1).showPage();
					} else {
						this.calcPage(-1);
					}
					ScrollRender.updatePage(this);
				}
				break;
			}
			default: {
			}
			}
		},
		page : {
			NUM : 0,
			curPageIndex : 0
		},
		setPageInfo : function() {
			this.page.NUM = Math.ceil(this.dataListLen / this.limit);
		},
		calcPage : function(step) {
			if (this.page.curPageIndex + step >= this.page.NUM - 1) {
				this.page.curPageIndex = this.page.NUM - 1;
			} else if (this.page.curPageIndex + step < 0) {
				this.page.curPageIndex = 0;
			} else {
				this.page.curPageIndex += step;
			}
			return this;
		},
		showPage : function() {
			this.progress.el.height(Math.floor(this.bar.len / this.page.NUM)
					+ "px");
			this.progress.el.css('top', this.progress.el.height()
					* this.page.curPageIndex + "px");
			return this;
		}
	};
	ScrollList.fn = ScrollList.prototype;
	ScrollList.fn.log = function() {
		this.DEBUG && console.log.apply(console, arguments);
	};
	exports.ScrollRender = ScrollRender;
	exports.ScrollList = ScrollList;
})(jQuery, window);