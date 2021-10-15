package kh.semi.boardclass.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;

/**
 * Servlet implementation class CommunityFreeUpdateServlet
 */
@WebServlet("/cfupdate")
public class CommunityFreeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityFreeUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board board = new Board();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		board.setUserId(request.getParameter("user_id"));
		board.setBoardTitle(request.getParameter("board_title"));
		board.setBoardContent(request.getParameter("board_content"));
		board.setBoardNo(Integer.parseInt(request.getParameter("board_no")));
		
		int result = new CommunityService().updateFreeBoard(board);
		
		request.setAttribute("result", result);
		request.setAttribute("board_no", board.getBoardNo());
		request.setAttribute("pageNum", pageNum);
		
		request.getRequestDispatcher("/WEB-INF/community/freeBoard/FreeBoardUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
