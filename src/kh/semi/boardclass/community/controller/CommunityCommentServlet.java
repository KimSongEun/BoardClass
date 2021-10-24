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
import kh.semi.boardclass.user.model.vo.User;

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
		System.out.println("post로만 진입. insert 후 list 보여줌");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String pageNum = request.getParameter("pageNum");
		String boardNoStr = request.getParameter("boardNo");
		String commentNoStr = request.getParameter("commentNo");
		String commentRefStr = request.getParameter("commentRef");
		String commentReLevelStr = request.getParameter("commentReLevel");
		String commentReStepStr = request.getParameter("commentReStep");
		
		User loginSS = (User)request.getSession().getAttribute("userSession");
		if(loginSS == null) {
			System.out.println("로그아웃이 풀려서 메인으로 이동");
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		String userId = loginSS.getUserId();
		
		int boardNo = 0;
		int commentNo = 0;
		int commentRef = 0;
		int commentReLevel = 0;
		int commentReStep = 0;
		
		try {
			boardNo = Integer.parseInt(boardNoStr);
		}catch( Exception e ) {
			e.printStackTrace();
			System.out.println("boardNoStr 숫자변환못함");
			response.sendRedirect("cf");
			return;
		}
		try {
			commentNo = Integer.parseInt(commentNoStr);
			commentRef = Integer.parseInt(commentRefStr);
			commentReLevel = Integer.parseInt(commentReLevelStr);
			commentReStep = Integer.parseInt(commentReStepStr);			
		}catch( Exception e ) {
			e.printStackTrace();
			System.out.println("commentNo 숫자변환못함 - 댓글, 답글아님");
		}
		
		
		
		Comment comment = new Comment();
		comment.setBoardNo(boardNo);
		comment.setUserId(userId);
		comment.setCommentContent(request.getParameter("commentContent"));
		comment.setCommentNo(commentNo);
		comment.setCommentRef(commentRef);
		comment.setCommentReLevel(commentReLevel);
		comment.setCommentReStep(commentReStep);
		
		CommunityService cs = new CommunityService();
		int result = cs.insertComment(comment, userId);
		
		CommunityService bd = new CommunityService();
		Board board = bd.getBoard(boardNo);
		
		String content = board.getBoardContent();
		content = content.replace("\r\n", "<br>");
		
		request.setAttribute("commentNo", comment.getCommentNo());
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("board", board);
		request.setAttribute("content", content);
		request.setAttribute("userId", userId);
		request.setAttribute("commentRef", comment.getCommentRef());
		request.setAttribute("commentReLevel", comment.getCommentReLevel());
		request.setAttribute("commentReStep", comment.getCommentReStep());
		request.setAttribute("result", result);
		System.out.println("userId :" + userId);
		
		//request.getRequestDispatcher("/WEB-INF/community/freeBoard/Comment.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/bdetail?boardNo=" + boardNo);
	}

}
