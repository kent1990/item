function pintu(){
    //console.info('x');

    $(".win-homepage").click(function(){
        if(document.all){
        document.body.style.behavior = 'url(#default#homepage)';
        document.body.setHomePage(document.URL);
        }else{alert("设置首页失败，请手动设置！");}
	});
	$(".win-favorite").click(function(){
		var sURL=document.URL;
		var sTitle=document.title;
		try {window.external.addFavorite(sURL, sTitle);}
		catch(e){
			try{window.sidebar.addPanel(sTitle, sURL, "");}
			catch(e){alert("加入收藏失败，请使用Ctrl+D进行添加");}
		}
	});
	$(".win-forward").click(function(){
		window.history.forward(1);
	});
	$(".win-back").click(function(){
		window.history.back(-1);
	});
	$(".win-backtop").click(function(){$('body,html').animate({scrollTop:0},1000);return false;});
	$(".win-refresh").click(function(){
		window.location.reload();
	});
	$(".win-print").click(function(){
		window.print();
	});
	$(".win-close").click(function(){
		window.close();
	});
	$('.checkall').click(function(){
		var e=$(this);
		var name=e.attr("name");
		var checkfor=e.attr("checkfor");
		var type;
		if (checkfor!='' && checkfor!=null && checkfor!=undefined){
			type=e.closest('form').find("input[name='"+checkfor+"']");
		}else{
			type=e.closest('form').find("input[type='checkbox']");
		};
		if (name=="checkall"){
			$(type).each(function(index, element){
				element.checked=true;
			});
			e.attr("name","ok");
		}else{
			$(type).each(function(index, element){
				element.checked=false;
			});
			e.attr("name","checkall");
		}
	});
	$('.dropdown-toggle').click(function(){
		$(this).closest('.button-group, .drop').addClass("open");
	});
	 $(document).bind("click",function(e){
		 if($(e.target).closest(".button-group.open, .drop.open").length == 0){
			 $(".button-group, .drop").removeClass("open");
		 }
	});
	$checkplaceholder=function(){
		var input = document.createElement('input');
		return 'placeholder' in input;
	};
	if(!$checkplaceholder()){
		$("textarea[placeholder], input[placeholder]").each(function(index, element){
			if($(element).val().length ===0 && ($(element).attr("placeholder") || $emptyplaceholder(element))){
				$(element).val($(element).attr("placeholder"));
				$(element).data("pintuerholder",$(element).css("color"));
				$(element).css("color","rgb(169,169,169)");
				$(element).focus(function(){$hideplaceholder($(this));});
				$(element).blur(function(){$showplaceholder($(this));});
			}
		})
	};
	$emptyplaceholder=function(element){
	   //console.info(element);
		var $content=$(element).val();
        //console.info($content);
		return ($content.length === 0) || $content == $(element).attr("placeholder");
	};
	$showplaceholder=function(element){
		//不为空及密码框
		if($emptyplaceholder(element) && $(element).attr("type")!="password"){
			$(element).val($(element).attr("placeholder"));
			$(element).data("pintuerholder",$(element).css("color"));
			$(element).css("color","rgb(169,169,169)");
		}
	};
	var $hideplaceholder=function(element){
		if($(element).data("pintuerholder")){
			$(element).val("");
			$(element).css("color", $(element).data("pintuerholder"));
			$(element).removeData("pintuerholder");
		}
	};
	$('textarea, input, select').blur(function(){
		var e=$(this);
		if(e.attr("data-validate")){
			e.closest('.field').find(".input-help").remove();
			var $checkdata=e.attr("data-validate").split(',');
			var $checkvalue=e.val();
			var $checkstate=true;
			var $checktext="";
			if(e.attr("placeholder")==$checkvalue){$checkvalue="";}
			if($checkvalue!="" || e.attr("data-validate").indexOf("required")>=0){
				for(var i=0;i<$checkdata.length;i++){
					var $checktype=$checkdata[i].split(':');
					if(! $pintuercheck(e,$checktype[0],$checkvalue)){
						$checkstate=false;
						$checktext=$checktext+"<li>"+$checktype[1]+"</li>";
					}
				}
			};
			if($checkstate){
				e.closest('.form-group').removeClass("check-error");
				//e.parent().find(".input-help").remove();
				e.closest('.form-group').addClass("check-success");
			}else{
				e.closest('.form-group').removeClass("check-success");
				e.closest('.form-group').addClass("check-error");
				//e.closest('.field').append('<div class="input-help"><ul>'+$checktext+'</ul></div>');
			}
		}
	});
	$pintuercheck=function(element,type,value){
		$pintu=value.replace(/(^\s*)|(\s*$)/g, "");
		switch(type){
			case "en_zh":return /^[0-9A-Za-z]+$/.test($pintu);break;
			case "required":return /[^(^\s*)|(\s*$)]/.test($pintu);break;
			case "chinese":return /^[\u0391-\uFFE5]+$/.test($pintu);break;
			case "number":return /^\d+$/.test($pintu);break;
			case "integer":return /^[-\+]?\d+$/.test($pintu);break;
			case "plusinteger":return /^[+]?\d+$/.test($pintu);break;
			case "double":return /^[-\+]?\d+(\.\d+)?$/.test($pintu);break;
			case "plusdouble":return /^[+]?\d+(\.\d+)?$/.test($pintu);break;
			case "english":return /^[A-Za-z]+$/.test($pintu);break;
			case "username":return /^[a-z]\w{3,}$/i.test($pintu);break;
			case "mobile":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[0-9]\d{8}?$|18[0-9]\d{8}?$|17[07]\d{8}?$|147\d{8}?$|1\d{10}?$/.test($pintu);break;
			case "phone":return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "tel":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[189]\d{8}?$|18[1279]\d{8}?$|170\d{8}?$|177\d{8}?$|147\d{8}?$/.test($pintu) || /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "email":return /^[^@]+@[^@]+\.[^@]+$/.test($pintu);break;
			case "url":return /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/.test($pintu);break;
			case "ip":return /^[\d\.]{7,15}$/.test($pintu);break;
			case "qq":return /^[1-9]\d{4,10}$/.test($pintu);break;
			case "currency":return /^\d+(\.\d+)?$/.test($pintu);break;
			case "zip":return /^[1-9]\d{5}$/.test($pintu);break;
			case "idcard":return /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/.test($pintu);break;
			case "%%":return /^(0)\.[0-9]{1,2}$/.test($pintu);break;
			case "radio":
				var radio=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
				return eval(radio==1);
				break;
			default:
				var $test=type.split('#');
				if($test.length>=1){
					switch($test[0]){
						case "compare":
							return eval(Number($pintu)+$test[1]);
							break;
						case "regexp":
							return new RegExp($test[1],"gi").test($pintu);
							break;
						case "length":
							var $length;
							if(element.attr("type")=="checkbox"){
								$length=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
							}else{
								$length=$pintu.replace(/[\u4e00-\u9fa5]/g,"***").length;
							}
							return eval($length+$test[1]);
							break;
						case "ajax":
							var $getdata;
							var $url=$test[1]+$pintu;
							$.ajaxSetup({async:false});
							$.getJSON($url,function(data){
								$getdata=data.getdata;
							});
							if($getdata=="true"){return true;}
							break;
						case "repeat":
							return $pintu==jQuery('input[name="'+$test[1]+'"]').eq(0).val();
							break;
						default:return true;break;
					}
					break;
				}else{
					return true;
				}
		}
	};
	$('form').submit(function(){
		$(this).find('input[data-validate],textarea[data-validate],select[data-validate]').trigger("blur");
		var numError = $(this).find('.check-error').length;
		if(numError){
			$(this).find('.check-error').first().find('input[data-validate],textarea[data-validate],select[data-validate]').first().focus().select();
			return false;
		}
	});
	$('.form-reset').click(function(){
		$(this).closest('form').find(".input-help").remove();
		$(this).closest('form').find('.form-submit').removeAttr('disabled');
		$(this).closest('form').find('.form-group').removeClass("check-error");
		$(this).closest('form').find('.form-group').removeClass("check-success");
	});
    $('.tab .tab-nav li').unbind('click');
    $('.tab .tab-nav li').unbind('mouseover');
	$('.tab .tab-nav li').each(function(){
		var e=$(this);
		var trigger=e.closest('.tab').attr("data-toggle");
		if (trigger=="hover"){
			e.mouseover(function(){
				$showtabs(e);
			});
			e.click(function(){
				return false;
			});
		}else{
			e.click(function(){
				$showtabs(e);
				return false;
			});
		}
	});
	$showtabs=function(e){
		var detail=e.children("a").attr("href");
        var data = e.children("a").attr('data-url');
		e.closest('.tab .tab-nav').find("li").removeClass("active");
		e.closest('.tab').find(".tab-body .tab-panel").removeClass("active");
		e.addClass("active");
        if(data!=undefined){
            $(detail).load(data,function(){
                $(detail).addClass("active");
            });
        }else{
          $(detail).addClass("active");
        }
	};
	$('.dialogs').each(function(){
		var e=$(this);
		var trigger=e.attr("data-toggle");
		if (trigger=="hover"){
			e.mouseover(function(){
				$showdialogs(e);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$showdialogs(e);
			});
		}
	});

	$showdialogs=function(e){
		var trigger=e.attr("data-toggle");
		var getid=e.attr("data-target");
		var data=e.attr("data-url");
		var mask=e.attr("data-mask");
		var width=e.attr("data-width");
        var postdata = e.attr("data-postdata");
		var detail="";
        var win_num = 'win-'+($('.dialog-win').length);
		var masklayout=$('<div class="dialog-mask"  masklayout="'+win_num+'" style="z-index:'+(($('.dialog-win').length)+10)+'"></div>');
		if(width==null){width="420px";}

		if (mask=="1"){
			$("body").append(masklayout);
		}
		detail='<div class="dialog-win" masklayout="'+win_num+'" style="position:fixed;width:'+width+';z-index:'+(($('.dialog-win').length)+11)+';">';

		if(getid!=null){detail=detail+$(getid).html();}
        if(data!=null && postdata!=null){
        	$.ajax({
	        	url:data,
	        	type:'POST',
	        	data:postdata,
	        	async:false,
	        	success:function(result,status,xhr){
	        		var sessionStatus = xhr.getResponseHeader("sessionstatus");
			    	var redirectLocation = xhr.getResponseHeader("location");
			   		if(sessionStatus=="sessionTimeOut"){				      
			      		$.Showmsg(result);
			      		window.setTimeout(function(){
			      			window.location=redirectLocation;
			      		},2000);
			      		return null;
			     	}
			   		detail=detail+xhr.responseText;
	        		
	        	}
        })}
        else if(data!=null){
        	$.ajax({
        		url:data,
        		async:false,
        		success:function(result,status,xhr){
        			var sessionStatus = xhr.getResponseHeader("sessionstatus");
			    	var redirectLocation = xhr.getResponseHeader("location");
			   		if(sessionStatus=="sessionTimeOut"){				      
			      		$.Showmsg(result);
			      		window.setTimeout(function(){
			      			window.location=redirectLocation;
			      		},2000);
			      		return null;
			     	}
			   		detail=detail+xhr.responseText;
        		}
        	})}

		detail=detail+'</div>';

		var win=$(detail);

		win.find(".dialog").addClass("open");
		$("body").append(win);
		var x=parseInt($(window).width()-win.outerWidth())/2;
		var y=parseInt($(window).height()-win.outerHeight())/2;
		if (y<=10){y="10"}
		win.css({"left":x,"top":y});
		win.find(".dialog-close,.close").each(function(){
			$(this).click(function(){
				win.remove();
				$('.dialog-mask[masklayout='+win_num+']').remove();
			});
		});
        pintu();//浮层需要重新调用一下，不然js相关动作无效
		/**
		masklayout.click(function(){
			win.remove();
			$(this).remove();
		});
		**/
        return win;
	};
	$('.tips').each(function(){
		var e=$(this);
		var title=e.attr("title");
		var trigger=e.attr("data-toggle");
		e.attr("title","");
		if (trigger=="" || trigger==null){trigger="hover";}
		if (trigger=="hover"){
			e.mouseover(function(){
				$showtips(e,title);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$showtips(e,title);
			});
		}else if(trigger=="show"){
			e.ready(function(){
				$showtips(e,title);
			});
		}
	});
	$showtips=function(e,title){
		var trigger=e.attr("data-toggle");
		var place=e.attr("data-place");
		var width=e.attr("data-width");
		var css=e.attr("data-style");
		var image=e.attr("data-image");
		var content=e.attr("content");
		var getid=e.attr("data-target");
		var data=e.attr("data-url");
		var x=0;
		var y=0;
		var html="";
		var detail="";

		if(image!=null){detail=detail+'<img class="image" src="'+image+'" />';}
		if(content!=null){detail=detail+'<p class="tip-body">'+content+'</p>';}
		if(getid!=null){detail=detail+$(getid).html();}
		if(data!=null){detail=detail+$.ajax({url:data,async:false}).responseText;}
		if(title!=null && title!=""){
			if(detail!=null && detail!=""){detail='<p class="tip-title"><strong>'+title+'</strong></p>'+detail;}else{detail='<p class="tip-line">'+title+'</p>';}
		}
		detail='<div class="tip">'+detail+'</div>';
		html=$(detail);

		$("body").append( html );
		if(width!=null){
			html.css("width",width);
		}
		if(place=="" || place==null){place="top";}
		if(place=="left"){
			x=e.offset().left - html.outerWidth()-5;
			y=e.offset().top - html.outerHeight()/2 + e.outerHeight()/2;
		}else if(place=="top"){
			x=e.offset().left - html.outerWidth()/2 + e.outerWidth()/2;
			y=e.offset().top - html.outerHeight()-5;
		}else if(place=="right"){
			x=e.offset().left + e.outerWidth()+5;
			y=e.offset().top - html.outerHeight()/2 + e.outerHeight()/2;
		}else if(place=="bottom"){
			x=e.offset().left - html.outerWidth()/2 + e.outerWidth()/2;
			y=e.offset().top + e.outerHeight()+5;
		}
		if (css!=""){html.addClass(css);}
		html.css({"left":x+"px","top":y+"px","position":"absolute"});
		if (trigger=="hover" || trigger=="click" || trigger==null){
			e.mouseout(function(){html.remove();e.attr("title",title)});
		}
	};
	$('.alert .close').each(function(){
		$(this).click(function(){
			$(this).closest('.alert').remove();
		});
	});
	$('.radio label').each(function(){
		var e=$(this);
		e.click(function(){
			e.closest('.radio').find("label").removeClass("active");
			e.addClass("active");
		});
	});
	$('.checkbox label').each(function(){
		var e=$(this);
		e.click(function(){
			if(e.find('input').is(':checked')){
				e.addClass("active");
			}else{
				e.removeClass("active");
			};
		});
	});
	$('.collapse .panel-head').each(function(){
		var e=$(this);
		e.click(function(){
			e.closest('.collapse').find(".panel").removeClass("active");
			e.closest('.panel').addClass("active");
		});
	});
	$('.icon-navicon').each(function(){
		var e=$(this);
		var target=e.attr("data-target");
		e.click(function(){
			$(target).toggleClass("nav-navicon");
		});
	});
	$('.banner').each(function(){
		var e=$(this);
		var pointer=e.attr("data-pointer");
		var interval=e.attr("data-interval");
		var style=e.attr("data-style");
		var items=e.attr("data-item");
		var items_s=e.attr("data-small");
		var items_m=e.attr("data-middle");
		var items_b=e.attr("data-big");
		var num=e.find(".carousel .item").length;
		var win=$(window).width();
		var i=1;

		if(interval==null){interval=5};
		if(items==null || items<1){items=1};
		if(items_s!=null && win>760){items=items_s};
		if(items_m!=null && win>1000){items=items_m};
		if(items_b!=null && win>1200){items=items_b};

		var itemWidth=Math.ceil(e.outerWidth()/items);
		var page=Math.ceil(num/items);
		e.find(".carousel .item").css("width",itemWidth+ "px");
		e.find(".carousel").css("width",itemWidth*num + "px");

		var carousel=function(){
			i++;
			if(i>page){i=1;}
			$showbanner(e,i,items,num);
		};
		var play=setInterval(carousel,interval*600);

		e.mouseover(function(){clearInterval(play);});
		e.mouseout(function(){play=setInterval(carousel,interval*600);});

		if(pointer!=0 && page>1){
			var point='<ul class="pointer"><li value="1" class="active"></li>';
			for (var j=1;j<page;j++){
				point=point+' <li value="'+(j+1)+'"></li>';
			};
			point=point+'</ul>';
			var pager=$(point);
			if(style!=null){pager.addClass(style);};
			e.append(pager);
			pager.css("left",e.outerWidth()*0.5 - pager.outerWidth()*0.5+"px");
			pager.find("li").click(function(){
				$showbanner(e,$(this).val(),items,num);
			});
			var lefter=$('<div class="pager-prev icon-angle-left"></div>');
			var righter=$('<div class="pager-next icon-angle-right"></div>');
			if(style!=null){lefter.addClass(style);righter.addClass(style);};
			e.append(lefter);
			e.append(righter);

			lefter.click(function(){
				i--;
				if(i<1){i=page;}
				$showbanner(e,i,items,num);
			});
			righter.click(function(){
				i++;
				if(i>page){i=1;}
				$showbanner(e,i,items,num);
			});
		};
	});
	$showbanner=function(e,i,items,num){
		var after=0,leftx=0;
		leftx = - Math.ceil(e.outerWidth()/items)*(items)*(i-1);
		if(i*items > num){after=i*items-num;leftx= - Math.ceil(e.outerWidth()/items)*(num-items);};
		e.find(".carousel").stop(true, true).animate({"left":leftx+"px"},800);
		e.find(".pointer li").removeClass("active");
		e.find(".pointer li").eq(i-1).addClass("active");
	};
	$(".spy a").each(function(){
		var e=$(this);
		var t=e.closest(".spy");
		var target=t.attr("data-target");
		var top=t.attr("data-offset-spy");
		var thistarget="";
		var thistop="";
		if(top==null){top=0;};
		if(target==null){thistarget=$(window);}else{thistarget=$(target);};

		thistarget.bind("scroll",function(){
			if(target==null){
				thistop=$(e.attr("href")).offset().top - $(window).scrollTop() - parseInt(top);
			}else{
				thistop=$(e.attr("href")).offset().top - thistarget.offset().top - parseInt(top);
			};

			if(thistop<0){
				t.find('li').removeClass("active");
				e.parents('li').addClass("active");
			};

		});
	});
	$(".fixed").each(function(){
		var e=$(this);
		var style=e.attr("data-style");
		var top=e.attr("data-offset-fixed");
		if(top==null){top=e.offset().top;}else{top=e.offset().top - parseInt(top);};
		if(style==null){style="fixed-top";};

		$(window).bind("scroll",function(){
			var thistop=top - $(window).scrollTop();
			if(style=="fixed-top" && thistop<0){
				e.addClass("fixed-top");
			}else{
				e.removeClass("fixed-top");
			};

			var thisbottom=top - $(window).scrollTop()-$(window).height();
			if(style=="fixed-bottom" && thisbottom>0){
				e.addClass("fixed-bottom");
			}else{
				e.removeClass("fixed-bottom");
			};
		});

	});
    ////// 对各种支付方式的支持的js todo:各种支付方式js
    $('.pay-method').unbind();
    $('.pay-method').each(function(){
		var e=$(this);
        var eform = $(this).closest('form');
		var trigger=e.attr("data-toggle");
		if (trigger=="" || trigger==null){trigger="click";}
		if (trigger=="hover"){
			e.mouseover(function(){
				$payMethod(e,eform);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$payMethod(e,eform);
			});
		}else if(trigger=="show"){
			e.ready(function(){
				$payMethod(e,eform);
			});
		}
	});
	$payMethod=function(e,eform){
		var  pay_method=e.attr("pay-method");
        eform.find('input[id=pay_method]').val(pay_method);
        eform.submit();
	};
    //全选
    $('.choose-all-checkbox').unbind('click');
    $('.choose-all-checkbox').unbind('hover');
    //console.info($('.choose-all-checkbox').length);
    $('.choose-all-checkbox').each(function(){
		var e=$(this);
		var trigger=e.attr("data-toggle");
		if (trigger=="" || trigger==null){trigger="click";}
		if (trigger=="hover"){
			e.mouseover(function(){
				$chooseAllCheckbox(e);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$chooseAllCheckbox(e);
			});
		}
        if(e.attr('data-save-input')!='' && e.attr('data-save-input')!=null){
            //加载将选择结果存放到目标input中
            if (trigger=="hover"){
                $(e.attr("data-target")).unbind('hover');
                $(e.attr("data-target")).mouseover(function(){
    				$chooseCheckboxToInput(e);
    			});
    		}else if(trigger=="click"){
                $(e.attr("data-target")).unbind('click');
                $(e.attr("data-target")).click(function(){
    				$chooseCheckboxToInput(e);
    			});
    		}
            //选中表单里面已有的
            var getid=e.attr("data-target");
    		var save_input=e.attr("data-save-input");
            var re_html=$(save_input).val();
            var strs= new Array(); //定义一数组
            strs=re_html.split(","); //字符分割
            $(e.attr("data-target")).each(function(){
                //console.info(strs.indexOf($(this).val()));
                if(strs.indexOf($(this).val())>=0){
                    $(this).prop('checked',true);
                }
            });
        }
	});
	$chooseAllCheckbox=function(e){
		var getid=e.attr("data-target");
        if(e.prop('checked')){
            $(getid).prop('checked',true);
        }else{
            $(getid).prop('checked',false);
        }
        if(e.attr('data-save-input')!='' && e.attr('data-save-input')!=null){
            $chooseCheckboxToInput(e);
        }
	};
    $chooseCheckboxToInput=function(e){
		var getid=e.attr("data-target");
		var save_input=e.attr("data-save-input");
        var re_html=$(save_input).val();
        var strs= new Array(); //定义一数组
        strs=re_html.split(","); //字符分割
        //console.info(getid.length);
        $(getid).each(function(){
            //删除这一页在项目中有的，
            for(var i=0;i<strs.length;i++){
                if($(this).val()==strs[i]){
                    //console.info('有相等',$(this).val());
                    strs.splice(i,1);
                }
            }
            //加上选中的
            if($(this).prop('checked')){
                strs.push($(this).val());
            }
        });
        //console.info(strs);
        $(save_input).val(strs.join(','));
	};
    //下拉变成变表
    $('.buttom-select.drop-menu a').click(function(){
        $('#'+$(this).closest('.buttom-select').attr('data-val-id')).val($(this).attr('data-val'));
        $(this).closest('.button-group, .drop').find('.dropdown-toggle .buttom-select-val').text($(this).text());
        $(this).closest('.button-group, .drop').removeClass('open');
        return false;
    });
    /** 增加表单的验证与提交 **/
	$('form[class~=ajaxpost]').unbind('submit');
	$('form[class~=ajaxpost]').submit(function() {
		$(this).find('input[data-validate],textarea[data-validate],select[data-validate]').trigger("blur");
		var numError = $(this).find('.check-error').length;
		if (numError) {
			$(this).find('.check-error').first().find('input[data-validate],textarea[data-validate],select[data-validate]').first().focus().select();
			return false;
		}
		//todo: sung hookwin 表单如果使用post提交方式，则使用ajax,且返回的只能用json方式，格式中可包含的参数为：{status='y/n',info='提示内容',其它参数...}
        var thisform = $(this);
		var method_str = ($(this).attr('method'));
		if (method_str.toLowerCase() == "post") {
			var sub_url = $(this).attr('action');
			var sub_button = $(this).find('button[type=submit]').first();
			var post_data = $(this).serializeArray();
			//1.把所有的变为不可写，只读？还是屏毕
			//$(this).find('input,textarea,select').attr('disabled',"disabled");
			var old_bottom_str = $(sub_button).text();
			$(sub_button).html('<span class="icon-refresh rotate"></span>&nbsp;&nbsp;' + old_bottom_str).attr('disabled', "disabled");
			$.post(sub_url, post_data, function(data,status,xhr) {
				var sessionStatus = xhr.getResponseHeader("sessionstatus");
		    	var redirectLocation = xhr.getResponseHeader("location");
		   		if(sessionStatus=="sessionTimeOut"){				      
		      		$.Showmsg(html);
		      		window.setTimeout(function(){
		      			window.location=redirectLocation;
		      		},2000);
		      		return;
		     	}
			     if(typeof(data.info)!='undefined'){
			         $.Showmsg(data.info);
                 }
				if(data.status == "y") {
				    if(typeof(data.info)!='undefined'){
                        setTimeout(function() {
                            $.Hidemsg();
    				    }, 3500);
                    }
				    //回调自己的方法
				    if(data.target_id=="1"){
				    	remote();
				    }
                    if(typeof(data.target_id)!='undefined' && typeof(data.callback_fun)!='undefined' && data.target_id=='callback'){
                        //console.info('回调js的方法');
                        eval(data.callback_fun);
                    }
				    if(typeof(data.close_dialog)!='undefined'){
				        if(data.close_dialog=='this'){
				            //关闭表单自己所在的层
                            var dialogwin = $(thisform).closest('.dialog-win');
                            //关浮层，
                            $('.dialog-mask[masklayout='+$(dialogwin).attr('masklayout')+']').remove();
                            //关窗口
                            $(dialogwin).remove();
                        }else{
    				        //关闭弹出的所有浮层
    				        $('.dialog-win').remove();
                            $('.dialog-mask').remove();
                        }
				    }
					if (typeof(data.url) != 'undefined') {
				        //$.Hidemsg();
						if (typeof(data.target_id) != 'undefined') {
						  if(data.target_id!=''){
						      if(data.target_id == 'showdialogs'){
						          //打开一个浮层来加载
                                    var b = {};
                                    b['data-toggle']='click';
                                    b['data-url']=data.url;
                                    b['data-mask']='1';
                                    if(typeof(data.showdialogs_width) != 'undefined'){
                                        b['data-width']=data.showdialogs_width;
                                    }
                                  $showdialogs($(b));
						      }else{
			                     ajaxload(data.url,data.target_id);
                              }
                            }else{
                                ajaxload(data.url);
                            }
						} else {
                            top.location.href = data.url;
						}
						return false;
					}
				}else{
				    if(typeof(data.info)!='undefined'){
    				    setTimeout(function() {
                            $.Hidemsg();
    					}, 5500);
                    }
				}
				//解锁按钮
				$(sub_button).text(old_bottom_str).removeAttr('disabled', "disabled");
				return false;
			}, 'json');
			return false;
		}else if(method_str.toLowerCase() == "get"){
		  var sub_url = $(this).attr('action')+'?'+$.param($(this).serializeArray());
          var target_id = $(this).attr('target-id');
          if(typeof(target_id)!= 'undefined'){
                ajaxload(sub_url,target_id);
          } else{
		        ajaxload(sub_url);
          }
          return false;
		}
	});
	
}



