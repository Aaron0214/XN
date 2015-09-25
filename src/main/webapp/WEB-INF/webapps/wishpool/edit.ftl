[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html style="overflow:hidden;">
<head>
	<title>查看愿望</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/wishpool/list.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/wishpool/mywish.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.wishpool.edit")}
	</div>
	<form id="editForm" action="" method="post">
		<table id="inputTable" class="input">
			<input type="text" class="hidden" name="id" value="${wishPoolBean.id}"/>
			<tr>
				<th>${message("xnode.wishpool.wishtext")}： </th>
				<td>
 					<textarea id="text_area" class="form-input text" name="wishtext" style="width: 254px;">${wishPoolBean.wishText}</textarea>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.wishpool.template")}： </th>
				<td>
					<select class="select" name="template">
						<option [#if "${wishPoolBean.template}" == "1"]selected="selected"[/#if]value="1">
							模板${wishPoolBean.template}
						</option>
						[#--<option value="2"></option>
						<option value="3"></option>--]
					</select>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.wishpool.wishnum")}： </th>
				<td>
					<img src="${base}/resources/xnode/images/wishpool/heart.png"></img>
					${wishPoolBean.wishNum}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.createDate")}： </th>
				<td>
					${wishPoolBean.createDate}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.modifyDate")}： </th>
				<td>
					${wishPoolBean.modifyDate}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.comments")}： </th>
				<td>
					<input type="text" class="form-input text" name="comments" value="${wishPoolBean.comments}"/>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<input type="submit" class="button" id="submit" value="保存"/>
					<input type="button" class="button" id="return" value="返回" onclick="location.href='mywish.jhtml'"/>
				</td>
			</tr>
		</table>
		<div class="msKeimgBox">
			<label class="show">模板效果展示：</label>
			<div class="image">
				[#if "${wishPoolBean.template}" == "1"]
					<div class="template-one">
						<label class="wish-text">${wishPoolBean.wishText}</label>
						<label class="wish-user">[@shiro.principal /]</label>
					</div>
				[/#if]
				[#--[#if "${wishPoolBean.template}" == "2"]
					<div class="template-two">
						<label class="wish-text">${wishPoolBean.wishText}</label>
						<label class="wish-user">[@shiro.principal /]</label>
					</div>
				[/#if]--]
			</div>
		</div>
	</from>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/input.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/wishpool/edit.js"></script>
</body>
</html>