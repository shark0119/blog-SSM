<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ include file="/common/taglibs.jsp" %>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>文章 - 异清轩博客管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/blog/back/Hui-iconfont/iconfont.css">
<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/resources/blog/back/images/icon/icon.png">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/blog/back/images/icon/favicon.ico">
<script src="${pageContext.request.contextPath}/resources/blog/back/js/jquery-2.1.4.min.js"></script>








<link href="${ctx}/resources/blog_info/css/page.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${ctx}/resources/js/page.js"></script>
</head>
<body class="user-select" style="background: white;">

 


                <!--当前分页的状态  -->
				<!--总数  -->
				 <input type="hidden" id="totalcount" value="${page.totalCount}"/>
				<!-- 当前页数 -->
				<input type="hidden" id="pageNow" value="${page.pageNow}"/> 


  <header>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="${ctx}/front/blog/indexlist">YlsatCMS</a> </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <!-- <li><a href="">消息 <span class="badge">1</span></a></li> -->
            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户名:${sessionScope.SYS_USER.nickName} <span class="caret"></span></a> </li>
            <li><a href="javascript:void(0)" onclick="loginOut()">退出登录</a></li>
            <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </header>


<section class="container-fluid">


  <div class="row">
  
   <div class="content wide-content" style="width:250px; padding:  56px;float:left;">
        <div class="container-fluid">
            <div class="settings-wrapper" id="pad-wrapper">
                <!-- avatar column -->
                <div class="span3 avatar-box">
                    <!-- <div class="personal-image">
                        <img src="img/personal-info.png" class="avatar img-circle" />
                    </div> -->
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
              </div>
              </div>
             </div> 
  
  
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main"  style="padding: 0px;float:left;margin-left: 100px;margin-top: 60px;width: 1000px">
       
      <form action="/Article/checkAll" method="post" style="margin-top: 0px;">
        <h1 class="page-header">管理 <!-- <span class="badge">7</span> --></h1>
        <div class="table-responsive">
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th><span class="glyphicon glyphicon-th-large"></span> 
                <span class="visible-lg">选择</span></th>
                <th><span class="glyphicon glyphicon-file"></span> 
                <span class="visible-lg">标题</span></th>
                <th>
                  <i class="icon Hui-iconfont">&#xe681;</i>
                  <span class="visible-lg">栏目</span></th>
                <th class="hidden-sm">
                  <i class="icon Hui-iconfont">&#xe725;</i>
                <span class="visible-lg">点击量</span></th>
                <th class="hidden-sm">
                  <i class="icon Hui-iconfont">&#xe622;</i>
                  <span class="visible-lg">评论</span></th>
                <th class="hidden-sm">
                  <i class="icon Hui-iconfont">&#xe697;</i>
                  <span class="visible-lg">点赞</span></th>
                <th class="hidden-sm">
                  <i class="icon Hui-iconfont">&#xe66e;</i>
                  <span class="visible-lg">踩</span></th>
                <th>
                
                  <i class="icon Hui-iconfont">&#xe690;</i>
                  <span class="visible-lg">日期</span>
                </th>
                <th><span class="glyphicon glyphicon-pencil"></span> 
                <span class="visible-lg">操作</span></th>
              </tr>
            </thead>
            <tbody>
				<c:forEach items="${blogcontentVos}" var="blogcontentVos">
              <tr>
                <td><input type="checkbox" class="input-control" name="checkbox[]" value="${blogcontentVos.blogId }" /></td>
                <td class="article-title"><a href="${pageContext.request.contextPath}/comment/back/blogDetail?blogId=${blogcontentVos.blogId}" >${blogcontentVos.title}</a></td>
               <%--  <td class="article-title">${blogcontentVos.draftContent}</td> --%>
                <td>${blogcontentVos.sectionName}</td>
              <c:if test="${blogcontentVos.draftContent==1}">
	                <td class="hidden-sm">${blogcontentVos.click}&nbsp;&nbsp;
	                <c:if test="${blogcontentVos.newClick != 0}">
	                	<span class="badge">${blogcontentVos.newClick }</span>
	                </c:if></td>
	                <td class="hidden-sm">${blogcontentVos.comment}&nbsp;&nbsp;
	                <c:if test="${blogcontentVos.newComment != 0}">
	                	<span class="badge">${blogcontentVos.newComment }</span>
	                </c:if></td>
	                <td class="hidden-sm">${blogcontentVos.good}&nbsp;&nbsp;
	                <c:if test="${blogcontentVos.newGood != 0}">
	                	<span class="badge">${blogcontentVos.newGood }</span>
	                </c:if></td>
	                <td class="hidden-sm">${blogcontentVos.bad}&nbsp;&nbsp;
	                <c:if test="${blogcontentVos.newBad != 0}">
	                	<span class="badge">${blogcontentVos.newBad }</span>
	                </c:if></td>
	            </c:if> 
                  <c:if test="${blogcontentVos.draftContent==2}">
                <td class="hidden-sm">0&nbsp;&nbsp;<span class="badge">0</span></td>
                <td class="hidden-sm">0&nbsp;&nbsp;<span class="badge">0</span></td>
                <td class="hidden-sm">0&nbsp;&nbsp;<span class="badge">0</span></td>
                <td class="hidden-sm">0&nbsp;&nbsp;<span class="badge">0</span></td>
                </c:if> 
                <td><fmt:formatDate pattern="yyyy-MM-dd " value="${blogcontentVos.createDate }"/></td>
                <c:if test="${blogcontentVos.draftContent==1}">
                 <td><%-- <a class="update" href="updateContentShow?blogcontentId=+${blogcontentVos.blogContentId}">修改</a> --%>
                 <a class="delete" rel="${blogcontentVos.blogContentId}">删除</a></td> 
                </c:if>
                <c:if test="${blogcontentVos.draftContent==2}">
                <td><a class="update" href="updateContentShow?blogcontentId=+${blogcontentVos.blogContentId}">继续编辑</a>
                 <a class="delete" rel="${blogcontentVos.blogContentId}">删除</a></td> 
                </c:if>
                
             
              </tr>
               </c:forEach>
            </tbody>
          </table>
        </div>
        <footer class="message_footer">
          <nav>
            <div class="btn-toolbar operation" role="toolbar">
              <div class="btn-group" role="group"> <a class="btn btn-default" onClick="select()">全选</a> <a class="btn btn-default" onClick="reverse()">反选</a> <a class="btn btn-default" onClick="noselect()">不选</a> </div>
              <div class="btn-group" role="group">
                <button type="button" id="allDelete" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="删除全部选中" name="checkbox_delete">删除</button>
              </div>
            </div>
            <div style="float: right;"><ul class="page" maxshowpageitem="5" pagelistcount="10"  id="page"></ul></div>
          </nav>
        </footer>
      </form>
    </div>
  </div>
