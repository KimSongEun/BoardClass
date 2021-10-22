package kh.semi.boardclass.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardReport;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class BoardReportServlet
 */
@WebServlet("/creport")
public class BoardReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// TODO 로그인 시에만 가능 // 본인이 작성한 글에는 신고 불가능
		User loginSS = (User)request.getSession().getAttribute("userSession");
		int boardNo = Integer.parseInt(request.getParameter("no"));
		Board vo = new CommunityService().getBoard(boardNo);
		// 게시글
		// 게시글 신고
		int countreport = 0;
		if(loginSS != null) {
			String userId = loginSS.getUserId();
			countreport = new CommunityService().CountBoardReport(boardNo, userId);
		}
		System.out.println("countreport="+countreport);
		System.out.println("vo="+vo);
		request.setAttribute("reportresult", countreport);
		request.setAttribute("Board", vo);
		request.getRequestDispatcher("/WEB-INF/community/BoardContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
