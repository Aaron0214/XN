(function() {
	var height=0;
   function getMainHeight(){
          if(window.innerWidth== undefined){
              var B= document.body, D= document.documentElement;  
              /*height= Math.min(D.clientHeight, B.clientHeight)-60; */ 
              height= Math.min(D.clientHeight, B.clientHeight)-100;
          }else{
                /* height= window.innerHeight-60;*/
        	  height= window.innerHeight-100;
          }
   }
   /*firefox height:100%   无效*/
   getMainHeight();
   $(".main").height(height);
   $("div.panel-group").height(height);
   $(window).resize(function(){
	  getMainHeight();
	  if(height > 161){
		  $(".main").height(height);
		  $("div.panel-group").height(height);
		  //Bug 60778    窗口放大缩小
		  var $iframeBody = $(document.getElementById("iframe").contentWindow.document).find("body");
		  var $iframeHtml = $(document.getElementById("iframe").contentWindow.document).find("html");
          var deviation = $iframeBody.width()-$iframeHtml.width();
          if(($.browser.msie||$.browser.mozilla)&&($iframeHtml.scrollLeft()>deviation)) {
                 $iframeHtml.scrollLeft(deviation);
          }
	  }
   });
})(jQuery);