</section>

<script src="${pageContext.request.contextPath}/resources/blog/back/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/blog/back/js/admin-scripts.js"></script> 
<script>
//是否确认删除
 $(function(){   
	$(".delete ").click(function(){
		var name = $(this);
		var id = name.attr("rel"); //对应id
			if(window.confirm("此操作不可逆，是否确认？"))
			{
				$.ajax({
					type: "POST",
					url: "${pageContext.request.contextPath}/back/blog/deleteBlog",
					data: "blogcontentId=" +id,
					/* cache: false, //不缓存此页面    */
					success: function (responseText) {
					if(JSON.parse(responseText).status==200){
					    alert("删除成功")
            			window.location.reload();
            		}else{
            			alert(JSON.parse(responseText).message);
						}
					}
				});
			};
	});   
}); 


//是否确认修改
 $(function(){   
	$(".update").click(function(){
		var name = $(this);
		var id = name.attr("rel"); //对应id
				$.ajax({
					type: "POST",
					url: "${pageContext.request.contextPath}/back/blog/deleteBlog",
					data: "blogcontentId=" +id,
					/* cache: false, //不缓存此页面    */
					success: function (responseText) {
					  alert(responseText)
					if(JSON.parse(responseText).status==200){
					    alert("删除成功")
            			window.location.reload();
            		}else{
            			alert(JSON.parse(responseText).message);
						}
					}
				});
	});   
}); 

</script>


 <script type="text/javascript">
    		var count=null;
    		var pageNow=null;
    		/* var blogId=null; */
    		count=$("#totalcount").val();
    		pageNow=$("#pageNow").val();
    		/* blogId=$("#blogId").val(); */
		    function tt(dd){
		       alert(dd);
		    	}
		    var GG = {
		        "kk":function(mm){
		            window.location.href="${ctx}/back/blog/findAllCheckArticle?pageNow="+mm;
		        }
		    }
		    $("#page").initPage(count,pageNow,GG.kk);
   			 /*$("#page1").initPage(100,1,GG.kk);*/
</script>


<!-- 批量删除开始 -->
<script type="text/javascript">
	/*批量删除  */
	$("#allDelete").click(function(){
		//创建数组接收当前的属性
		var arrayid = new Array();
		//获取当前被选中的
		 $('input[name="checkbox[]"]:checked').each(function(){arrayid.push($(this).val());});
		 	//判断一下
			if(arrayid.length==0){
            		alert("没有博客被选中");
            		return;
            	}
           var url="${ctx}/back/blog/allDelete"; 
           if(confirm("您确定要批量删除")){
           	 //进行ajax提交
           	 $.post(
           	 	url,
           	 	{blogIds:arrayid.join(",")},
           	 	//回调函数
           	 	function(data){
           	 	//alert(data);
           	 		if(JSON.parse(data).status==200){
           	 			//成功没有异常
           	 			alert("删除成功");
           	 		window.location.reload();
           	 		}else{
           	 			alert("删除失败！请联系管理员");
           	 			window.location.reload();
           	 		}
           	 	}
           	 
           	 );
           }	
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
