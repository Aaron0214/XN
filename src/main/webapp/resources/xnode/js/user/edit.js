(function(){
	
	$("#bir_province").change(function(){
		var code = $("#bir_province").val();
		$("#bir_town").addClass("hidden");
		$.ajax({
			url:"getDistrictList.jhtml",
			type:"get",
			data:{code:code},
			dataType:"JSON",
			success:function(data){
				$("#bir_city").empty();
				$("#bir_city").append('<option value="">请选择...</option>');
				$.each(data,function(i,item){
					$("#bir_city").append('<option style="width:90px;" value="'+ item.code +'">'+ item.value +'</option>');
				});
			}
		});
	});
	$("#bir_city").change(function(){
		var code = $("#bir_city").val();
		$.ajax({
			url:"getDistrictList.jhtml",
			type:"get",
			data:{code:code},
			dataType:"JSON",
			success:function(data){
				$("#bir_town").empty();
				if(data != null && data.length > 0){
					$("#bir_town").removeClass("hidden");
					$("#bir_town").append('<option value="">请选择...</option>');
					$.each(data,function(i,item){
						$("#bir_town").append('<option value="'+ item.code +'">'+ item.value +'</option>');
					});
				}
			}
		});
	});
	
	$("#province").change(function(){
		var code = $("#province").val();
		$("#town").addClass("hidden");
		$.ajax({
			url:"getDistrictList.jhtml",
			type:"get",
			data:{code:code},
			dataType:"JSON",
			success:function(data){
				$("#city").empty();
				$("#city").append('<option value="">请选择...</option>');
				$.each(data,function(i,item){
					$("#city").append('<option style="width:90px;" value="'+ item.code +'">'+ item.value +'</option>');
				});
			}
		});
	});
	$("#city").change(function(){
		var code = $("#city").val();
		$.ajax({
			url:"getDistrictList.jhtml",
			type:"get",
			data:{code:code},
			dataType:"JSON",
			success:function(data){
				$("#town").empty();
				if(data != null && data.length > 0){
					$("#town").removeClass("hidden");
					$("#town").append('<option value="">请选择...</option>');
					$.each(data,function(i,item){
						$("#town").append('<option value="'+ item.code +'">'+ item.value +'</option>');
					});
				}
			}
		});
	});
	
})();