<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ include file="/common/taglibs.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="GBK">
<title>个人博客模板古典系列之——江南墨卷</title>
<meta name="keywords" content="个人博客模板古典系列之——江南墨卷" />
<meta name="description" content="个人博客模板古典系列之——江南墨卷" />
${jquery_js }
${jquery_form_js }
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link href="${ctx}/resources/blog/front/css/base.css" rel="stylesheet">
<link href="${ctx}/resources/blog/front/css/index.css" rel="stylesheet">
<link href="${ctx}/resources/blog/back/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/resources/blog/back/css/font-awesome.min.css" rel="stylesheet">
<script src="${ctx}/resources/blog/back/js/bootstrap.min.js"></script><!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
 <link href="${ctx}/resources/blog_info/css/page.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/blog/front/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/page.js"></script></head>
<link rel="stylesheet" href="${ctx}/resources/blog/front/css/style.css" /> 
<link rel="stylesheet" href="${ctx}/resources/blog_info/css/reset.css"/>
    <link rel="stylesheet" href="${ctx}/resources/blog_info/css/post.css"/>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.5.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/htmleaf-demo.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/icons.css" />
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
								<a href="${pageContext.request.contextPath}/front/user/findUser?userId=${sessionScope.SYS_USER.userId}&page=1">个人信息</a>
								<a href="#">退出登录</a>
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
            <li><a href="${ctx }/announcement/frontAnno">公告</a> </li>
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
		$("#addcomment").click(function(){
			var comment=$("#comment").val();
			if(comment==null||""==comment){
				alert("内容不能为空！");
			}
			var url="${ctx}/message/sendMsgToAdmin";
			
			$.post(url,{"comment":comment},function(data){
				if(data.retCode=="0"){
					alert("留言成功！");
					location.reload();
				}else{
					alert("您还没有登录！");
				}
			},"json");
		});
		
	});
</SCRIPT> 
    </div>
  </header>
  <div class="jztop"></div>
  <div class="container"><input id="front" type="hidden" value="${front}"/>
	 
	 <div class="reader-comment">
                <form id="post-com" class="post-comment edit-comment">
                <input type="hidden" id="blogId"  value="${blogcontentVo.blogId}"/>
                    <h3 class="pr edit-comment-title">留言</h3>
                    <textarea id="comment"  cols="83" rows="10" ></textarea>
                    <input type="button" id="addcomment" class="submit" value="提交留言"/>
                    <div class="unlock clearfix">
                       <!-- <div class="fl lock-bg">
                             <div class="lock-bar"></div> 
                        </div>-->
                        <!-- <div class="fl lock-status" draggable="false">有评论时邮件通知我</div> -->
                    </div>
                    <input type="hidden" id="dynamicNotice" class="lock-sta" value="0"/> 
                </form>
	
	</div>
  <div>
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
                      
                        </div>
                    </div>
                </div>
	    </div>
	
</c:forEach>
</div>
	 </div>
	 	
	 
	 
  
  <!-- container代码 结束 -->
  <div class="jzend"></div>
  <footer>
    <div class="footer">
      <div class="f_l">
        <p>All Rights Reserved 版权所有：<a href="http://www.yangqq.com">杨青个人博客</a> 备案号：蜀ICP备00000000号</p>
      </div>
      <div class="f_r textr">
        <p>Design by DanceSmile</p>
      </div>
    </div>
  </footer>
</div>
</body>
	   <!-- 分页js -->
    <script type="text/javascript">
    		
</script>
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
		margin-left: 370px;
	}
</style>
  </body>
</html>
