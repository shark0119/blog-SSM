<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head lang="en">
${jquery_js }
${jquery_form_js }
 <link href="${ctx}/resources/blog_info/css/page.css" type="text/css" rel="stylesheet"/>
    <meta charset="UTF-8">
    <title>博客详情</title>
    <link rel="stylesheet" href="${ctx}/resources/blog_info/css/reset.css"/>
    <link rel="stylesheet" href="${ctx}/resources/blog_info/css/post.css"/>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.5.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/htmleaf-demo.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/icons.css" />
	
	<link href="${ctx}/resources/blog/front/css/base.css" rel="stylesheet">
	<link href="${ctx}/resources/blog/front/css/index.css" rel="stylesheet">
	<link href="${ctx}/resources/blog/back/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/resources/blog/back/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/blog/front/css/style.css" />
	<script type="text/javascript" src="${ctx}/resources/js/page.js"></script>
</head>
<body>
<div class="topnav">
<!-- <a href="#" target="_blank">个人博客模板古典系列之——江南墨卷</a>——作品来自<a href="#" target="_blank">杨青个人博客网站</a> -->
<div class="fl login" style="float: right;">

				<c:if test="${sessionScope.SYS_USER.accountEmail==null}">
                    <span><i class="iconfont">&#xe6a0;</i><a href="/blog/register.jsp">注册</a></span>
					<span><i class="iconfont">&#xe65b;</i><a href="/blog/front/login">登录</a></span>
				</c:if>
				<c:if test="${sessionScope.SYS_USER.accountEmail!=null}">
					<span class="has-login">
						<span class="pl pr has-login">
							<a href="#">已登录:${sessionScope.SYS_USER.nickName}</a>
							<span class="pa has-login hid">
								<a href="${pageContext.request.contextPath}/front/user/findUser?userId=${sessionScope.SYS_USER.userId}&page=1">详情</a>
								<a href="javascript:void(0)" onclick="loginOut()">注销</a>
							</span>
						</span>
					</span>
				</c:if>
					</div>
</div>
<div id="wrapper">
		  <header>
    <div class="headtop"></div>
    <div class="contenttop">
      <div class="logo f_l">个人博客模板古典系列之——江南墨卷</div>
      <div class="search f_r">
        <form action="/e/search/index.php" method="post" name="searchform" id="searchform">
               <input name="labelName" id="keyboard" class="input_text" value="请输入关键字" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" type="text">
         <!--  <input name="show" value="title" type="hidden">
          <input name="tempid" value="1" type="hidden">
          <input name="tbname" value="news" type="hidden"> -->
          <input name="button" class="input_submit"   onclick="souso();" value="搜索" type="button">
        </form>
      </div>
      <div class="blank"></div>
      <nav>
        <div  class="navigation">
          <ul class="menu">
            <li><a href="${ctx}/front/blog/indexlist">网站首页</a></li>
            <li><a href="#">关于我</a>
              <ul>
                <li><a href="about.html">个人简介</a></li>
                <li><a href="listpic.html">个人相册</a></li>
              </ul>
            </li>
            <li><a href="#">栏目</a>
              <ul>
                <c:forEach items="${sectionVos}" var="sectionVo">
                  <li class = "color1" style="background: 	#585858;color: black;">
                  <a href="${pageContext.request.contextPath}/front/blog/findBlogBySection?sectionName=${sectionVo.sectionName}"><img src="">
                  <b>${sectionVo.sectionName}</b></a>
                  </li>
                </c:forEach>
              </ul>
            </li>
            <li><a href="newslistpic.html">技术文章</a> </li>
            <li><a href="${ctx }/message/messageAdmin">给我留言</a> </li>
            <li><a href="${ctx}/front/blog/add-contributeBlog">我要投稿</a>
            <ul>
                <li><a href="${ctx}/front/blog/findAllBlogByuserId">我的投稿管理</a></li>
             </ul>
            </li>
          </ul>
        </div>
      </nav>
      <SCRIPT type=text/javascript>
	// Navigation Menu
	$(function() {
		$(".menu ul").css({display: "none"}); // Opera Fix
		$(".menu li").hover(function(){
			$(this).find('ul:first').css({visibility: "visible",display: "none"}).slideDown("normal");
		},function(){
			$(this).find('ul:first').css({visibility: "hidden"});
		});
		
		$.post("${ctx}/announcement/getNewAnnounce",{},function(data){
				$("#announcement").html(data.content);
			},"json"
		);
	});
		function loginOut (){
		$.ajax ({
			url: "${ctx}/loginOut",
			type: 'post',
			success: function (data){
				var result = JSON.parse(data);
				if (result.success){
					window.location.reload();
				}
			}
		});
	}
