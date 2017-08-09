(function(){
    var approval = document.querySelectorAll(".vacation-list-body ul li:nth-child(5)");
    var approveBtn = document.querySelectorAll(".vacation-list-body ul li:nth-child(7)");
    for (var i= 0,l=approval.length;i<l;i++){
        if(approval[i].innerHTML == "未审核"){
            /* 让审批状态字体变成#963 */
            approval[i].style.color = "#08f";
            approval[i].style.fontWeight = "600";
            /* 让操作按钮变成蓝色(可操作) */
            approveBtn[i].style.color = "#4E93BB";
            approveBtn[i].onmouseover = function(){
                this.style.color = "#4E93FF";
            };
            approveBtn[i].onmouseout = function(){
                this.style.color = "#4E93BB";
            }
            /* 未审核的按钮点击才有事件 */
            approveBtn[i].onclick = function(){
                window.parent.document.getElementById("myframe").src = "approve-vacation.html";
            }
        }
        else if(approval[i].innerHTML == "已审核"){
            approval[i].style.color = "#999";
            approval[i].style.fontWeight = "600";
            //approveBtn[i].style.display = "none";
        }
        else if(approval[i].innerHTML == "审核拒绝"){
            /* 让审批状态字体变成红色 */
            approval[i].style.color = "#d00";
            approval[i].style.fontWeight = "600";
        }
    }
})();