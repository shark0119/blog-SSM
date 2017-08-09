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
<!--  <link rel="stylesheet" href="http://www.helloweba.com/demo/css/main.css" /> -->
<link rel="stylesheet" href="${ctx}/resources/blog/front/css/style.css" /> 
 

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
		$(".menu ul").css({display: "none"}); // Opera Fix
		$(".menu li").hover(function(){
			$(this).find('ul:first').css({visibility: "visible",display: "none"}).slideDown("normal");
		},function(){
			$(this).find('ul:first').css({visibility: "hidden"});
		});
		
	});
</SCRIPT> 
    </div>
  </header>
  <div class="jztop"></div>
  <div class="container"><input id="front" type="hidden" value="${front}"/>
	  <section id="cd-timeline" class="cd-container" >
    <c:forEach items="${listAnno }" var="anno" varStatus="a">
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture" <c:if test="${a.index%2 eq 0 }">style="background:#e5e5e5;"</c:if>
			<c:if test="${a.index%2 eq 1 }">style="background:#f6f6f6;"</c:if>>
				<span style="font-size:30px;margin-left: 20%;margin-top: 15%;display: inline-block;">
				<fmt:formatNumber minIntegerDigits="2" pattern="0" type="number"  value="${a.index+1 }"/></span>
			</div>
	
			<div class="cd-timeline-content" >
				<h1>${anno.title }</h1>
				<p style="font-size: 20px;">${anno.content }</p>
				<!-- <a href="" class="cd-read-more" target="_blank" style="font-size: 16px;">阅读全文</a> -->
				<span class="cd-date" style="font-size: large;">${anno.createtime }</span>
			</div>
		</div>
	</c:forEach>
	</section> 
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
    		/* var count=null;
    		var pageNow=null;
    		var blogId=null;
    		count=$("#totalcount").val();
    		pageNow=$("#pageNow").val();
    		blogId=$("#blogId").val(); */
		    function tt(dd){
		        //alert(dd);
		    	}
		    var GG = {
		        "kk":function(mm){
		         //alert(count);
		        
		           alert(mm);
		           /*  window.location.href="${ctx}/front/blog/detailShow?pageNow="+mm+"&blogId="+blogId+"#current-comment"; */
		        }
		    }
		    /* $("#page").initPage(count,pageNow,GG.kk); */
   			 $("#page").initPage(100,1,GG.kk);
</script>

  </body>
</html>
