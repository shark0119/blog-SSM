<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
		function jump(p,s){
			var oForm = document.searchForm || document.forms[0];
			with(oForm){
				elements["pager.currentPage"].value=p;
				elements["pager.pageSize"].value=s;
				submit();
			}
		
		}
		function jump_to(p,s){
		
		var regexp=/^[1-9]\d*$/;
	 	var totalPage = document.getElementById("totalPage").value;
		if(!regexp.test(p)){
			alert("请输入 正确的数字！");
			return;
		}else if((p-totalPage) > 0){
			alert("总页码一共"+totalPage+"页，请输入正确的页码！");
			return;
		}else{
			jump(p,s);
		}  
		
		}
	</script>
	<input type="hidden" id="totalPage" value='<s:property value='pager.pageCount'/>'/>
	 <table style="width:98%;margin:0 auto;">
    	<tr>
    		<td style="text-align:left;">
    			第<span style="color:red"><s:property value="pager.currentPage"/></span>/<s:property value="pager.pageCount"/>页
    			共<s:property value="pager.total"/>条
    		</td>
    		<td style="text-align:right">
    			<s:if test="pager.currentPage==1">
    				首页
    				上一页
    			</s:if>
    			<s:else>
    				<a style="color:#00f" href="javascript:jump(1,<s:property value="pager.pageSize"/>)">首页</a>
    				<a style="color:#00f" href="javascript:jump(<s:property value="pager.currentPage-1"/>,<s:property value="pager.pageSize"/>)">上一页</a>
    			</s:else>
    			<s:if test="pager.currentPage==pager.pageCount">
    				下一页
    				末页
    			</s:if>
    			<s:else>
    				<a style="color:#00f" href="javascript:jump(<s:property value="pager.currentPage+1"/>,<s:property value="pager.pageSize"/>)">下一页</a>
    				<a style="color:#00f" href="javascript:jump(<s:property value="pager.pageCount"/>,<s:property value="pager.pageSize"/>)">末页</a>
    			</s:else>
    			
    			转到<s:textfield id="gPage" cssStyle="width:15px" name="pager.currentPage"></s:textfield>/<span style="color:red;font-size:13px"><s:property value="pager.pageCount"/></span>页<input type="button" value="GO" onclick="jump_to(document.getElementById('gPage').value,<s:property value="pager.pageSize"/>)" />
    			每页显示：<s:select name="pager.pageSize" list="#{3:'3',5:'5',10:'10',20:'20'}" onchange="jump(1,this.value)"></s:select>
    		</td>
    	</tr>
    </table>