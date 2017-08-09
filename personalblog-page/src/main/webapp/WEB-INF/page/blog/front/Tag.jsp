<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>addTag</title>
	<style>
		@font-face {
		  font-family: 'iconfont';
		  src: url('font/iconfont.eot');
		  src: url('font/iconfont.eot?#iefix') format('embedded-opentype'),
		  url('font/iconfont.woff') format('woff'),
		  url('font/iconfont.ttf') format('truetype'),
		  url('font/iconfont.svg#iconfont') format('svg');
		}
		.iconfont{
			font-family:"iconfont" !important;
			font-size:16px;font-style:normal;
			-webkit-font-smoothing: antialiased;
			-webkit-text-stroke-width: 0.2px;
			-moz-osx-font-smoothing: grayscale;
		}
		*{
			margin: 0;
			padding: 0;
		}
		.clearfix:after{
			visibility: hidden;
			display: block;
			clear: both;
			content: ".";
			height: 0;
		}
		.clearfix{
			zoom: 1;
		}
		.fl{
			float: left;
		}
		.fr{
			float: right;
		}
		.add-tag{
			/*width: 280px;
			border: 1px solid #ccc;*/
		}
		.item-head{
			/*overflow: hidden;
			height: 36px;
			line-height: 36px;
			padding: 0 10px;
			border-bottom: 1px solid #ccc;*/
			display: none;
		}
		.item-title{
			font-size: 14px;
			font-weight: 600;
		}
		.item-control{
			font-size: 20px;
			cursor: pointer;
		}
		.item-body{
			margin: 10px 10px 20px;
		}
		.item-body form{
			margin: 10px 0;
		}
		.item-body form input{
			width: 180px;
			height: 24px;
			text-indent: 6px;
		}
		.item-body form button{
			width: 46px;
			height: 30px;
			border: 1px solid #ccc;
			border-radius: 3px;
			background: #f3f3f3;
			cursor: pointer;
			outline: none;
		}
		.item-body form button:hover{
			border-color: #999;
		}
		.tip{
			margin: 6px 0;
			font-size: 14px;
		}
		.selected-tag{
			margin: 6px 0;
		}
		.single-tag{
			margin: 4px 8px 4px 0;
			font-size: 14px;
			color: #666;
		}
		i{
			font-style: normal;
		}
		.single-tag i{
			display: inline-block;
			width: 14px;
			height: 14px;
			margin-right: 4px;
			line-height: 14px;
			text-align: center;
			border-radius: 50%;
			color: #fff;
			background: #008EC2;
			cursor: pointer;
		}
		.selected-tag+.tip{
			color: #008EC2;
			text-decoration: underline;
			cursor: pointer;
			user-select: none;
		}
		.select-used span{
			color: #008EC2;
			text-decoration: underline;
			cursor: pointer;
		}
		.select-used{
			display: none;
			padding: 6px;
			border: 1px solid #f3f3f3;
		}
	</style>
</head>
<body>
	<div class="add-tag">
		<div class="item-head">
			<div class="fll item-title">标签</div>
			<div class="fr item-control iconfont">&#xe60b;</div>
		</div>
		<div class="item-body">
			<form name="addTag">
				<input type="text" name="input-tag" id="tag-content"/>
				<input type="button" value="增加" id="add-tag-btn"/>
			</form>
			<div class="tip">多个标签请用英文逗号（,）分开</div>
			<div class="selected-tag clearfix">
			</div>
			<div class="tip">从常用标签中选择</div>
			<div class="select-used">
			<c:forEach var="lable" items="${lables }">
				<span class="single-tag">${lable.labelName }</span>
			</c:forEach>
			</div>
		</div>
	</div>
	<script>
		var wrap = document.querySelector('.add-tag')
		var slide = document.querySelector('.item-control');
		var itemBody = document.querySelector('.item-body');
		var input = document.querySelector('#tag-content');
		var btn = document.querySelector('#add-tag-btn');
		var tip = document.querySelectorAll('.tip')[1];
		var selectedWrap = document.querySelector('.selected-tag');
		var usedTagWrap = document.querySelector('.select-used');
		var usedTag = document.querySelectorAll('.select-used span');
		
		wrapSta = false;
		slide.onclick = function(){
			wrapSta = !wrapSta;
			if (wrapSta)
			{
				this.innerHTML = '&#xe66f;';
				itemBody.style.display = 'none';
				wrap.style.borderBottom = 'none';
			}
			else{
				this.innerHTML = '&#xe60b;';
				itemBody.style.display = 'block';
				wrap.style.borderBottom = '1px solid #ccc';
			}
		}

		var usedSta = false;
		tip.onclick = function(){
			usedSta = !usedSta;
			if (usedSta)
			{
				this.nextElementSibling.style.display = 'block';
			}
			else{
				this.nextElementSibling.style.display = 'none';
			}
		}

		if (usedTagWrap.childElementCount)
		{
			for (var i=0,l=usedTag.length;i<l;i++)
			{
				usedTag[i].onclick = function(){
					var html = '<span class="fl single-tag"><i>&times;</i>'+this.innerHTML+'</span>';
					selectedWrap.innerHTML += html;

					var delTag = document.querySelectorAll('.selected-tag i');
					for (var j=0,len=delTag.length;j<len;j++)
					{
						delTag[j].onclick = function(){
							this.parentNode.parentNode.removeChild(this.parentNode);
						}
					}
				}
			}
		}

		btn.onclick = function(){
			if (input.value.trim()){
				var arr = input.value.split(',');
				for (var i =0 ; i < arr.length; i++){
					var html = '<span class="fl single-tag"><i>&times;</i>'+arr[i]+'</span>';
					selectedWrap.innerHTML += html;
					var delTag = document.querySelectorAll('.selected-tag i');
					for (var j=0,len=delTag.length;j<len;j++)
					{
						delTag[j].onclick = function(){
							this.parentNode.parentNode.removeChild(this.parentNode);
						}
					}
				}
				input.value = '';
				input.focus();
			}

		}
	</script>
</body>
</html>
