(function(){
	var str = getCookie("a_clicked");
	var lists = null;
	if(null != str){
		lists = str.split(",");
		$.each($(".input").find("a"),function(i,item){
			$.each(lists,function(j,list){
				if(item.text == list){
					$(item).addClass("change-color");
				}
			});
		});
	}
	
	$(".input").find("a").click(function(){
		$(this).addClass("change-color");
		var item = this;
		var options = {path:"/"};
		
		if(null != lists){
			var ifadd = true;
			$.each(lists,function(i,list){
				if(item.text == list){
					ifadd = false;
					return false;
				}else{
					ifadd = true;
				}
			});
			if(ifadd){
				str += item.text+",";
				addCookie("a_clicked",str,options);
			}
		}else{
			addCookie("a_clicked",this.text+",",options);
		}
	});
})();