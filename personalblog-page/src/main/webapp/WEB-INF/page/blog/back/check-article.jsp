﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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


                <!--当前分页的状态  -->
				<!--总数  -->
				 <input type="hidden" id="totalcount" value="${page.totalCount}"/>
				<!-- 当前页数 -->
				<input type="hidden" id="pageNow" value="${page.pageNow}"/> 





<section class="container-fluid">
  <div class="row">
    <!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main"> -->
      <form action="/Article/checkAll" method="post" >
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
                  
                   <th>
                  <i class="icon Hui-iconfont">&#xe681;</i>
                  <span class="visible-lg">审核状态</span></th>
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
                <td class="article-title"><a href="${pageContext.request.contextPath}/back/blog/checkBlogDetail?blogId=${blogcontentVos.blogId}" >${blogcontentVos.title}</a></td>
               <%--  <td class="article-title">${blogcontentVos.draftContent}</td> --%>
                <td>${blogcontentVos.sectionName}</td>
                <c:if test="${blogcontentVos.checkArticle==1}">
                <td>审核通过</td>
                </c:if>
                <c:if test="${blogcontentVos.checkArticle==2}">
                <td>审核不通过</td>
                </c:if>
                <c:if test="${blogcontentVos.checkArticle==3}">
                <td>未审核</td>
                </c:if>
                <td><fmt:formatDate pattern="yyyy-MM-dd " value="${blogcontentVos.createDate }"/></td>
                <td><a class="update" href="${pageContext.request.contextPath}/back/blog/checkBlogDetail?blogId=${blogcontentVos.blogId}">审核</a>
                 <a class="delete" rel="${blogcontentVos.blogContentId}">删除</a></td> 
             
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
<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <form action="" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" >个人信息</h4>
        </div>
        <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr> </tr>
            </thead>
            <tbody>
              <tr>
                <td wdith="20%">姓名:</td>
                <td width="80%"><input type="text" value="王雨" class="form-control" name="truename" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">用户名:</td>
                <td width="80%"><input type="text" value="admin" class="form-control" name="username" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">电话:</td>
                <td width="80%"><input type="text" value="18538078281" class="form-control" name="usertel" maxlength="13" autocomplete="off" /></td>
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
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >登录记录</h4>
      </div>
      <div class="modal-body">
        <table class="table" style="margin-bottom:0px;">
          <thead>
            <tr>
              <th>登录IP</th>
              <th>登录时间</th>
              <th>状态</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>::1:55570</td>
              <td>2016-01-08 15:50:28</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64377</td>
              <td>2016-01-08 10:27:44</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64027</td>
              <td>2016-01-08 10:19:25</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:57081</td>
              <td>2016-01-06 10:35:12</td>
              <td>成功</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="images/weixin.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<!--提示模态框-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="images/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
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
/*   function tijiao(){
            	var html=ue.getContent();
            	var title=$("#article-title").val();
            	$("#message").html(html);
            	var url="addBlog.action";
            	$.post(url,{"content":html,"title":title},
            	function(responseText){
            	 if(JSON.parse(responseText).status==200){
            	location.href="${pageContext.request.contextPath}/back/blog/findAllBlog";
            	}else{
            	alert(JSON.parse(responseText).message);
            	} 
            	});
            	} */

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
	

</script>
</body>
</html>