$(function(){
	pintu();
	//xliang
	whdu();
	$(window).resize(function() {
		whdu();
	});
	dianzhuang();
	$(document).on("click",".xiala>ul>li>a",function(){
	/*$('.xiala>ul>li>a').onclick(function() {*/
		$('.xiala li').removeClass('djbj');
		$(this).closest('li').addClass('djbj');
        $('.xiala span').removeAttr('id');
		$('.xiala a').removeAttr('id');
        $(this).prev('span').attr('id','text-c2');
		$(this).attr('id','text-c');
		if ($(this).next().children('li').length == 0) {
			dianzhuang();
            if($(this).attr('data-url')==''){
                return false;
            }
			ajaxload($(this).attr('data-url'));
		} else {
			jjzh($(this));
		}
	});
	$(document).on("click",".xiala>ul>li>ul>li>a",function(){
	/*$('.xiala>ul>li>ul>li>a').click(function() {*/
		$('.xiala li').removeClass('djbj');
		$(this).parents('li').addClass('djbj');
		$('.xiala span').removeAttr('id');
		$('.xiala a').removeAttr('id');
        $(this).prev('span').attr('id','text-c2');
		$(this).attr('id','text-c');
		if ($(this).next().children('li').length == 0) {
			dianzhuang();
            if($(this).attr('data-url')==''){
                return false;
            }
	        if($(this).attr('onclick')!=''&&$(this).attr('onclick')!=null){//lzyafh
	            return false;
	        }
			ajaxload($(this).attr('data-url'));
		} else {
			jjzh($(this));
		}
	});
	$(document).on("click",".xiala>ul>li>ul>li>ul>li>a",function(){
	/*$('.xiala>ul>li>ul>li>ul>li>a').click(function() {*/
		$('.xiala li').removeClass('djbj');
		$(this).parents('li').addClass('djbj');
		$('.xiala span').removeAttr('id');
		$('.xiala a').removeAttr('id');
        $(this).next('span').attr('id','text-c2');
		$(this).attr('id','text-c');
		if ($(this).next().children('li').length == 0) {
			dianzhuang();
            if($(this).attr('data-url')==''){
                return false;
            }
	        if($(this).attr('onclick')!=''&&$(this).attr('onclick')!=null){//lzyafh
	            return false;
	        }
			ajaxload($(this).attr('data-url'));
		} else {
			jjzh($(this));
		}
	});
	$(document).on("click",".xiala>ul>li>ul>li>ul>li>ul>li>a",function(){
		/*$('.xiala>ul>li>ul>li>ul>li>a').click(function() {*/
			$('.xiala li').removeClass('djbj');
			$(this).parents('li').addClass('djbj');
			$('.xiala span').removeAttr('id');
			$('.xiala a').removeAttr('id');
	        $(this).next('span').attr('id','text-c2');
			$(this).attr('id','text-c');
			ajaxload($(this).attr('data-url'));
			
		});
	//$('.xiala>ul>li>ul>li>ul>li').append('<span class="icon-caret-right" style="display: block; float: left;">&nbsp;&nbsp;</span>');
	$('#hyling').mouseover(function() {
	    myshowshop();
		$('#hylingkai').show();
		$(this).hide();
	});
	$('#hylingkai').mouseleave(function() {
		$('#hyling').show();
		$(this).hide();
	});
});
//打印小票
function printTicket(tplId,orderCode,printway,paramUrl)
{
    //获取打印数据，并打印
    var askurl = $('#sys-print-ticket').attr("data-url")+'/'+tplId+'/'+orderCode+"?"+paramUrl;//提交地址
    $.get(askurl,function(data){
        //$.Showmsg(data.info);
        //console.info(data.info);
        if(data.status == 'y'){
            //开始打印
            var atitle = '<a href="client://command/print?'+data.content+'" class="djdy" style="display:none;">打印小票</a>';
                $('#sys-print-ticket').html(atitle);
                var mo2g = '<span id="mo2g" style="display:none;">小票</span>';
                $('#sys-print-ticket .djdy').html(mo2g);
                if(printway=='hand')
                {
                    //如果是手动打印，就只打印一次
                    $("#mo2g").click();
                    return true;
                }
                for(i=1;i<=data.print_num;i++)
                {
                    //打印次数
                    $("#mo2g").click();
                }
        }
    });
}
//获取我所能看的到的店铺，然后把数据处理了扔到#myshowshop下，
//如果后台返回结果为status=n,就什么都不做
function myshowshop(){
    $.post($('#hyling').attr('data-url'),function(data,status,xhr){
    	var sessionStatus = xhr.getResponseHeader("sessionstatus");
    	var redirectLocation = xhr.getResponseHeader("location");
   		if(sessionStatus=="sessionTimeOut"){				      
      		$.Showmsg(html);
      		window.setTimeout(function(){
      			window.location=redirectLocation;
      		},2000);
      		return;
     	}
    	var shopId = $("#default_shop").data("id");
       if(data.status == 'y'){
            var str = '';
            $.each(data.shop,function(xkey,xval){
            	if(shopId!=xval.shop_id){
                	str += '<div class="x12  padding-small-top"><a href="javascript:void(0);" onclick="javascript:change_shop(this);" data-url="'+data.url+'/'+xval.shop_id+'" class="text-sub"  title="点击切换到【'+xval.shop_name+'】">'+(xval.shop_name)+'</a></div>';
            	}
            });
            $("#myshowshop").html(str);
       }
    });
}
//切换我目前所处的店铺
function change_shop(xthis){
    $.Showmsg('正在切换中...');
    $.post($(xthis).attr('data-url'),function(data){
        $.Showmsg(data.info);
        if(data.status == 'y'){
            top.location.href=data.url;
        }
    });
    return true;
}
//检测下面没有ul的时候就吧自己加上一个小图标

