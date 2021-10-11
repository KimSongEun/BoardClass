<%@page import="kh.semi.boardclass.admin.model.vo.Banner"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Banner> volist=(ArrayList<Banner>)request.getAttribute("bannervolist");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="./css/admin/ad/adminAd.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script type="text/javascript" src="./js/admin/ad/adminAd.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <title>광고 조회</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-ad-section">
            <div class="admin-ad-div">
                <div class="admin-ad-title">광고 조회</div>
                <div class="admin-ad-search">
                    <select class="admin-ad-search-select">
                        <option>광고제목 </option>
                    </select>
                    <input type="text" class="admin-ad-search-input">
                    <input type="button" value="검색" class="admin-ad-search-button">
                <button type="button" class="insert btn btn-primary"
                    style="float : right; background-color: #285226; color: #EAEAEA; border-radius: 5px;">광고작성</button>
                </div>

                <div class="admin-ad-table-div">
                    <table class="table table-striped admin-notice-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>글번호</td>
                            <td style="width : 300px;">광고제목</td>
                            <td>광고 작성일</td>
                            <td>수정 </td>
                            <td>삭제 </td>
                        </tr>
                        <%if(volist !=null){
						 for(Banner b : volist){ %> 
                        <tr>
                            <td><%=b.getPromotionNo() %></td>
                            <td><a href = #사용자가보는공지사항화면새창열기 target = '_blank'> <%=b.getPromotionTitle() %></a></td>
                            <td><%=b.getPromotionDate() %></td>
                            <td><button class="update btn btn-primary" value="updatego" no="<%=b.getPromotionNo()%>">광고수정</button> </td>
                            <td><button class="delete btn btn-primary" value="deletego" id="<%=b.getPromotionNo() %>">광고삭제</button> </td>
                        </tr>
                         <%} }%> 
                    </table>
                </div>

            <div class="admin-ad-page-nav">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                <% if(startPage == 1) {%>
                	<li class="page-item-previous disabled">
                	<%} else { %>
                  <li class="page-item-previous">
                  <% }%>
                    <a class="page-link" href="adlist?pagenum=${startPage-1}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
  	<%for (int i = startPage; i <= endPage; i++) {%>
		<li class="page-item"><a class="page-link" href="adlist?pagenum=<%=i%>"><%=i%></a></li>
		<%} if(endPage == pageCount){%>
		<li class="page-item-next disabled">
		<%}else{ %>
                  <li class="page-item-next">
                  <% }%>
                    <a class="page-link" href="adlist?pagenum=${endPage+1}" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
        </div>
        </div>
        </div>
    </section>
</body>

</html>