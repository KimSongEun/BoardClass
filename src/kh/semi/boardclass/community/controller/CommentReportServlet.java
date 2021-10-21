package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentReportServlet
 */
@WebServlet("/ccreport")
public class CommentReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO 로그인시에 신고가능
		String reportTitle = null;
		String reportContent = null;
		if(request.getParameter("reportTitle") != null) {
			reportTitle = request.getParameter("reportTitle");
		}
		if(request.getParameter("reportContent") != null) {
			reportContent = request.getParameter("reportContent");
		}
		if(reportTitle == null || reportContent == null) {
			PrintWriter script = response.getWriter();
			script.println("<scirpt>");
			script.println("alert('입력이 안 된 사항이 있습니다..');");
			script.println("location.href='login.jsp");
			script.println("history.back()");
			script.println("</scirpt>");
		}
		
	
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
