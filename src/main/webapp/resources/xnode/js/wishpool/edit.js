(function(){
	$("#text_area").blur(function(){
		$(".msKeimgBox").find(".wish-text").empty();
		$(".msKeimgBox").find(".wish-text").append($("#text_area").val());
	});
})();