(function(){
	// 表单验证
	$("#changeForm").validate({
		rules: {
			oPassword: "required",
			nPassword: "required",
			cPassword: "required",
		}
	});	
	
	$("#cPassword").blur(function(){
		var cPassword = $("#cPassword").val();
		var nPassword = $("#nPassword").val();
		if(cPassword != nPassword){
			$("#info").removeClass("hidden");
			$("#cPassword").addClass("warn");
		}else{
			$("#info").addClass("hidden");
			$("#cPassword").removeClass("warn");
		}
	});
})();