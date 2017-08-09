// qdshen.js 存放一些通用函数

// 秒转化成时分秒函数
function secToHms(sec){
    var sec = parseInt(sec);
    var hours = ~~(sec/3600);
    var minutes = Math.floor((sec - hours*3600)/60);
    var seconds = sec%60;
    hours = hours<10?'0'+hours:hours;
    minutes = minutes<10?'0'+minutes:minutes;
    seconds = seconds<10?'0'+seconds:seconds;

    if (hours == '00'){
        return minutes+':'+seconds;
    }
    else{
        return hours+':'+minutes+':'+seconds;
    }
}
//时间版运动函数
function animate(obj,attr,target,time){
    var startVal = parseInt(getStyle(obj,attr));
    var startTime = new Date();
    var timer = setInterval(function(){
        var nowTime = new Date();
        var prop = (nowTime - startTime) / time;
        if (prop >= 1){
            clearInterval(timer);
            prop = 1;
        }
        obj.style[attr] = prop*(target - startVal) + startVal + "px";
    },13);
}
// 获取元素的非行间样式
function getStyle(obj,attr){
    return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj,null)[attr];
}
// 获取本地时间函数
function getTime(){
    var time = new Date();
    var year = time.getFullYear();
    var month = time.getMonth() + 1;
    var date = time.getDate();
    var hours = time.getHours();
    var minutes = time.getMinutes();
    var seconds = time.getSeconds();
    var week = time.getDay();

    month = month<10?'0'+month:month;
    date = date<10?'0'+date:date;
    hours = hours<10?'0'+hours:hours;
    minutes = minutes<10?'0'+minutes:minutes;
    seconds = seconds<10?'0'+seconds:seconds;

    switch(week){
        case 1: week='一';break;
        case 2: week='二';break;
        case 3: week='三';break;
        case 4: week='四';break;
        case 5: week='五';break;
        case 6: week='六';break;
        case 0: week='日';break;
        default: break;
    }

    return month+'/'+date+'||'+hours+':'+minutes+':'+seconds+'||'+'星期'+week;
    // 拿到数据可用split拆分
}

