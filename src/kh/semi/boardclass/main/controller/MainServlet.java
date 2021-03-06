package kh.semi.boardclass.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.main.model.service.MainService;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;

/**
 * Servlet implementation class GoGoMain
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
		
		ArrayList<Notice> noticevolist  = new MainService().getNotice();
		request.setAttribute("noticevolist", noticevolist);
		System.out.println(noticevolist);
		
		ArrayList<Banner> advolist  = new MainService().getAdList();
		request.setAttribute("advolist", advolist);
		System.out.println(advolist);
		
		int adCnt = new MainService().getAdCount();
		request.setAttribute("adCnt", adCnt);
		
		ArrayList<Board> boardlist = new MainService().getBestBoard();
		request.setAttribute("boardlist", boardlist);
		
		ArrayList<Used> usedNewList = new UsedService().selectNewUsedList();
		request.setAttribute("usedNewList", usedNewList);
		
		String viewPage = "/WEB-INF/index/main.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
