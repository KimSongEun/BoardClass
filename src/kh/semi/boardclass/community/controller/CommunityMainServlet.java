package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;

/**
 * Servlet implementation class CommunityMainServlet
 */
@WebServlet("/cmain")
public class CommunityMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityMainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO  filter
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		//자유게시판 조회수 랭킹
		ArrayList<Board> bestfreeone = new CommunityService().bestFreeViewone();
		request.setAttribute("bestfreeone", bestfreeone);
		ArrayList<Board> bestfreetwo = new CommunityService().bestFreeViewtwo();
		request.setAttribute("bestfreetwo", bestfreetwo);
		ArrayList<Board> bestfreethree = new CommunityService().bestFreeViewthree();
		request.setAttribute("bestfreethree", bestfreethree);
		ArrayList<Board> bestfreefour = new CommunityService().bestFreeViewfour();
		request.setAttribute("bestfreefour", bestfreefour);
		ArrayList<Board> bestfreefive = new CommunityService().bestFreeViewfive();
		request.setAttribute("bestfreefive", bestfreefive);
		
		// 자유게시판 댓글순 랭킹
		ArrayList<Board> bestfreecomt = new CommunityService().bestFreeComt();
		request.setAttribute("bestfreecomt", bestfreecomt);
		System.out.println("랭킹");
		System.out.println("bestfreecomt: " + bestfreecomt);
		
		//자유게시판 추천순 랭킹
		ArrayList<Board> bestfreelike = new CommunityService().bestFreeLike();
		request.setAttribute("bestfreelike", bestfreelike);
		
		//유저정보 조회수 랭킹
		ArrayList<Board> bestuserviewone = new CommunityService().bestUserViewOne();
		request.setAttribute("bestuserviewone", bestuserviewone);
		ArrayList<Board> bestuserviewtwo = new CommunityService().bestUserViewTwo();
		request.setAttribute("bestuserviewtwo", bestuserviewtwo);
		ArrayList<Board> bestuserviewthree = new CommunityService().bestUserViewThree();
		request.setAttribute("bestuserviewthree", bestuserviewthree);
		ArrayList<Board> bestuserviewfour = new CommunityService().bestUserViewFour();
		request.setAttribute("bestuserviewfour", bestuserviewfour);
		ArrayList<Board> bestuserviewfive = new CommunityService().bestUserViewFive();
		request.setAttribute("bestuserviewfive", bestuserviewfive);
		
		//유저정보 댓글순
		ArrayList<Board> bestusercomtone = new CommunityService().bestUserComtOne();
		request.setAttribute("bestusercomtone", bestusercomtone);
		ArrayList<Board> bestusercomttwo = new CommunityService().bestUserComtTwo();
		request.setAttribute("bestusercomttwo", bestusercomttwo);
		ArrayList<Board> bestusercomtthree = new CommunityService().bestUserComtThree();
		request.setAttribute("bestusercomtthree", bestusercomtthree);
		ArrayList<Board> bestusercomtfour = new CommunityService().bestUserComtFour();
		request.setAttribute("bestusercomtfour", bestusercomtfour);
		ArrayList<Board> bestusercomtfive = new CommunityService().bestUserComtFive();
		request.setAttribute("bestusercomtfive", bestusercomtfive);
		
		//유저정보 추천순
		ArrayList<Board> bestuserlike = new CommunityService().bestUserLike();
		request.setAttribute("bestuserlike", bestuserlike);
		
		int totCnt = new CommunityService().getBoardCount();
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {pageNum = "1";}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10, blockSize = 10;
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		int startNum = totCnt - startRow +1;
		ArrayList<Board> list = new CommunityService().selectBoardList(startRow, endRow);
		int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
		int startPage = (int)(currentPage -1) / blockSize * blockSize + 1;
		int endPage = startPage + blockSize - 1;
		if( endPage > pageCnt ) endPage = pageCnt;
		
		request.setAttribute("totCnt", totCnt);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startNum", startNum);
		request.setAttribute("list", list);
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.getRequestDispatcher("/WEB-INF/community/Community.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
