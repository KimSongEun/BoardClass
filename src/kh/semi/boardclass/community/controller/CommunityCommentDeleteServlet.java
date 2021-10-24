package kh.semi.boardclass.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;

/**
 * Servlet implementation class CommunityCommentDeleteServlet
 */
@WebServlet("/ccdelete")
public class CommunityCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityCommentDeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		String commentNo  = request.getParameter("commentNo");
		String boardNo  = request.getParameter("boardNo");
		int result = new CommunityService().deleteComment(Integer.parseInt(commentNo));
		
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("result", result);
//		request.getRequestDispatcher("WEB-INF/community/CommentDelete.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/bdetail?boardNo=" + boardNo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
