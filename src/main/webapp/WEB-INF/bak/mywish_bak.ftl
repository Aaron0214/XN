[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html style="overflow:hidden;">
<head>
	<title>许愿池</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/wishpool/list.css" rel="stylesheet" type="text/css" />
	<!--[if IE]>
		<style type="text/css">
			.iename{
				margin:-20px 0 0 -20px;
			}
			.ietext{
				margin:125px 90px 90px 130px;
			}
		</style>
	<![endif]-->
</head>
<body>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.wishpool.list")}
	</div>
	<from id="listForm" action="" method="post">
		<div class="bar">
			<input type="button" class="button" id="addButton" value="${message("xnode.wishpool.add")}">
			<input type="button" class="button" id="saveButton" value="${message("xnode.wishpool.save")}">
		</div>
		<div class="main">
			<!--图库弹出层 开始-->
			<div class="mskeLayBg"></div>
			<div class="mskelayBox">
				<div class="mske_html"></div>
				<div class="rolate-bar">
					<label class="rolate-slip"></label>
					<label class="rolate-shade" id="shade"></label>
					<input type="button" class="rolate-button" id="rolate"/>
				</div>
				<div class="mskeClaose"></div>
			</div>
			<!--图库弹出层 结束-->
			
			<div class="msKeimgBox">
				<div class="template-one wish-back iename" title="希望今年财源滚滚！" id="drag">
					<label class="wish-text ietext">希望今年财源滚滚！</label>
					<label class="wish-user ietext">[@shiro.principal /]</label>
				</div>
				<span class="hidden"> 
					<div class="bigImageBox">
						<label class="big-text ietext">希望今年财源滚滚！</label>
						<label class="big-user ietext">[@shiro.principal /]</label>
					</div>
				</span>
			</div>
			
			<div class="msKeimgBox1">
				<div class="template-one wish-back1 iename" title="希望今年平平安安！" id="drag1">
					<label class="wish-text ietext">希望今年平平安安！</label>
					<label class="wish-user ietext">[@shiro.principal /]</label>
				</div>
				<span class="hidden"> 
					[#--<img id="img" src="${base}/resources/xnode/images/wishpool/bigimage.png"></img>--]
					<div class="bigImageBox">
						<label class="big-text ietext">希望今年平平安安！</label>
						<label class="big-user ietext">[@shiro.principal /]</label>
					</div>
				</span>
			</div>
			
		</div>
	</form>
	<script>
		var username = "[@shiro.principal /]";
	</script>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jquery-rolate/jquery.rotate.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/drag.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/rolate.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/viewImage.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/wishpool/mywish1.js"></script>
</body>
</html>