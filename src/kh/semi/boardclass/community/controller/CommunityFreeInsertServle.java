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
		// 답글이므로 어느글에 답글을 달것인가 정보가 전달되어 올 것임.
//		Board oVo = null;
//		String viewBno = request.getParameter("boardNo");
//		System.out.println(viewBno);
//		if(viewBno == null || viewBno.equals("")) {   // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
//			oVo= new Board();
//		} else {
//			int boardNo = Integer.parseInt(viewBno);
//			// 알아와야함. bref, bre_level, bre_step
//			oVo = new CommunityService().getBoard(boardNo); 
//		}
//				
//		String title = request.getParameter("title");  //내용부분입력된값이지요
//		String content = request.getParameter("content");  //뭐라해야할지모를제목
//		String type = request.getParameter("type"); // 사담/ 건의 / 질문
//		String category = request.getParameter("category"); // 자유게시판
//		String writer = (String)request.getSession().getAttribute("memberLoginInfo");
//		if(writer == null || writer.equals("")) {
//			writer = "c";   // TODO: 임시 user 설정
//		}
//		out.println("입력된 title: "+ title);
//		out.println("<br>입력된 content: "+ content);
//		
////		Board vo = new Board(oVo.getBoardNo(), title, content, writer, type, category, oVo.getBoardReplyRef(), oVo.getBoardReplyLev(), oVo.getBoardReplySeq());		
//		
//		int result = new CommunityService().insertFreeBoard(vo);
//		if(result == 0) {
//			out.println("<br>게시글 되지 않았습니다. <br>작성된 글에 비속어가 포함되어 있습니다. <br>다시 작성해 주세요.");
//		} else {
//			out.println("<br>게시글 입력되었습니다.");
//		}
		
	//	request.getRequestDispatcher("boardlist").forward(request, response);
		
		//2
	//	 답글이므로 어느글에 답글을 달것인가 정보가 전달되어 올 것임.
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
		String writer = (String)request.getSession().getAttribute("memberLoginInfo");
		if(writer == null || writer.equals("")) {
			writer = "c";   // TODO: 임시 user 설정
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
		vo.setUserId(writer);
		int result = new CommunityService().insertFreeBoard(vo);
		response.sendRedirect("cf");
	}

}
