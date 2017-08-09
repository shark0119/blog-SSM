//声明变量
var Empname=null;
var age=null;
var sex=null;
var phone=null;
var address=null;
var button=null;

//使用jquery进行赋值
$(function(){
	//对变量取值
	Empname=$("#Empname");
	age=$("#age");
	sex=$("#sex");
	phone=$("#phone");
	address=$("#address");
	button=$("#btnSave");
	//使用友情提示
	Empname.next().html("*必填");
	age.next().html("*必填");
	sex.next().html("*必选");
	phone.next().html("*必填");
	address.next().html("*必填");
	
	//验证用户名(绑定失去焦点事件！)
	Empname.bind("blur",function(){
		if($.trim(Empname.val())==""){
			update(Empname.next(), {"color" : "red"}, imgNo+"用户名不能为空！", false);
		}else{
			update(Empname.next(), {"color" : "green"}, imgYes+"用户名可以使用！", true);
		}
		
	}).bind("focus",function(){
		update(Empname.next(), {"color" : "#666666"},"* 请输入你的姓名！", false);
	});
	//年龄的验证
	age.bind("blur",function(){
		//使用正则
		var agetest=/^(1[89]|[2-8][0-9]|90)$/;
		if(agetest.test(age.val())){
			update(age.next(), {"color" : "green"}, imgYes+"年龄可以使用！", true);
		}else{
			update(age.next(), {"color" : "red"}, imgNo+"年龄格式不正确(18—90岁)！", false);
		}
		
	}).bind("focus",function(){
		update(age.next(), {"color" : "#666666"},"* 请输入年龄(18-90岁)！", false);
	});
	//手机
	phone.bind("blur",function(){
		var phonetest=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(phonetest.test(phone.val())){
			update(phone.next(), {"color" : "green"}, imgYes+"手机号码可以使用！", true);
		}else{
			update(phone.next(), {"color" : "red"}, imgNo+"手机格式不正确(13/15/18开头)！", false);
		}
		
	}).bind("focus",function(){
		update(phone.next(), {"color" : "#666666"},"* 请输入手机号码(13/15/18开头)！", false);
	});
	//地址
	address.bind("blur",function(){
		if($.trim(address.val())==""){
			update(address.next(), {"color" : "red"}, imgNo+"地址不能为空！", false);
		}else{
			update(address.next(), {"color" : "green"}, imgYes+"地址可以使用！", true);
		}
	}).bind("focus",function(){
		update(address.next(), {"color" : "#666666"},"* 请输入地址！", false);
	});
	//移出事件
	Empname.blur();
	age.blur();
	phone.blur();
	address.blur();
	//按钮验证
	/*button.bind("click",function(){
		if(Empname.attr("status")=="true" && age.attr("status")=="true"&&phone.attr("status")=="true"
			&&address.attr("status")=="true"){
			if(confirm("确定修改")){
				//updateUser.submit();
				
    			};
    		$("#editForm").ajaxSubmit(options);
			}
		}
		
	});*/
});
