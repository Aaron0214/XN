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
				top:135px;
				left:85px;
			}
		</style>
	<![endif]-->
</head>
<body>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.wishpool.mywishlist")}
	</div>
	<form id="listForm" action="mywish.jhtml" method="get">
		<div class="tab_view">
			<a [#if "${tabView}" == "list"]class="active"[/#if]>list</a>
			<a [#if "${tabView}" == "map"]class="active"[/#if]>map</a>
			<input type="text" id="tabView" name="tabView" value="${tabView}"class="hidden"/>
		</div>
		<!-- 图形方式查看 -->
		<div [#if "${tabView}" == "list"]class="main hidden"[/#if] class="main">
			<div class="bar flow">
				<input type="button" class="button" id="refreshButton" onclick="location.reload();" value="${message("xnode.wishpool.refresh")}">
				<input type="button" class="button" id="addButton" value="${message("xnode.wishpool.add")}">
				<input type="button" class="button" id="saveButton" value="${message("xnode.wishpool.save")}">
				[#--<input type="button" class="button" id="rolateButton" value="${message("xnode.wishpool.rolate")}">
				<input type="button" class="button hidden" id="cancelButton" value="${message("xnode.wishpool.sure")}">--]
			</div>
			<!--图库弹出层 开始-->
			<div class="mskeLayBg"></div>
			<div class="mskelayBox">
				<div class="mske_html"></div>
				<div class="rolate-bar">
					<label class="rolate-slip">
						<span class="shade_info">
							<span class="info_t">-180</span>
							<span class="info_c">0</span>
							<span class="info_b">180</span>
						</span>
					</label>
					<label class="rolate-shade" id="shade"></label>
					<input type="button" class="rolate-button" id="rolate"/>
				</div>
				<div class="mskeClaose"></div>
			</div>
			<!--图库弹出层 结束-->
			[#list wishBeanList as WishPoolBean]
				<div class="msKeimgBox${WishPoolBean.index}">
					<input type="text" value="${WishPoolBean.id}" class="hidden"/>
					<div class="template-one iename" style="${WishPoolBean.css}" title="${WishPoolBean.wishText}" id="drag${WishPoolBean.index}">
						<label class="wish-text ietext">${WishPoolBean.wishText}</label>
						<label class="wish-user ietext">[@shiro.principal /]</label>
						<div class="heart_img">
							<img src="${base}/resources/xnode/images/wishpool/heart.png"></img>
							${WishPoolBean.wishNum}
						</div>
					</div>
					<span class="hidden"> 
						<div class="bigImageBox">
							<label class="big-text ietext">${WishPoolBean.wishText}</label>
							<label class="big-user ietext">[@shiro.principal /]</label>
							<div class="big_heart_img">
								<img src="${base}/resources/xnode/images/wishpool/heart.png"></img>
								${WishPoolBean.wishNum}
							</div>
						</div>
					</span>
				</div>
			[/#list]
		</div>
		
		<!-- 列表形式查看 -->
		<div [#if "${tabView}" == "map"]class="list_main hidden"[/#if] class="list_main">
			<div class="bar">
				<label>编号：</label>
				<input type="text" name="code" class="form-input text" style="width:140px;" value="${searchWishBean.code}"/>
				<label>愿望内容：</label>
				<input type="text" name="wishtext" class="form-input text" style="width:140px;" value="${searchWishBean.wishtext}"/>
				<label>开始日期：</label>
				<input type="text" name="startDate" id="startDate" class="form-input text" onfocus="WdatePicker();" value="${searchWishBean.startDate}" autocomplete="off"/>
				<label>结束日期：</label>
				<input type="text" name="endDate" id="endDate" class="form-input text" onfocus="WdatePicker();" value="${searchWishBean.endDate}" autocomplete="off"/>
				<input type="submit" class="button" id="searchButton" value="${message("xnode.node.search")}">
			</div>
			<table id="listTable" class="list">
				<tbody>
					<tr>
						<th style="width:5%"><a name="index" href="javascript:void(0);">序号</a></th>
						<th style="width:10%"><a name="code" href="javascript:void(0);"></a>编号</th>
						<th style="width:20%"><a name="wishText" href="javascript:void(0);"></a>愿望</th>
						<th style="width:15%"><a name="createDate" href="javascript:void(0);"></a>创建日期</th>
						<th style="width:15%"><a name="modifyDate" href="javascript:void(0);"></a>修改日期</th>
						<th style="width:5%"><a name="wishNum" href="javascript:void(0);"></a>获得祝福数</th>
						<th style="width:10%"><a name="operate" href="javascript:void(0);"></a>操作</th>
					</tr>
					[#list wishBeanList as WishPoolBean]
						<tr>
							<td>
								${WishPoolBean.index}
							</td>
							<td>${WishPoolBean.code}</td>
							<td>${WishPoolBean.wishText}</td>
							<td>${WishPoolBean.createDate}</td>
							<td>${WishPoolBean.modifyDate}</td>
							<td>
								${WishPoolBean.wishNum}
								<img src="${base}/resources/xnode/images/wishpool/heart.png"></img>
							</td>
							<td>
								<a href="view.jhtml?id=${WishPoolBean.id}" target="iframe">查看</a>
								<a href="edit.jhtml?id=${WishPoolBean.id}" target="iframe">编辑</a>
							</td>
						</tr>
					[/#list]
				</tbody>
			</table>
		</div>
		
	</form>
	<script>
		var username = "[@shiro.principal /]";
	</script>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/datepicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/drag.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/rolate.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/viewImage.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/wishpool/mywish.js"></script>
</body>
</html>