$(function(){
	$('.index-tab-nav li').click(function(){
		$(this).addClass('active').siblings().removeClass('active')
		$index = $(this).index();
		$('.tab-content').eq($index).show().siblings().hide();
	})
  $('.detail-tab li').click(function(){
    $(this).addClass('active').siblings().removeClass('active')
    $index = $(this).index();
    $('.detail-content-list').eq($index).show().siblings().hide();
  })
	$('.icon-menu').click(function(){
		$('body').addClass('with-panel-left');
		$('.panel-left').show(400);
		$('.panel-left').css('overflow','auto');
		$('.overlay').show();
	})
	$('.overlay').click(function(){
		$('body').removeClass('with-panel-left');
		$(this).hide();
		$('.panel-left').hide(400);
	})
	$(window).scroll(function () {
        if ($(window).scrollTop() >= 50) {
            $('.slide-nav').fadeIn();
        }
        else {
            $('.slide-nav').fadeOut();
        }
    });
    $('.slide-nav').click(function () {
    $('html,body').animate({ scrollTop: 0 }, 500);
    });
    // 切换登录方式
   	$('.go-password-login').click(function(){
   		$('.code-input-wrap').hide();
   		$('.password-input-wrap').show();
   	});
   	$('.go-code-login').click(function(){
   		$('.password-input-wrap').hide();
   		$('.code-input-wrap').show();
   	})
    // 消息中心切换
    $('.message-tab li').click(function(){
      $(this).addClass('active').siblings().removeClass('active');
    });

    $('.cart-min').click(function(){
    var n = $('.cart-button').val();
    var num = parseInt(n)-1;
    if (num == 0) {
      return
    }
    $('.cart-button').val(num)
  })
  $('.cart-max').click(function(){
    $('.cart-min').removeClass('cart-min-disabled');
    var n =$('.cart-button').val();
    var num = parseInt(n)+1;
    $('.cart-button').val(num);
  })
  $('.cart-button').blur(function(){
    var n = $('.cart-button').val();
    if(parseInt(n) <= 0){
      $(".cart-button").val(1);
    }
  })
})