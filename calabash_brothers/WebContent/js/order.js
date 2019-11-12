/**
 * 个人订单页面的js
 */

function serch(){
	console.log("1111");
	$.getJSON("order.action",{type:2,status:20},function(data){
		console.log("2222");
		var html="";
		if(data.listVO.length==0){
			html+="<div class='comment_author'><h1>你没有该状态的商品！</h></div>";
			
		}else{
			$.each(data.listVO,function(i,listvo){
				
			});
		}
		
	});
	
}
function c1(oid1){
	$.getJSON("order.action",{oid:oid1,type:30,},function(data){
		console.log("2222");
		if(data.flag){
			this.html("")
		}
	});
}
function c2(oid1){
	$.getJSON("order.action",{oid:oid1,type:40,},function(data){
		console.log("2222");
		if(data.flag){
			console.log("22*22");
		}
	});
}
function c3(oid1){
	$.getJSON("order.action",{oid:oid1,type:50,},function(data){
		console.log("2222");
		if(data.flag){
			console.log("22*22");
		}
	});
}
$(function() {
	var current_user_id = $("#current_user_id").val();
	if (current_user_id == "") {
		return false;
	} else {
		$.post("selectaddress.action", {}, function(result) {
			var html = "<option value='0'>-prov-</option>";
			$.each(result.list, function(i, data) {
				html += "<option value='" + data.id + "'>收货人："
						+ data.rusername + "电话" + data.tel + "地址"
						+ data.area + "-" + data.addres + "</option>"
			});
			$("#address").html(html);
		}, "json");
	}
});
function sub() {
	var address = $("#address").val();
	var current_user_id = $("#current_user_id").val();
	if (current_user_id == "") {
		alert("请先进行登录！");
		return false;
	}
	if (address == "0") {
		alert("请选择收货地址");
		return false;
	} else {
		$("#form").submit();
	}
}
function att() {
	var current_user_id = $("#current_user_id").val();
	if (current_user_id == "") {
		alert("请先进行登录！");
		return false;
	} else {
		window.location = "attention.action?type=2&&gid=${goodsinfo.id }";
	}
}
function addr() {
	var current_user_id = $("#current_user_id").val();
	if (current_user_id == "") {
		alert("请先进行登录！");
		return false;
	} else {
		window.location = "addraddress.action?type=1&&gid=${goodsinfo.id }";
	}
}
