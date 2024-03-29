<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<html lang="zh-CN">
<head>
${jquery_js }
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>栏目 - 异清轩博客管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/blog/back/css/font-awesome.min.css">
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
  <div class="row">
   <!--  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main"> -->
      <div class="row">
        <div class="col-md-5">
          <h1 class="page-header">添加</h1>
          <form id="editForm" method="post" >
          <input type="hidden" id="sectionId" value="${section.sectionId}"/>
            <div class="form-group">
              <label for="category-name">栏目名称</label>
              <input type="text" id="category-name" value="${section.sectionName}" name="sectionName" class="form-control" placeholder="在此处输入栏目名称" required autocomplete="off">
              <span class="prompt-text">这将是它在站点上显示的名字。</span> </div>
            <!-- <div class="form-group">
              <label for="category-alias">栏目别名</label>
              <input type="text" id="category-alias" name="alias" class="form-control" placeholder="在此处输入栏目别名" required autocomplete="off">
              <span class="prompt-text">“别名”是在URL中使用的别称，它可以令URL更美观。通常使用小写，只能包含字母，数字和连字符（-）。</span> </div>
            <div class="form-group">
              <label for="category-fname">父节点</label>
              <select id="category-fname" class="form-control" name="fid">
                <option value="0" selected>无</option>
                <option value="1">前端技术</option>
                <option value="2">后端程序</option>
                <option value="3">管理系统</option>
                <option value="4">授人以渔</option>
                <option value="5">程序人生</option>
              </select>
              <span class="prompt-text">栏目是有层级关系的，您可以有一个“音乐”分类目录，在这个目录下可以有叫做“流行”和“古典”的子目录。</span> </div>-->
            <div class="form-group">
              <label for="category-keywords">关键字</label>
              <input type="text" id="category-keywords" value="${section.keyWord}" name="keyWord" class="form-control" placeholder="在此处输入栏目关键字" autocomplete="off">
              <span class="prompt-text">关键字会出现在网页的keywords属性中。</span> </div>
            <div class="form-group">
              <label for="category-describe">描述</label>
              <textarea class="form-control"  id="category-describe" name="describe" rows="4" autocomplete="off">${section.description}</textarea>
              <span id="prompt-text" class="prompt-text">描述会出现在网页的description属性中。</span> </div> 
            <c:choose>
            	<c:when test="${isupdate!=1}">
            		 <button class="btn btn-primary" id="save" type="button" name="submit">添加新栏目</button>
            	</c:when>
            	<c:when test="${isupdate==1}">
            		<button class="btn btn-primary" id="update" type="button" name="submit">修改</button>
            	</c:when>
            </c:choose> 
           
          </form>
        </div>
        <div class="col-md-7">
          <h1 class="page-header">管理 <span class="badge"></span></h1>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th><span class="glyphicon glyphicon-paperclip"></span> <span class="visible-lg">ID</span></th>
                  <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">名称</span></th>
                  <!-- <th><span class="glyphicon glyphicon-list-alt"></span> <span class="visible-lg">别名</span></th>-->
                  <th><span class="glyphicon glyphicon-pushpin"></span> <span class="visible-lg">总数</span></th> 
                  <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                </tr>
              </thead>
              <tbody>
              <!--循环取数据开始  -->
              <c:forEach items="${ sections}" var="section">
                <tr>
                  <td>${section.sectionId}</td> 
                  <td>${section.sectionName}</td>
                  <td>${section.count}</td> 
                  <td>
                  <c:if test="${section.sectionId!=1 }">
                  <a href="${ctx}/section/skipupdate?sectionid=${section.sectionId}">修改</a> <a class="delete" rel="${section.sectionId}">删除</a>
                  </c:if>
                  </td>
                   
                </tr>
               </c:forEach>
              </tbody>
            </table>
            <span class="prompt-text"><strong>注：</strong>删除一个栏目也会删除栏目下的文章和子栏目,请谨慎删除!</span> </div>
        </div>
      </div>
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
<!--隐藏传值  -->
<input id="path" value="${ctx}" type="hidden"/>
<script src="${pageContext.request.contextPath}/resources/blog/back/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/blog/back/js/admin-scripts.js"></script>
 <script src="${ctx }/resources/js/common.js"></script>
 <script src="${ctx }/resources/js/addSection.js"></script>
<script>
//是否确认删除
$(function(){   
	$(".delete").click(function(){
	//alert("进入删除");
		var name = $(this);
		var url="${ctx}/section/delete.json";
		var sectionid = name.attr("rel"); //对应id  
			if(window.confirm("此操作不可逆，是否确认？"))
			{
				$.post(
				url,
				{sectionid:sectionid},
					function(data){
						if(JSON.parse(data).status==200){
									alert("删除成功");
									location.reload();
								}else if(JSON.parse(data).status==300){
									alert("失败！请联系管理员");
								}
							}
				);
			};
		
	});
	//增加新栏目
	$("#save").click(function(){
		var url="${ctx}/section/addsection.json";
		var sectionName=$("#category-name").val();
		var keyWord=$("#category-keywords").val();
		var description=$("#category-describe").val();
		if(categoryname.attr("status")!="true"){
					categoryname.blur();
				}else if(categorykeywords.attr("status")!="true"){
					categorykeywords.blur();
				}else if(categorydescribe.attr("status")!="true"){
					categorydescribe.blur();
				}else{
					if(confirm("确定保存")){
					$.post(
						url,
						{sectionName:sectionName,keyWord:keyWord,description:description},
						function(data){
							if(JSON.parse(data).status==200){
										alert("增加成功");
										location.reload();
									}else if(JSON.parse(data).status==300){
										alert("失败！请联系管理员");
									}
							}
						);
					}
				}
		//异步表单提交
		
	}); 
	//修改
	$("#update").click(function(){
		var url="${ctx}/section/update.json";
		var sectionName=$("#category-name").val();
		var keyWord=$("#category-keywords").val();
		var description=$("#category-describe").val();
		var sectionId=$("#sectionId").val();
		if(categoryname.attr("status")!="true"){
					categoryname.blur();
				}else if(categorykeywords.attr("status")!="true"){
					categorykeywords.blur();
				}else if(categorydescribe.attr("status")!="true"){
					categorydescribe.blur();
				}else{
					//异步表单提交
					if(confirm("确定保存")){
						$.post(
							url,
							{sectionId:sectionId,sectionName:sectionName,keyWord:keyWord,description:description},
							function(data){
								if(JSON.parse(data).status==200){
											alert("修改成功");
											location.href="${ctx}/section/manage.json";
										}else if(JSON.parse(data).status==300){
											alert("失败！请联系管理员");
										}
							}
						
						);
					}
				}
	}); 
	  
});
</script>
</body>
</html>
