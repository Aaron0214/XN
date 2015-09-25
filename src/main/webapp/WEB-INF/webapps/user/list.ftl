<!DOCTYPE html>
<html>
<head>
	<title>用户列表</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/user/list.css" rel="stylesheet" type="text/css" />
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.user.list")}
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
					<th style="width:5%"><a name="statusValue" href="javascript:void(0);"></a>状态</th>
					<th style="width:10%"><a name="nodeNum" href="javascript:void(0);"></a>记录笔记数量</th>
					<th style="width:10%"><a name="wishNum" href="javascript:void(0);"></a>发起愿望数量</th>
					<th style="width:10%"><a name="createDate" href="javascript:void(0);"></a>创建日期</th>
					<th style="width:10%"><a name="modifyDate" href="javascript:void(0);"></a>修改日期</th>
					<th style="width:10%"><a name="operate" href="javascript:void(0);"></a>操作</th>
				</tr>
				[#list userBeanList as UserShowBean]
					<tr>
						<td>${UserShowBean.index}</td>
						<td>${UserShowBean.code}</td>
						<td>
							<a style="color:blue;" href="view.jhtml?username=${UserShowBean.username}" target="iframe">${UserShowBean.username}</a>
						</td>
						<td>${UserShowBean.name}</td>
						<td>${UserShowBean.sexValue}</td>
						<td>${UserShowBean.statusValue}</td>
						<td>${UserShowBean.nodeNum}</td>
						<td>${UserShowBean.wishNum}</td>
						<td>${UserShowBean.createDate}</td>
						<td>${UserShowBean.modifyDate}</td>
						<td>
							[#if "${UserShowBean.status}" == "1"]<a href="unlock.jhtml?id=${UserShowBean.id}" target="iframe">解锁</a>
							[#else]<span style="color:#B0AFAF;">解锁<span>[/#if]
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
