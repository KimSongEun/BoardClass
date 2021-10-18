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
		//TODO 아이디 정보
		
		if(request.getParameter("boardNo") == null) {
			response.sendRedirect(request.getContextPath() + "board/boardlist");
		} else {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			Board board = new CommunityService().getBoard(boardNo);
            request.setAttribute("board", board);
            request.getRequestDispatcher("/WEB-INF/community/freeBoard/FreeBoardUpdate.jsp").forward(request, response);
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String type = request.getParameter("type");
			
			Board vo = new Board();
			vo.setBoardNo(boardNo);
			vo.setBoardTitle(title);
			vo.setBoardContent(content);
			vo.setBoardType(type);
			
			CommunityService co = new CommunityService();
			int rowCount = co.updateFreeBoard(vo);
			if(rowCount > 0) {
				response.sendRedirect(request.getContextPath() + "/cfdetail?boardNo=" + boardNo);
			} else {
				response.sendRedirect(request.getContextPath() + "/cfdetail?boardNo=" + boardNo);
			}
		}
	}

