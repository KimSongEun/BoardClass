package kh.semi.boardclass.community.controller;

import java.io.IOException;

import javax.mail.search.IntegerComparisonTerm;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/bupdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
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
		
		User loginSS = (User)request.getSession().getAttribute("userSession");
		if(loginSS == null) {
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board vo = new CommunityService().getBoard(boardNo);
		
		request.setAttribute("board", vo);
		request.getRequestDispatcher("/WEB-INF/community/BoardUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
