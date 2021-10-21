<%@page import="kh.semi.boardclass.admin.model.vo.Banner"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
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
                <table class="admin-ad-search">
                <tr>
                	<td>
                    <select class="admin-ad-search-select">
                        <option>광고제목 </option>
                    </select>
                    <input type="text" class="admin-ad-search-input">
                    <input type="button" value="검색" class="admin-ad-search-button">
                    </td>
                    <td style = "text-align : right; font-size : 15px">
                    	표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "adlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "adlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "adlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-ad-table-div">
                    <table class="table table-striped admin-ad-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>글번호</td>
                            <td class = "text-center">메인등록</td>
                            <td>광고제목</td>
                            <td>광고 작성일</td>
                            <td>수정 </td>
                            <td>삭제 </td>
                        </tr>
                        <%if(volist !=null){
						 for(Banner b : volist){ %> 
                        <tr>
                            <td style="vertical-align : middle" class = "promotionNo"><%=b.getPromotionNo() %></td>
                            <td style="vertical-align : middle">
                            	<div class="form-check">
								  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked<%=b.getPromotionNo() %>"<%if(b.getPromotionPlace()==1){ %>checked<%} else{ }%>>
								  <label class="form-check-label" for="flexCheckChecked<%=b.getPromotionNo() %>">
								    	&nbsp; 메인노출
								  </label>
								</div>
                            </td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden"><a href = #사용자가보는광고화면새창열기 target = '_blank' style = "color : #754100"> <%=b.getPromotionTitle() %></a></td>
                            <td style = "vertical-align : middle"><%=b.getPromotionDate() %></td>
                            <td style = "vertical-align : middle"><button class="update btn btn-danger" value="updatego" no="<%=b.getPromotionNo()%>">광고수정</button> </td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" id="<%=b.getPromotionNo() %>">광고삭제</button> </td>
                        </tr>
                         <%} }%> 
                         <tr>
                          <td colspan = "6"><button type="button" class="insert btn btn-primary"
                    style="float : right; background-color: #285226; color: #EAEAEA; border-radius: 5px;">광고작성</button></td>
                    </tr>
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
                    <a class="page-link" href="adlist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
  	<%for (int i = startPage; i <= endPage; i++) {%>
		<li class="page-item"><a class="page-link" href="adlist?pagenum=<%=i%>&viewcount=${viewcount}"><%=i%></a></li>
		<%} if(endPage == pageCount){%>
		<li class="page-item-next disabled">
		<%}else{ %>
                  <li class="page-item-next">
                  <% }%>
                    <a class="page-link" href="adlist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
        </div>
        </div>
    </section>
</body>

</html>