(function($){
 	$.extend($.fn, {
 		zTreeCombox: function (options) {
            var op = $.extend({}, options);
            $(this).removeClass("textInput");           
            
            $(this).focus(function(){
                $(this).removeClass("focus");                
            });
            $(this).click($(this).zTreeClick);
                      
            return this.each(function () {
                $(this).after("<div class='treeComboxBtn' refInputId='" + $(this).attr("id") + "' id='btn_" + $(this).attr("name") + "'></div>");
                $("#btn_" + $(this).attr("name")).click($("#btn_" + $(this).attr("name")).zTreeClick);
                $(this).after("<input type='hidden' name='" + $(this).attr("name") + "' id= 'valof_" + $(this).attr("name") + "' value='" + $(this).attr("nodeValue") + "'/>");
                $(this).attr("name", "show_" + $(this).attr("name"));
            });
        },
        zTreeClick: function () {
            if ($("#zTreeComboxContent").length > 0) {
                treeCtl.hideTreeCombox();
                return;
            }
            treeCtl = $(this);
            if (treeCtl.attr("refInputId") != null) {
                treeCtl = $("#" + treeCtl.attr("refInputId"));
            }

            $container = treeCtl.attr("container") ? $("#" + treeCtl.attr("container")) : $("body");
            treeCtl.after("<div id=\"zTreeComboxContent\" class=\"zTreeComboxContent\" style=\"display:none; position: absolute;overflow:auto;\"><ul id=\"treeComboxCtl\" class=\"ztree\" style=\"margin-top:0; width:160px;\"></ul></div>");
            var setting = {
                view: {
                    dblClickExpand: false
                },
                async: {
                    enable: true,
                    url: treeCtl.attr("dataUrl")+"?tmp=" + Math.random(),
                    autoParam: ["id", "name=n", "level=lv"],
                    otherParam: { id: treeCtl.attr("passId"), select_sid: treeCtl.attr("nodeValue"), "state_id": 1 },
                    type: "get"
                },
                callback:{
                    onClick:function (e, treeId, treeNode) {	                       
	                        var ctlObj = treeCtl;
	                        var ctlValueObj = treeCtl.next().next();
	                        ctlObj.attr("value", treeNode.name);
	                        treeCtl.attr("nodeValue", treeNode.id);
	                        ctlValueObj.attr("value", treeNode.id);
	                        treeCtl.hideTreeCombox();
	                        
	                        if(treeCtl.attr("callBack"))
	                        	eval(treeCtl.attr("callBack"));
                    },
                    onAsyncSuccess: function (event, treeId, treeNode, msg) {
                        if (!treeNode) {
                            var treeObj = $.fn.zTree.getZTreeObj("treeComboxCtl");
                            var node = treeObj.getNodeByParam("id", treeCtl.attr("nodeValue"), null);
                            treeObj.selectNode(node);                            
                        }
                    }
                }
                
                /* function (e, treeId, treeNode) {
                        //if (treeNode.isParent == false) {
                            var ctlObj = treeCtl;
                            var ctlValueObj = treeCtl.next().next();
                            ctlObj.attr("value", treeNode.name);
                            treeCtl.attr("nodeValue", treeNode.id);
                            ctlValueObj.attr("value", treeNode.id);
                            treeCtl.hideTreeCombox();
                        //}
                    }*/
                
            };
            $.fn.zTree.init($("#treeComboxCtl"), setting);
            treeCtl.setLocation();
            $("#zTreeComboxContent").slideDown("fast");
            $("#zTreeComboxContent").css("overflow","auto");
            $container.scroll(treeCtl.setLocation);
            $("body").bind("mousedown", treeCtl.onBodyDown);
        },
        setLocation: function (event) {
            var ctlObj = treeCtl;
            var ctlOffset = treeCtl.position();

            var containerLeft = 0;
            var containerTop = 0;

            containerLeft = $container.scrollLeft();
            containerTop = $container.scrollTop();
            $("#zTreeComboxContent").css({"z-index": 9999999, left: (ctlOffset.left + containerLeft) + "px",
                top: ctlOffset.top + containerTop + ctlObj.outerHeight() + "px"
            });
            
        },
        onBodyDown: function (event) {
            if (!(event.target.id == "menuBtn" || event.target.id == "zTreeComboxContent" || $(event.target).parents("#zTreeComboxContent").length > 0)) {
                treeCtl.hideTreeCombox();
            }
        },
        hideTreeCombox: function () {
            $("#zTreeComboxContent").fadeOut("fast", function () {
                $("#zTreeComboxContent").remove();
            });
            $("body").unbind("mousedown", treeCtl.onBodyDown);
            $container.unbind("scroll", treeCtl.setLocation);
        }
	});
})(jQuery);/**
 * @author Roger Wu
 */