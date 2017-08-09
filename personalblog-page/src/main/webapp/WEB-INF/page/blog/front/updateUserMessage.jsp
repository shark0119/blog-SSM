<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户 - 异清轩博客</title>
    <link href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/layout.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/elements.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/lib/font-awesome.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/blog/front/css/szhcss/compiled/personal-info.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/blog/back/Hui-iconfont/iconfont.css">
<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resources/blog/back/images/icon/icon.png">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/blog/back/images/icon/favicon.ico">
<script src="${pageContext.request.contextPath}/resources/blog/back/js/jquery-2.1.4.min.js"></script>
<!--[if gte IE 9]>
  <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="js/html5shiv.min.js" type="text/javascript"></script>
  <script src="js/respond.min.js" type="text/javascript"></script>
  <script src="js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>

<body class="user-select">
<section class="container-fluid">
  <header>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="${ctx}/front/blog/indexlist">YlsatCMS</a> </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
           <!--  <li><a href="">消息 <span class="badge">1</span></a></li> -->
            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户名:${sessionScope.SYS_USER.nickName} <span class="caret"></span></a> </li>
            <li><a href="javascript:void(0)" onclick="loginOut()">退出登录</a></li>
            <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
    <div class="content wide-content">
        <div class="container-fluid">
            <div class="settings-wrapper" id="pad-wrapper">
                <!-- avatar column -->
                <div class="span3 avatar-box">
                   
          <ul class="nav nav-sidebar">
	        <li><a href="${pageContext.request.contextPath}/front/user/findUser?userId=${sessionScope.SYS_USER.userId}&page=1">查看个人 资料</a></li>
	      </ul>
	       <ul class="nav nav-sidebar">
	        <li><a href="${pageContext.request.contextPath}/front/user/findUser?userId=${sessionScope.SYS_USER.userId}&page=2">修改个人资料</a></li>
	      </ul>
	       <ul class="nav nav-sidebar">
	        <li><a href="${pageContext.request.contextPath}/front/user/findUser?userId=${sessionScope.SYS_USER.userId}&page=3">修改密码</a></li>
	      </ul>
	        <ul class="nav nav-sidebar">
			         <li><a href="${ctx}/front/blog/findAllBlogByuserId">我的投稿管理</a></li>
                  </ul>
                </div>

                <!-- edit form column -->
                <div class="span7 personal-info">
                    <h5 class="personal-title">修改个人信息</h5>
					
					<form action="" method="post" enctype="mutilpart/from-date">
					</form>
					
                    <form action="" method="post" >
                    
                    	<input type="hidden" value="${user.userId}" id="userId"  />
                        <div class="field-box">
                            <label>用户昵称:</label>
                            <input class="span5 inline-input" type="text" id="nickName" value="${user.nickName}" />
                        </div>
                        <div class="field-box">
                            <label>Email:</label>
                            <input class="span5 inline-input" type="text" id="email" value="${user.accountEmail}" />
                        </div>
                        <div class="field-box">
                            <label>电话:</label>
                            <input class="span5 inline-input" type="text" id="tel" value="${user.accountTel}" />
                        </div>
                      
                        <div class="span6 field-box actions">
                            <input type="button" class="btn-glow primary" id="button" value="确认修改" />
                            <span>OR</span>
                            
                            <a href="javascript:history.back(-1);">返回</a> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="${pageContext.request.contextPath}/resources/blog/back/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/blog/back/js/admin-scripts.js"></script> 
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/blog/front/js/szhjs/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/blog/front/js/szhjs/theme.js"></script>
<script type="text/javascript">
$(function () {
    $("#button").click(function () {
        //var headPortrait=$("#head").val(); 
         var userId=$("#userId").val(); 
         var nickName=$("#nickName").val(); 
          var email=$("#email").val(); 
           var tel=$("#tel").val(); 
           var url= "${pageContext.request.contextPath}/front/user/updateUserMessage";
                $.post(url,{"userId":userId,"nickName":nickName,"email":email,"tel":tel},function(data){
                if(data=="success"){
                	alert("修改成功!");
                	top.location.reload();
                	 /* window.location.href="${pageContext.request.contextPath}/front/login";  */
                }else{
                	alert("修改失败!");
                	 window.history.go(-1); 
                }
               /*  	 window.location.href="${pageContext.request.contextPath}/front/login"; */
                });

    });
});
function loginOut (){
		$.ajax ({
			url: "${ctx}/loginOut",
			type: 'post',
			success: function (data){
				var result = JSON.parse(data);
				if (result.success){
					window.location.href="/blog/";
				}
			}
		});
}
</script>
</body>
</html>
