package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class CommunityUserInsertServlet
 */
@WebServlet("/cuwrite")
public class CommunityUserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/community/UserBoard/UserBoardInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		
		Board oVo = null;
		String viewBno = request.getParameter("boardNo");
		System.out.println(viewBno);
		if(viewBno == null || viewBno.equals("")) {   // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
			oVo= new Board();
		} else {
			int boardNo = Integer.parseInt(viewBno);
			// 알아와야함. bref, bre_level, bre_step
			oVo = new CommunityService().getBoard(boardNo); 
		}
//		String writer = (String)request.getSession().getAttribute("memberLoginInfo");
//		if(writer == null || writer.equals("")) {
//			writer = "c";   // TODO: 임시 user 설정
//		}
		String userId = "c"; //TODO: 임시 user 설정
		User userSS = (User) request.getSession().getAttribute("user");
		if (userSS != null) {
			userId = userSS.getUserId();
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category"); // 유저정보게시판
		String type = request.getParameter("type");
		
		Board vo = new Board();
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
		vo.setBoardCategory(category);
		vo.setBoardType(type);
		vo.setUserId(userId);
		int result = new CommunityService().insertUserBoard(vo);
		
		response.sendRedirect("cu");
	}

}
