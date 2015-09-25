[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
	<title>祝福我的人</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/wishpool/well_wisher.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.wishpool.list")}
	</div>
	<form id="" action="" method="get">
		<table id="inputTable" class="input">
			<tbody>
				<tr>
					<th>祝福来自：</th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<a href="../user/edit.jhtml?username=abc">abc</a>
						<a href="">bcd</a>
						<a>abcd</a>
						<a>123</a>
					</td>	
				</tr>
			</tbody>
		</table>
	</form>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/input.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/wishpool/well_wisher.js"></script>
</boby>
</html>