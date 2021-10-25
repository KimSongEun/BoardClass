package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.Comment;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/bdetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//TODO 로그인
		
		// 게시글 보기 위한 작업
		String boardNoStr = request.getParameter("boardNo");
		int boardNo = 0;
		try {
			boardNo = Integer.parseInt(boardNoStr);
		}catch( Exception e ) {
			e.printStackTrace();
			System.out.println("boardNoStr 숫자변환못함");
			response.sendRedirect("cf");
			return;
		}
		Board bo = new Board();
		bo.setBoardNo(boardNo);
		
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
		
		//추천
		User loginSS = (User)request.getSession().getAttribute("userSession");
		//신고
		int countlike = 0;		
		if(loginSS != null) {
			String userId = loginSS.getUserId();
			countlike = new CommunityService().CountLikeBoard(boardNo);
		}
		
		int countreport = 0;
		if(loginSS != null) {
			String userId = loginSS.getUserId();
			countreport = new CommunityService().countBoardReport(boardNo, userId);
		}
		//댓글 신고
		int countcomtreport = 0;
		if(loginSS != null) {
			String userId = loginSS.getUserId();
			countcomtreport = new CommunityService().countReportComment(commentNo, userId);
		}
		
		System.out.println("countlike="+countlike);
		System.out.println("countreport="+countreport);
		System.out.println("countcomtreport: " + countcomtreport);
		
		request.setAttribute("reportresult", countreport);
		
		request.setAttribute("countcomtreport", countcomtreport);
		
		request.setAttribute("likeresult", countlike);
		
		request.getRequestDispatcher("/WEB-INF/community/BoardContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
