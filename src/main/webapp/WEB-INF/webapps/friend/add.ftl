[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
	<title>添加好友</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/friend/list.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/friend/add.css" rel="stylesheet" type="text/css" />
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.friend.add")}
	</div>
	<form id="listForm" action="add.jhtml" method="GET">
		<div class="bar">
			<label>用户名：</label>
			<input type="text" name="username" class="form-input text" value="${username}"/>
			<input type="submit" class="button" id="searchButton" value="${message("xnode.node.search")}">
		</div>
		<table id="listTable" class="list">
			<tbody>
				<tr>
					<th style="width:10%"><a name="username" href="javascript:void(0);"></a>用户名</th>
					<th style="width:10%"><a name="level" href="javascript:void(0);"></a>等级</th>
					<th style="width:10%"><a name="operate" href="javascript:void(0);"></a>操作</th>
					<th style="width:80%"><a name="" href="javascript:void(0);"></a></th>
				</tr>
				[#list nonFriendList as FriendAddBean]
					<tr>
						<td>
							${FriendAddBean.username}
						</td>
						<td>
							${FriendAddBean.level}
						</td>
						<td>
							[#if "${FriendAddBean.isSendMessage}" == "Y"]<span style="color: #B0AFAF;">已发送</span>[/#if]
							[#if "${FriendAddBean.isSendMessage}" == "N"]<a href="addFriend.jhtml?username=${FriendAddBean.username}" target="iframe">加为好友</a>[/#if]
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
	<script type="text/javascript" src="${base}/resources/xnode/js/friend/add.js"></script>
</body>
</html>
