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
	  setTimeout(showSlidesAuto, 2000);
	}	

