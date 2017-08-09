<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<script type="text/javascript" src="ueditor.config.js"></script>
	<script type="text/javascript" src="ueditor.all.js"></script>
	<!-- <script type="text/javascript" charset="utf-8" src="/style/lang/zh-cn/zh-cn.js"></script> -->
	<script type="text/javascript" src="ueditor.parse.js"></script>
	<script type="text/javascript" src="third-party/jquery-1.10.2.js"></script>



	<div>
 	<script type="text/plain" id="myUeditor" name="content" style="width:800px;height:500px;">
		输入内容………
	</script>
	
	<!-- 内容使用ajax交 -->
	<input id="button" onclick="tijiao();" type="button" value="提交"/>
	<script type="text/javascript">
		var ue=UE.getEditor('myUeditor',{toolbars:[['fullscreen', 'source', 'undo', 'redo',],
				
				['indent','snapscreen','bold','italic','underline','fontfamily', 'fontsize', 'forecolor','backcolor','justifyleft', //居左对齐
        'justifyright', 'justifycenter', 'justifyjustify','strikethrough','fontborder','subscript','superscript',
				 ],
				['formatmatch','removeformat','emotion','pasteplain','selectall','print','preview', 'time', 'date', 'simpleupload', 'insertimage',
				'inserttable','insertrow','insertcol', 'mergeright', 'mergedown', 'deleterow', 'deletecol','splittorows','splittocols',]],
				
            
            	autoHeightEnabled:false,
            	autoWidthEnabled:true
            });
            
            /* uParse("#message",{rootPath:"../third-parth"}); */
            
            function tijiao(){
            	var html=ue.getContent();
            	alert(html);
            	$("#message").html(html);
            	var url="";
            	$.post(url,{"html":html},function(){});
            	
            }
	</script>
</div>

