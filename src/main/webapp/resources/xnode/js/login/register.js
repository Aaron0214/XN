(function(){
	$("#registerForm").validate({
		rules: {
			password: "required",
			username: "required",
			cPassword: "required",
			email: "email",
			rd_info:"required",
		}
	});
	
	$("#password").focus(function(){
		$(".info-box").removeClass("hidden");
	});
	$("#password").blur(function(){
		$(".info-box").addClass("hidden");
	});
	
	$("#email").focus(function(){
		$(".email-box").removeClass("hidden");
	});
	$("#email").blur(function(){
		$(".email-box").addClass("hidden");
	});
	
	$("#cPassword").blur(function(){
		var cPassword = $("#cPassword").val();
		var password = $("#password").val();
		if(cPassword != password){
			$("#info").removeClass("hidden");
			$("#cPassword").addClass("warn");
		}else{
			$("#info").addClass("hidden");
			$("#cPassword").removeClass("warn");
		}
	});
	
	$("#username").blur(function(){
		var img = document.getElementById("img");
		img.src = "/xnode/resources/xnode/images/loading_icon.gif";
		$("#img").removeClass("hidden");
		$(".r_info").addClass("hidden");
		var username = $("#username").val();
		if(username != ""){
			$.ajax({
				url:"checkUser.jhtml",
				type:"get",
				data:{username:username},
				dataType:"JSON",
				success:function(data){
					if(data == true){
						setTimeout(function() {
							img.src = "/xnode/resources/xnode/images/login/success_img.jpg";
						}, 400);
					}else{
						setTimeout(function() {
							$("#img").addClass("hidden");
							$(".r_info").removeClass("hidden");
						}, 400);
					}
				}
			});
		}else{
			$("#img").addClass("hidden");
			$(".r_info").addClass("hidden");
		}
	});
	
	$("#register").click(function(){
		if($("#rd_info").is(":checked")){
			$("#registerForm").submit();
		}else{
			$.message("warn","请先阅读用户协议！");
		}
	})
})();