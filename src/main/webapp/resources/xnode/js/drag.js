(function(){
	$.mouseDrag = function(id){
		var drag = document.getElementById(id);
		if (document.attachEvent) {
			drag.attachEvent('onmousedown', dragHandle);
		} else {
			drag.addEventListener('mousedown', dragHandle, false);
		}
		function dragHandle(event) {
			var event = event || window.event;
			var startX = drag.offsetLeft;
			var startY = drag.offsetTop;
			var mouseX = event.clientX;
			var mouseY = event.clientY;
			var deltaX = mouseX - startX;
			var deltaY = mouseY - startY;
			if (document.attachEvent) {
				drag.attachEvent('onmousemove', moveHandle);
				drag.attachEvent('onmouseup', upHandle);
				drag.attachEvent('onlosecapture', upHandle);
				drag.setCapture();
			} else {
				document.addEventListener('mousemove', moveHandle, true);
				document.addEventListener('mouseup', upHandle, true);
			}
			function moveHandle(event) {
				var event = event || window.event;
				var x = (event.clientX - deltaX);
				var y = (event.clientY - deltaY);
				if(x<=5){
					x = 5;
				}
				if(x>=865){
					x = 865;
				}
				if(y<=30){
					y = 30;
				}
				if(y>=613){
					y = 613;
				}
				drag.style.left = x + "px";
				drag.style.top = y + "px";
			}
			function upHandle() {
				if (document.attachEvent) {
					drag.detachEvent('onmousemove', moveHandle);
					drag.detachEvent('onmouseup', upHandle);
					drag.detachEvent('onlosecapture', upHandle);
					drag.releaseCapture();
				} else {
					document.removeEventListener('mousemove', moveHandle, true);
					document.removeEventListener('mouseup', upHandle, true);
				}
			}
		}
	};
})();