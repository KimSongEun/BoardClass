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
 * Servlet implementation class DupNicknameChkServlet
 */
@WebServlet("/dupnicknamechk")
public class DupNicknameChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupNicknameChkServlet() {
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
		UserService uservice = new UserService();
		int result = uservice.checkNick(request.getParameter("userNickname"));
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.append("fail"); // 만약 dupNicknameChk()의 결과값이 0 이상이면 ‘fail’
		} else {
			out.append("ok"); // 결과값이 0 보다 크지 않으면, ‘ok’를 담아서 보낸다.
		}
		out.flush();
		out.close();
	}
	

}
