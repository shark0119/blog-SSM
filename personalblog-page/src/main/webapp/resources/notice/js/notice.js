var readMark = document.querySelector('.read-mark');
var empty = document.querySelector('.empty');

readMark.onclick = function(){
    var singleNotice = document.querySelectorAll('.single-notice');

    for (var i= 0,l=singleNotice.length;i<l;i++){
        singleNotice[i].classList.add('read');
    }
}
empty.onclick = function(){
    var singleNotice = document.querySelectorAll('.single-notice');
    var noticeList = document.querySelector('.notice-list');

    for (var i= 0,l=singleNotice.length;i<l;i++){
        noticeList.removeChild(singleNotice[i]);
    }
}
