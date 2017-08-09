<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglibs.jsp" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>异清轩博客注册</title>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link rel='stylesheet prefetch' href='${pageContext.request.contextPath}/resources/register/css/reset.css'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/register/css/default.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/register/css/styles.css">
    <script src="${pageContext.request.contextPath}/resources/register/js/jquery-2.1.1.min.js"></script>
<%--     <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script> --%>
</head>
<body>
    <article class="htmleaf-content">
        <!-- multistep form -->
        <form id="msform" >
            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">账号设置</li>
                <li>验证码</li>
               <!--  <li>个人详细信息</li> -->
            </ul>
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">创建你的账号</h2>
                <h3 class="fs-subtitle">这是第一步</h3>
                <input type="text" name="emailOrTel" id="emailOrTel" placeholder="Email地址/手机号" required="required"/>
                <input type="password" name="pass" id="pass" placeholder="密码" required="required" />
                <input type="password" name="cpass" id="cpass" placeholder="重复密码" />
                <input type="button" name="next" id="next1"class="next action-button" value="下一步" />
            </fieldset>
            
            <fieldset>
                <h2 class="fs-title">验证码</h2>
                <h3 class="fs-subtitle">请注意接收验证码</h3>
                <input type="text" name="YZM" id="YZM" placeholder="验证码" required="required"/>
                <input type="button" name="previous" class="previous action-button" value="上一步" />
                <input type="button" name="next" id="next2" class="action-button" value="成功" />
            </fieldset>
            
        </form>
    </article>
    <script>window.jQuery || document.write('<script src="js/jquery-2.1.1.min.js"><\/script>')</script>
    <script src="${pageContext.request.contextPath}/resources/register/js/jquery.easing.min.js" type="text/javascript"></script>
    <script>
    	var accountAvail = false ;
    	var pwdAvail = false ;
    	$("#emailOrTel").click(function(){
			$("#next1").val("下一步");
		});
    	$("#YZM").click(function(){
			$("#next2").val("成功");
		});
    	$("#emailOrTel").blur(function(){
	    		var emailOrTel=$(this).val();
	    		var Reg=/(^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$)|(^1[0-9]{10}$)/;
	    		if(!Reg.test(emailOrTel)){	
	    			$("#next1").val('账号格式错误');
	    			accountAvail = false;
	    			return;
	    		}
	    		var url="checkName.action";
	    			$.post(url,{"emailOrTel":emailOrTel},
	    					function(data){
	    						if(!data.retcode){
	    							$("#next1").val('账号已经存在');
	    							accountAvail = false;
	    							return;
	    						}else{
	    						  accountAvail = true;
	    				    		return;
	    						}
	    					},"json"
	    				);
	    		});
    		
    	$("#next1").click(function(){
    		var Reg=/(^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$)|(^1[0-9]{10}$)/;
    		if(!Reg.test($("#emailOrTel").val())){	
    			$("#next1").val('账号格式错误');
    			accountAvail = false;
    			return;
    		}
    		if ($("#pass").val()!=$("#cpass").val()){
    			$("#next1").val('两次密码输入不一致');
    			pwdAvail = false;
    			return;    			
    		}else{
    			pwdAvail = true;
    			$("#next1").val('...');
    		}
    		/*发送验证吗  */
    		/* pwdAvail = true; */
	    		var url="sendYZM.action";
	    		var emailOrTel=$("#emailOrTel").val();
	    		var pass=$("#pass").val(); 
	    	if(accountAvail){
	    		 $.post(url,{"emailOrTel":emailOrTel,"password":pass},
	    				 function(data){
	    				if(data.retcode!="1"){
	    					alert("验证码发送成功！");
	    				}
	    			},"json"
	    	 );
	    	}	
    	});
    	
    	$("#next2").click(function(){
    		var reg = /^\d+$/;   		
    		
    		if (!reg.test ($("#YZM").val())){
    			$("#next2").val('验证码格式错误');
    			return;
    		}
    		var flag=true;
    		var url="addUser.action";
    		var YZM=$("#YZM").val();
    		if(flag){
    			$.post(url,
    					{"yzm":YZM},
    					function(data){
    						if(JSON.parse(data).retCode==false){
    							$("#next2").val('验证码输入错误');
							}else {
								alert("注册成功");
								location.href= "${ctx}/front/login";								
							}
    					});
    		}
    	})
    	
        var current_fs, next_fs, previous_fs;
        var left, opacity, scale;
        var animating;
        $('.next').click(function () {
        	//验证不通过直接返回
        	if (!(pwdAvail && accountAvail))
        		return;
        	
            if (animating)
                return false;
            animating = true;
            current_fs = $(this).parent();
            next_fs = $(this).parent().next();
            $('#progressbar li').eq($('fieldset').index(next_fs)).addClass('active');
            next_fs.show();
            current_fs.animate({ opacity: 0 }, {
                step: function (now, mx) {
                    scale = 1 - (1 - now) * 0.2;
                    left = now * 50 + '%';
                    opacity = 1 - now;
                    current_fs.css({ 'transform': 'scale(' + scale + ')' });
                    next_fs.css({
                        'left': left,
                        'opacity': opacity
                    });
                },
                duration: 800,
                complete: function () {
                    current_fs.hide();
                    animating = false;
                },
                easing: 'easeInOutBack'
            });
        });
        $('.previous').click(function () {
            if (animating)
                return false;
            animating = true;
            current_fs = $(this).parent();
            previous_fs = $(this).parent().prev();
            $('#progressbar li').eq($('fieldset').index(current_fs)).removeClass('active');
            previous_fs.show();
            current_fs.animate({ opacity: 0 }, {
                step: function (now, mx) {
                    scale = 0.8 + (1 - now) * 0.2;
                    left = (1 - now) * 50 + '%';
                    opacity = 1 - now;
                    current_fs.css({ 'left': left });
                    previous_fs.css({
                        'transform': 'scale(' + scale + ')',
                        'opacity': opacity
                    });
                },
                duration: 800,
                complete: function () {
                    current_fs.hide();
                    animating = false;
                },
                easing: 'easeInOutBack'
            });
        });
        $('.submit').click(function () {
            return false;
        });
    </script>
</body>
</html>