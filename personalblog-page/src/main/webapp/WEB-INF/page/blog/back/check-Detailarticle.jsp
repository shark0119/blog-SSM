<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head lang="en">
${jquery_js }
${jquery_form_js }
    <meta charset="UTF-8">
    <title>post page</title>
    <link rel="stylesheet" href="${ctx}/resources/blog_info/css/reset.css"/>
    <link rel="stylesheet" href="${ctx}/resources/blog_info/css/post.css"/>
</head>

<body>
    <!-- <div id="container" class="clearfix"> -->
        <div class="fl left-aside">
            <div class="post">
                <div class="post-top">
                    <a href="#post-com" class="iconfont">&#xe60c;<span class="comment-num">${count }</span></a>
                    <span class="iconfont">&#xe608;<span class="read-num">${blogcontentVo.click}</span></span>
                </div>
                <h2 class="post-title">${blogcontentVo.title}</h2>
                                                        <%--     作者：${blogcontentVo.nickName} --%>
                <div class="post-img">
                  <%--   <img src="<%=request.getContextPath()%>/resources/images/poster.jpg" alt="生死狙击" width="500" height="750"/> --%>
                </div>
                <div class="post-content">
                ${blogcontentVo.content}
         
             
                </div>
                <div class="reader-opinion clearfix">
                    <p class="fl" ><a href="${pageContext.request.contextPath}/back/blog/checkPass?blogId=${blogcontentVo.blogId}">审核通过</a></p>
                    <p class="fl"><a href="${pageContext.request.contextPath}/back/blog/checkNotPass?blogId=${blogcontentVo.blogId}">审核不通过</a></p>
                </div>
            </div>
         <%--    <div class="reader-comment">
                <form id="post-com" class="post-comment edit-comment">
                <input type="hidden" id="blogId"  value="${blogcontentVo.blogId}"/>
                    <h3 class="pr edit-comment-title">发表评论</h3>
                    <textarea id="comment"  cols="83" rows="10" ></textarea>
                    <input type="button" id="addcomment" class="submit" value="提交评论"/>
                    <div class="unlock clearfix">
                        <div class="fl lock-bg">
                            <div class="lock-bar"></div>
                        </div>
                        <div class="fl lock-status" draggable="false">有邮件时通知我</div>
                    </div>
                    <input type="hidden" id="dynamicNotice" class="lock-sta" value="0"/>
                </form>
                <div class="comment-count">
                    目前评论: <span class="current-comment">${count }</span>
                </div>
                <div class="comment-list">
                  <c:forEach items="${list }" var="comment">
                    <div class="single-comment clearfix">
                        <div class="origin-comment clearfix">
                            <div class="fl user-head-img"></div>
                            <div class="fl comment-info">
                                <div class="user-name">${comment.key.addressorName }</div>
                                <div class="comment-time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comment.key.createDate }"/></div>
                                <div class="comment">${comment.key.commentContent }</div>
                            </div>
                            <div class="view-more">查看回复</div>
                            <input type="button" ref="${comment.key.commentId}" value="删除" class="del-btn delete"/>
                            <div class="replay">回复</div>
                            <form name="commentForm" class="fl edit-comment">
                               <input type="hidden" id="replycommentid"  class="lock-sta" value="${comment.key.commentId}"/>
                                <div class="edit-head clearfix">
                                    <h3 class="fl edit-comment-title">发表评论</h3>
                                    <div class="fr cancel-comment">取消评论</div>
                                </div>
                                <textarea class="replycomment"  cols="83" rows="10"></textarea>
                                <input type="button" ref="${comment.key.commentId}" 
                                 class="submit save" value="提交评论"/>
                                <div class="unlock clearfix">
                                    <div class="fl lock-bg">
                                        <div class="lock-bar"></div>
                                    </div>
                                    <div class="fl lock-status" draggable="false">有邮件时通知我</div>
                                </div>
                                <input type="hidden" class="replydynamicNotice" class="lock-sta" value="0"/>
                            </form>
                        </div>
                        <div class="child-comments" style="display: none;">
                        <!--子评论开始  -->
                        <c:forEach items="${comment.value}" var="comment2">
                           <div class="child-comment clearfix">
                               <div class="fl user-head-img"></div>
                               <div class="fl comment-info">
                                   <div class="comment-title">
                                       <span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comment2.createDate }"/></span><br/>
                                       <span>${comment2.addressorName }</span> 回复
                                       <span>${comment2.needreplyName }</span>  说:
                                   </div>
                                   <div class="comment">${comment2.commentContent }</div>
                               </div>
                               <input type="button" ref="${comment2.commentId }" value="删除" class="del-btn-c deletereply"/>
                               <div class="replay">回复</div>
                               <form name="commentForm2" class="fl edit-comment">
                                   <div class="edit-head clearfix">
                                       <h3 class="fl edit-comment-title">发表评论</h3>
                                       <div class="fr cancel-comment">取消评论</div>
                                   </div>
                                   <textarea cols="83" rows="10"></textarea>
                                   <input type="button" ref="${comment2.commentId }" class="submit saveagain" value="提交评论"/>
                                   <div class="unlock clearfix">
                                       <div class="fl lock-bg">
                                           <div class="lock-bar"></div>
                                       </div>
                                       <div class="fl lock-status" draggable="false">有邮件时通知我</div>
                                   </div>
                                   <input type="hidden" class="lock-sta" value="0"/>
                               </form>
                               
                           </div>
                           
                           </c:forEach>
                              
                        </div>
                      
                    </div>
                     
                   </c:forEach>
                    
                </div>
                <div class="more">更多评论...</div>
            </div>
        </div>
