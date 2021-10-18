package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.dao.CommunityDao;
import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.Comment;

/**
 * Servlet implementation class CommunityFreeDetailServlet
 */
@WebServlet("/cfdetail")
public class CommunityFreeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityFreeDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//TODO 로그인
		
		// 게시글 보기 위한 작업
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String pageNum = request.getParameter("pageNum");
		 new CommunityService().readCount(boardNo);
		Board board = new CommunityService().getBoard(boardNo);
		String date = board.getBoardWriteDate();
		
//		String content = board.getBoardContent();
//		content = content.replace("/r/n", "<br>");
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("board", board);
//		request.setAttribute("content", content);
		request.setAttribute("date", date);
		
		//댓글
		int commentNo = 0, commentRef = 0, commentReStep = 0, commentReLevel = 0;
		CommunityService cd = new CommunityService();
		
		request.setAttribute("commentNo", commentNo);
		request.setAttribute("commentRef", commentRef);
		request.setAttribute("commentReLevel", commentReLevel);
		request.setAttribute("commentReStep", commentReStep);
		
		ArrayList<Comment> list = cd.selectComment(boardNo);
		
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("/WEB-INF/community/freeBoard/FreeBoardContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
