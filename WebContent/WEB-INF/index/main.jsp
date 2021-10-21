<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="./css/index/maincss.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/index/main.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/index/header.jsp" />
	<section>
		<div class="slideshow-container">
        <c:if test = "${advolist != null}">
         <c:forEach items = "${advolist}" var="a" >			
			<div class="mySlides fade">
				<div class="numbertext">1 / 3</div>
				<img src="<%=request.getContextPath()%>${a.promotionImg}" style="width: 100%">
				<div class="text">Caption Text</div>
			</div>
		</c:forEach>
		</c:if>
	<%-- 		<div class="mySlides fade">
				<div class="numbertext">2 / 3</div>
				<img src="<%=request.getContextPath()%>/img/adtest/사이드 광고.jpg" style="width: 100%">
				<div class="text">Caption Two</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext">3 / 3</div>
				<img src="<%=request.getContextPath()%>/img/adtest/카탄 3D 광고.jpg" style="width: 100%">
				<div class="text">Caption Three</div>
				
			</div> --%>

 			<a class="prev" onclick="plusSlides(-1);">&#10094;</a> 
			<a class="next" onclick="plusSlides(1);">&#10095;</a>
		</div>
		<br>
		
		
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1);"></span> 
  <span class="dot" onclick="currentSlide(2);"></span> 
  <span class="dot" onclick="currentSlide(3);"></span> 
</div>

	</section>
	<c:import url="/WEB-INF/index/footer.jsp" />
	
	<script>
  	console.log("시작");
 	var slideIndex = 1;
	showSlides(slideIndex);
	
	function plusSlides(n) {
	  showSlides(slideIndex += n);
	}
	
	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}
	
	function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("dot");
	  if (n > slides.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";
	  }
 	  for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace("active", "");
	  }	 
	  slides[slideIndex-1].style.display = "block";
	   dots[slideIndex-1].className += " active"; 
	}  
	 
	var slideIndexAuto = 0;
	showSlidesAuto();

	function showSlidesAuto() {
	  var i;
	  var slidesAuto = document.getElementsByClassName("mySlides");
	  var dotsAuto = document.getElementsByClassName("dot");
	  for (i = 0; i < slidesAuto.length; i++) {
	    slidesAuto[i].style.display = "none";
	  }
	  slideIndexAuto++;
	  if (slideIndexAuto > slidesAuto.length) {slideIndexAuto = 1}
	  for (i = 0; i < dotsAuto.length; i++) {
		    dotsAuto[i].className = dotsAuto[i].className.replace(" active", "");
		  }
	  slidesAuto[slideIndexAuto-1].style.display = "block";
	  dotsAuto[slideIndexAuto-1].className += " active";
	  setTimeout(showSlidesAuto, 2000); // Change image every 2 seconds
	}
	
	</script>
</body>
</html>