</SCRIPT> 
    </div>
  </header>
  <div class="jztop"></div>
		</div>
		<input type="hidden" value="${blogcontentVo.blogId}" id="currentBlogId"/>
				<!--当前分页的状态  -->
				<!--总数  -->
				 <input type="hidden" id="totalcount" value="${page.totalCount}"/>
				<!-- 当前页数 -->
				<input type="hidden" id="pageNow" value="${page.pageNow}"/> 

    <div id="container" class="clearfix">
        <div class="fl left-aside">
            <div class="post">
                <div class="post-top">
                    <a href="#post-com" class="iconfont">&#xe60c;<span class="comment-num">${count }</span></a>
                    <span class="iconfont">&#xe608;<span class="read-num">${blogcontentVo.click}</span></span>
                </div>
                <h2 class="post-title">${blogcontentVo.title}</h2>
                <div class="post-img">
                  <%--   <img src="<%=request.getContextPath()%>/resources/images/poster.jpg" alt="生死狙击" width="500" height="750"/> --%>
                </div>
                <div class="post-content">
                ${blogcontentVo.content}
        		
             
                </div>
                <div class="reader-opinion clearfix">
                
               <section class="content" style="text-align: center;">
			     <ol class="grid">
				<li class="grid__item">
					<button class="icobutton icobutton--thumbs-up" value="good"><span class="fa fa-thumbs-up"></span></button>
				</li>
				<li class="grid__item">
					<button class="icobutton icobutton--thumbs-up" value="bad"><span class="fa fa-thumbs-down"></span></button>
				</li>
				
			    </ol>
		       </section>
                    <!-- <p class="fl"><span class="good iconfont">&#xe717;</span><a href="fd.jsp">赞</a><span class="count"></span></p>
                    <p class="fl"><span class="bad iconfont">&#xe716;</span>踩</p> -->
                </div>
            </div>
            <div class="reader-comment">
                <form id="post-com" class="post-comment edit-comment">
                <input type="hidden" id="blogId"  value="${blogcontentVo.blogId}"/>
                    <h3 class="pr edit-comment-title">发表评论</h3>
                    <textarea id="comment"  cols="83" rows="10" ></textarea>
                    <input type="button" id="addcomment" class="submit" value="提交评论"/>
                    <div class="unlock clearfix">
                        <div class="fl lock-bg">
                            <div class="lock-bar"></div>
                        </div>
                        <div class="fl lock-status" draggable="false">有评论时邮件通知我</div>
                    </div>
                    <input type="hidden" id="dynamicNotice" class="lock-sta" value="0"/>
                </form>
                <div class="comment-count">
                    目前评论: <span id="current-comment" class="current-comment">${count }</span>
                </div>
                <div class="comment-list">
                  <c:forEach items="${list }" var="comment">
                    <div class="single-comment clearfix">
                        <div class="origin-comment clearfix">
                            <div id="${comment.key.commentId}ship"  class="fl user-head-img"></div>
                            <div class="fl comment-info">
                                <div class="user-name">${comment.key.addressorName }</div>
                                <div class="comment-time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comment.key.createDate }"/></div>
                                <div class="comment">${comment.key.commentContent }</div>
                            </div>
                            <div class="view-more">查看</div>
                            <div class="replay">回复</div>
                            <form name="commentForm" class="fl edit-comment">
                              <%--  <input type="hidden" id="replycommentid"  class="lock-sta" value="${comment.key.commentId}"/> --%>
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
                                    <div class="fl lock-status" draggable="false">有评论时邮件通知我</div>
                                </div>
                                <input type="hidden" class="replydynamicNotice" class="lock-sta" value="0"/>
                            </form>
                        </div>
                        <div class="child-comments" style="display: none;">
                        <!--子评论开始  -->
                        <c:forEach items="${comment.value}" var="comment2">
                           <div class="child-comment clearfix">
                               <div   class="fl user-head-img"></div>
                               <div class="fl comment-info">
                                   <div class="comment-title">
                                       <span ><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comment2.createDate }"/></span><br/>
                                       <span>${comment2.addressorName }</span> 回复
                                       <span>${comment2.needreplyName }</span>  说:
                                   </div>
                                   <div class="comment">${comment2.commentContent }</div>
                               </div>
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
                                       <div class="fl lock-status" draggable="false">有评论时邮件通知我</div>
                                   </div>
                                   <input type="hidden" class="lock-sta" value="0"/>
                               </form>
                               
                           </div>
                           
                           </c:forEach>
                              
                        </div>
                      
                    </div>
                     
                   </c:forEach>
                    
                </div>
                <!-- <div class="more">更多评论...</div> -->
                <div><ul class="page" maxshowpageitem="5" pagelistcount="10"  id="page"></ul></div>
            </div>
        </div>
        <div class="fr right-aside">
            <div class="hot-post">
                <div class="hot-post-head">
                    <i class="iconfont">&#xe611;</i>热门文章
                </div>
                <div class="hot-post-list">
                   
                <c:forEach var="blogcontentVos" items="${blogcontentVos}" varStatus="s">
                   <p><span></span><a href="detailShow.action?blogId=${blogcontentVos.blogId}" title="${blogcontentVos.title} " >${blogcontentVos.title} </a></p>
                </c:forEach>
                
                </div>
  
    <div id="toolbar">
        <span class="iconfont back-to-top">&#xe6a5;</span>  
    </div>
    <script src="${ctx}/resources/blog_info/js/qdshen.js"></script>
    <script src="${ctx}/resources/blog_info/js/post.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/mo.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/demo.js"></script>
		   <!-- 分页js -->
    <script type="text/javascript">
    		var count=null;
    		var pageNow=null;
    		var blogId=null;
    		count=$("#totalcount").val();
    		pageNow=$("#pageNow").val();
    		blogId=$("#blogId").val();
		    function tt(dd){
		        //alert(dd);
		    	}
		    var GG = {
		        "kk":function(mm){
		         //alert(count);
		        
		            //alert(mm);
		            window.location.href="${ctx}/front/blog/detailShow?pageNow="+mm+"&blogId="+blogId+"#current-comment";
		        }
		    }
		    $("#page").initPage(count,pageNow,GG.kk);
   			 /*$("#page1").initPage(100,1,GG.kk);*/
</script>
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
								oWrap[0].innerHTML += '<span class="pa success">您还没有邮箱或者邮箱未认证</span>';
							}else if(JSON.parse(data).message=="未知用户"){
								oWrap[0].innerHTML += '<span class="pa success">您还没有登录或者被管理员禁言</span>';
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
			/*再次评论  */
			$(".saveagain").click(function(){
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
					oWrap[oThis.index].innerHTML += '<span class="pa success" style="color:red;">评论不能为空</span>';
				}
			});
		});
    
    
    </script>
</body>
</html>