package kh.semi.boardclass.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;

/**
 * Servlet implementation class AdListServlet
 */
@WebServlet("/adlist")
public class AdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int PAGE_SIZE = 10; // TODO: 나중에 선택한 글 수로 바뀌게 하기
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
		
		aCount = new AdminService().getAdCount();
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
		
		ArrayList<Banner> volist  = new AdminService().selectAdList(startRnum, endRnum);
		
		request.setAttribute("bannervolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("/WEB-INF/admin/ad/adlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
