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
<title>管理用户 - 异清轩博客管理系统</title>
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
<%--   <header>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="/">YlsatCMS</a> </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="">消息 <span class="badge">1</span></a></li>
            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">管理员:${sessionScope.SYS_USER.accountEmail} <span class="caret"></span></a>
             <!--  <ul class="dropdown-menu dropdown-menu-left">
                <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>
                <li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>
              </ul> -->
            </li>
            <li><a href="/Index/outLogin" onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
            <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
          </ul>
          <form action="" method="post" class="navbar-form navbar-right" role="search">
            <div class="input-group">
              <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索" maxlength="15">
              <span class="input-group-btn">
              <button class="btn btn-default" type="submit">搜索</button>
              </span> </div>
          </form>
        </div>
      </div>
    </nav>
  </header> --%>
  <div class="row">
    <!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main"> -->
    	<h1 class="page-header">操作</h1>
        <ol class="breadcrumb">
          <li><a data-toggle="modal" data-target="#addUser">增加用户</a></li>
        </ol>
        <h1 class="page-header">管理 <span class="badge">2</span></h1>
        <div class="table-responsive">
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th><span class="glyphicon glyphicon-th-large"></span> <span class="visible-lg">ID</span></th>
                <th><span class="glyphicon glyphicon-user"></span> <span class="visible-lg">Email</span></th>
                 <th><span class="glyphicon glyphicon-user"></span> <span class="visible-lg">发表数量</span></th>
                <th><span class="glyphicon glyphicon-bookmark"></span> <span class="visible-lg">用户电话</span></th>
                <th><span class="glyphicon glyphicon-pushpin"></span> <span class="visible-lg">用户角色</span></th>
                <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${users}" varStatus="s" var="user">
              <tr>
                <td>${user.userId}</td>
                <td>${user.accountEmail}</td>
                <td>${user.amount}</td>
                <td>${user.accountTel}</td>
                <td>${user.rolename}</td>
                <td> 
	                <c:if test="${user.state==1}"><a href="${pageContext.request.contextPath}/back/userManager/updateState?state=${user.state}&userId=${user.userId}">禁用</a></c:if> 
	                <c:if test="${user.state==2}"><a href="${pageContext.request.contextPath}/back/userManager/updateState?state=${user.state}&userId=${user.userId}">启用</a></c:if> 
                <%--  <a href="${pageContext.request.contextPath}/message/runAddMsg?receiveId=${user.userId}"  >发消息</a> --%>
                </td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
    </div>
  </div>
</section>
<!--用户信息模态框-->
<div class="modal fade" id="seeUser" tabindex="-1" role="dialog" aria-labelledby="seeUserModalLabel">
  <div class="modal-dialog" role="document" style="max-width:450px;">
    <form action="/User/update" method="post" autocomplete="off" draggable="false">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title">修改用户</h4>
        </div>
        <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr> </tr>
            </thead>
            <tbody>
              <tr>
                <td wdith="20%">姓名:</td>
                <td width="80%"><input type="text" value="" class="form-control" id="truename" name="truename" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">用户名:</td>
                <td width="80%"><input type="text" value="" class="form-control" id="username" name="username" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">电话:</td>
                <td width="80%"><input type="text" value="" class="form-control" id="usertel" name="usertel" maxlength="13" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">旧密码:</td>
                <td width="80%"><input type="password" class="form-control" name="old_password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">新密码:</td>
                <td width="80%"><input type="password" class="form-control" name="password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">确认密码:</td>
                <td width="80%"><input type="password" class="form-control" name="new_password" maxlength="18" autocomplete="off" /></td>
              </tr>
            </tbody>
            <tfoot>
              <tr></tr>
            </tfoot>
          </table>
        </div>
        <div class="modal-footer">
          <input type="hidden" name="userid" value="" />
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--右键菜单列表-->
<div id="rightClickMenu">
  <ul class="list-group rightClickMenuList">
    <li class="list-group-item disabled">欢迎访问异清轩博客</li>
    <li class="list-group-item"><span>IP：</span>172.16.10.129</li>
    <li class="list-group-item"><span>地址：</span>河南省郑州市</li>
    <li class="list-group-item"><span>系统：</span>Windows10 </li>
    <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
  </ul>
</div>
<script src="${pageContext.request.contextPath}/resources/blog/back/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/blog/back/js/admin-scripts.js"></script> 
<script>
$(function () {
    $(".delete").click(function () {
        var name = $(this);
        var id = name.attr("rel"); //对应id   
            if (window.confirm("此操作不可逆，是否确认？")) {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/back/userManager/delete",
                    data: "userId=" + id,
                    cache: false, //不缓存此页面   
                    success: function (data) {
                        window.location.reload();
                    }
                });
            };
    });
});
</script>
</body>
</html>
