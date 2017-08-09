var oldpassword=null;
var newpassword=null;
var againpassword=null;

//使用jquery赋值
$(function(){
	oldpassword=$("#oldpassword");
	newpassword=$("#newpassword");
	againpassword=$("#againpassword");
	
	//友情提示
	oldpassword.next().html("*必填");
	newpassword.next().html("*必填");
	againpassword.next().html("*必填");
	
	//进行验证
	oldpassword.bind("blur",function(){
		if($.trim(oldpassword.val())=="" || oldpassword.val()==null){
			update(oldpassword.next(),{"color" : "red"},imgNo+"原密码不能为空",false)
		}else{
			//使用ajax提交进行验证
			var url=path+"/emp/updatePassword.action";
			$.post(
				url,
				{"oldpassword":oldpassword.val()},
				function(data){
					if(data.retcode=="0"){
						//可以使用
						update(oldpassword.next(),{"color" : "green"},imgYes+"密码正确",true);
					}else{
						update(oldpassword.next(),{"color" : "red"},imgNo+"当前登录用户的密码输入错误",false);
					}
				}
			);
		}
		
	}).bind("focus",function(){
		update(oldpassword.next(),{"color" : "#666666"},"*请输入原密码",false);
	});
	//新密码
	newpassword.bind("blur",function(){
		//对密码的格式进行判断
		if($.trim(newpassword.val())!="" && newpassword.val()!=null && newpassword.val().length>=6&& newpassword.val().length<=20){
			//格式正确
			update(newpassword.next(),{"color" : "green"},imgYes+"密码可以使用",true);
		}else{
			//格式错误
			update(newpassword.next(),{"color" : "red"},imgNo+"密码格式不正确或者为空",false);
		}
	}).bind("focus",function(){
		update(newpassword.next(),{"color" : "#666666"},"*请输入新密码(大于6，小于20位)",false);
	});
	//确认密码
	againpassword.bind("blur",function(){
		//对确认密码进行验证
		if($.trim(againpassword.val())!="" && againpassword.val()!=null && againpassword.val()==newpassword.val() ){
			//两次密码一致
			update(againpassword.next(),{"color" : "green"},imgYes+"可以使用",true);
		}else{
			update(againpassword.next(),{"color" : "red"},imgNo+"两次密码不一致",false);
		}
		
	}).bind("focus",function(){
		update(againpassword.next(),{"color" : "#666666"},"*两次密码必须一致",false);
	});
	
});