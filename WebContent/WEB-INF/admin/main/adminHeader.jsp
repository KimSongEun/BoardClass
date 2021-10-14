<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="./css/admin/main/adminHeader.css?"/> 
	<script type="text/javascript" src="./js/admin/main/adminHeader.js"></script>  
    <header>
		<div class="admin-header">
			<div class="admin-con1"> 
				<span style="font-weight: bold;" class="admin-con1-span">BoardClass</span> <span style="font-weight: nomal;">ADMINPAGE</span>
				<span style="float: right; line-height: 14px;"><a href="#" style="text-decoration:none;color:white;padding-right: 10px;line-height:20px;">LOGOUT</a></span>
			</div>
		</div>	
	</header>
	
	<nav>			
		<div class="admin-nav"> 
			<div class="admin-profile">
				<img class="admin-profile-img" src = "./img/adminprofile.png"></img>
				<p class="admin-nav-id">관리자</p>
			</div>
			
			<ul class="admin-nav-ul">
	            <li class="admin-nav-li" id="menu1">
		            <img class="admin-nav-img" src="./img/dice.png">
		            <a class="admin-header-a" href="adminmain">메인</a>
	            </li>
                <br>
	            <li class="admin-nav-li" id="menu2">
		            <img class="admin-nav-img" src="./img/dice.png">
		            <a class="admin-header-a" href="#">관리자 게시판 관리</a> <span class="li-list" id="menu2_s">▼</span>
	            </li>
	                <ul class="admin-nav-li-ul" id="menu2_ul" style="display: none">
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="noticelist">공지사항 조회</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="noticemadeview">공지사항 등록</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="boardgamelist">보드게임 조회</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="boardgamemadeview">보드게임 등록</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="adlist">광고 조회</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="admadeview">광고 등록</a></li>
	                </ul>
                    <br>
	            <li class="admin-nav-li" id="menu3">
		            <img class="admin-nav-img" src="./img/dice.png">
		            <a class="admin-header-a" href="#">유저 게시판 관리</a> <span class="li-list" id="menu3_s">▼</span>
	            </li>
	                <ul class="admin-nav-li-ul" id="menu3_ul" style="display: none">
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="allboardlist">전체 글 목록</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="allcommentlist">전체 댓글 목록</a></li>
	                </ul>
                    <br>
                <li class="admin-nav-li" id="menu4">
                    <img class="admin-nav-img" src="./img/dice.png">
                    <a class="admin-header-a" href="#">회원관리</a> <span class="li-list" id="menu4_s">▼</span>
                </li>
                    <ul class="admin-nav-li-ul" id="menu4_ul" style="display: none">
                        <li class="admin-nav-li-li"><a class="admin-header-a" href="userlist">회원관리</a></li>
                        <li class="admin-nav-li-li"><a class="admin-header-a" href="reportboardlist">신고된 글</a></li>
                        <li class="admin-nav-li-li"><a class="admin-header-a" href="reportcommentlist">신고된 댓글</a></li>
                    </ul>    
	        </ul>
		</div>
	</nav>
