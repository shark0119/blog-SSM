var starttime=null;
var endtime=null;
var days=null;
var cause=null;
var approverid=null;

//使用jqery赋值
$(function(){
	starttime=$("#starttime");
	endtime=$("#endtime");
	days=$("#days");
	cause=$("#cause");
	approverid=$("#approverid");
	
	starttime.next().html("*必填");
	endtime.next().html("*必填");
	days.next().html("*自动计算");
	cause.next().html("*必填");
	approverid.next().html("*必填");
	//开始验证
	starttime.bind("blur",function(){
		var myDate=new Date();  
		var mytime=myDate.toLocaleDateString();
		//将对比的时间进行格式化
		var start = new Date(starttime.val().replace("-", "/").replace("-", "/"));
        var end = new Date(mytime.replace("-", "/").replace("-", "/"));
        if(start<end){
			update(starttime.next(), {"color" : "red"}, imgNo+"日期只能大于现在日期!", false);
		}else if($.trim(starttime.val())==""|| starttime.val()==null ){
			update(starttime.next(), {"color" : "red"}, imgNo+"日期不能为空", false);
		}else{
			update(starttime.next(), {"color" : "green"}, imgYes+"日期可以使用", true);
		}
	}).bind("focus",function(){
			update(starttime.next(), {"color" : "#666666"},"*选择开始日期", false);
	});
	
	
	endtime.bind("blur",function(){
		//对比时间
		var start = new Date(starttime.val().replace("-", "/").replace("-", "/"));
        var end = new Date(endtime.val().replace("-", "/").replace("-", "/"));
        
        if(start>end){
			update(endtime.next(), {"color" : "red"}, imgNo+"结束日期小于开始时间!", false);
			update(days.next(), {"color" : "red"}, imgNo+"您的日期不合理!", false);
		}else if($.trim(endtime.val())==""|| endtime.val()==null ){
			update(endtime.next(), {"color" : "red"}, imgNo+"日期不能为空", false);
		}else if(start.getDay()==end.getDay()){
			update(endtime.next(), {"color" : "red"}, imgNo+"开始日期和结束日期不能相同！", false);
			update(days.next(), {"color" : "red"}, imgNo+"您的日期不合理!", false);
		}else{
			update(endtime.next(), {"color" : "green"}, imgYes+"日期可以使用", true);
		}
			
		}).bind("focus",function(){
			
		});


	days.bind("blur",function(){
		if($.trim(days.val())!=""&&days.val()!=null){
			update(days.next(), {"color" : "green"}, imgYes+"可以使用！", true);
		}else{
			update(days.next(), {"color" : "red"}, imgNo+"天数未计算", false);
		}
		
	}).bind("focus",function(){
		update(days.next(), {"color" : "#666666"},"* 自动计算！", false);
	});


	cause.bind("blur",function(){
		if($.trim(cause.val())!=""&&cause.val()!=null){
			update(cause.next(), {"color" : "green"}, "可以使用！", true);
		}else{
			update(cause.next(), {"color" : "red"}, "原因不能为空", false);
		}
		
	}).bind("focus",function(){
		update(cause.next(), {"color" : "#666666"},"* 请输入请假原因！", false);
	});
		
	
});