(function(){
	$("#getPasseordForm").validate({
		rules: {
			username: "required",
			email: "email",
		}
	});
	
	$("#email").focus(function(){
		$(".email-box").removeClass("hidden");
	});
	$("#email").blur(function(){
		if($("#email").val() != ""){
			$(".info-email").empty();
		}
		$(".email-box").addClass("hidden");
	});
	
	$("#username").blur(function(){
		$(".r_info").addClass("hidden");
		var username = $("#username").val();
		if(username != ""){
			$(".info-username").empty();
			$.ajax({
				url:"checkUser.jhtml",
				type:"get",
				data:{username:username},
				dataType:"JSON",
				success:function(data){
					if(data){
						$(".r_info").removeClass("hidden");
					}
				}
			});
		}else{
			$(".r_info").addClass("hidden");
		}
	});
	
	$("#getPassword").click(function(){
		var username = $("#username").val();
		var email = $("#email").val();
		if(username != "" && email != ""){
			$.ajax({
				url:"checkEmail.jhtml",
				type:"get",
				data:{username:username,email:email},
				dataType:"JSON",
				success:function(data){
					if(data){
						$.message("密码已发送到邮箱！");
					}else{
						$.dialog({
							title: "发送确认？",
							content: $("#check-dialog").html(),
							onOk: function($dialog){
								$.ajax({
									type:"post",
									url:"getPwd.jhtml",
									data: {username:username,email:email},
									dataType: "JSON",
									success: function(data){
										$.message(data);
									}
								});
							}
						});
					}
				}
			});
		}else{
			$(".info-username").empty();
			$(".info-email").empty();
			$("#username").addClass("fieldError");
			$(".info-username").append('<label for="username" class="fieldError">必填</label>');
			$("#email").addClass("fieldError");
			$(".info-email").append('<label for="email" class="fieldError">必填</label>');
			$.message("warn","请填必填项！");
		}
	});
})();