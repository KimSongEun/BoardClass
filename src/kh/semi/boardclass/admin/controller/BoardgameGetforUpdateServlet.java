package kh.semi.boardclass.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.admin.model.vo.Banner;
import kh.semi.boardclass.game.model.vo.Game;

/**
 * Servlet implementation class BoardgameGetforUpdateServlet
 */
@WebServlet("/boardgamecontent")
public class BoardgameGetforUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardgameGetforUpdateServlet() {
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
		
		String no = request.getParameter("no");
		System.out.println(no);
		int gameNo = Integer.parseInt(no);
		Game vo = new AdminService().getBoardGame(gameNo);
		request.setAttribute("gameno", no);
		request.setAttribute("gamevo", vo);
		request.getRequestDispatcher("/WEB-INF/admin/boardgame/boardgameupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
