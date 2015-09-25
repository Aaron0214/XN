[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html style="overflow:hidden;">
<head>
	<title>许愿池</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/wishpool/list.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/wishpool/mywish.css" rel="stylesheet" type="text/css" />
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
		<input type="text" id="username" value = "[@shiro.principal /]" class="hidden"/>
		[#--<div class="tab_view">
			<a [#if "${tabView}" == "list"]class="active"[/#if]>list</a>
			<a [#if "${tabView}" == "map"]class="active"[/#if]>map</a>
			<input type="text" id="tabView" name="tabView" value="${tabView}"class="hidden"/>
		</div>--]
		<!--图库弹出层 开始-->
		<div class="mskeLayBg"></div>
		<div class="mskelayBox">
			<div class="mske_html"></div>
			<div class="img_html"></div>
			<div class="mskeClaose"></div>
		</div>
		<!--图库弹出层 结束-->
		[#list wishList as WishPoolBean]
			<div class="msKeimgBox${WishPoolBean.index}">
				<input type="text" value="${WishPoolBean.id}" class="hidden"/>
				<div class="template-one iename" style="${WishPoolBean.css}" title="${WishPoolBean.wishText}" id="drag${WishPoolBean.index}">
					<label class="wish-text ietext">${WishPoolBean.wishText}</label>
					<label class="wish-user ietext">${WishPoolBean.username}</label>
					<div class="heart_img">
						<img src="${base}/resources/xnode/images/wishpool/heart.png"></img>
						${WishPoolBean.wishNum}
					</div>
				</div>
				<span class="hidden"> 
					<div class="big_image">
						<div class="bigImageBox">
							<label class="big-text ietext">${WishPoolBean.wishText}</label>
							<label class="big-user ietext">${WishPoolBean.username}</label>
						</div>
					</div>
					<div class="heart_img">
						<div class="big_heart_img">
							<img src="${base}/resources/xnode/images/wishpool/heart.png"></img>
							${WishPoolBean.wishNum}
						</div>
					</div>
				</span>
			</div>
		[/#list]
	</form>
	<div class="hidden" id="check-dialog">
		<table class="input">
			<caption>是否发送祝福？</caption>
		</table>
	</div>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/drag.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/viewImage.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/wishpool/list.js"></script>
	
</body>
</html>