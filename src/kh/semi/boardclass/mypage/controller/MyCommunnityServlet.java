package kh.semi.boardclass.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.mypage.model.service.MyPageService;
import kh.semi.boardclass.mypage.model.vo.UserMyComt;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class MyCommunnityServlet
 */
@WebServlet("/mycommunity")
public class MyCommunnityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCommunnityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		final int PAGE_SIZE = 5; // 한 페이지 당 글 개수
		final int PAGE_BLOCK = 5; // 한 화면에 나타날 페이지 링크수
		int bCount = 0; // 총 글수
		int pageCount = 0; // 총 페이지수
		int startPage = 1; // 화면에 나타날 시작페이지
		int endPage = 1; // 화면에 나타날 마지막페이지
		int currentPage = 1; // 눌려진 페이지
		int startRnum = 1; // 화면에 나타날 글 번호
		int endRnum = 1; // 화면에 나타날 글 번호

		final int PAGE_SIZE2 = 5; // 한 페이지 당 글 개수
		final int PAGE_BLOCK2 = 5; // 한 화면에 나타날 페이지 링크수
		int bCount2 = 0; // 총 글수
		int pageCount2 = 0; // 총 페이지수
		int startPage2 = 1; // 화면에 나타날 시작페이지
		int endPage2 = 1; // 화면에 나타날 마지막페이지
		int currentPage2 = 1; // 눌려진 페이지
		int startRnum2 = 1; // 화면에 나타날 글 번호
		int endRnum2 = 1; // 화면에 나타날 글 번호

		String pageNum = request.getParameter("pagenum");
		if (pageNum != null) { // 눌려진 페이지가 있음.
			currentPage = Integer.parseInt(pageNum);
		}
		String pageNum2 = request.getParameter("pagenum2");
		if (pageNum2 != null) { // 눌려진 페이지가 있음.
			currentPage2 = Integer.parseInt(pageNum2);
		}
		HttpSession session = request.getSession();
		String userId = ((User) session.getAttribute("userSession")).getUserId();
		System.out.println(userId);
		bCount = new MyPageService().getMyBoardCount(userId);
		System.out.println("토탈컨텐츠 : " + bCount);
		bCount2 = new MyPageService().getMyBoardComtCount(userId);
		System.out.println("토탈컨텐츠 : " + bCount2);
		
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);

		// rownum 조건 계산
		startRnum = (currentPage - 1) * PAGE_SIZE + 1; 
		endRnum = startRnum + PAGE_SIZE - 1;
		if (endRnum > bCount)
			endRnum = bCount;

		if (currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK - 1) * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		ArrayList<Board> volist = new MyPageService().myBoardList(userId, startRnum, endRnum);
		System.out.println("volist " + volist);

		request.setAttribute("volist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);

	
		pageCount2 = (bCount2 / PAGE_SIZE2) + (bCount2 % PAGE_SIZE2 == 0 ? 0 : 1);

		
		startRnum2 = (currentPage2 - 1) * PAGE_SIZE2 + 1; 
		endRnum2 = startRnum2 + PAGE_SIZE2 - 1;
		if (endRnum2 > bCount2)
			endRnum2 = bCount2;

		if (currentPage2 % PAGE_BLOCK2 == 0) {
			startPage2 = (currentPage2 / PAGE_BLOCK2 - 1) * PAGE_BLOCK2 + 1;
		} else {
			startPage2 = (currentPage2 / PAGE_BLOCK2) * PAGE_BLOCK2 + 1;
		}
		endPage2 = startPage2 + PAGE_BLOCK2 - 1;
		if (endPage2 > pageCount2)
			endPage2 = pageCount2;

		ArrayList<UserMyComt> volist2 = new MyPageService().myBoardCommentList(userId, startRnum2, endRnum2);
		System.out.println("volist2 " + volist2);

		request.setAttribute("volist2", volist2);
		request.setAttribute("startPage2", startPage2);
		request.setAttribute("endPage2", endPage2);
		request.setAttribute("pageCount2", pageCount2);

		request.getRequestDispatcher("/WEB-INF/mypage/myCommunity.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

}