<!--         <div class="fr right-aside">
            <div class="hot-post">
                <div class="hot-post-head">
                    <i class="iconfont">&#xe611;</i>热门文章
                </div>
                <div class="hot-post-list">
                    <p><span>1</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>2</span><a href="#">小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊</a></p>
                    <p><span>3</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>4</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>5</span><a href="#">小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊</a></p>
                    <p><span>6</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>7</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>8</span><a href="#">小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊</a></p>
                </div>
            </div>
            <div class="hot-post">
                <div class="hot-post-head">
                    <i class="iconfont">&#xe611;</i>热门黄片
                </div>
                <div class="hot-post-list">
                    <p><span>1</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>2</span><a href="#">小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊</a></p>
                    <p><span>3</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>4</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>5</span><a href="#">小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊</a></p>
                    <p><span>6</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>7</span><a href="#">论打小赵的重要性</a></p>
                    <p><span>8</span><a href="#">小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊小赵好傻逼啊</a></p>
                </div>
            </div>
        </div>
    </div> -->
    <div id="toolbar">
        <span class="iconfont back-to-top">&#xe6a5;</span>  
    </div>
    <script src="${ctx}/resources/blog_info/js/qdshen.js"></script>
    <script src="${ctx}/resources/blog_info/js/post.js"></script>
    <!--增加主评论 -->
    <script  type="text/javascript">
    	var oWrap = document.querySelectorAll('.edit-comment-title');
    	for (var i=0;i<oWrap.length;i++){
    		oWrap[i].index = i;
    	}
    	var oBtnc = document.querySelectorAll('.submit');
    	for (var i=0;i<oBtnc.length;i++){
    		oBtnc[i].index = i;
    	}
    	$(function(){
    		//主评论
			$("#addcomment").click(function(){
				if (this.previousElementSibling.value.trim() != ''){
					var url="${ctx}/comment/add.json";
					var blogId=$("#blogId").val();
					var commentContent=$("#comment").val();
					var dynamicNotice=$("#dynamicNotice").val();
						//ajax提交
						$.post(
						url,
						{blogId:blogId,commentContent:commentContent,dynamicNotice:dynamicNotice},
						function(data){
						//alert(JSON.parse(data).message);
							if(JSON.parse(data).status==200){
								oWrap[0].innerHTML += '<span class="pa success">评论发表成功</span>';
								location.reload();
							}else if((JSON.parse(data).message)=="未知邮箱"){
								//alert(JSON.parse(data).message);
								oWrap[0].innerHTML += '<span class="pa success">您还没有邮箱</span>';
							}else if(JSON.parse(data).message=="未知用户"){
								oWrap[0].innerHTML += '<span class="pa success">您还没有登录</span>';
						    }else if(JSON.parse(data).status==300){
								alert("失败"); 
							}
						}
						);
				}
				else{
					oWrap[0].innerHTML += '<span class="pa success" style="color:red;">评论不能为空</span>';
				}
			});
			//增加子评论
			
			$(".save").click(function(){
				var oThis = this;
				if (this.previousElementSibling.value.trim() != ''){
					var url="${ctx}/comment/addreply.json";
					var refCommentId=$(this).attr("ref");
					var commentContent=this.previousElementSibling.value;
					var dynamicNotice=this.nextElementSibling.nextElementSibling.value;
					$.post(
						url,
						{refCommentId:refCommentId,commentContent:commentContent,dynamicNotice:dynamicNotice},
						function(data){
							if(JSON.parse(data).status==200){
								oWrap[oThis.index].innerHTML += '<span class="pa success">评论发表成功</span>';
								location.reload();
							}else if((JSON.parse(data).message)=="未知邮箱"){
								oWrap[oThis.index].innerHTML += '<span class="pa success">您还没有邮箱</span>';
							}else if((JSON.parse(data).message)=="未知用户"){
								oWrap[oThis.index].innerHTML += '<span class="pa success">您还没有登录</span>';
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
			/*再次评论  */
			$(".saveagain").click(function(){
				var oThis = this;
				if (this.previousElementSibling.value.trim() != ''){
					var url="${ctx}/comment/addreply.json";
					var refCommentId=$(this).attr("ref");
					var commentContent=this.previousElementSibling.value;
					var dynamicNotice=this.nextElementSibling.nextElementSibling.value;
					$.post(
						url,
					{refCommentId:refCommentId,commentContent:commentContent,dynamicNotice:dynamicNotice},
					function(data){
						if(JSON.parse(data).status==200){
							oWrap[oThis.index].innerHTML += '<span class="pa success">评论发表成功</span>';
							location.reload();
						}else if((JSON.parse(data).message)=="未知邮箱"){
								oWrap[oThis.index].innerHTML += '<span class="pa success">您还没有邮箱</span>';
						}else if((JSON.parse(data).message)=="未知用户"){
								oWrap[oThis.index].innerHTML += '<span class="pa success">您还没有登录</span>';
						}else if(JSON.parse(data).status==300){
							alert("失败");
						}
					}
				);
				}
				else{
					oWrap[oThis.index].innerHTML += '<span class="pa success" style="color:red;">评论不能为空</span>';
				}
			});
			//主评论删除
			$(".delete").click(function(){
				var url="${ctx}/comment/delete.json";
				var commentid=$(this).attr("ref");
				if(confirm("确定删除主评论")){
					$.post(
						url,
						{commentid:commentid},
						function(data){
							if(JSON.parse(data).status==200){
								alert("删除成功");
								location.reload();
							}else if(JSON.parse(data).status==300){
								alert("失败");
							}
						}
					);
				
				}
			
			});
			//子评论删除
			$(".deletereply").click(function(){
				var url="${ctx}/comment/delete.json";
				var commentid=$(this).attr("ref");
				if(confirm("确定删除评论")){
					$.post(
						url,
						{commentid:commentid},
						function(data){
							if(JSON.parse(data).status==200){
								alert("删除成功");
								location.reload();
							}else if(JSON.parse(data).status==300){
								alert("失败");
							}
						}
					);
				
				}
			
			});
		});
    
    
    </script> --%>
</body>
</html>