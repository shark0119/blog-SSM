<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
${jquery_js }
    <meta charset="UTF-8">
    <title>notice</title>
    <link rel="stylesheet" href="${ctx }/resources/notice/css/notice.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/blog/back/Hui-iconfont/iconfont.css">
	<script>
		function n_markAllReaded (){
			location.href = "${ctx}/setAllReaded";
		}
		function n_deleteAll (){
			if (window.confirm("确认清空消息？"))
				location.href = "${ctx}/deleteAllNotices";
		}
	</script>
</head>
<body style="backgroundcolor: #EEE;">
    <div class="w notice">
        <div class="notice-head clearfix">
            <span class="fl">未读通知:<span class="unread-count">${unreadNoticeCount }</span></span>
            <span class="fl line">|</span>
            <a class="fl read-mark" href="javascript:n_markAllReaded()">全部标记为已读</a>
            <span class="fl line">|</span>
            <a class="fl empty" href="javascript:n_deleteAll()">清空所有通知</a>
        </div>
        <hr/>
        <ul class="notice-list">
	        <c:forEach items="${noticeList }" var="notice">
	            <li class="read post-reply single-notice clearfix">
	            	<a class="fl"><input type="checkbox" value="${notice.noticeId }" class="input-control" name="checkbox[]"/></a>
	            	<span class="fl">&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                <span class="fl icon Hui-iconfont">
	                	<c:if test="${notice.state eq 'readed' }"> &#xe70b; </c:if>
	                	<c:if test="${notice.state eq 'unread' }"> &#xe686; </c:if>
	                </span>
	                <span class="fl">&nbsp;&nbsp;</span>
	                <c:if test="${notice.actorId != -1 }">
		                <a href="#" class="fl">
		                	<input type="hidden" value="${notice.actorId }" id="actorId"/>
		                    <span class="user-name" style="color: blue;">${notice.actorName }</span>
		                </a>
	                </c:if>
	                <span class="fl">
		                <c:if test="${notice.actorId == -1 }">
		                	有人
		                </c:if>
		                <span class="">&nbsp;&nbsp;</span>
		                <c:if test="${notice.operateType eq 'comment' }"> 回复了您的博文 </c:if>
		                <c:if test="${notice.operateType eq 'recomment' }"> 在博文
		                	<!--跳回到这个博文-->
			                <a href="${ctx}/comment/back/blogDetail?blogId=${notice.blogId}" >
		                    	<span class="post-name" style="color: blue;">${notice.blogTitle }</span>
		                	</a> 回复了您 </c:if>
		                <c:if test="${notice.operateType eq 'like'}"> 赞了您的博文 </c:if>
		                <c:if test="${notice.operateType eq 'dislike' }"> 踩了您的博文 </c:if>
		                <c:if test="${notice.operateType eq 'message' }"> 
		                	有<a href="#">新留言</a>给您
		                </c:if>
	                </span>
	                <span class="fl">&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                <c:if  test="${notice.operateType != 'recomment'}" >
	                <!--跳回到这个博文-->
		                <a href="${ctx}/comment/back/blogDetail?blogId=${notice.blogId}" class="fl" >
		                    <span class="post-name" style="color: blue;">${notice.blogTitle }</span>
		                </a>
	                </c:if>
	                <c:if test="${notice.operateType eq 'recomment'}" >
	                <!--调回这条评论 -->
		                <span onclick="test()" class="fl" >
		                <!--传值-->
	                	<input type="hidden" id="blogid" value="${notice.blogId}" />
	                	<input type="hidden" id="commentid" value="${notice.commentId}" />
		                    <span class="post-name" style="color: blue;">${notice.comment }</span>
		                </span>	                	
	                </c:if>
	                <span class="fr time">
	                	<fmt:formatDate value="${notice.createTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
	                </span>
	            </li>
	        </c:forEach>
         </ul>
         <hr/>
	    <footer class="message_footer">
	          <nav>
	            <div class="btn-toolbar operation" role="toolbar">
	              <div class="btn-group" role="group"> 
	              	<a class="btn btn-default" onClick="select()">全选</a> 
	              	<a class="btn btn-default" onClick="reverse()">反选</a> 
	              	<a class="btn btn-default" onClick="noselect()">不选</a> 
	              </div>
	            <div class="btn-group" role="group">
	                <button type="button" id="allDelete" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="删除全部选中" name="checkbox_delete">删除</button>
	              </div>
	            </div>
	          </nav>
	     </footer>

    </div>

	<script src="${pageContext.request.contextPath}/resources/blog/back/js/jquery-2.1.4.min.js"></script>
    <script src="${ctx }/resources/notice/js/notice.js"></script>
	<script src="${pageContext.request.contextPath}/resources/blog/back/js/admin-scripts.js"></script> 
</body>
<!--批量删除 -->
<script type="text/javascript">
		$("#allDelete").click(function(){
    			 var arrayid = new Array();
    			 $('input[name="checkbox[]"]:checked').each(function(){arrayid.push($(this).val());});
    			if(arrayid.length==0){
            		alert("没有消息被选中");
            		return;
            	}
            	//开始ajax提交
            	var url="${ctx}/alldeleteNot";
            	if(confirm("确定批量删除")){
            	
            		$.post(
            		url,
            		{ids:arrayid.join(",")},
            		function(data){
            			if(JSON.parse(data).status==200){
            				//删除成功
            				alert("删除成功");
            				location.reload();
            			}else{
            				//失败
            				alert("删除失败！请联系管理员");
            				location.reload();
            			}
            		
            		}
            	
            	);
            	
            	}
          	
	});
	 function test(){
	 var blogid=$("#blogid").val();
	 var commentid=$("#commentid").val();
        // alert("成功");
        //alert(commentid)
         	window.location.href="${ctx}/comment/back/blogDetail?&blogId="+blogid+"#"+commentid+"ship";
         } 
</script>
</html>