//定义变量
var empsn=null;
var password=null;
var code=null;

//jquery赋值
$(function(){
	empsn=$("#userNum");
	password=$("#password");
	code=$("#random-code");
	
	//友情提示
	empsn.next().html("*必填");
	password.next().html("*必填");
	code.next().next().html("*必填");
	
	//进行非空验验证
	empsn.bind("blur",function(){
		if($.trim(empsn.val())=="" || empsn.val()==null){
			update(empsn.next(),{"color" : "red"},"工号不能为空",false)
		}else{
			update(empsn.next(),{"color" : "green"},"",true);
		}
	}).bind("focus",function(){
		update(empsn.next(),{"color" : "red"},"请输入工号",false);
	});
	
	//密码
	password.bind("blur",function(){
		//对密码的格式进行判断
		if($.trim(password.val())!="" && password.val()!=null && password.val().length>=6&& password.val().length<=20){
			//格式正确
			update(password.next(),{"color" : "green"},"",true);
		}else{
			//格式错误
			update(password.next(),{"color" : "red"},"密码格式不正确或者为空",false);
		}
	}).bind("focus",function(){
		update(password.next(),{"color" : "red"},"请输入密码，大于6小于20",false);
	});
	//验证码
	code.bind("blur",function(){
		if($.trim(code.val())=="" || code.val()==null){
			update(code.next().next(),{"color" : "red"},"验证码不能为空",false)
		}else{
			//使用ajax提交验证
			var url=path+"/code/verification.action";
			$.post(
					url,
					{"rand":code.val()},
					function(data){
						if(data.retcode=="0"){
							//正确
							update(code.next().next(),{"color" : "green"},"验证码正确",true);
						}else{
							update(code.next().next(),{"color" : "red"},"验证码输入错误",false);
						}
					}
			);
			
		}
	}).bind("focus",function(){
		update(code.next().next(),{"color" : "red"},"请输入验证码",false);
	});
	
});
