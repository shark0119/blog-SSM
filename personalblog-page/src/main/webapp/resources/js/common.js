/*显示友情提示的js
 * element:显示提示信息的元素
 * css:样式
 * info:提示信息
 * status:状态：验证是否通过
*/
function update(element,css,info,status){
	element.css(css);
	element.html(info);
	element.prev().attr("status",status);
}
var path=$("#path").val();


