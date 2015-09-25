[#assign shiro=JspTaglibs["/WEB-INF/tld/shiro.tld"] /]
<!DOCTYPE html>
<html lang="zh-CN">
<head><meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"><meta name="renderer" content="webkit" />
<link rel="icon" href="${base}/static/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${base}/static/favicon.ico" type="image/x-icon" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>${message("admin.main.title")} - ${message("shop.common.adminCenterAlias")}</title>
<meta name="author" content="Ce Xu" />
<meta name="copyright" content="cexu" />
<link href="${base}/resources/listen/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="${base}/resources/listen/css/common.css" rel="stylesheet" type="text/css" />
<link href="${base}/resources/listen/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table class="head">
		<tr class="headTr">
			<th class="logo">
				<a href="main.jhtml?userType=${userType}">
					<img src="${base}/resources/xnode/images/login/logo.png" alt="Hengtiansoft" />
				</a>
			</th>
			<th>
				<div class="link pull-right">
					<div class="dropdown" >
						<span class="loginName"></span>
						<a id="dLabel" data-toggle="dropdown" href="javascript:void(0)">
							<strong style="font-size:14px">[@shiro.principal /]</strong>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							<li role="menuitem" tabindex="-1"><a href="../role/userEdit.jhtml?name=[@shiro.principal /]" target="iframe" style="color:#fff"><span>${message("admin.main.profile")}</span></a></li>
							<li role="menuitem" tabindex="-1"><a href="../login/logout.jhtml" style="color:#fff"><span>${message("admin.main.logout")}</span></a></li>
						</ul>
					</div>
				</div>
			</th>
		</tr>
	</table>
	<table class="main" style="height:100%">
		<tr id="menuTr">
			<td id="menu" class="menu">
				<div class="panel-group" id="accordion" >
					<div class="panel panel-default">
					    [#list ["listen:addMachine", "listen:editMachie","listen:deleteMachine"] as permission]
						<div class="panel-heading">
							<h4 class="panel-title">
       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="mouse">
          							<span class="machineNav"></span>${message("listen.main.machineTitle")}<span class="navIcon"></span>
      							</a>
     	 					</h4>
						</div>
						[#break /]
						[/#list]
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<dl>
									[#list ["listen:addMachine", "listen:editMachie","listen:deleteMachine"] as permission]
										[@shiro.hasPermission name = permission]
											<dd><a href="../findError/list.jhtml" target="iframe">${message("listening.findError.manage")}</a></dd>
											[#break /]
										[/@shiro.hasPermission]
									[/#list]
									<dd><a href="../findError/view.jhtml" target="iframe">${message("listening.findError.view")}</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						[#list ["listen:search","listen:insert","listen:update","listen:delete","listen:addDataBase","listen:editDataBase","listen:deleteDataBase"] as permission]
							[@shiro.hasPermission name = permission]	
							<div class="panel-heading">
								<h4 class="panel-title">
	       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="mouse">
	          							<span class="sqlNav"></span>${message("listen.main.sqlTitle")}<span class="navIcon"></span></a>
	     	 					</h4>
							</div>
							[#break /]
							[/@shiro.hasPermission]
						[/#list]
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									[#list ["listen:addDataBase","listen:editDataBase","listen:deleteDataBase"] as permission]
									[@shiro.hasPermission name = permission]
										<dd><a href="../sqlOperate/list.jhtml" target="iframe">数据库</a></dd>
										[#break /]
									[/@shiro.hasPermission]
									[/#list]
									[#list ["listen:search","listen:insert","listen:update","listen:delete"] as permission]
									[@shiro.hasPermission name = permission]
										<dd><a href="../sqlOperate/view.jhtml" target="iframe">${message("listening.sqlOperate.operate")}</a></dd>
										[#break /]
									[/@shiro.hasPermission]
									[/#list]
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						[#list ["listen:roleAdd","listen:roleEdit","listen:roleDelete","listen:peopleAdd","listen:peopleEdit","listen:peopleDelete"] as permission]
							[@shiro.hasPermission name = permission]
							<div class="panel-heading">
								<h4 class="panel-title">
	       							<a data-toggle="collapse" data-parent="#accordion" href="#settlement" class="mouse">
	          							<span class="roleNav"></span>权限管理<span class="navIcon"></span></a>
	     	 					</h4>
							</div>
							[#break /]
							[/@shiro.hasPermission]
						[/#list]
						<div id="settlement" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									[#list ["listen:roleAdd","listen:roleEdit","listen:roleDelete"] as permission]
									[@shiro.hasPermission name = permission]
										<dd><a href="../role/roleView.jhtml" target="iframe">角色管理</a></dd>
										[#break /]
									[/@shiro.hasPermission]
									[/#list]
									[#list ["listen:peopleAdd","listen:peopleEdit","listen:peopleDelete"] as permission]
									[@shiro.hasPermission name = permission]
										<dd><a href="../role/userView.jhtml" target="iframe">用户管理</a></dd>
										[#break /]
									[/@shiro.hasPermission]
									[/#list]
									[@shiro.hasPermission name = "listen:authorities"]
										<dd><a href="../role/authorities.jhtml" target="iframe">权限管理</a></dd>
									[/@shiro.hasPermission]
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						[#list ["listen:webClose"] as permission]
						[@shiro.hasPermission name = permission]
							<div class="panel-heading">
								<h4 class="panel-title">
	       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="mouse">
	          							<span class="webManageNav"></span>网站管理<span class="navIcon"></span></a>
	     	 					</h4>
							</div>
							[#break /]
							[/@shiro.hasPermission]
						[/#list]
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									<dd><a href="../webmanage/view.jhtml" target="iframe">网站管理</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						[#list ["listen:SystemOperate"] as permission]
							[@shiro.hasPermission name = permission]
								<div class="panel-heading">
									<h4 class="panel-title">
		       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="mouse">
		          							<span class="systemNav"></span>系统管理<span class="navIcon"></span></a>
		     	 					</h4>
								</div>
								[#break /]
							[/@shiro.hasPermission]
						[/#list]
						<div id="collapseFour" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									<dd><a href="../codeDict/add.jhtml" target="iframe">${message("listening.codeDict.manage")}</a></dd>
								</dl>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
       							<a data-toggle="collapse" data-parent="#accordion" href="#collapseFive" class="mouse">
          							<span class="otherNav"></span>其他应用<span class="navIcon"></span></a>
     	 					</h4>
						</div>
						<div id="collapseFive" class="panel-collapse collapse">
							<div class="panel-body">
								<dl>
									<dd><a href="http://172.17.128.78/jenkins" target="_blank">jenkins服务器</a></dd>
									[#--<dd><a href="http://172.17.128.78/jenkins" target="iframe">jenkins服务器</a></dd>--]
									<dd><a href="http://172.16.128.167:8081/nagios/" target="_blank">nagios服务器(uat)</a></dd>
									<dd><a href="http://172.16.3.79:88/nagios/" target="_blank">nagios服务器(qa)</a></dd>
								</dl>
							</div>
						</div>
					</div>
				</div>
			</td>
			<td>
				[@shiro.lacksPermission name="supplier:order"]
					<iframe id="iframe" name="iframe" src="index.jhtml" frameborder="0"></iframe>
				[/@shiro.lacksPermission]
				<input type="hidden" value="${userType}" id="userType"/>
			</td>
		</tr>
	</table>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/bootstrap/bootstrap-collapse.js"></script>		
	<script type="text/javascript" src="${base}/resources/xnode/js/common/main.js"></script>
</body>
</html>