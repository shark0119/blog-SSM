<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
	#authCode{
		width: 170px;
		height:36px;
		text-indent: 10px;
	}
	body{
		background: url(${ctx}/resources/blog/back/images/111.jpg) no-repeat center/cover !important;
	}
	#codeImage{
	margin-left: 20px;
	}
</style>
<title>登录 - 易军博客管理系统</title>
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/front.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/frontLogin.css">
<link rel="apple-touch-icon-precomposed" href="/resources/blog/back/images/icon/icon.png">
<link rel="shortcut icon" href="${ctx }/resources/blog/back/images/icon/favicon.ico">
<script src="${ctx }/resources/blog/back/js/jquery-2.1.4.min.js"></script>
</head>

<body class="user-select">
  <div class="footer">
    <a href="${ctx }/front/blog/indexlist" data-toggle="tooltip" data-placement="left">前往博客体验</a>
  </div>
<div class="container">
  <div class="siteIcon"><img src="${ctx }/resources/blog/back/images/icon/icon2.png" alt="" data-toggle="tooltip" data-placement="top"  draggable="false" /></div>
  <form action="#" method="post" autocomplete="off" class="form-signin">
	    <h2 class="form-signin-heading">用户登录</h2>
	    <label for="userName" class="sr-only">用户名</label>
	    <input type="text" id="userName" name="username" class="form-control" placeholder="请输入手机号或者邮箱" required autofocus autocomplete="off" >
	    <label for="userPwd" class="sr-only">密码</label>
	    <input type="password" id="userPwd" name="password" class="form-control" placeholder="请输入密码" required autocomplete="off" maxlength="18">
	    <input id="authCode"   name="authCode" placeholder="请输入验证码" type="text" size="15"/>
	    <!--这里img标签的src属性的值为后台实现图片验证码方法的请求地址-->
	    <label>
	    	<img type="image" src="${ctx}/authCode" id="codeImage" onclick="chageCode()" title="图片看不清？点击重新得到验证码" style="cursor:pointer;"/>
	    </label>
	    <!-- <label>
	    	<a onclick="chageCode()">换一张</a>
	    </label> -->
	    <button class="btn btn-lg btn-primary btn-block" type="button" id="signinSubmit">登录</button>
	    <a href="${ctx }/register.jsp" >没有账号？前往注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="${ctx }/findPsd.jsp" >密码忘了？前往找回</a>
  </form>
</div>
<script src="${ctx }/resources/blog/back/js/bootstrap.min.js"></script> 
<script>
	$("#userName").click(function(){
		$("#signinSubmit").text("登录");
	});
	$("#userPwd").click(function(){
		$("#signinSubmit").text("登录");
	});
	$("#authCode").click(function(){
		$("#signinSubmit").text("登录");
	});
	function chageCode(){
		//链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
        $('#codeImage').attr('src','${ctx}/authCode?abc='+Math.random());
    }
	$('[data-toggle="tooltip"]').tooltip();
	window.oncontextmenu = function() {
		//return false;
	};
	$('.siteIcon img').click(function() {
		window.location.reload();
	});
	$('#signinSubmit').click(function() {
		if ($('#userName').val() === '') {
			$(this).text('手机号或邮箱不能为空');
		} else if ($('#userPwd').val() === '') {
			$(this).text('密码不能为空');
		} else {
			$.ajax({
				url:'${ctx}/verifyCode',
				type:'post',
				data:{'authCode':$("#authCode").val()},
				success:function (data){
					if (data == 'true'){
						$(this).text('登录中');
						$.ajax({
							url:'${ctx}/front/login',
							data:{'username':$("#userName").val(), 'password':$("#userPwd").val()},
							type:'post',
							success: function (data){
								var result = JSON.parse(data);
								if (result.status == 200){
									$("#signinSubmit").text("登录成功");
									location.href= "${ctx}/front/blog/indexlist";
								}else{
									$("#signinSubmit").text(result.message);
								}
							}
						});
					}else {
						$("#signinSubmit").text("验证码错误");
					}			
				}
			});
		}
	});
</script>
</body>
</html>
