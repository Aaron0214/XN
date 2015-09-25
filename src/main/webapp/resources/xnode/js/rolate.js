(function(){
	$.mouseRolate = function(id){
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
				var y = (event.clientY - deltaY);
				if(y <= 69){
					y = 69
				}
				if(y >= 429){
					y = 429
				}
				drag.style.top = y + "px";
				drag.title = y - 249;
				$.shade(y - 69);
				$.rolate(y - 249);
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
	$.shade = function(length){
		var shade = document.getElementById("shade");
		shade.style.height = length + "px";
	}
	
	$.buttonPlace = function(length){
		var drag = document.getElementById("rolate");
		drag.style.top = length + "px";
		drag.title = length - 249;
	}
})();