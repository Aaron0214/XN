<!DOCTYPE html>
<html>
<head>
	<title>注册用户</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${base}/resources/xnode/css/login/login.css"/>
	<link rel="stylesheet" type="text/css" href="${base}/resources/xnode/css/login/register.css"/>
</head>
<body [@flash_message /]>
	<form id="registerForm" action="save.jhtml" method="post">
		<div>
			<div class="header-box">
				<a class="title">XNode系统 | 注册系统账号</a>
				<a class="login">我已有账号，现在就 <span onclick="location.href='login.jhtml'">登陆</span></a>
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
							<div class="checkuser-box">
								<img id="img" style="width:25px;margin-left: 12px;" class="hidden"></img>
								<lable class="r_info hidden">该用户名已经被注册！</label>
							</div>
						</td>
					</tr>
					<tr>
						<th>密码:</th>
						<td>
							<input type="password" class="form-text text" name="password" id="password" required/>
							<div class="info-box hidden">
								<label class="p_info">请输入8~14位有效字符或数字</label>
								<label class="info-img"></label>
							</div>
						</td>
					</tr>
					<tr>
						<th>确认密码:</th>
						<td>
							<input type="password" class="form-text text" id="cPassword" required/>
							<label id="info" class="information hidden">*${message("xnode.user.notEquel")}</label>
						</td>
					</tr>
					<tr>
						<th>邮箱:</th>
						<td>
							<input type="text" class="form-text text" name="email" id="email" autocomplete="off" required/>
							<div class="email-box hidden">
								<label class="p_info">请输入一个有效的邮箱地址，如：abc@126.com</label>
								<label class="info-img"></label>
							</div>
						</td>
					</tr>
					<tr>
						<th></th>
						<td style="line-height: 15px;">
							<input type="checkBox" id="rd_info" required/>我已阅读
							<a target="_blank" href="userAgreement.jhtml">《XNode用户协议》</a>
						</td>
					</tr>
					<tr>
						<th></th>
						<td>
							<input type="button" class="register" id="register" value="注 册"/>
						</td>
					</tr>
				</table>
			</div>
			<div class="footer-box">
				<a>COPYRIGHT © 2015 XuCe ALL RIGHTS RESERVED.</a>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/input.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/login/register.js"></script>
</body>
</html>