package kh.semi.boardclass.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.Comment;

/**
 * Servlet implementation class CommunityCommentServlet
 */
@WebServlet("/cclist")
public class CommunityCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityCommentServlet() {
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
		
		String userId = request.getParameter("userId");
		String pageNum = request.getParameter("pageNum");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Comment comment = new Comment();
		comment.setBoardNo(boardNo);
		comment.setUserId(userId);
		comment.setCommentContent(request.getParameter("commentContent"));
		comment.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
		comment.setCommentRef(Integer.parseInt(request.getParameter("commentRef")));
		comment.setCommentReStep(Integer.parseInt(request.getParameter("commentReStep")));
		comment.setCommentReLevel(Integer.parseInt(request.getParameter("commentReLevel")));
		
		CommunityService cs = new CommunityService();
		int result = cs.insertComment(comment);
		
		Board board = cs.getBoard(boardNo);
		String content = board.getBoardContent();
		content = content.replace("\r\n", "<br>");
		
		request.setAttribute("commentNo", comment.getCommentNo());
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("board", board);
		request.setAttribute("userId", comment.getUserId());
		request.setAttribute("ref", comment.getCommentRef());
		request.setAttribute("re_level", comment.getCommentReLevel());
		request.setAttribute("re_step", comment.getCommentReStep());
		request.setAttribute("content", content);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/WEB-INF/community/freeBoard/FreeBoardContent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
