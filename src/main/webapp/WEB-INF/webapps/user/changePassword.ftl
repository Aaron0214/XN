[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
	<title>修改密码界面</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/user/change.css" rel="stylesheet" type="text/css" />
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.user.changePassord")}
	</div>
	<form id = "changeForm" action="change.jhtml" method = "post">
		<table id="inputTable" class="input">
			<tr>
				<th><span class="requiredField">*</span>${message("xnode.user.oPassord")}： </th>
				<td>
					<input type="text" class="hidden" name="username" value="[@shiro.principal /]"/>
 					<input type="password" class="form-input text" name="opassword" id="oPassword" required/>
				</td>
			</tr>
			<tr>
				<th><span class="requiredField">*</span>${message("xnode.user.nPassord")}： </th>
				<td>
					<input type="password" class="form-input text" name="npassword" id="nPassword" required/>
				</td>
			</tr>
			<tr>
				<th><span class="requiredField">*</span>${message("xnode.user.cPassord")}： </th>
				<td>
					<input type="password" class="form-input text" id="cPassword" required/>
					<label id="info" class="information hidden">*${message("xnode.user.notEquel")}</label>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<input type="submit" class="button" id="submit" value="保存"/>
					<input type="button" class="button" id="reset" value="返回"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/user/change.js"></script>
</body>
</html>