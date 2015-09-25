[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html>
	<head>
		<title>笔记列表</title>
		<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${base}/resources/xnode/css/xnode/list.css">
	</head>
	<body [@flash_message /]>
		<div class="path">
			<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.node.list")}
		</div>
		<form id="listForm" action="list.jhtml" method="get">
			<input type="text" name="username" value="[@shiro.principal /]" class="hidden"/>
			<div class="bar">
				<input type="submit" class="button" id="searchButton" value="${message("xnode.node.search")}">
			</div>
			<table id="listTable" class="list">
				<tbody>
					<tr>
						<th style="width:5%"><a name="index" href="javascript:void(0);">序号</a></th>
						<th style="width:20%"><a name="title" href="javascript:void(0);"></a>标题</th>
						<th style="width:20%"><a name="content" href="javascript:void(0);"></a>内容</th>
						<th style="width:5%"><a name="username" href="javascript:void(0);"></a>创建人</th>
						<th style="width:15%"><a name="createDate" href="javascript:void(0);"></a>创建日期</th>
						<th style="width:15%"><a name="modifyDate" href="javascript:void(0);"></a>修改日期</th>
						<th style="width:10%"><a name="operate" href="javascript:void(0);"></a>操作</th>
					</tr>
					[#list nodeListBean.list as NodeBean]
						<tr>
							<td>
								${NodeBean.index}
							</td>
							<td>${NodeBean.title}</td>
							<td>${NodeBean.content}</td>
							<td>${NodeBean.username}</td>
							<td>${NodeBean.createDate}</td>
							<td>${NodeBean.modifyDate}</td>
							<td>
								<a href="view.jhtml?id=${NodeBean.id}" target="iframe">查看</a>
								<a href="edit.jhtml?id=${NodeBean.id}" target="iframe">修改</a>
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
		<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
		<script type="text/javascript" src="${base}/resources/xnode/js/input.js"></script>
		<script type="text/javascript" src="${base}/resources/xnode/js/list.js"></script>
		<script type="text/javascript" src="${base}/resources/xnode/js/xnode/list.js"></script>
	</body>
</html>