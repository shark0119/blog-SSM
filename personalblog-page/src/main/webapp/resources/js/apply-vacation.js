(function(){
    /* 计算请假时间 */
    var date = document.querySelectorAll("input[type='date']");
    var days = document.getElementById("days");

    date[0].addEventListener("blur",toUnixTime);
    date[1].addEventListener("blur",toUnixTime);

    function toUnixTime(){
        var dat1= date[0].value;
        dat1 = new Date(Date.parse(dat1.replace(/-/g, "/")));
        dat1 = dat1.getTime();

        var dat2= date[1].value;
        dat2 = new Date(Date.parse(dat2.replace(/-/g, "/")));
        dat2 = dat2.getTime();

        // unix时间戳
        var time = (dat2 - dat1)/8.64e7; //一天是8.64e7毫秒
        if (time<=0){
            document.querySelector("#vacation-days").className = "notice";
            days.value = "";
        }
        else{
            document.querySelector("#vacation-days").className = "";
            if(time){
                days.value = time;
            }
        }
    }
})();