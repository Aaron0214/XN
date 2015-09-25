//检查是否是查看合同信息
if(window.location.href.indexOf("?") != -1){
	var parameter = window.location.href.split("?")[1];
	if(parameter.indexOf("contractId=")!=-1){
		parameter = parameter.split("&");
		for(var i = 0; i < parameter.length; i++){
			if(parameter[i].indexOf("contractId=")!=-1){
				var contractId = parameter[i].split("=")[1];
				window.location.replace("/xinyunlian-admin/admin/contract/view.jhtml?id="+contractId);
			}
		}
	}
}