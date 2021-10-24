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

import kh.semi.boardclass.mypage.model.service.MyPageService;
import kh.semi.boardclass.mypage.model.vo.MyGameLike;
import kh.semi.boardclass.mypage.model.vo.MyGameReview;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class MyBoardGameServlet
 */
@WebServlet("/myboardgame")
public class MyBoardGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBoardGameServlet() {
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

		final int PAGE_SIZE = 4; // 한 페이지 당 글 개수
		final int PAGE_BLOCK = 3; // 한 화면에 나타날 페이지 링크수
		int bCount = 0; // 총 글수
		int pageCount = 0; // 총 페이지수
		int startPage = 1; // 화면에 나타날 시작페이지
		int endPage = 1; // 화면에 나타날 마지막페이지
		int currentPage = 1; // 눌려진 페이지
		int startRnum = 1; // 화면에 나타날 글 번호
		int endRnum = 1; // 화면에 나타날 글 번호
		
		final int PAGE_SIZE2 = 4; // 한 페이지 당 글 개수
		final int PAGE_BLOCK2 = 3; // 한 화면에 나타날 페이지 링크수
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
		String userId = ((User) session.getAttribute("user")).getUserId();
		System.out.println(userId);
		bCount = new MyPageService().getMyBoardGameListCount(userId);
		System.out.println("토탈컨텐츠 : " + bCount);
		bCount2 = new MyPageService().getMyBoardGameReviewCount(userId);
		System.out.println("토탈컨텐츠2 : " + bCount2);
		// 총 페이지수 = (총 글 개수 / 페이지당 글수) + (총 글 개수에서 페이지당 글수로 나눈 나머지가 0이 아니라면 페이지개수를 1증가)
		// : 78글 / 한 페이지당 글 개수 5
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);

		// rownum 조건 계산
		startRnum = (currentPage - 1) * PAGE_SIZE + 1; // 1-6-11-16-21 페이지
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

		ArrayList<MyGameLike> volist = new MyPageService().myBoardGameList(userId, startRnum, endRnum);
		System.out.println("volist " + volist);

		request.setAttribute("volist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		pageCount2 = (bCount2 / PAGE_SIZE2) + (bCount2 % PAGE_SIZE2 == 0 ? 0 : 1);

		// rownum 조건 계산
		startRnum2 = (currentPage2 - 1) * PAGE_SIZE2 + 1; // 1-6-11-16-21 페이지
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

		ArrayList<MyGameReview> volist2 = new MyPageService().myBoardGameReviewList(userId, startRnum2, endRnum2);
		System.out.println("volist2 " + volist2);

		request.setAttribute("volist2", volist2);
		request.setAttribute("startPage2", startPage2);
		request.setAttribute("endPage2", endPage2);
		request.setAttribute("pageCount2", pageCount2);
		
		request.getRequestDispatcher("/WEB-INF/mypage/myGameList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
