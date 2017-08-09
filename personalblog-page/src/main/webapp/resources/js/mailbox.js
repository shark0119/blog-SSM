(function(){
    var oDel = document.querySelectorAll(".email-list-body ul>li:last-child");
    var oEmailBox = document.querySelector(".email-list-body");
    var oUl = document.querySelectorAll(".email-list-body ul");
    // 全选 和 删除
    var oBtn = document.querySelectorAll("input[type='button']");
    // 复选框
    var oCheckBox = document.querySelectorAll("input[type='checkbox']");

    //单个删除
   /*oDel.forEach(function(value,index,array){
       value.onclick = function(){
           if(confirm("确定删除此邮件吗?")){
               oEmailBox.removeChild(oUl[index]);
           }
       }
   });*/

   //全选/全不选
    /*oBtn[0].sta = false;
    oBtn[0].onclick = function(){
        var oCheckBox = document.querySelectorAll("input[type='checkbox']");
        if (this.sta){
            for (var i=0;i<oCheckBox.length;i++){
                oCheckBox[i].checked = null;
            }
        }
        else{
            for (var i=0;i<oCheckBox.length;i++){
                oCheckBox[i].checked = "checked";
            }
        }
        this.sta = !this.sta;
    };*/
   //全部删除
    /*oBtn[1].onclick = function(){
        var arr = [];
        var oCheckBox = document.querySelectorAll("input[type='checkbox']");
        oCheckBox.forEach(function(value,index,array){
            if (value.checked){
                arr.push(index);
            }
        });
        console.log(arr);
        //遍历结束删除全部
        if (arr.length) {
            if (confirm("确定删除这些邮件吗?")) {
                var oUl = document.querySelectorAll(".email-list-body ul");
                for (var i = 0, l = arr.length; i < l; i++) {
                    //oUl[arr[i]].style.display = "none";
                    oEmailBox.removeChild(oUl[arr[i]]);
                }
            }
        }
    }
*/
    //区分未读和已读邮件
    var regExp = /unread/;
    oUl.forEach(function(value,index,array){
        var icon = oUl[index].querySelector("li:nth-child(5)");
        /* 未读 */
        if (regExp.test(value.className)){
            oUl[index].style.color = "#000";
            oUl[index].style.fontWeight = "600";
            icon.innerHTML = "&#xe61a;";
            icon.style.color = "gold";
           // console.log("未读");
        }
        /* 已读 */
        else{
            icon.innerHTML = "&#xe7a6;";
            icon.style.color = "#ccc";
            //console.log("已读");
        }
    });
})();
