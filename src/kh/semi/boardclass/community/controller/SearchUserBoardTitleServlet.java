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
 * Servlet implementation class SearchUserBoardTitleServlet
 */
@WebServlet("/searchuserboardtitle")
public class SearchUserBoardTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserBoardTitleServlet() {
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
		
//		String viewcount = request.getParameter("viewcount");
//		int PAGE_SIZE;
//		if(viewcount != null) {
//			PAGE_SIZE = Integer.parseInt(viewcount);
//		} else {
//			PAGE_SIZE = 10;
//		}
//		final int PAGE_BLOCK = 5; 
//		int aCount = 0; 
//		int pageCount = 0; 
//		int startPage = 1;
//		int endPage = 1;
//		int currentPage = 1;
//		int startRnum = 1;
//		int endRnum = 1; 
//		
//		String pageNum = request.getParameter("pagenum");
//		if(pageNum !=null) { 
//				currentPage=Integer.parseInt(pageNum);
//		}
//		String type = request.getParameter("type");
//		String keyword = request.getParameter("keyword");
//		aCount = new CommunityService().UserBoardTitleCount(keyword);
//		pageCount = (aCount / PAGE_SIZE) + (aCount % PAGE_SIZE == 0 ? 0:1);
//		startRnum = (currentPage-1) * PAGE_SIZE + 1;  
//		endRnum = startRnum + PAGE_SIZE -1;
//		if(endRnum > aCount) endRnum = aCount;
//		
//		if (currentPage % PAGE_BLOCK == 0) {
//			startPage = (currentPage / PAGE_BLOCK -1) * PAGE_BLOCK + 1;
//		} else {
//			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
//		}
//		endPage = startPage + PAGE_BLOCK -1;
//		if(endPage > pageCount) endPage = pageCount;
		
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		int totCnt = new CommunityService().UserBoardTitleCount(keyword);
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {pageNum = "1";}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10, blockSize = 10;
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize -1;
		int startNum = totCnt - startRow +1;

		int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
		int startPage = (int)(currentPage -1) / blockSize * blockSize + 1;
		int endPage = startPage + blockSize - 1;
		if( endPage > pageCnt ) endPage = pageCnt;
		
		
		
		ArrayList<Board> list  = new CommunityService().UserBoardSearchTitle(keyword, startRow, endRow);
		
		request.setAttribute("totCnt", totCnt);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startNum", startNum);
		request.setAttribute("list", list);
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
//		request.setAttribute("viewcount", PAGE_SIZE);
//		request.setAttribute("list", list);
//		request.setAttribute("startPage", startPage);
//		request.setAttribute("endPage", endPage);
//		request.setAttribute("pageCount", pageCount);
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		
		System.out.println("keyword:" + keyword);
		
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
