<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
%>
<style>
*{
    margin: 0; padding: 0;
    background-color: #f8f3fd;
    box-sizing: border-box;
}
.total {
    font-family: ImcreSoojin;
    width: 1920px;
    height: 1080px;
    margin: 0 auto;
    /* background-color: darksalmon; */
}
header{
    position: relative;
}
.nav{
    width: 1920; height: 25px; 
    
    /* background-color: aqua; */
}
.nav a{text-decoration: none;color: black;}
.navlogin{
    top:5px;
    left: 90%;
    position: absolute;
    font-size: medium;
}
.navcategory{
    text-align: center;
    /* left: 50%;
    transform: translateX(-50%);
    position: absolute; */
    font-size: 25px;
}
.logo{
    /* background-color: antiquewhite; */
    width: 1920px; height: 200px;
    position: relative;
}
.logo img{
    width: 300px;
    position: absolute;
    left: 960px; 
    top: 100px;
    transform: translateX(-50%)translateY(-50%);          
}
#hrdash{
    border: 1px dashed grey;
}
#hrsolid{
    border: 1px solid grey;
}

</style>
<header>
    <div class="nav">
        <nav class="navlogin">
            <a href="#">로그인</a>
            |
            <a href="#">회원가입</a>
        </nav>
    </div>
    <div class="logo">
        <a href="#"><img src="logo.png" alt=""></a>
    </div>
    <hr id="hrdash"><br>
    <div class="nav">
        <nav class="navcategory">
            <a href="#">카테고리</a>
            |
            <a href="#">게임랭킹</a>
            |
            <a href="#">중고거래</a>
            |
            <a href="#">게시판</a>
            | 
            <a href="#">보드게임정보</a>
        </nav>
    </div>
    <br>
    <hr id="hrsolid">
</header>