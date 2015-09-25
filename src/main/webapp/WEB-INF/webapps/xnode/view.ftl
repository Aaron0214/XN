<html>
<head>
	<title>node function page</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${base}/resources/xnode/css/xnode/add.css">
	<link rel="stylesheet" href="${base}/resources/lib/jquery-msgbox/css/jquery.msgbox.css">
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo;${message("xnode.node.view")}
	</div>
	<form id="viewForm" action="" method="post">
	
		<div class="title title-box move-left">
			<label>标题</label>
			<textarea class="text-area text" name="title" id="title" readonly="readonly">${nodeBean.title}</textarea>
		</div>
		
		<div class="content">
			<label>内容</label>
			<div class="text-box">
				<textarea class="text-area text" name="content" id="content" readonly="readonly">${nodeBean.content}</textarea>
			</div>
		</div>
		<div>
			<input type="button" class="button" id="return" value="返回" href="../xnode/list.jhtml"/>
		</div>
	</from>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/input.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/xnode/add.js"></script>
</body>
</html>