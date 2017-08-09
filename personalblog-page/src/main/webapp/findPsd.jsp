<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/common/taglibs.jsp" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>易军博客——找回密码</title>
    <link rel='stylesheet prefetch' href='${pageContext.request.contextPath}/resources/findPassword/css/reset.css'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/findPassword/css/default.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/findPassword/css/styles.css">
	<script src="${pageContext.request.contextPath}/resources/findPassword/js/jquery-2.1.1.min.js"></script>
</head>
<body>
    <article class="htmleaf-content">
        <!-- multistep form -->
        <form id="msform">
            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">账号验证</li>
                <li>验证码</li>
                <li>找回密码</li>
            </ul>
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">输入你的账号</h2>
                <h3 class="fs-subtitle">这是第一步</h3>
                <input type="text" name="emailOrTel"  id="emailOrTel" placeholder="Email地址/手机号" />
                <input type="button" name="next" id="next1" class="action-button" value="下一步" />
            </fieldset>
            <fieldset>
                <h2 class="fs-title">验证码</h2>
                <h3 class="fs-subtitle">请注意接收验证码</h3>
                <input type="text" name="YZM"  id="yzm" placeholder="请输入验证码" />
                <input type="button" name="previous" class="previous action-button" value="上一步" />
                <input type="button" name="next" id="next2" class="next action-button" value="获取密码" />
            </fieldset>
            <fieldset>
                <h2 class="fs-title">密码详情</h2>
                <h3 class="fs-subtitle">您的密码为:</h3>
                <input type="text" id="fname" name="fname" readonly  value="这里是密码"/>
                <h5 style="font-size: 10px">请妥善处理，防止密码外泄！</h5>
                <input type="submit" name="submit" id="submit" class="submit action-button" value="前往登录" />
            </fieldset>
        </form>
    </article>
    <script>window.jQuery || document.write('<script src="js/jquery-2.1.1.min.js"><\/script>')</script>
    <script src="${pageContext.request.contextPath}/resources/findPassword/js/jquery.easing.min.js" type="text/javascript"></script>
    <script>
		
		var yzmAvail = false;
			$("#emailOrTel").click(function(){
				$("#next1").val("下一步");
			});
			
		  $("#next1").click(function(){
			  	var emailOrTel=$("#emailOrTel").val();
	    		var Reg=/(^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$)|(^1[0-9]{10}$)/;
		    	var emailOrTel=$("#emailOrTel").val();
	    		if(!Reg.test($("#emailOrTel").val())){	
	    			$("#next1").val("账号格式错误");
	    			accountAvail = false;
	    			return;
	    		}else{
	    			accountAvail = true;
	    			var url="checkName.action";
	    				$.post(url,{"emailOrTel":emailOrTel},
	    						function(data){
	    							if(data.retcode){
	    								$("#next1").val ("账号不存在");
	        							return;
	    							}else{
	    								var url="sendCode.action";
	    								$.post(url,{"emailOrTel":emailOrTel},
	    					    				 function(data){
	    					    				if(data.retcode!="1"){
	    					    					alert("验证码发送成功！");
	    					    					translation.call($("#next1"));
	    					    				}
	    					    			},"json"
	    					    	 	);
	        				    		return;
	    							}
	    						},"json"
	    				);
	    		}
	    		/*发送验证吗  */
	    		yzmAvail = true;
	    	});
		
		  $("#yzm").click(function(){
				$("#next2").val("获取密码");
			});
		$("#next2").click(function(){
    		var emailOrTel=$("#emailOrTel").val();
    		var url="findPassword.action";
    		var YZM=$("#yzm").val();
    		if (!(/^\d+$/.test($("#yzm").val()))){
    			$("#next2").val("验证码格式错误");
    			yzmAvail = false;
    			return;
    		}
    		yzmAvail = true;
    		if(yzmAvail){
    			$.post(url,
    					{"yzm":YZM,"emailOrTel":emailOrTel},
    					function(data){
    						if(JSON.parse(data).retCode==true){
		    					translation.call($("#next2"));    							
    							$("#fname").val(JSON.parse(data).password);
    						}else {
    							$("#next2").val("验证码错误");
    						}
    					});
    		}
    	});
		
		$("#submit").click(function(){
			location.href= "${ctx}/front/login";
		});
    
		
       	 var current_fs, next_fs, previous_fs;
       	 var left, opacity, scale;
       	 var animating;
       	 
        function translation() {
        	if (!(yzmAvail)){
        		return;
        	}
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
        }
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