package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;

/**
 * Servlet implementation class CommunityUserServlet
 */
@WebServlet("/cu")
public class CommunityUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUserServlet() {
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
		String category = "유저정보게시판";
		int totCnt = new CommunityService().getBoardCount(category);
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {pageNum = "1";}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10, blockSize = 10;
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		int startNum = totCnt - startRow +1;
		ArrayList<Board> list = new CommunityService().selectBoardList(startRow, endRow, category);
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
		request.setAttribute("category", category);
		request.getRequestDispatcher("/WEB-INF/community/UserBoard/UserBoardMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
