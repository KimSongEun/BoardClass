$(function(){
    $(".board").click(function(){
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
    })

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
				/*$('#boarddiv').append(data.allboarduservolist[i].boardNo);*/
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