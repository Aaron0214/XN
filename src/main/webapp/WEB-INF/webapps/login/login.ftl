<!DOCTYPE html>
<html>
<head>
	<title>欢迎登录本系统</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${base}/resources/xnode/css/login/login.css"/>
</head>
<body [@flash_message /]>
	<form id="loginForm" action="" method="post">
		<div>
			<div class="main-box">
				<div class="text-box">
					<label>登  录</label>
				</div>
				<div class="username-box">
					<div style="text-align: left; margin-left: 48px;">
						<label>用户名</label>
					</div>
					<div style="margin-top: 5px;">
						<input type="text" id="username" name="username" class="form-input text"/>
					</div>
				</div>
				<div class="password-box">
					<div style="text-align: left; margin-left: 48px;">
						<label>密码</label>
					</div>
					<div style="margin-top: 5px;">
						<input type="password" id="password" name="password" class="form-input text"/>
					</div>
				</div>
				<div class="four-part">
					<input type="checkBox" id="reminder" /><a class="reminder_user">记住用户</a> 
					<a href="getPassword.jhtml" style="margin-left: 85px;">忘记密码？</a>
				</div>
				<input type="button" class="login-btn" id="login" value="登  录"/>
				<div class="register-part">
					<a href="register.jhtml">注册账号</a>
				</div>
			</div>
		</div>
		<div class="footer-box">
			<a>COPYRIGHT © 2015 XuCe ALL RIGHTS RESERVED.</a>
		</div>
	</form>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/input.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/login/login.js"></script>
</body>
</html>