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
		request.getRequestDispatcher("/WEB-INF/community/freeBoard/BoardReport.jsp").forward(request, response);
		// 관리자 신고 글 목록으로 이동
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// TODO 로그인 시에만 가능 // 본인이 작성한 글에는 신고 불가능
		String writer = (String)request.getSession().getAttribute("memberLoginInfo");
		if(writer == null || writer.equals("")) {
			writer = "c";   // TODO: 임시 user 설정
		}
		// 게시글 신고
		// 게시글 번호/신고번호/ 신고자 아이디 
		// 신고 한 번 후 끝
		String boardNoStr = request.getParameter("boardNo");
		String boardReportStr = request.getParameter("boardReport");
		String userId = request.getParameter("userId");
		int boardNo = 0, boardReportNo = 0;
		try {
			boardNo = Integer.parseInt(boardNoStr);
		}catch( Exception e ) {
			e.printStackTrace();
			System.out.println("boardNoStr 숫자변환못함");
			return;
		}
		try {
			boardReportNo = Integer.parseInt(boardReportStr);		
		}catch( Exception e ) {
			e.printStackTrace();
			System.out.println("boardReportNo 숫자변환못함 ");
		}
		
		BoardReport br = new BoardReport();
		br.setBoardNo(boardNo);
		br.setUserId(userId);
		br.setBoardReportNo(boardReportNo);
		
		
		CommunityService cs = new CommunityService();
		int result = cs.insertReportBoard(br);
		
		CommunityService bd = new CommunityService();
		Board board = bd.getBoard(boardNo);
		response.sendRedirect(request.getContextPath() + "/cfdetail?boardNo=" + boardNo);
	}

}
