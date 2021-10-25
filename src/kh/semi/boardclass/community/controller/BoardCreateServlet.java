package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class BoardCreateServlet
 */
@WebServlet("/boardcreate")
public class BoardCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCreateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

		User loginSS = (User)request.getSession().getAttribute("userSession");
		if(loginSS == null) {
			System.out.println("로그아웃이 풀려서 메인으로 이동");
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		if (!ServletFileUpload.isMultipartContent(request))
			System.out.println("error");

		String userId = loginSS.getUserId();
		
		
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
		int result = new CommunityService().insertBoard(vo);
		System.out.println("vo" + vo);
		response.sendRedirect("cmain");
			
		}
	}

