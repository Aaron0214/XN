(function(){
	var index = null;
	$.each($("#listForm").find(".template-one"),function(i,item){
		var top = parseInt(item.style.top.substring(0,item.style.top.length-2) == "" ? "0" : item.style.top.substring(0,item.style.top.length-2));
		item.style.top = (top == 0 ? 84 + "px" : top + 42 + "px");
		$.mouseDrag(item.id);
		$.Imageview(item.parentNode.className,item.id,true);
		index = parseInt(item.id.substring(4,item.id.length)) + 1;
	});
	
	/*$.ajax({
		url:"getWishList.jhtml",
		type:"get",
		data:{username:username},
		dataType:"JSON",
		success:function(data){
			$.each(data,function(i,item){
				var parent_calss = "msKeimgBox" + item.index;
				var id = "drag" + item.index;
				var html = '<div class='+ parent_calss +'>'+ 
								'<div class="template-one iename" id='+ id +'"style="'+ item.css +'">' + 
									'<label class="wish-text ietext">'+ item.wishText +'</label>' +
									'<label class="wish-user ietext">'+ username +'</label>' +
								'</div>' +
								'<span class="hidden">' +
									'<div class="bigImageBox">' +
										'<label class="big-text ietext">'+ item.wishText +'</label>' + 
										'<label class="big-user ietext">'+ username +'</label>' +
									'</div>' +
								'</span>' +
							'</div>';
				$("#listForm").find(".main").append(html);
				$.mouseDrag(id);
				$.Imageview(parent_calss,id);
			});
		}
	});*/
	
	$("#addButton").click(function(){
		var parent_calss = "msKeimgBox" + index;
		var id = "drag" + index;
		var html = '<div class='+ parent_calss +'>'+ 
			'<div class="template-one template-back iename"id='+ id +'>' + 
				'<label id="small-text" class="wish-text ietext"></label>' +
				'<label class="wish-user ietext">'+ username +'</label>' +
			'</div>' +
			'<span class="hidden">' +
				'<div class="bigImageBox">' +
					'<textarea id="text-area" class="big-text add-test ietext"></textarea>' + 
					'<label class="big-user ietext">'+ username +'</label>' +
				'</div>' +
			'</span>' +
		'</div>';
		$("#listForm").find(".main").append(html);
		$.mouseDrag(id);
		$.Imageview(parent_calss,id,true);
		$("#addButton").addClass("disabled");
	});
	
	$("#saveButton").click(function(){
		var wishList = {};
		var list = [];
		var i = 0;
		var isOk = false;
		$.each($("#listForm").find(".template-one"),function(i,item){
			var text = $("." + item.parentNode.className).find(".wish-text")[0].textContent;
			var top  = parseInt(item.style.top.substring(0,item.style.top.length-2));
			var css  = item.style.cssText.split("top")[0] + ((top - 42) == 0 ? "":"top:" + (top - 42) +"px;");
			if(text == ""){
				isOk = true;
			}else{
				isOk = false;
			}
			var wishBean = {};
			wishBean.id = $("." + item.parentNode.className).find("input").val();
			wishBean.css = css;
			wishBean.template = "1";
			wishBean.wishText = text;
			wishBean.username = username;
			list[i] = wishBean;
			i++;
		});
		wishList.list = list;
		if(!isOk){
			$.ajax({
				url:"saveWishList.jhtml",
				type:"post",
				data:{wishList:JSON.stringify(wishList)},
				dataType:"json",
				success:function(data){
					$.message(data);
					setTimeout(function() {
						location.reload();
					}, 800);
				}
			});
		}else{
			$.message("warn","亲，您的愿望还没有填写哟！");
			return false;
		}
	});
	
	$(".tab_view").find("a").click(function(){
		$(".tab_view").find(".active").removeClass("active");
		$(this).addClass("active");
		if(this.text == "list"){
			$(".main").addClass("hidden");
			$(".list_main").removeClass("hidden");
			$("#tabView").val("list");
		}else{
			$(".list_main").addClass("hidden");
			$(".main").removeClass("hidden");
			$("#tabView").val("map");
		}
		updateView(this.text);
	});
	
	function updateView(view){
		$.ajax({
			url:"updateView.jhtml",
			type:"post",
			data:{view:view},
			dataType:"JSON",
			success:function(data){
				
			}
		});
	};
	
	$("#rolateButton").click(function(){
		$("#cancelButton").removeClass("hidden");
		$("#rolateButton").addClass("hidden");
		$("#addButton").addClass("disabled");
		$("#refreshButton").addClass("disabled");
		$("#saveButton").addClass("disabled");
	});
	
	$("#cancelButton").click(function(){
		$("#rolateButton").removeClass("hidden");
		$("#cancelButton").addClass("hidden");
		$("#addButton").removeClass("disabled");
		$("#refreshButton").removeClass("disabled");
		$("#saveButton").removeClass("disabled");
	});
	
})();