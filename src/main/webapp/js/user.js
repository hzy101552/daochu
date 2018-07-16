var User = function(){
	this.init = function(){
		 // 用于导出excel
		$("#userExport").click(function() {
			var url =  '/export/';
			var params = JSON.stringify(user.acquireInquireData());
			//如果出现中文乱码情况请添加下面这句代码
			/*params = encodeURI(encodeURI(params));
            location.href = url + "?queryJson="+params;*/
		});
	};
	//获取查询条件
	this.acquireInquireData = function(){
		var inquireCondition = {
				name:$('#name').val(),//名称
				sex: $('#sex').val(),//性别
				age: $('#age').val(),//年龄
		};
		return inquireCondition;
	};
}
	
var user;
$(function(){
	user = new User();
	user.init();
});
