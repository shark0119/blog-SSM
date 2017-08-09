<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- <%@include file="/common/taglibs.jsp" %>
${jquery} 
${bootstrap} 
${style} 
${font-awesome} 
${precomposed} 
${shortcuticon} 
${summernote_css }
${summernote_js }
${summernote-zh-CN_js }
${bootstrap_js }
${admin-scripts_js }
${html5shiv }
${respond }
${selectivizr } --%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/style.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="${ctx }/resources/blog/back/images/icon/icon.png">
<link rel="shortcut icon" href="${ctx }/resources/blog/back/images/icon/favicon.ico">
<script src="${ctx }/resources/blog/back/js/jquery-2.1.4.min.js"></script>
<script src="${ctx }/resources/blog/back/js/bootstrap.min.js"></script> 
<script src="${ctx }/resources/blog/back/js/admin-scripts.js"></script> 


      <form action="" method="post" >
        <h1 class="page-header">操作</h1>
        <ol class="breadcrumb">
          <li><a href="runAddMsg">发消息</a></li>
        </ol>
     
        <div class="table-responsive">
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th><span class="glyphicon glyphicon-th-large"></span> <span class="visible-lg">选择</span></th>
                <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">发件人</span></th>
                 <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">标题</span></th>
                <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">日期</span></th>
                <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${listMsg }" var="msg">
              <tr>
                <td class="first"><input type="checkbox" class="input-control" name="checkbox[]" value="${msg.id }" /></td>
                <td class="article-title">${msg.sendId }</td>
                <td class="article-title">${msg.title }</td>
                <td>${msg.time }</td>
                <td> <a href="javascript:del(${msg.id});">删除</a><a href="runAddMsg?receiveId=${msg.sendId }">回复</a></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <footer class="message_footer">
          <nav>
            <div class="btn-toolbar operation" role="toolbar">
              <div class="btn-group" role="group"> <a class="btn btn-default" onClick="select()">全选</a> <a class="btn btn-default" onClick="reverse()">反选</a> <a class="btn btn-default" onClick="noselect()">不选</a> </div>
              <div class="btn-group" role="group">
                <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="删除全部选中" name="checkbox_delete" id="checkbox_delete">删除</button>
              </div>
            </div>
            <ul class="pagination pagenav">
              <li class="disabled" onclick="javascript:pagelist(${page-1});"><a aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li>
              <li class="active"><a id="page">${page }</a></li>
              <li class="disabled" onclick="javascript:pagelist(${page+1});"><a aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a> </li>
            </ul>
          </nav>
        </footer>
      </form>
 
	<div id="myAlert" class="alert alert-success" style="width: 300px;position: fixed;left:30%;top:50px;">
		<a href="#" class="close" data-dismiss="alert">&times;</a>
		<strong>发送成功！</strong><span id="alertRec">${receiveId }</span>已收到。
	</div>
	
 <div id="modalfade" class="modalfade" style="display: none;">
 	<div class="cur_move" node-type="handle" style="cursor: move;">
 		<a node-type="close" href="javascript:hidden();" class="layerbox_close">×</a>
 	</div>
  <div class="modal-dialog" role="document">
   	<div><div id="span_div"><span style="font-family: fantasy;font-size: 18px">标题：</span></div><div id="title1"></div></div>
   <div id="content1"></div>
  </div>
</div> 

<style>
html body{
	padding: 0;
}
	#span_div{
		width:70px;
	}
	#title1{
		float:left;
		width:400px;
		font-size:16px;
		text-align: left;
		margin-left: 80px;
		margin-top: -25px;
	}
	#content1{
		margin-top:20px;
	}
	.modalfade{
		width:700px;
		height:500px;
		border: thick;
		border-bottom-color: #eeeeee;
		position: fixed;
		left:20%;
		top:20%;
		background-color: #f5f5f5;
	}
	.cur_move{
		width: 40px;
		height: 40px;
		position: relative;
		background-color: white;
		margin-left: 660px;
	}
	.layerbox_close{
		display:inline-block;
		font-size: 40px;
		text-align: center;
		margin-left:5px;
		margin-top: -7px;
	}
</style>



<script>
	if($("#alertRec").html()==null||$("#alertRec").html()==""){
				$("#myAlert").hide();
			}else{
				$("#myAlert").show("slow");
				setTimeout(function(){$("#myAlert").fadeOut("slow");},3000);
			}
$(function(){ 
	  
	$("#checkbox_delete").click(function(){
			var checked="";
			$("input[name='checkbox[]']:checked").each(function(){
					checked+=$(this).val()+",";
				});
			
			if(checked==""){
				alert("请先选择！");
				return false;
			}
			if(confirm("你确定要删除吗?")){
				$.post("${ctx}/message/delAll",{"id":checked},function(data){
				
						location.reload();
					
				},"json");
			}
			
			
			
			$(".close").click(function(){
				$("#myAlert").alert();
			});
	});
	
	
	$("tbody tr td:not(.first)").click(function(){
		var id=$(this).parent().find("input").val();
		$.post("${ctx}/message/getMsg",{"id":id},function(data){
			$("#title1").html(data.title);
			$("#content1").html(data.content);
			$("#modalfade").fadeIn("slow");
		},"json");
		
	});
		   
});

function pagelist(page){
		if(page<1){
			return;
		}else{
			location="${ctx}/message/getMsgList?page="+page;
		}
}
function del(id){
	if(window.confirm("此操作不可逆，是否确认？")){
		$.post("message/delMsg",{"id":id},function(data){
			location.reload();	
		},"json");
	}
}
function hidden(){
	$("#modalfade").hide("slow");
}
</script>

