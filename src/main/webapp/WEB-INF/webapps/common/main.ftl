[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
	<title>xnode 系统</title>
	<style>
		.username-box {
			right: 16px;
			position: absolute;
			font-size: 16px;
			padding-top: 2px;
		}
	</style>
	<link href="${base}/resources/xnode/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table class="head">
		<tr class="headTr">
			<th class="logo">
				<a href="main.jhtml?userType=${userType}">
					欢迎登陆本系统！
					[#--<img src="${base}/resources/xnode/images/login/logo.png" alt="" />--]
				</a>
			</th>
			<th>
				<div class="link pull-right">
					<div class="username-box">
						<span>你好,</span>
						<a href="../user/view.jhtml" id="username" target="iframe">[@shiro.principal /]</a>
						<a href="../login/logout.jhtml" id="logout">退出登陆</a>
					</div>
				</div>
			</th>
		</tr>
	</table>
	<table class="main" style="height:100%;margin-left: 20px;">
		<tr id="menuTr">
			<td id="menu" class="menu">
				<div class="panel-group" style="border: 1px solid #ccc;border-top: 0px;" id="accordion" >
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="../common/index.jhtml" target="iframe" class="mouse">
									<span class="machineNav"></span>首页
								</a>
							</h4>
						</div>
					</div>
					<div class="panel panel-default">
					    [#list ["xnode:addMachine", "xnode:editMachie","xnode:deleteMachine"] as permission]
						<div class="panel-heading">
							<h4 class="panel-title">
       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="mouse">
          							<span class="machineNav"></span>${message("xnode.main.node")}<span class="navIcon"></span>
      							</a>
     	 					</h4>
						</div>
						[#break /]
						[/#list]
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<dl>
									[#list ["xnode:addMachine", "xnode:editMachie","xnode:deleteMachine"] as permission]
										[#--[@shiro.hasPermission name = permission]--]
											<dd><a href="../xnode/list.jhtml?username=[@shiro.principal /]" target="iframe">我的笔记</a></dd>
											[#break /]
										[#--[/@shiro.hasPermission]--]
									[/#list]
									<dd><a href="../xnode/add.jhtml" target="iframe">新建笔记</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="mouse">
          							<span class="matterNav"></span>心愿墙<span class="navIcon"></span></a>
     	 					</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									<dd><a href="../wishpool/list.jhtml" target="iframe">心愿墙</a></dd>
									<dd><a href="../wishpool/mywish.jhtml?username=[@shiro.principal /]" target="iframe">我的愿望</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="mouse">
      							<span class="friendNav"></span>朋友圈<span class="navIcon"></span></a>
     	 					</h4>
						</div>
						<div id="collapseFour" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									<dd><a href="../friend/list.jhtml" target="iframe">我的好友</a></dd>
									<dd><a href="../friend/add.jhtml" target="iframe">添加好友</a></dd>
									<dd><a href="../friend/getMessage.jhtml" target="iframe">好友申请</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
       							<a data-toggle="collapse" data-parent="#accordion" href="#settlement" class="mouse">
          							<span class="memberNav"></span>用户管理<span class="navIcon"></span></a>
     	 					</h4>
						</div>
						<div id="settlement" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									<dd><a href="../user/list.jhtml" target="iframe">用户列表</a></dd>
									<dd><a href="../user/view.jhtml" target="iframe">我的资料</a></dd>
									<dd><a href="../user/changePassword.jhtml" target="iframe">密码更改</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
	   							<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="mouse">
	      							<span class="sqlNav"></span>系统设置<span class="navIcon"></span></a>
	 	 					</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									<dd><a href="../sqlOperate/list.jhtml" target="iframe">角色管理</a></dd>
									<dd><a href="../sqlOperate/list.jhtml" target="iframe">权限设置</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
						</div>
					</div>
				</div>
			</td>
			<td>
				<iframe id="iframe" name="iframe" src="index.jhtml" frameborder="0"></iframe>
				<input type="hidden" value="${userType}" id="userType"/>
			</td>
		</tr>
	</table>
	<table class="footer">
		<tr>
			<th>
				<div class="footer-box">
					<a>COPYRIGHT © 2015 XuCe ALL RIGHTS RESERVED.</a>
				</div>
			</th>
		</tr>
	</table>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/bootstrap/bootstrap-collapse.js"></script>		
	<script type="text/javascript" src="${base}/resources/xnode/js/common/main.js"></script>
</body>
</html>