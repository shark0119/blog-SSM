<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/style.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="${ctx }/resources/blog/back/images/icon/icon.png">
<link rel="shortcut icon" href="${ctx }/resources/blog/back/images/icon/favicon.ico">
<script src="${ctx }/resources/blog/back/js/jquery-2.1.4.min.js"></script>
<script src="${ctx }/resources/blog/back/js/bootstrap.min.js"></script> 

 <link rel="stylesheet" href="${ctx}/resources/blog_info/css/reset.css"/>
    <link rel="stylesheet" href="${ctx}/resources/blog_info/css/post.css"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/blog/front/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/blog/front/css/htmleaf-demo.css">
	<script type="text/javascript" src="${ctx}/resources/js/page.js"></script>
	<link href="${ctx}/resources/blog_info/css/page.css" type="text/css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/icons.css" />
	
<style>
.bg2{
	clear:both;
	margin-left: 10px;
	margin-top:10px;
	width: 600px;
	height: 100px;
}
	.mod_comment_option{
		margin-top: -15px;
	}
	.mod_comment_sub{
		display:inline-block;
		height: 10px;
	}
	.bt_tx2{
		font-size:12px;
		width:60px;
		height: 25px;
	}
	.c_tx3{
	font-size:12px;
		width:60px;
		height: 25px;
	}
	.mod_comment_other{
		margin-left: 100%;
	}
</style>
	
	
<c:forEach items="${message}" var="lists" >
	<div class="jumbotron" style="background: white;">
	    <div class="container">
                    <div class="single-comment clearfix">
                        <div class="origin-comment clearfix">
                            <div class="fl user-head-img"></div>
                            <div class="fl comment-info">
                                <div class="user-name">${lists.comment.sendId }</div>
                                <div class="comment-time">${lists.comment.createtime }</div>
                                <div class="comment">${lists.comment.comment }</div>
                            </div>
                            
                        <div class="child-comments" style="clear: both;max-height: 400px;overflow:auto;margin-top: 100px;">
                        <!--子评论开始  -->
                        <c:forEach items="${lists.ans}" var="ans">
                           <div class="child-comment clearfix">
                               <div class="fl user-head-img"></div>
                               <div class="fl comment-info">
                                   <div class="comment-title">
                                       <span>${ans.createtime }</span><br/>
                                       <span>${ans.sendId }</span> 回复
                                       <span>${ans.receiveId }</span>  说:
                                   </div>
                                   <div class="comment">${ans.comment }</div>
                               </div>
                           </div>
                           </c:forEach>
                        </div>
                       <div class="view-more" style="position: relative;top: 10px;">回复</div>
                            <!-- <div class="replay">回复</div> -->
                            <div id="commentModule48_commentBox" class="bg2 mod_comment_post" style="display: none;">
								<p class="mod_comment_textarea">
								<span><textarea id="commentModule48_content" cols="60" rows="1" class="textarea textinput input_focus"></textarea></span>
								</p>
								<p class="mod_comment_option"><span class="mod_comment_sub"><button type="button" id="commentModule48_postButton" rel="${lists.comment.id }" sendId="${lists.comment.sendId }" class="bt_tx2">确定</button>
								<a id="commentModule48_cancelButton" href="javascript:;" class="c_tx3">取消</a><span id="commentModule48_extension_bottom" class="mod_comment_extension"></span></span>
								<span class="c_tx3 mod_comment_other"><span id="commentModule48_currentLength">0</span>/<span id="commentModule48_maxLength">100</span></span></p></div>
                        </div>
                    </div>
                </div>
	    </div>
	
</c:forEach>

<script>
	$(function(){
		$(".view-more").click(function(){
			
			 $(this).next().show(); 
		});
		$(".c_tx3").click(function(){
		$(this).parent().parent().parent().hide();
		});
		
		$(".bt_tx2").click(function(){
			var comment=$(this).parent().parent().parent().find("textarea").val();
			var id=$(this).attr("rel");
			var sendId=$(this).attr("sendId");
			if(comment==""){
				alert("回复内容不能为空！");
				return false;
			}
			var url="${ctx}/message/sendComments";
			$.post(url,{"id":id,"comment":comment,"sendId":sendId},function(data){
				$(this).parent().parent().parent().find("textarea").val("");
				location.reload();
			},"json");
		});
		
		$("textarea").focus(function(){
		
			$(this).bind("input propertychange keyup",function(){
		
				var comment=$(this).val();
				if(comment.length>=100){
					$(this).val(comment.substr(0,100));
				}
				$(this).parent().parent().parent().find("#commentModule48_currentLength").html($(this).val().length);
				return false;
			});
		});
		
		
		$(".save").click(function(){
				var oThis = this;
				if (this.previousElementSibling.value.trim() != ''){
					var url="${ctx}/comment/addreply.json";
					var refCommentId=$(this).attr("ref");
					var commentContent=this.previousElementSibling.value;
					var dynamicNotice=this.nextElementSibling.nextElementSibling.value;
					var blogId=$("#blogId").val();
					$.post(
						url,
						{blogId:blogId,refCommentId:refCommentId,commentContent:commentContent,dynamicNotice:dynamicNotice},
						function(data){
							if(JSON.parse(data).status==200){
								oWrap[oThis.index].innerHTML += '<span class="pa success">评论发表成功</span>';
								location.reload();
							}else if((JSON.parse(data).message)=="未知邮箱"){
								oWrap[oThis.index].innerHTML += '<span class="pa success">您还没有邮箱或者邮箱未认证</span>';
							}else if((JSON.parse(data).message)=="未知用户"){
								oWrap[oThis.index].innerHTML += '<span class="pa success">您还没有登录或者被管理员禁言</span>';
							}else if(JSON.parse(data).status==300){
								alert("失败");
							}
						}
					);
				}
				else{
					oWrap[oThis.index].innerHTML += '<span class="pa success" style="color:#f00;">评论不能为空</span>';
				}
			});
	});
</script>

