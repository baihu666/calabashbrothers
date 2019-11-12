

function tupian() {
	console.log("headimg");
 	$.getJSON("updateuser.action",{type:1},function(data){
	console.log(data);
	if (data.flag=="ture") {
		var html = "1";
		$("#headimg").html(html);
	}else{
		$("#headimg").html("图片上传错误");
	}
})
}

function nameBlur(userName) {
	console.log(userName)
	$.post("check.action",{name:userName},function(result){
		console.log(result.flag);
		if (result=="true") {
			$("#n").html("用户名已存在")
		}else{
			$("#n").html("")
		}
	})
}
function check() {
	var name = $("#name").val();
	var pass1 = $("#pass1").val();
	var pass2 = $("#pass2").val();
	var name_exit = $("#n").html();
	var age = $("#age").val();
	if (name=="") {
		alert("用户名不能为空");
		return false;
	}
	if (pass1=="") {
		alert("密码不能为空");
		return false;
	}
	if(name_exit!=""){
		alert("用户名已存在");
	}
	if (age=="") {
		alert("年龄不能为空")
	}
	if (pass1==pass2) {
		var flag = confirm("确定提交？");
		if(flag){
			$("#form1").submit();
		}else{
			return false;
		}
	} else {
		alert("密码不同");
		
		return false;
	}
}
//创建省列表
$(function(){
	$.post("provcityarea.action",{type:1},function(result){
		console.log(result);
		var html = "<option value='0'>-prov-</option>";
		//将集合遍历在一个html中
		$.each(result.list,function(i,data){
			html +="<option value='"+data.provinceId+"'>"+data.province+"</option>"
		});
		//将HTML放入到页面中
		$("#provincedId").html(html);
	},"json");
});

//显示出所有的市
function showCity(pid) {
	$.post("provcityarea.action",{type:2,provinceId:pid},function(result){
		console.log(result);
		var html="<option value = '0'>-city-</option>";
		//遍历list加载进html中
		$.each(result.list,function(i,data){
			html += "<option value = '"+data.cityID+"'>"+data.city+"</option>"
		});
		//将html加载到页面中
		$("#cityId").html(html);
	},"json");
	//将区县列表清空
	showArea(0);
}
//显示出cityid对应的所有去心啊
function showArea(cid) {
	$.post("provcityarea.action",{type:3,cityID:cid},function(result){
		console.log(result);
		var html = "<option value= '0'>-area-</option>";
		//遍历
		$.each(result.list,function(i,data){
			html += "<option value= '"+data.areaID+"'>"+data.area+"</option>"
		});
		$("#areaId").html(html);
	},"json");
}


