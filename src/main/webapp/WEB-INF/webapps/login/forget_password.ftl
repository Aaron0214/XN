<!DOCTYPE html>
<html>
<head>
	<title>注册用户</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${base}/resources/xnode/css/login/login.css"/>
	<link rel="stylesheet" type="text/css" href="${base}/resources/xnode/css/login/register.css"/>
</head>
<body [@flash_message /]>
	<form id="getPasseordForm" action="save.jhtml" method="post">
		<div>
			<div class="header-box">
				<a class="title">XNode系统 | 找回密码</a>
				<a class="login">返回 <span onclick="location.href='login.jhtml'">登陆</span></a>
			</div>
			<div id="nav">
				<div class="nav-2"></div>
			</div>
			<div class="center-box">
				<table id="registerTable" class="input">
					<tr>
						<th>用户名:</th>
						<td>
							<input type="text" class="form-text text" name="username" id="username" autocomplete="off" required/>
							<div class="info-username" style="display: inline-block;"></div>
							<div class="checkuser-box">
								<lable class="r_info hidden">该用户名不存在！</label>
							</div>
						</td>
					</tr>
					<tr>
						<th>邮箱:</th>
						<td>
							<input type="text" class="form-text text" name="email" id="email" autocomplete="off" required/>
							<div class="info-email" style="display: inline-block;"></div>
							<div class="email-box hidden">
								<label class="p_info">请输入一个有效的邮箱地址，如：abc@126.com</label>
								<label class="info-img"></label>
							</div>
						</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th></th>
						<td>
							<input type="button" class="register" id="getPassword" value="找 回 密 码"/>
						</td>
					</tr>
				</table>
			</div>
			<div class="footer-box">
				<a>COPYRIGHT © 2015 XuCe ALL RIGHTS RESERVED.</a>
			</div>
		</div>
	</form>
	<div class="hidden" id="check-dialog">
		<table class="input">
			<caption>所填邮箱地址与注册邮箱不一致，是否继续？</caption>
		</table>
	</div>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/input.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/login/getPassword.js"></script>
</body>
</html>