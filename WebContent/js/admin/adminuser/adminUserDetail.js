function openPage(pageName,elmnt) {
    console.log("시작");
    var i, tabcontent;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    document.getElementById(pageName).style.display = "block"; 
  }
$(function(){
 /*   $(".board").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#boarddiv"));
        $("#boarddiv").fadeIn(300);
    })
    $(".used").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#useddiv"));
        $("#useddiv").fadeIn(500);
    })
    $(".comt").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#comtdiv"));
        $("#comtdiv").fadeIn(500);
    })
    $(".review").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#reviewdiv"));
        $("#reviewdiv").fadeIn(500);
    })
    $(".reportboard").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#reportboarddiv"));
        $("#reportboarddiv").fadeIn(300);
    })
    $(".reportused").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#reportuseddiv"));
        $("#reportuseddiv").fadeIn(500);
    })
    $(".reportcomt").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#reportcomtdiv"));
        $("#reportcomtdiv").fadeIn(500);
    })
    $(".reportreview").click(function(){
        $("#contentdiv").text("");
        $("#contentdiv").append($("#reportreviewdiv"));
        $("#reportreviewdiv").fadeIn(500);
    })*/

	$(".board").click(boarddetail);
	function boarddetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailboard.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.allboarduservolist.length; i++){
				html += "<tr>"
				html += "<td>"+data.allboarduservolist[i].boardNo+"</td>";
				html += "<td>"+data.allboarduservolist[i].boardCategory+"</td>";
				html += "<td>"+data.allboarduservolist[i].boardType+"</td>";
				html += "<td id = 'tda'><a href = #게시글조회가기 target='blank'>"+data.allboarduservolist[i].boardTitle+"</a></td>";
				html += "<td style = 'white-space : nowrap; text-overflow : ellipsis; overflow : hidden'>"+data.allboarduservolist[i].boardContent+"</td>";
				html += "<td>"+data.allboarduservolist[i].boardRewriteDate+"</td>";
				html += "</tr>";
		}
		$("#input_data").html(html);
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	
	$(".used").click(useddetail);
	function useddetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailused.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.usedvolist.length; i++){
				var usedState = data.usedvolist[i].usedState;
				if(usedState == '0'){
					usedState = '미개봉'
				} else if (usedState == '1') {
					usedState = '상태좋음'
				} else if (usedState == '2') {
					usedState = '사용흔적있음'
				} else if (usedState == '3') {
					usedState = '구성품누락'
				}
				var usedChange = data.usedvolist[i].usedChange;
				if(usedChange == '0') {
					usedChange = '교환가능'
				} else if(usedChange == '1') {
					usedChange = '교환불가능'
				}
				var usedExtype = data.usedvolist[i].usedExtype;
				if(usedExtype == '0') {
					usedExtype = '직거래&택배'
				} else if (usedExtype == '1') {
					usedExtype = '직거래'
				} else if (usedExtype == '2') {
					usedExtype = '택배'
				}
				console.log(usedState);
				html += "<tr>"
				html += "<td>"+data.usedvolist[i].usedNo+"</td>";
				html += "<td style = 'white-space : nowrap; text-overflow : ellipsis; overflow : hidden' id = 'tda'><a href = #중고글조회가기 target='blank'>"+data.usedvolist[i].usedTitle+"</a></td>";
				html += "<td>"+usedState+"</td>";
				html += "<td>"+usedChange+"</td>";
				html += "<td>"+usedExtype+"</td>";
				html += "<td>"+data.usedvolist[i].usedPrice+"</td>";
				html += "<td>"+data.usedvolist[i].usedCategory+"</td>";
				html += "</tr>";
			}

				console.log(usedState);
		$("#input_data").html(html);
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
	};
	
	$(".comt").click(comtdetail);
	function comtdetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailcomment.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.commentvolist.length; i++){
				html += "<tr>"
				html += "<td>"+data.commentvolist[i].commentNo+"</td>";
				html += "<td>"+data.commentvolist[i].boardTitle+"</td>";
				html += "<td style = 'white-space : nowrap; text-overflow : ellipsis; overflow : hidden' id = 'tda'><a href = #댓글조회가기 target='blank'>"+data.commentvolist[i].commentContent+"</a></td>";
				html += "<td>"+data.commentvolist[i].commentRewriteDate+"</td>";
				html += "</tr>";
		}
		$("#input_data").html(html);
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	
	$(".review").click(reviewdetail);
	function reviewdetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailreview.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.reviewvolist.length; i++){
				html += "<tr>"
				html += "<td>"+data.reviewvolist[i].reviewNo+"</td>";
				html += "<td>"+data.reviewvolist[i].gameKoName+"</td>";
				html += "<td style = 'white-space : nowrap; text-overflow : ellipsis; overflow : hidden' id = 'tda'><a href = #리뷰 조회가기 target='blank'>"+data.reviewvolist[i].reviewContent+"</a></td>";
				html += "<td>"+data.reviewvolist[i].reviewDate+"</td>";
				html += "</tr>";
		}
		$("#input_data").html(html);
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	
	$(".reportboard").click(reportboarddetail);
	function reportboarddetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailreportboard.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.reportboardvolist.length; i++){
				html += "<tr>"
				html += "<td style = 'color : #f55354'>"+data.reportboardvolist[i].reportCount+"</td>";
				html += "<td>"+data.reportboardvolist[i].boardNo+"</td>";
				html += "<td>"+data.reportboardvolist[i].boardCategory+"</td>";
				html += "<td>"+data.reportboardvolist[i].boardType+"</td>";
				html += "<td id = 'tda'><a href = #게시글조회가기 target='blank'>"+data.reportboardvolist[i].boardTitle+"</a></td>";
				html += "<td>"+data.reportboardvolist[i].boardRewriteDate+"</td>";
				html += "<td style = 'vertical-align : middle'><button class='delete btn warning' value='deletego' id = '"+data.reportboardvolist[i].boardNo+"'>삭제</button></td>";
				html += "</tr>";
		}
		$("#input_data").html(html);
		$(".delete").click(function () {
				console.log("눌림");
		var deleteid = $(this).attr("id");
		if(confirm(deleteid+"번 게시글 삭제하시겠습니까?")){
			location.href = "userdetailreportboarddelete?userId="+user_id+"&boardNo=" + deleteid;
		} else {
		}
});
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
	 
	};

	
	
	$(".reportused").click(reportuseddetail);
	function reportuseddetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailreportused.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.reportusedvolist.length; i++){
				var usedState = data.reportusedvolist[i].usedState;
				if(usedState == '0'){
					usedState = '미개봉'
				} else if (usedState == '1') {
					usedState = '상태좋음'
				} else if (usedState == '2') {
					usedState = '사용흔적있음'
				} else if (usedState == '3') {
					usedState = '구성품누락'
				}
				var usedChange = data.reportusedvolist[i].usedChange;
				if(usedChange == '0') {
					usedChange = '교환가능'
				} else if(usedChange == '1') {
					usedChange = '교환불가능'
				}
				var usedExtype = data.reportusedvolist[i].usedExtype;
				if(usedExtype == '0') {
					usedExtype = '직거래&택배'
				} else if (usedExtype == '1') {
					usedExtype = '직거래'
				} else if (usedExtype == '2') {
					usedExtype = '택배'
				}
				console.log(usedState);
				html += "<tr>"
				html += "<td style = 'color : #f55354'>"+data.reportusedvolist[i].reportCount+"</td>";
				html += "<td>"+data.reportusedvolist[i].usedNo+"</td>";
				html += "<td style = 'white-space : nowrap; text-overflow : ellipsis; overflow : hidden' id = 'tda'><a href = #중고글조회가기 target='blank'>"+data.reportusedvolist[i].usedTitle+"</a></td>";
				html += "<td>"+usedState+"</td>";
				html += "<td>"+usedChange+"</td>";
				html += "<td>"+usedExtype+"</td>";
				html += "<td>"+data.reportusedvolist[i].usedPrice+"</td>";
				html += "<td>"+data.reportusedvolist[i].usedCategory+"</td>";
				html += "<td style = 'vertical-align : middle'><button class='delete btn warning' value='deletego' id = '"+data.reportusedvolist[i].usedNo+"'>삭제</button></td>";
				html += "</tr>";
			}

				console.log(usedState);
		$("#input_data").html(html);
		$(".delete").click(function () {
				console.log("눌림");
		var deleteid = $(this).attr("id");
		if(confirm(deleteid+"번 중고글 삭제하시겠습니까?")){
			location.href = "userdetailreportuseddelete?userId="+user_id+"&usedNo=" + deleteid;
		} else {
		}
});		
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
	};
	
	$(".reportcomt").click(reportcomtdetail);
	function reportcomtdetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailreportcomment.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.reportcommentvolist.length; i++){
				html += "<tr>"
				html += "<td style = 'color : #f55354'>"+data.reportcommentvolist[i].reportCount+"</td>";
				html += "<td>"+data.reportcommentvolist[i].commentNo+"</td>";
				html += "<td>"+data.reportcommentvolist[i].boardTitle+"</td>";
				html += "<td style = 'white-space : nowrap; text-overflow : ellipsis; overflow : hidden' id = 'tda'><a href = #댓글조회가기 target='blank'>"+data.reportcommentvolist[i].commentContent+"</a></td>";
				html += "<td>"+data.reportcommentvolist[i].commentRewriteDate+"</td>";
				html += "<td style = 'vertical-align : middle'><button class='delete btn warning' value='deletego' id = '"+data.reportcommentvolist[i].commentNo+"'>삭제</button></td>";
				html += "</tr>";
		}
		$("#input_data").html(html);
		$(".delete").click(function () {
				console.log("눌림");
		var deleteid = $(this).attr("id");
		if(confirm(deleteid+"번 커뮤니티 댓글 삭제하시겠습니까?")){
			location.href = "userdetailreportcommentdelete?userId="+user_id+"&commentNo=" + deleteid;
		} else {
		}
});		
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	
	$(".reportreview").click(reportreviewdetail);
	function reportreviewdetail() {
		var user_id = $(this).attr("id");
		console.log(user_id);
		$.ajax({
		url : "userdetailreportreview.ajax",
		type : "post",
		data : {userId : user_id},
		dataType : "json",
		success : function(data){
			console.log("ajax 성공");
			var html = "";
			for(var i=0; i<data.reportreviewvolist.length; i++){
				html += "<tr>"
				html += "<td style = 'color : #f55354'>"+data.reportreviewvolist[i].reportCount+"</td>";
				html += "<td>"+data.reportreviewvolist[i].reviewNo+"</td>";
				html += "<td>"+data.reportreviewvolist[i].gameKoName+"</td>";
				html += "<td style = 'white-space : nowrap; text-overflow : ellipsis; overflow : hidden' id = 'tda'><a href = #리뷰 조회가기 target='blank'>"+data.reportreviewvolist[i].reviewContent+"</a></td>";
				html += "<td>"+data.reportreviewvolist[i].reviewDate+"</td>";
				html += "<td style = 'vertical-align : middle'><button class='delete btn warning' value='deletego' id = '"+data.reportreviewvolist[i].reviewNo+"'>삭제</button></td>";
				html += "</tr>";
		}
		$("#input_data").html(html);
		$(".delete").click(function () {
				console.log("눌림");
		var deleteid = $(this).attr("id");
		if(confirm(deleteid+"번 리뷰글 삭제하시겠습니까?")){
			location.href = "userdetailreportreviewdelete?userId="+user_id+"&reviewNo=" + deleteid;
		} else {
		}
});		
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	
		$(".memberdelete").click(function () {
				console.log("눌림");
		var deleteid = $(this).attr("id");
		if(confirm(deleteid+"님 강제 탈퇴하시겠습니까?")){
			location.href = "userdelete?userId="+ deleteid;
		} else {
		}
});		
    // $("#board").click(function(){
    //     console.log("클릭");
    //     $("#test").show();
    // });
    // //$(".subnav").mouseover();
    // $(".subnav").mouseover(function(){
    //     $(this).show();
    // });
    // $(".subnav").(function(){
    //     $(this).show();
    // });
    // $(".a").click(function(){
    //     var clickedIdx = $(this).index();
    //     $(".b").each(function(index,element){
    //         if(index==clickedIdx) {
    //             $(element).fadeIn();
    //         } else {
    //             $(element).hide();
    //         }
    //     })
    // });

    // $(".c").click(function(){
    //     var clickedIdx = $(this).index();
    //     $(".d").each(function(index,element){
    //         if(index==clickedIdx) {
    //             $(element).fadeIn();
    //         } else {
    //             $(element).hide();
    //         }
    //     })
    // });

    // $(".e").click(function(){
    //     var clickedIdx = $(this).index();
    //     $(".f").each(function(index,element){
    //         if(index==clickedIdx) {
    //             $(element).fadeIn();
    //         } else {
    //             $(element).hide();
    //         }
    //     })
    // });

    // $(".g").click(function(){
    //     var clickedIdx = $(this).index();
    //     $(".h").each(function(index,element){
    //         if(index==clickedIdx) {
    //             $(element).fadeIn();
    //         } else {
    //             $(element).hide();
    //         }
    //     })
    // });
})