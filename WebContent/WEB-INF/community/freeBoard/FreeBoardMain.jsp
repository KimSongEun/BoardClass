<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<link rel="stylesheet" href="./css/community/freeBoard/freeBoardMain.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" ></script>
</head>
<%@include file="/WEB-INF/community/header.jsp" %>
<body>
<nav id="c_category" class="c_category">
		<ul>
			<li><a href="./cmain">커뮤니티</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="./cf">자유게시판</a></li>
			<li><a href="#">유저정보게시판</a></li>
			<li><a href="#">모임게시판</a></li>
		</ul>
</nav> <!-- TODO 링크 첨부 -->
<section>
<select id="b_category">
  <option value="freeboard">자유게시판</option>
  <option value="userboard">유저정보게시판</option>
  <option value="gathering">모임게시판</option>
</select>
<div id ="a1">

</div>

</section>
<input type="button" value="새글쓰기" id="btn_write" onclick="location.href ='cfwrite'"/>
<!-- <a href="/cfinsert">새글쓰기</a> -->

<script>
//change 될때마다 getListAjax
/* $('#b_category').change(getListAjax=function(){
	$.ajax({
		url: '',
		data:'b_category='+$(this).val(),
		dataType: 'json',
		success : function(data){
			if(!data.data || data.dada=="" || data.data.length<1) return false;
			$('#a1').html(data.data[0].CONTENT);
		},
	});
}); */
//2
$(function(){
	$('#b_category').on('change', getList);
});
	function getList(){
		console.log("ajax 시작부분");
		$.ajax({
			type:"post",
			url: 'commlist',
			data: { category : $('#b_category').val()},
			dataType: 'json',
			success: function(data) {
				if(data.result == "ok") {
					$('#a1').html("");
					for(var i=0; i<data.volist.length; i++){
						var newNode = '<p id="id_'+data.volist[i].boardNo+'"><a href="#">'+data.volist[i].boardNo+'</a>  | '+data.volist[i].boardTitle+'</p>'; 
						$('#a1').append(newNode);
					}
				}else {
					
				}
			}
		});//ajax
	}
</script>



<%@include file="/WEB-INF/community/footer.jsp" %>
</body>
</html>