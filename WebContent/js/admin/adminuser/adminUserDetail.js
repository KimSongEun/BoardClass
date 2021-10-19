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
				html += "<td>"+data.allboarduservolist[i].boardTitle+"</td>";
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