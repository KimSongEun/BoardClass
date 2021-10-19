package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.admin.model.vo.AllBoardUser;
import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;

/**
 * Servlet implementation class CommunityFreeSearchServlet
 */
@WebServlet("/cfsearch")
public class CommunityFreeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityFreeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		
//		String field_ = request.getParameter("f");
//		String query_ = request.getParameter("q");
//		
//		String field = "title";
//		if(field_ != null) {
//			field = field_;
//		}
//		String query = "";
//		if(query_ != null) {
//			query = query_;
//		}
//		
//		CommunityService cs = new CommunityService();
////		ArrayList<Board> list = cs.searchFreeBoard(query, field, 1, 10);
//		
//		request.setAttribute("list", list);

		
		request.getRequestDispatcher("WEB-INF/community/freeBoard/FreeBoardMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
