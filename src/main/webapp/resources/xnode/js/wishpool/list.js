(function(){
/*	$.mouseDrag("drag");
	$.mouseDrag("drag1");
	$.Imageview("msKeimgBox","drag");
	$.Imageview("msKeimgBox1","drag1");*/
	$.each($("#listForm").find(".template-one"),function(i,item){
		$.mouseDrag(item.id);
		$.Imageview(item.parentNode.className,item.id,false);
	});
	
	$(".heart_img").click(function(){
		var wishId = parseInt(this.parentNode.parentNode.firstElementChild.value);
		var username = $("#username").val();
		$.ifshow(false);
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
						$.ifshow(true);
					}
				});
			},onClose: function(){
				$.ifshow(true);
			}
		});
	});
	
	/*$.dialog({
		title: "选择用户",
		content: $("#select-user-dialog").html(),
		onShow: function($dialog){
			var selectId = $("#userList input").val();
			if(selectId != null && selectId != ""){
				$dialog.find("select").val(selectId);
			}
		},
		onOk: function($dialog){
			var selectId = $dialog.find("select").val();
			var selectName = $dialog.find("select option:selected").html();
			
			insertUser(selectId, selectName);
			
			$.ajax({
				type: "GET",
				url: "getFunctionList.jhtml",
				data: {
					id: selectId
				},
				dataType: "JSON",
				success: function(list){
					$roleBox.empty();
					$listBox.empty();
					$.each(list.nonSelected, function(index, value){
						$roleBox.append('<option value="' + value.id + '">' + value.name + '</option>');
					});
					$.each(list.currentRole, function(index, value){
						$listBox.append('<option value="' + value.id + '">' + value.name + '</option>');
					});
				}
			});
		},
		onClose: function(){
			if($("#userList a").size() == 0) {
				$.message("warn", "请选择一个用户");
				return false;
			}
		}
	})*/
})();
