package kh.semi.boardclass.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.user.model.service.UserService;

/**
 * Servlet implementation class DupIdChkServlet
 */
@WebServlet("/deletechkpwd")
public class DeleteChkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteChkPwd() {
        super();
        // TODO Auto-generated constructor stub
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
		
		 String userId = request.getParameter("userId");
	     String userPassword = request.getParameter("userPassword");
	     UserService uservice = new UserService();
		 int result = uservice.deleteChkPwd(userId,userPassword);

		PrintWriter out = response.getWriter();
		
	
		if (result > 0) {
			out.append("ok"); // 0이상이면 삭제할 값이 있음
		} else {
			out.append("fail"); 
		}
		out.flush();
		out.close();
	}

}
