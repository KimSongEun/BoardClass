<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./css/index/maincss.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/index/main.js"></script>
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
</head>

<body>
<c:import url="/WEB-INF/index/header.jsp" />
	<section>
	<button onclick="topFunction()" id="myBtn" title="Go to top"><img class="topbtnimg" src = "./img/TOP.png"></button>
		
		<!-- 검색 -->
		<div class="search-container">
        <form class="form_search" action="#">
            <div class="custom-select">
                <select>
                    <option value="0">--선택--</option>
                    <option value="1">cate1</option>
                    <option value="2">cate2</option>
                    <option value="3">cate3</option>
                </select>
            </div>
            <div>
                <input type="text" name="main_search">
            </div>
            <div>
                <button type="submit"><i class="fa fa-search"></i></button>
            </div>
        </form>
   		</div>
		
		<!--광고 넣을 부분 -->
		<br>
		<div class="slideshow-container">
			<c:if test="${advolist != null}">
				<c:forEach items="${advolist}" var="a">
					<div class="mySlides fade">
						<div class="numbertext">${a.rownum}/ ${adCnt}</div>
						<img src="<%=request.getContextPath()%>${a.promotionImg}"
							style="width: 100%" onerror="this.src='./img/adtest/기본 광고 이미지.png'">
					</div>
				</c:forEach>
			</c:if>
			<br>
			<div style="text-align: center;">
			<c:if test="${advolist != null}">
				<c:forEach items="${advolist}" var="a">
						<span class="dot" onclick="currentSlide(${a.rownum});"></span>
				</c:forEach>
			</c:if>
					</div>

			<a class="prev" onclick="plusSlides(-1);">&#10094;</a> 
			<a class="next" onclick="plusSlides(1);">&#10095;</a>
		</div>
		<br>

		 <div class="notice-div" style="margin:0 auto;">
                <table class="table  notice-table" style="text-align: center;">
                    <colgroup>
	                   	<col width="100px">
	                   	<col width="300px">
	                   	<col width="150px">
                   	</colgroup>
                    <thead>
                        <tr>
                            <td colspan="2" style="text-align:left; font-size: 18px; font-weight: bold; padding-left:20px"> 📋 공지사항</td>
                            <td style = "font-size : 10px; text-align:right;"><a href = "<%=request.getContextPath() %>/nmain">+더보기</a></td>
                        </tr>
                    </thead>
                    <tbody>
                    <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        <td>공지 번호</td>
                        <td>공지 제목</td>
                        <td>공지 작성일</td>
                    </tr>
			<c:if test="${noticevolist != null}">
				<c:forEach items="${noticevolist}" var="n">						 
                    <tr>
                        <td>${n.announceNo}</td>
                        <td style="white-space : nowrap; text-overflow : ellipsis; overflow : hidden" title = "${n.adminTitle}"><a href="<%=request.getContextPath() %>/cnoticedetail?announceNo=${n.announceNo}" style = "color : #754100;">${n.adminTitle}</a></td>
                        <td>${n.adminRwrDate}</td>
                    </tr>
                   </c:forEach>
                   </c:if>
                   </tbody>
                </table>
            </div>
			<br>
	</section>
	<c:import url="/WEB-INF/index/footer.jsp" />

	<script>
	  	console.log("시작");
	 	var slideIndex = 1;
		var slideIndexAuto = 0;
		var mybutton = document.getElementById("myBtn");
	  	
	  	$(function(){
			showSlides(slideIndex);
			
			showSlidesAuto();
			
			window.onscroll = function() {scrollFunction()};
	  	});
	  	
	  	var x, i, j, l, ll, selElmnt, a, b, c;
	    /* Look for any elements with the class "custom-select": */
	    x = document.getElementsByClassName("custom-select");
	    l = x.length;
	    for (i = 0; i < l; i++) {
	        selElmnt = x[i].getElementsByTagName("select")[0];
	        ll = selElmnt.length;
	        /* For each element, create a new DIV that will act as the selected item: */
	        a = document.createElement("DIV");
	        a.setAttribute("class", "select-selected");
	        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
	        x[i].appendChild(a);
	        /* For each element, create a new DIV that will contain the option list: */
	        b = document.createElement("DIV");
	        b.setAttribute("class", "select-items select-hide");
	        for (j = 1; j < ll; j++) {
	            /* For each option in the original select element,
	            create a new DIV that will act as an option item: */
	            c = document.createElement("DIV");
	            c.innerHTML = selElmnt.options[j].innerHTML;
	            c.addEventListener("click", function (e) {
	                /* When an item is clicked, update the original select box,
	                and the selected item: */
	                var y, i, k, s, h, sl, yl;
	                s = this.parentNode.parentNode.getElementsByTagName("select")[0];
	                sl = s.length;
	                h = this.parentNode.previousSibling;
	                for (i = 0; i < sl; i++) {
	                    if (s.options[i].innerHTML == this.innerHTML) {
	                        s.selectedIndex = i;
	                        h.innerHTML = this.innerHTML;
	                        y = this.parentNode.getElementsByClassName("same-as-selected");
	                        yl = y.length;
	                        for (k = 0; k < yl; k++) {
	                            y[k].removeAttribute("class");
	                        }
	                        this.setAttribute("class", "same-as-selected");
	                        break;
	                    }
	                }
	                h.click();
	            });
	            b.appendChild(c);
	        }
	        x[i].appendChild(b);
	        a.addEventListener("click", function (e) {
	            /* When the select box is clicked, close any other select boxes,
	            and open/close the current select box: */
	            e.stopPropagation();
	            closeAllSelect(this);
	            this.nextSibling.classList.toggle("select-hide");
	            this.classList.toggle("select-arrow-active");
	        });
	    }

	    function closeAllSelect(elmnt) {
	        /* A function that will close all select boxes in the document,
	        except the current select box: */
	        var x, y, i, xl, yl, arrNo = [];
	        x = document.getElementsByClassName("select-items");
	        y = document.getElementsByClassName("select-selected");
	        xl = x.length;
	        yl = y.length;
	        for (i = 0; i < yl; i++) {
	            if (elmnt == y[i]) {
	                arrNo.push(i)
	            } else {
	                y[i].classList.remove("select-arrow-active");
	            }
	        }
	        for (i = 0; i < xl; i++) {
	            if (arrNo.indexOf(i)) {
	                x[i].classList.add("select-hide");
	            }
	        }
	    }

	    /* If the user clicks anywhere outside the select box,
	    then close all select boxes: */
	    document.addEventListener("click", closeAllSelect);
	</script>
</body>
</html>