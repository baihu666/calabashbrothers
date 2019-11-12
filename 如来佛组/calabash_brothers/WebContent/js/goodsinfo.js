/**
 * 详情的js 
 */
var current_user_id;
$(function(){
	current_user_id = $("#current_user_id").val();
	comment_select();
});
/**
 * 查询当前商品的所有评论信息
 */
function comment_select(){
	var id = $("#gid").val();
	console.log(id);
	//使用json的方式，获取到评论列表
	$.getJSON("comment.action",{type:1,gid:id},function(data){
		var html = "";
		if(data.list.length==0){
			html += "<div class='comment_author'>还没有人</div>";
			html += "<div class='comment_text'>快来抢沙发</div>";
		}else{
			$.each(data.list,function(i,comment){
				html += "<div class='comment_author'><span>"+(i+1)+"楼</span><span>"+comment.userName+"</span><span>"+comment.dateTimeStr+"</span>";
				if(current_usr_id!=null&&current_user_id==comment.uid){
					html += "<span class='comment_delete' onClick='comment_delete("+Comment.id+","+comment.gid+")'>删除</span>"
				}
				html += "</div>";
				html += "<div class='comment_text'>"+comment.content+"</div>";
			});
		}
		console.log(html);
		$("#comment").html(html);
	});
}
/**
 * 在用户评论前进行一次检查
 */
function check(){
	var content = $("#comment_content").val();
	var uid = $("#uid").val();
	return false;
}
	if(content==""){
		alert("content is not null");
		return false;
	}
	if(uid==""){
		alert("user id is not null");
		return false;
	}
	return true;
	
	

function comment_submit(){
		var gid_param = $("#gid").val();
		var uid_param = $("#current_user_id").val();
		var content_param = $("#comment_content").val();
		console.log(gid_param);
		console.log(uid_param);
		console.log(contnet_param);
		if(check()){
			$.getJSON("comment.action",{type:2,gid:gid_param,uid:uid_param,content:content_param},function(data){
				var flag = data.flag;
				console.log(flag);
				//刷新窗体，将所有评论展示出来
				comment_select();
				//将内容框清空
				$("#comment_select").val("");
			});
		}
	}
/**
 * 删除评论
 * @param id
 * @param gid
 */
function comm_delete(param1,param2){
	$.getJSON("comment.action",{type:3,id:param1,bid:param2},function(data){
		var flag = data.flag;
		console.log(flag);
		if(flag){
			comment_select();//刷新评论列表
		}
	});
}