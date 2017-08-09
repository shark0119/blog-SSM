//定义变量
var sn=null;
var password=null;
var empname=null;
var age=null;
var phone=null;
var address=null;


//使用jquery封装
$(function(){
	sn=$("#sn");
	password=$("#password");
	empname=$("#empname");
	age=$("#age");
	phone=$("#phone");
	address=$("#address");
	//提示
	sn.next().html("*必填");
	password.next().html("*必填");
	empname.next().html("*必填");
	age.next().html("*必填");
	phone.next().html("*必填");
	address.next().html("*必填");
	
	//开始验证
	sn.bind("blur",function(){
		if($.trim(sn.val())==""||sn.val()==null){
			update(sn.next(), {"color" : "red"}, imgNo+"用户工号不能为空", false);
		}else{
			//使用ajax验证
			var url=path+"/emp/isSn.action";
			$.post(
				url,
				{"employee.sn":sn.val()},
				function(data){
					if(data.retcode=="0"){
						//可以使用
						update(sn.next(), {"color" : "green"}, imgYes+"用户工号可以使用！", true);
					}else{
						update(sn.next(), {"color" : "red"}, imgNo+"用户工号已经存在", false);
					}
				}
			);
		}
		
	}).bind("focus",function(){
		update(sn.next(), {"color" : "#666666"},"* 请输入用户工号！用户登录的，请牢记！！", false);
	});
	//密码
	password.bind("blur",function(){
		if($.trim(password.val())!=""&&password.val()!=null&&password.val().length>=6&&password.val().length<=20){
			update(password.next(), {"color" : "green"}, imgYes+"弱！", true);
		}else{
			update(password.next(), {"color" : "red"}, imgNo+"密码为空！或者格式错误", false);
		}
		
		}).bind("focus",function(){
			update(password.next(), {"color" : "#666666"},"* 6到20 位！", false);
		});
	//姓名
	empname.bind("blur",function(){
		if($.trim(empname.val())==""||empname.val()==null){
			update(empname.next(), {"color" : "red"}, imgNo+"用户姓名不能为空", false);
		}else{
			var nametest=/^[\u0391-\uFFE5]+$/;
			if(nametest.test(empname.val())){
				update(empname.next(), {"color" : "green"}, imgYes+"用户姓名可以使用！", true);
			}else{
				update(empname.next(), {"color" : "red"}, imgNo+"姓名格式不正确", false);
			}
		}
	}).bind("focus",function(){
		update(empname.next(), {"color" : "#666666"},"* 请输姓名(不包含特殊字符 例如@#)！", false);
	});

	//年龄
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
	
});