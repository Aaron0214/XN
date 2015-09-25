(function(){
	var width=0;
    function getMainWidth(){
          if(window.innerWidth== undefined){
              var B= document.body, D= document.documentElement;  
              width= Math.min(D.clientWidth, B.clientWidth);
          }else{
        	  width = window.innerWidth;
          }
    }
    /*firefox height:100%   无效*/
    getMainWidth();
	var left = parseInt((width/2 - 151)/width * 100); 
	$(".main-box").css("left",left + "%");
	$(window).resize(function(){
		getMainWidth();
		var left = parseInt((width/2 - 151)/width * 100); 
		$(".main-box").css("left",left + "%");
	});
	
	removeCookie("a_clicked",{path:"/"});
	
	$(".four-part").find(".reminder_user").click(function(){
		if($("#reminder").is(":checked")){
			$("#reminder").attr("checked", false);
		}else{
			$("#reminder").attr("checked", true);
		}
	});
	
	var username = getCookie("username");
	if(username != ""){
		$("#username").val(username);
	}
	
	$("#login").click(function(){
		if($("#reminder").is(":checked")){
			addCookie("username",$("#username").val(),{path:"/"});
		}
		$("#loginForm").submit();
	})
	
})(jQuery);