<!DOCTYPE html>
<html>
<head>
	<title>用户编辑界面</title>
	<link href="${base}/resources/xnode/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${base}/resources/xnode/css/user/edit.css" rel="stylesheet" type="text/css" />
</head>
<body [@flash_message /]>
	<div class="path">
		<a href="/xnode/common/index.jhtml">${message("xnode.path.index")}</a>&raquo; ${message("xnode.user.edit")}
	</div>
	<form id="editForm" action="update.jhtml" method="POST">
		<table id="inputTable" class="input">
			<tr>
				<th>${message("xnode.user.username")}：</th>
				<td>
					<input class="form-input" name="username" value="${userBean.username}" style="border: 0px;font-size: 14px;"/>
					<input type="text" name="id" value="${userBean.id}" class="hidden"/>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.code")}：</th>
				<td>
					<label class="form-input" name="code">${userBean.code}</label>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.name")}：</th>
				<td>
					<input type="text" class="form-input text" name="name" value="${userBean.name}"/>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.sex")}：</th>
				<td>
					<input type="radio" name="sex" value="0" [#if "${userBean.sex}" == 0]checked="checked"[/#if]/>男
					<input type="radio" style="margin-left:20px;" name="sex" value="1" [#if "${userBean.sex}" == 1]checked="checked"[/#if]/>女
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.birth")}：</th>
				<td>
					<input type="text" name="birth" class="form-input text" value="${userBean.birth}" onfocus="WdatePicker();" autocomplete="off"/>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.birthPlace")}：</th>
				<td>
					<select class="form-select text" id="bir_province" name="birProvinceCode" >
						<option value="">请选择...</option>
						[#list list.birProvinceList as CodeDictBean]
							<option value="${CodeDictBean.code}" [#if "${CodeDictBean.code}"=="${userBean.birProvinceCode}"]selected="selected"[/#if]>
								${CodeDictBean.value}
							</option>
						[/#list]
					</select>
					
					<select class="form-select text" id="bir_city" name="birCityCode">
						<option value="">请选择...</option>
						[#list list.birCityList as CodeDictBean]
							<option value="${CodeDictBean.code}" [#if "${CodeDictBean.code}"=="${userBean.birCityCode}"]selected="selected"[/#if]>
								${CodeDictBean.value}
							</option>
						[/#list]
					</select>
					<select [#if "${userBean.birTownCode}"]class="form-select text"[/#if] class="form-select text hidden" id="bir_town" name="birTownCode" value="${userBean.birTownCode}">
						<option value="">请选择...</option>
						[#list list.birTownList as CodeDictBean]
							<option value="${CodeDictBean.code}" [#if "${CodeDictBean.code}"=="${userBean.birTownCode}"]selected="selected"[/#if]>
								${CodeDictBean.value}
							</option>
						[/#list]
					</select>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.user.address")}：</th>
				<td>
					<select class="form-select text" id="province" name="province">
						<option value="">请选择...</option>
						[#list list.provinceList as CodeDictBean]
							<option value="${CodeDictBean.code}" [#if "${CodeDictBean.code}"=="${userBean.province}"]selected="selected"[/#if]>
								${CodeDictBean.value}
							</option>
						[/#list]
					</select>
					
					<select class="form-select text" id="city" name="city">
						<option value="">请选择...</option>
						[#list list.cityList as CodeDictBean]
							<option value="${CodeDictBean.code}" [#if "${CodeDictBean.code}"=="${userBean.city}"]selected="selected"[/#if]>
								${CodeDictBean.value}
							</option>
						[/#list]
					</select>
					
					<select [#if "${userBean.town}"]class="form-select text"[/#if] class="form-select text hidden" id="town" name="town">
						<option value="">请选择...</option>
						[#list list.townList as CodeDictBean]
							<option value="${CodeDictBean.code}" [#if "${CodeDictBean.code}"=="${userBean.town}"]selected="selected"[/#if]>
								${CodeDictBean.value}
							</option>
						[/#list]
					</select>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.createDate")}：</th>
				<td>
					<label class="form-input" name="createDate">${userBean.createDate}</label>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.modifyDate")}：</th>
				<td>
					<label class="form-input" name="modifyDate">${userBean.modifyDate}</label>
				</td>
			</tr>
			<tr>
				<th>${message("xnode.common.comments")}：</th>
				<td>
					<input type="text" name="comments" class="form-input text" value="${userBean.comments}"/>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<input type="submit" class="button" id="submit" value="保存"/>
					<input type="button" class="button" id="return" onclick="location.href='view.jhtml?username=${userBean.username}'" value="返回"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="${base}/resources/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqtools/jquery.tools.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqvalidate/jquery.validate.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/jqautocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${base}/resources/lib/datepicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/common.js"></script>
	<script type="text/javascript" src="${base}/resources/xnode/js/user/edit.js"></script>
</body>
</html>
