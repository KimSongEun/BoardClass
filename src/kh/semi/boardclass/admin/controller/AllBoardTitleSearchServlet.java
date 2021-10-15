package kh.semi.boardclass.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.admin.model.vo.AllBoardUser;

/**
 * Servlet implementation class AllBoardSearchServlet
 */
@WebServlet("/allboardtitlesearch")
public class AllBoardTitleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBoardTitleSearchServlet() {
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
		
		String viewcount = request.getParameter("viewcount");
		int PAGE_SIZE;
		if(viewcount != null) {
			PAGE_SIZE = Integer.parseInt(viewcount);
		} else {
			PAGE_SIZE = 10;
		}
		final int PAGE_BLOCK = 5; 
		int aCount = 0; 
		int pageCount = 0; 
		int startPage = 1;
		int endPage = 1;
		int currentPage = 1;
		int startRnum = 1;
		int endRnum = 1; 
		
		String pageNum = request.getParameter("pagenum");
		if(pageNum !=null) { 
				currentPage=Integer.parseInt(pageNum);
		}
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		aCount = new AdminService().getAllBoardTitleCount(keyword);
		pageCount = (aCount / PAGE_SIZE) + (aCount % PAGE_SIZE == 0 ? 0:1);
		startRnum = (currentPage-1) * PAGE_SIZE + 1;  
		endRnum = startRnum + PAGE_SIZE -1;
		if(endRnum > aCount) endRnum = aCount;
		
		if (currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK -1) * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK -1;
		if(endPage > pageCount) endPage = pageCount;
		
		ArrayList<AllBoardUser> volist  = new AdminService().searchAllBoardTitleList(keyword, startRnum, endRnum);
		
		request.setAttribute("viewcount", PAGE_SIZE);
		request.setAttribute("allboarduservolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/WEB-INF/admin/allboard/allboardlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
