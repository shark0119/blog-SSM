<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/blog/front/css/style.css" />

<%-- <link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/resources/blog/front/css/element_style.css" /> --%>

<script src="${ctx}/resources/blog/back/js/bootstrap.min.js"></script><!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
 <link href="${ctx}/resources/blog_info/css/page.css" type="text/css" rel="stylesheet"/>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/blog/front/js/jquery.js"></script> --%>
<script type="text/javascript" src="${ctx}/resources/js/page.js"></script></head>
<body>


                <!--当前分页的状态  -->
				<!--总数  -->
				 <input type="hidden" id="totalcount" value="${page.totalCount}"/>
				<!-- 当前页数 -->
				<input type="hidden" id="pageNow" value="${page.pageNow}"/> 



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
								<a href="javascript:void(0)" onclick="loginOut()">退出登录</a>
							</span>
						</span>
					</span>
				</c:if>
					</div>
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
  <div></div>
  <div class="jztop"></div>
  <div class="container">
    <div class="bloglist f_l">
    
       <c:forEach var="blogcontentVos" items="${blogcontentVos}" varStatus="s">
      <h3><a >${blogcontentVos.title}</a></h3>
      <figure><img src="${pageContext.request.contextPath}/resources/blog/front/images/06.jpg" alt="【心路历程】请不要在设计这条路上徘徊啦"></figure>
      <ul>
        <p> ${blogcontentVos.abstrac}</p>
        <a title="【心路历程】请不要在设计这条路上徘徊啦" href="detailShow.action?blogId=${blogcontentVos.blogId}" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
      </ul>
      <p class="dateview"><span><fmt:formatDate pattern="yyyy-MM-dd " value="${blogcontentVos.createDate}"/></span><span>作者：${blogcontentVos.nickName}</span><span></span></p>
      </c:forEach>
      <div style="text-align: center;"><ul class="page" maxshowpageitem="5" pagelistcount="10"  id="page"></ul></div>
    </div>
       
    <div class="r_box f_r">
      <div class="tit01">
        <h3 class="tit">关注我</h3>
        <div class="gzwm">
          <ul>
            <li><a class="email" href="#" target="_blank">我的电话</a></li>
            <li><a class="qq" href="#mailto:admin@admin.com" target="_blank">我的邮箱</a></li>
            <li><a class="tel" href="#" target="_blank">我的QQ</a></li>
            <li><a class="prize" href="#">个人奖项</a></li>
          </ul>
        </div>
      </div>
      <!--tit01 end-->
      
      
      
		
      <div class="ph">
        <h3 class="tit">点击排行</h3>
        <ul class="rank">
          <c:forEach var="blogcontentVos" items="${blogcontentVos}" varStatus="s">
          <li><a href="detailShow.action?blogId=${blogcontentVos.blogId}" title="${blogcontentVos.title} " >${blogcontentVos.title} </a></li>
          </c:forEach>
        </ul>
      </div>
     
  	      
      <div class="ad"> <img src="${pageContext.request.contextPath}/resources/blog/front/images/03.jpg"> </div>
    </div>
  </div>
  <!-- container代码 结束 -->
  <div class="jzend"></div>
  <footer>
    <div class="footer">
      <div class="f_l">
  
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
                function souso(){
   			 	var labeName=$("#keyboard").val();
   			 	location.href="${pageContext.request.contextPath}/front/blog/findBlogByLabel?labelName="+labeName;
   			 }
</script>


    <script type="text/javascript">
    		var count=null;
    		var pageNow=null;
    		/* var blogId=null; */
    		count=$("#totalcount").val();
    		pageNow=$("#pageNow").val();
    	/* 	blogId=$("#blogId").val(); */
		    function tt(dd){
		        //alert(dd);
		    	}
		    var GG = {
		        "kk":function(mm){
		          
		            window.location.href="${ctx}/front/blog/indexlist?pageNow="+mm; 
		        }
		    }
		    $("#page").initPage(count,pageNow,GG.kk);
   			 /*$("#page1").initPage(100,1,GG.kk);*/
</script>
</html>


