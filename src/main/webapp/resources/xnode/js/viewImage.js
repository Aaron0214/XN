(function() {
	
	var map = {};
	
	var value = "";
	var $t_id = null;
	var $l_id = null;
	var ismove = false;
	var isview = true;
	var rolate_degree = 0;
	var click_div = null;
	var isshow = true;
	
	function getNowPosition(id){
		var obj = document.getElementById(id);
		var now_position = {
			left:"",
			top:""
		};
		now_position.left = obj.style.left;
		now_position.top = obj.style.top;
		map[id] = now_position;
	};
	
	function checkIsMove(id){
		var obj = document.getElementById(id);
		if(obj.style.left != map[id].left || obj.style.top != map[id].top){
			ismove = true;
			map[id].left = obj.style.left;
			map[id].top = obj.style.top;
		}else{
			ismove = false;
		}
	};
		
	$.Imageview = function(parent,id,istrue){
		isview = istrue;
		getNowPosition(id);
		
		// 图库弹出层
		$(".mskeLayBg").height($(document).height());
		$(".mskeClaose").click(function() {
			$(".mskeLayBg,.mskelayBox").hide();
			//更新缩略图愿望内容
			if(isview){
				if($("."+ parent).find(".add-test").length != 0){
					value = $("#text-area").val();
					$("#small-text").empty();
					$("#small-text").append(value);
				}
				$("."+ click_div).find(".template-one").css("transform","rotate("+ rolate_degree +"deg)");
			}
		});
		
		
		$("."+ parent).click(function() {
			if(isshow){
				checkIsMove(id);
				if(!ismove){
					if(isview){
						$(".mske_html").html($(this).find("span").html());
						if($("."+ parent).find(".add-test").length != 0){
							$("#text-area").append(value);
						}
						showRolate(id);
						$.mouseRolate("rolate");
					}else{
						$(".mske_html").html($(this).find("span").find(".big_image").html());
						$(".img_html").html($(this).find("span").find(".heart_img").html());
					}
					click_div = parent;
					$(".mskeLayBg").show();
					$(".mskelayBox").fadeIn(300);
				}
			}
		});
	};
	
	$.rolate = function(degree){
		rolate_degree = degree;
		$(".mske_html").css("transform","rotate("+ degree +"deg)");
	}
	
	function showRolate(id){
		var div_id = document.getElementById(id);
		var degree = parseInt(div_id.style.transform.substring(7,div_id.style.transform.length - 4));
		if(isNaN(degree)){
			degree = 0;
		}
		$.shade(degree + 180);
		$.buttonPlace(249 + degree);
		$.rolate(degree);
	}
	
	$.ifshow = function(option){
		isshow = option;
	}
	
	$(".img_html").click(function(){
		var wishId = parseInt($("."+ click_div).find("input").val());
		var username = $("#username").val();
		$.dialog({
			title: "发送确认？",
			content: $("#check-dialog").html(),
			onOk: function($dialog){
				$.ajax({
					type:"post",
					url:"sendWish.jhtml",
					data: {wishId:wishId,username:username},
					dataType: "JSON",
					success: function(data){
						if(data.type == "success"){
							data.content += ",页面将自动刷新";
							$.message(data);
							setTimeout(function() {
								location.reload();
							}, 800);
						}else{
							$.message(data);
						}
					}
				});
			}
		});
	});
})();