(function(){
	var index = null;
	$.each($("#listForm").find(".template-one"),function(i,item){
		var top = parseInt(item.style.top.substring(0,item.style.top.length-2) == "" ? "0" : item.style.top.substring(0,item.style.top.length-2));
		item.style.top = (top == 0 ? 84 + "px" : top + 42 + "px");
		$.mouseDrag(item.id);
		$.Imageview(item.parentNode.className,item.id);
		index = parseInt(item.id.substring(4,item.id.length)) + 1;
	});
	
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
		$.Imageview(parent_calss,id);
		$("#addButton").addClass("disabled");
	});
	
	$("#rolateButton").click(function(){
		$("#cancelButton").removeClass("hidden");
		$("#rolateButton").addClass("hidden");
		$("#addButton").addClass("disabled");
		$("#saveButton").addClass("disabled");
//		$.mouseRolate("drag");
	});
	
	$("#cancelButton").click(function(){
		$("#rolateButton").removeClass("hidden");
		$("#cancelButton").addClass("hidden");
		$("#addButton").removeClass("disabled");
		$("#saveButton").removeClass("disabled");
	});
})();