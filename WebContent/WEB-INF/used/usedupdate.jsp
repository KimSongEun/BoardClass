<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="./css/index/maincss.css" />
<link rel="stylesheet" href="./css/used/usedupdate.css" />
<title>중고거래글 작성</title>
</head>
<body>
	<%@include file="/WEB-INF/index/header.jsp"%>

	<section>
		<div class="article_create">
			<form class="form_create" action="usedupdate" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="usedNo" value="${used.usedNo}">
				<div class="div_table">
					<table>
						<tr class="tr_img">
							<td class="td_thumbnail">
								<div id="thumbnail">
									<img src="${pageContext.request.contextPath}/${used.usedImg}">
								</div>
							</td>
							<td>
								<input type="file" name="usedImg" onchange="setImg(event);">
							</td>
						</tr>
						<tr>
							<td><label for="title">제목 : </label></td>
							<td><input id="title" name="usedTitle"
								placeholder="제목을 입력해주세요" value="${used.usedTitle}"></td>
						</tr>
						<tr class="tr_price">
							<td><label for="price">가격 : </label></td>
							<td><input id="price" name="usedPrice"
								placeholder="숫자만 입력하세요" value="${used.usedPrice}"></td>
						</tr>
						<tr class="tr_state">
							<td><label for="state">상태 : </label></td>
							<td><select id="state" name="usedState">
									<option value="0">미개봉</option>
									<option value="1">상태좋음</option>
									<option value="2">사용흔적있음</option>
									<option value="3">구성품누락</option>
							</select></td>
						</tr>
						<tr class="tr_changeable">
							<td><label for="changeable">교환여부 : </label></td>
							<td><select id="changeable" name="usedChange">
									<option value="0">교환가능</option>
									<option value="1">교환불가</option>
							</select></td>
						</tr>
						<tr class="tr_changetype">
							<td><label for="changetype">거래방식 : </label></td>
							<td><select id="changetype" name="usedExtype">
									<option value="0">직거래&amp;택배</option>
									<option value="1">직거래</option>
									<option value="2">택배</option>
							</select></td>
						</tr>
						<tr class="tr_file">
							<td><label for="gamecate">카테고리 : </label></td>
							<td><select id="gamecate" name="usedCategory">
									<option value="">없음</option>
									<option value="퍼즐">퍼즐</option>
									<option value="전략">전략</option>
									<option value="추상">추상</option>
									<option value="테마">테마</option>
									<option value="방탈출, 추리">방탈출, 추리</option>
									<option value="2인 추천">2인 추천</option>
									<option value="파티">파티</option>
									<option value="가족">가족</option>
									<option value="어린이">어린이</option>
									<option value="한글">한글</option>
							</select></td>
						</tr>
					</table>
				</div>
				<div class="div_info">
					<label for="info" class="label_down">상품정보</label>
					<textarea id="info" name="usedInfo" placeholder="상품정보를 입력하세요"
						autofocus>${used.usedInfo}</textarea>
					<div id="info_count">(0 / 1,000)</div>
				</div>
				<div class="div_keyword">
					<input class="input_keyword" type="text" id="searchresult" value=""
						placeholder="#검색어" name="keyword" readonly>
				</div>
				<div class="div_search">
					<label for="search" class="label_down">함께 저장할 게임을 검색해주세요!</label> <input
						type="search" id="search" list="keywordResult">
					<button type="button" id="searchadd">추가</button>
					<datalist id="keywordResult">
					</datalist>
					<div id="searchnull"></div>
				</div>
				<div class="div_button">
					<button class="btn_button" type="submit"
						onclick="return checkValAll();">등록</button>
				</div>
			</form>


		</div>
	</section>
	<%@include file="/WEB-INF/index/footer.jsp"%>
	<script>
	
		$(document).ready(function(){
			$("#state option").each(function(){
				if($(this).val()=="${used.usedState}"){
					$(this).attr("selected","true");
				}
			});
			$("#changeable option").each(function(){
				if($(this).val()=="${used.usedChange}"){
					$(this).attr("selected","true");
				}
			});
			$("#changetype option").each(function(){
				if($(this).val()=="${used.usedExtype}"){
					$(this).attr("selected","true");
				}
			});
			$("#gamecate option").each(function(){
				if($(this).val()=="${used.usedCategory}"){
					$(this).attr("selected","true");
				}
			});
		});
	
	
		function checkValAll() {
			console.log("checkValAll함수진입");

			var title = document.getElementById("title");
			var price = document.getElementById("price");
			var info = document.getElementById("info");

			var titleval = title.value;
			var priceval = price.value;
			var infoval = info.value;

			if (!titleval) {
				alert("제목을 입력하세요")
				title.focus();
				return false;
			}

			if (!priceval) {
				alert("가격을 입력하세요");
				price.focus();
				return false;
			}

			var regExpPrice = /^[0-9]{1,7}$/;
			if (!regExpPrice.test(priceval)) {
				alert("숫자만 입력해주세요. 입력가능한 최대금액은 9,999,999입니다.");
				price.focus();
				return false;
			}

			if (!infoval) {
				alert("상품 상세 설명을 작성하세요");
				info.focus();
				return false;
			}
			
			return true;

		}

		$("#search").keyup(searchCB);
		function searchCB() {
			var search = $("#search").val().trim();
			if (search == "") {
				return;
			}
			$.ajax({
						type : "post",
						url : "gamesearch.do",
						data : {
							searchKeyword : search
						},

						dataType : "json",
						success : function(receive) {
							console.log(receive);
							$("#keywordResult").html("");
							if (receive == null) {
								$("#searchnull").html("");
								$("#searchnull").append('<p>검색된 게임이 없습니다</p>');
								return;
							}
							for (var i = 0; i < receive.length; i++) {
								var searchresult = "<option value='" + receive[i].gameKoName + "'>";
								$("#keywordResult").append(searchresult);
							}
						},
						error : function(request, status, error) {
							alert("code:" + request.status + "\n" + "message:"
									+ request.responseText + "\n" + "error:"
									+ error);
						}
					});
		}

		$("#searchadd").click(
				function() {
					var searchval = $("#search").val();
					if (searchval != "") {
						$.ajax({
							type : "post",
							url : "gamematch.do",
							data : {
								matchKeyword : searchval
							},

							dataType : "json",
							success : function(matchresult) {
								if (matchresult > 0) {
									console.log(matchresult);
									$("#searchresult").val(searchval);
								} else {
									alert("존재하지 않는 게임은 추가할 수 없습니다.");
									$("#search").val("");
								}
							},
							error : function(request, status, error) {
								alert("code:" + request.status + "\n"
										+ "message:" + request.responseText
										+ "\n" + "error:" + error);
							}
						});

					}
				});

		
		$("#title").on("keyup", function() {
			if ($(this).val().length > 200) {
				$(this).val($(this).val().substring(0, 200));
			}
		});
		
		
		$("#info").on("keyup", function() {
			$("#info_count").html("(" + $(this).val().length + " / 1,000)");

			if ($(this).val().length > 1000) {
				$(this).val($(this).val().substring(0, 1000));
				$("#info_count").html("(1,000 / 1,000)");
			}
		});

		$(window).on("beforeunload", function() {
			return "작성중인 글은 저장되지 않습니다. 페이지를 나가시겠습니까?";
		});

		$(document).ready(function() {
		    $(".form_create").on("submit", function (e) {
		        $(window).off("beforeunload");
		        return true; })
		    });
		
		function setImg(event) {
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				$("#thumbnail").empty();
				document.querySelector("div#thumbnail").append(img);
				var file= document.document.getElementById("usedImg");
				console.log(file);
			};
			reader.readAsDataURL(event.target.files[0]);
		}

	</script>
</body>
</html>