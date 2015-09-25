[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
	<title>好友请求</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/friend/list.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/friend/add.css" rel="stylesheet" type="text/css" />
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.friend.message")}
	</div>
	<form id="listForm" action="getMessage.jhtml" method="GET">
		<div class="bar">
			<label>用户名：</label>
			<input type="text" name="username" class="form-input text" value="${username}"/>
			<input type="submit" class="button" id="searchButton" value="${message("xnode.node.search")}">
		</div>
		<table id="listTable" class="list">
			<tbody>
				<tr>
					<th style="width:20%"><a name="message" href="javascript:void(0);"></a>好友请求消息</th>
					<th style="width:10%"><a name="operate" href="javascript:void(0);"></a>操作</th>
					<th style="width:70%"><a name="" href="javascript:void(0);"></a></th>
				</tr>
				[#list messageList as MessageBean]
					<tr>
						<td>
							${MessageBean.senderName} ${MessageBean.message}
						</td>
						<td>
							<a href="agree.jhtml?id=${MessageBean.id}" target="iframe">同意</a>
							<a href="disagree.jhtml?id=${MessageBean.id}" target="iframe">不同意</a>
						</td>
						<td></td>
					</tr>
				[/#list]
			</tbody>
		</table>
	</form>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
</body>
</html>