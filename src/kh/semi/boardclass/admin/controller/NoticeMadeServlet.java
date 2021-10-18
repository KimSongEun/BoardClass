package kh.semi.boardclass.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;

/**
 * Servlet implementation class AnnounceMadeServlet
 */
@WebServlet("/noticemade")
public class NoticeMadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeMadeServlet() {
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

		String title = request.getParameter("title"); 
		String content = request.getParameter("content");
		String writer = (String)request.getSession().getAttribute("memberLoginInfo"); //TODO: 관리자계정 넣는 것에 따라서 바꾸기
		if(writer == null) {
			writer = "song"; // TODO: 임시 writer 설정
		}		
		
		int result = new AdminService().insertNotice(title,content, writer);
		response.sendRedirect("noticelist");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