function dianzhuang() {
	$('.xiala ul li').each(function() {
		if ($(this).children('ul').length == 0) {
			$(this).children('span').removeClass('icon-caret-right');
			$(this).children('span').addClass('icon-caret-right');
		}
	});
}
//刷新图标和lode请求

function ajaxload(url, divid) {
	if (typeof(url) != 'undefined') {
		var loadstr = '<div class="xuanzhuan"><span class="icon-spinner rotate"></span></div>';
		if (typeof(divid) != 'undefined') {
			$('#' + divid).html(loadstr);
			$.post(url,null,function(response,status,xhr){
				var sessionStatus = xhr.getResponseHeader("sessionstatus");
		    	var redirectLocation = xhr.getResponseHeader("location");
		   		if(sessionStatus=="sessionTimeOut"){				      
		      		$.Showmsg(response);
		      		window.setTimeout(function(){
		      			window.location=redirectLocation;
		      		},2000);
		      		return ;
		     	}
		   		$('#' + divid).html(response);
		   		pintu();
		   		table_width();
		   		table_width2();
			},"html");
//			$('#' + divid).html(loadstr).load(url,function(){
//			 pintu();
//             table_width();
//             table_width2();
//			});
		} else {
			$(".fadein-right").html(loadstr);
			$.post(url,null,function(response,status,xhr){
				var sessionStatus = xhr.getResponseHeader("sessionstatus");
		    	var redirectLocation = xhr.getResponseHeader("location");
		   		if(sessionStatus=="sessionTimeOut"){				      
		      		$.Showmsg(response);
		      		window.setTimeout(function(){
		      			window.location=redirectLocation;
		      		},2000);
		      		return ;
		     	}
		   		$(".fadein-right").html(response);
		   		pintu();
		   		table_width();
		   		table_width2();
			},"html");
//			$('.fadein-right').html(loadstr).load(url,function(){				
//			 	pintu();
//             table_width();
//             table_width2();
//			});
		}
		return false;
	}
	return false;
}
//计算左菜单的高度和右边的高度和宽度

