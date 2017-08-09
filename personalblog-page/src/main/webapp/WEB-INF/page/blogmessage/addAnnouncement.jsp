<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/style.css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="${ctx }/resources/blog/back/images/icon/icon.png">
<link rel="shortcut icon" href="${ctx }/resources/blog/back/images/icon/favicon.ico">
<script src="${ctx }/resources/blog/back/js/jquery-2.1.4.min.js"></script>
<script src="${ctx }/resources/blog/back/js/bootstrap.min.js"></script> 
<script src="${ctx }/resources/blog/back/js/admin-scripts.js"></script> 
<!--summernote富文本编辑器-->
<link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/lib/summernote/summernote.css">
<script src="${ctx }/resources/blog/back/lib/summernote/summernote.js"></script> 
<script src="${ctx }/resources/blog/back/lib/summernote/lang/summernote-zh-CN.js"></script> 

   <!--  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main"> -->
      <div class="row">
        <form action="addAnnouncement<c:if test='${not empty anno.id}'>?id=${anno.id}</c:if>" method="post" class="add-article-form">
         
          <div class="col-md-9">
            <h1 class="page-header">撰写新公告</h1>
            <div class="form-group">
             <%-- <input type="hidden" value="${anno.id }"/> --%>
              <label for="article-title" class="sr-only">标题</label>
              <input type="text" value="${anno.title }" id="article-title" name="title" class="form-control" placeholder="在此处输入标题" required autofocus autocomplete="off">
            </div>
            <div class="form-group">
              <label for="article-content" class="sr-only">内容</label>
              <textarea id="article-content" name="content" class="form-control">${anno.content }</textarea> 
            </div>
          </div>
          <div class="col-md-3">
            <h1 class="page-header">操作</h1>
            <div class="add-article-box">
              <h2 class="add-article-box-title"><span>发布</span></h2>
              <div class="add-article-box-content">
              	<p><label>状态：</label><span class="article-status-display">未发布</span></p>
                <p><label>发布于：</label><span class="article-time-display"><input style="border: none;width: 12em;" type="datetime" id=time name="time" value="2016-01-09 17:29:37" /></span></p>
              </div>
              <div class="add-article-box-footer">
                <button class="btn btn-primary" type="submit" name="submit">发布</button>
              </div>
            </div>
          </div>
        </form>
      </div>
  


<!--summernote富文本编辑器-->

<script>
var myVar=setInterval(function(){myTimer()},1000);
$('#article-content').summernote({
	lang: 'zh-CN'
});


function myTimer()
{
var d=new Date();
var t=d.toLocaleString();
document.getElementById("time").value=t;
}
</script>