package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;

/**
 * Servlet implementation class SearchNoticeContentServlet
 */
@WebServlet("/searchnoticecontent")
public class SearchNoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNoticeContentServlet() {
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
		aCount = new CommunityService().getNoticeSearchCount(keyword);
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
		
		ArrayList<Notice> list  = new CommunityService().searchNoticeContent(keyword, startRnum, endRnum);
		
		
		request.setAttribute("viewcount", PAGE_SIZE);
		request.setAttribute("noticevolist", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		
		System.out.println("keyword:" + keyword);
		
		request.getRequestDispatcher("/WEB-INF/community/notice/NoticeMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