function whdu() {
	$(".bodyw").css('height', $(window).height());

	$('.left').css('height', $(window).height());
    $('.left2').css('height', $(window).height() - 153);

	$('.right').css('width', ($('body').width() - 200));
    $('.right2').css('height', $(window).height()-53);
	$('.right2').css('width', ($('body').width() - 202));

}
//向右边剪头点开，变成向下边的剪头

function jjzh(dkgb) {
	if (dkgb.closest('li').children('a').children('span').attr('class') == 'icon-caret-right') {
		dkgb.closest('li').children('ul').show();
		dkgb.closest('li').children('a').children('span').attr('class', 'icon-caret-down');
	} else {
		dkgb.closest('li').children('ul').hide();
		dkgb.closest('li').children('a').children('span').attr('class', 'icon-caret-right');
	}
}
//计算所有th宽度的和并赋值给table
function table_width(){
    $('.table').each(function(){
        var tw=0;
        $(this).children('thead').children('tr').children('th').each(function(){
            if($(this).attr('width')!=undefined){
                tw+=parseInt($(this).attr('width'));
            }
        });
        $(this).css('min-width',tw);
    });
}
function table_width2(){

    $('.jishuankuandu').css('min-width',500);
}
/**
将秒转成时分秒
**/
function formatSeconds(value) {
    var theTime = parseInt(value);// 秒
    var theTime1 = 0;// 分
    var theTime2 = 0;// 小时
    if(theTime > 60) {
        theTime1 = parseInt(theTime/60);
        theTime = parseInt(theTime%60);
            if(theTime1 > 60) {
            theTime2 = parseInt(theTime1/60);
            theTime1 = parseInt(theTime1%60);
            }
    }
    var result = ""+parseInt(theTime)+"秒";
    if(theTime1 > 0) {
        result = ""+parseInt(theTime1)+"分"+result;
    }
    if(theTime2 > 0) {
        result = ""+parseInt(theTime2)+"小时"+result;
    }
    return result;
}


//将json格式的对象拼接成复杂的url参数
function parseParam(param, key){
    var paramStr="";
    if(param instanceof String||param instanceof Number||param instanceof Boolean){
        //paramStr+="&"+key+"="+encodeURIComponent(param);
        paramStr+="&"+key+"[]="+encodeURIComponent(param);
    }else{
        $.each(param,function(i){
            //var k=key==null?i:key+(param instanceof Array?"["+i+"]":"."+i);
            var k=key==null?i:(param instanceof Array?"["+i+"]":i);
            paramStr+='&'+parseParam(this, k);
        });
    }
    return paramStr.substr(1);
};