(function(){
	
	$("#addForm").validate({
		rules: {
			title: "required",
			content: "required",
		}
	});
	
	$("#reset").click(function(){
		$("#title").val("");
		$("#content").val("");
		$.message("success","重置成功");
	});
	
	
	
})();