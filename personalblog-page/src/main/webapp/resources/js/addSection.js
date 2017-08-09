//定义变量
var categoryname=null;
var categorykeywords=null;
var categorydescribe=null;
var sectionId=null;
$(function(){
	 categoryname=$("#category-name");
	 categorykeywords=$("#category-keywords");
	 categorydescribe=$("#category-describe");
	 sectionId=$("#sectionId");
	//栏目名
	categoryname.bind("blur",function(){
			if($.trim(categoryname.val())=="" || categoryname.val()==null){
						update(categoryname.next(),{"color" : "red"},"栏目不能为空",false)
					}else{
						//使用ajax提交判断
						/*update(categoryname.next(),{"color" : "green"},"栏目可以使用",true);*/
						var url=path+"/section/isSectioNanme.json";
						$.post(
							url,
							{sectionName:categoryname.val(),sectionId:sectionId.val()},
							function(data){
								if(JSON.parse(data).status==200){
									//可以使用
									update(categoryname.next(),{"color" : "green"},"栏目名可以使用",true);
								}else if(JSON.parse(data).status==300){
									//不可以使用
									update(categoryname.next(),{"color" : "red"},"栏目名已经存在",false)
								}
							}	
						);
					}
		
	}).bind("focus",function(){
		update(categoryname.next(),{"color" : "#990F0F"},"*请输入栏目名",false);
	})
	
	//关键字
	categorykeywords.bind("blur",function(){
		if($.trim(categorykeywords.val())=="" || categorykeywords.val()==null){
			update(categorykeywords.next(),{"color" : "red"},"关键字不能为空",false)
		}else{
			update(categorykeywords.next(),{"color" : "green"},"关键字可以使用",true);
		}
		
	}).bind("focus",function(){
		update(categorykeywords.next(),{"color" : "#990F0F"},"*请输入关键字",false);
	})
	
	//描述
	categorydescribe.bind("blur",function(){
		//非空验证
		if($.trim(categorydescribe.val())=="" || categorydescribe.val()==null){
			update(categorydescribe.next(),{"color" : "red"},"描述不能为空",false)
		}else{
			update(categorydescribe.next(),{"color" : "green"},"描述可以使用",true);
		}
		
		
	}).bind("focus",function(){
		update(categorydescribe.next(),{"color" : "#990F0F"},"*请输入描述",false);
		
	})
});

