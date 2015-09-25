<!DOCTYPE html>
<html>
<head>
	<title>我的好友</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/friend/list.css" rel="stylesheet" type="text/css" />
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.friend.list")}
	</div>
	<form id="listForm" action="" method="POST">
		<table id="listTable" class="list">
			<tbody>
				<tr>
					<th style="width:5%"><a name="index" href="javascript:void(0);">序号</a></th>
					<th style="width:10%"><a name="code" href="javascript:void(0);"></a>用户编码</th>
					<th style="width:10%"><a name="username" href="javascript:void(0);"></a>用户名</th>
					<th style="width:5%"><a name="name" href="javascript:void(0);"></a>姓名</th>
					<th style="width:5%"><a name="sexValue" href="javascript:void(0);"></a>性别</th>
					<th style="width:5%"><a name="friendNum" href="javascript:void(0);"></a>好友（数）</th>
					<th style="width:5%"><a name="friendNum" href="javascript:void(0);"></a>记录笔记（数）</th>
					<th style="width:5%"><a name="friendNum" href="javascript:void(0);"></a>发起愿望（数）</th>
					<th style="width:10%"><a name="operate" href="javascript:void(0);"></a>操作</th>
				</tr>
				[#list friendBeanlist as friendBean]
					<tr>
						<td>${friendBean.index}</td>
						<td>${friendBean.code}</td>
						<td>
							<a style="color:blue;" href="../user/view.jhtml?username=${friendBean.username}" target="iframe">${friendBean.username}</a>
						</td>
						<td>${friendBean.name}</td>
						<td>${friendBean.sexValue}</td>
						<td>${friendBean.friendNum}</td>
						<td>${friendBean.nodeNum}</td>
						<td>${friendBean.wishNum}</td>
						<td>
							<a href="focus.jhtml?username=${friendBean.username}" target="iframe">添加特别关注</a>
							<a href="delete.jhtml?username=${friendBean.username}" target="iframe">删除好友</a>
						</td>
					</tr>
				[/#list]
			</tbody>
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
