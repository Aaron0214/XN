<!DOCTYPE html>
<html lang="zh-CN">
<head><meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"><meta name="renderer" content="webkit" /><link rel="icon" href="${setting.shopSiteUrl}/favicon.ico" type="image/x-icon" /><link rel="shortcut icon" href="${setting.shopSiteUrl}/favicon.ico" type="image/x-icon" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>${message("admin.index.title")} - ${message("shop.common.adminCenterAlias")}</title>
<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.input .powered {
	font-size: 11px;
	text-align: right;
	color: #cccccc;
}
</style>
</head>
<body>
	<div class="path">
		系统介绍
	</div>
	<table class="input firstTable">
		<tr>
			<th>
				系统名称:
			</th>
			<td>
				记事本
			</td>
			<th>
				系统版本:
			</th>
			<td>
				V1.0
			</td>
		</tr>
		<tr>
			<th>
				公司地址:
			</th>
			<td>
				<a href="#" target="_blank">暂无</a>
			</td>
			<th>
				论坛系统:
			</th>
			<td>
				<a href="#" target="_blank">暂无</a>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				&nbsp;
			</td>
		</tr>
		<tr>
			<th>
				java版本:
			</th>
			<td>
				${javaVersion}
			</td>
			<th>
				java目录:
			</th>
			<td>
				${javaHome}
			</td>
		</tr>
		<tr>
			<th>
				系统名称:
			</th>
			<td>
				${osName}
			</td>
			<th>
				系统版本:
			</th>
			<td>
				${osArch}
			</td>
		</tr>
		<tr>
			<th>
				服务器信息:
			</th>
			<td>
				${serverInfo}
			</td>
			<th>
				服务器版本:
			</th>
			<td>
				${servletVersion}
			</td>
		</tr>
		<tr>
			<td colspan="4">
				&nbsp;
			</td>
		</tr>
		[#--<tr>
			<td class="powered" colspan="4">
				COPYRIGHT © 2014 XuCe ALL RIGHTS RESERVED.
			</td>
		</tr>--]
	</table>
	<script type="text/javascript" src="${base}/resources/xnode/js/common/index.js"></script>
</body>
</html>
