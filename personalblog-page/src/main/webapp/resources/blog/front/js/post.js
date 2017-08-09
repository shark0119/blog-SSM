var oReply = document.getElementsByClassName('replay');
var oLockBar = document.getElementsByClassName('lock-bar');
var oCancelComment = document.getElementsByClassName('cancel-comment');
var oRightAside = document.getElementsByClassName('right-aside')[0];
var oBackup = document.getElementsByClassName('back-to-top')[0];

oBackup.onclick = function(){
    document.documentElement.scrollTop = document.body.scrollTop = 0;
    //animate(document.body,'scrollTop',0,1000);
}

document.body.onscroll = function(){
    var w = (window.innerWidth-1100)/2 - 8;
    if (document.body.scrollTop >= 50){
        oRightAside.style = 'position: fixed;top: 0px;right:'+w+'px;';
    }
    else{
        oRightAside.style = null;
    }
}
// 点击回复 出现编辑回复区域
for (var i= 0,l=oReply.length;i<l;i++){
    oReply[i].onclick = function(){
        if (check() == 1){
            this.nextElementSibling.style.display = 'block';
        }
    }

    oCancelComment[i].onclick = function(){
        this.parentNode.parentNode.style.display = 'none';
    }
}

// 滑动解锁
//for (var j= 0,len=oLockBar.length;j<len;j++){
//    oLockBar[j].index = j;
//    oLockBar[j].onmousedown = function (e) {
//        var e = e || window.event;
//        var x0 = e.clientX;
//        var l = this.offsetLeft;
//        var oThis = this;
//        document.onmousemove = function (e) {
//            var e = e || window.event;
//            var dis = l + e.clientX - x0;
//            dis = dis < 0 ? 0 : dis;
//            dis = dis > 18 ? 18 : dis;
//            if (dis == 18) {
//                oThis.parentNode.style.background = '#3B90F2'
//                oThis.parentNode.parentNode.nextElementSibling.value = '1';
//            }
//            else {
//                oThis.parentNode.style.background = '#f3f3f3';
//                oThis.parentNode.parentNode.nextElementSibling.value = '0';
//            }
//            oThis.style.left = dis + 'px';
//        }
//        document.onmouseup = function () {
//            document.onmousemove = null;
//            document.onmouseup = null;
//        }
//    }
//}
// 点击解锁
for (var j= 0,len=oLockBar.length;j<len;j++){
    oLockBar[j].sta = false;
    oLockBar[j].onclick = function () {
        this.sta = !this.sta;
        if (this.sta){
            this.style.left = '18px';
            this.parentNode.style.background = '#3B90F2'
            this.parentNode.parentNode.nextElementSibling.value = '1';
        }
        else{
            this.style.left = '0';
            this.parentNode.style.background = '#f3f3f3';
            this.parentNode.parentNode.nextElementSibling.value = '0';
        }
    }
}
// 获取元素的非行间样式
function getStyle(obj,attr){
    return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj,null)[attr];
}

// 检查有几个编辑评论区块是展开的
function check(){
    var cnt = 0;
    var o = document.getElementsByClassName('edit-comment');
    for (var i=0;i< o.length;i++){
        if (getStyle(o[i],'display') == 'block'){
            cnt++;
        }
    }
    return cnt;
}

