[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
	<title>用户编辑界面</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/user/view.css" rel="stylesheet" type="text/css" />
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.user.edit")}
	</div>
	<form id="viewForm" action="" method="POST">
		[#if "${currentUser}" == "${userBean.username}"]
			<div class="edit-box">
				<a class="edit_button" href="edit.jhtml?username=${userBean.username}"></a>
			</div>
		[/#if]
		<table id="inputTable" class="input">
			<tr>
				<th>${message("xnode.user.username")}：</th>
				<td>
					${userBean.username}
					<input type="text" name="id" value="${userBean.id}" class="hidden"/>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.code")}：</th>
				<td>
					${userBean.code}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.name")}：</th>
				<td>
					${userBean.name}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.sex")}：</th>
				<td>
					[#if "${userBean.sex}" == 0]男[/#if]
					[#if "${userBean.sex}" == 1]女[/#if]
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.birth")}：</th>
				<td>
					${userBean.birth}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.birthPlace")}：</th>
				<td>
					[#if "${userBean.birProvinceValue}" == "" && "${userBean.birCityCodeValue}" =="" && "${userBean.birTownCodeValue}" == ""]暂无[/#if]
					${userBean.birProvinceValue}&nbsp;&nbsp;${userBean.birCityCodeValue}&nbsp;&nbsp;${userBean.birTownCodeValue}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.address")}：</th>
				<td>
					[#if "${userBean.provinceValue}" == "" && "${userBean.cityValue}" =="" && "${userBean.townValue}" == ""]暂无[/#if]
					${userBean.provinceValue}&nbsp;&nbsp;${userBean.cityValue}&nbsp;&nbsp;${userBean.townValue}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.createDate")}：</th>
				<td>
					${userBean.createDate}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.modifyDate")}：</th>
				<td>
					${userBean.modifyDate}
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.comments")}：</th>
				<td>
					[#if "${userBean.comments}" == ""]无[/#if] 
					${userBean.comments}
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/datepicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
</body>
</html>
