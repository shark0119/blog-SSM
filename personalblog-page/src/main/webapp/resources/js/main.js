(function(){
    /* 时间刷新 */
    refreshDate();
    setInterval(refreshDate,1000);

    function refreshDate(){
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth()+1;
        var dat = date.getDate();
        var hour = date.getHours();
        hour = hour<10?'0'+hour:hour;
        var min = date.getMinutes();
        min = min<10?'0'+min:min;
        var sec = date.getSeconds();
        sec = sec<10?'0'+sec:sec;
        var week = date.getDay();
        switch(week){
            case 1: week="一";break;
            case 2: week="二";break;
            case 3: week="三";break;
            case 4: week="四";break;
            case 5: week="五";break;
            case 6: week="六";break;
            case 0: week="日";break;
            default: break;
        }
        var time = year+"年"+month+"月"+dat+"日&#12288;"+hour+":"+min+":"+sec+"&#12288;"+"星期"+week;

       document.getElementsByClassName('time')[0].innerHTML = time;
    }
})();
