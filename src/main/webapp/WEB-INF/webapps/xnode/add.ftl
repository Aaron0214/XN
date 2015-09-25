[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<html>
<head>
	<title>node function page</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${base}/resources/xnode/css/xnode/add.css">
	<link rel="stylesheet" href="${base}/resources/lib/jquery-msgbox/css/jquery.msgbox.css">
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo;${message("xnode.node.add")}
	</div>
	<form id="addForm" action="save.jhtml" method="post">
		<input type="text" name="username" value="[@shiro.principal /]" class="hidden"/>
		[#--<div class="title">
			<label>标题</label>
			<div class="title-box border">
				<textarea class="text-area text" id="title"></textarea>
			</div>
		</div>--]
		
		<div class="title title-box move-left">
			<label>标题</label>
			<textarea class="text-area text" name="title" id="title" required></textarea>
		</div>
		
		<div class="content">
			<label>内容</label>
			<div class="text-box">
				<textarea class="text-area text" name="content" id="content" required></textarea>
			</div>
		</div>
		<div>
			<input type="submit" class="button" id="submit" value="保存"/>
			<input type="button" class="button" id="reset" value="重置"/>
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