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
 * Servlet implementation class CommunityFreeInsertServle
 */
@WebServlet("/cfwrite")   // get 방식은 jsp 파일 열기, post 방식은 jsp에서 입력된 데이터 받아서 db에 저장하기
public class CommunityFreeInsertServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityFreeInsertServle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/community/freeBoard/FreeBoardInsert.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
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

		String userId = "c";
		User userSS = (User) request.getSession().getAttribute("user");
		if (userSS != null) {
			userId = userSS.getUserId();
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category"); // 자유게시판
		String type = request.getParameter("type");
		
		Board vo = new Board();
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
		vo.setBoardCategory(category);
		vo.setBoardType(type);
		vo.setUserId(userId);
		int result = new CommunityService().insertFreeBoard(vo);
		response.sendRedirect("cf");
	}

}
