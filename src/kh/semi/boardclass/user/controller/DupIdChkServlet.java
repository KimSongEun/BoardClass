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
@WebServlet("/dupidchk")
public class DupIdChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdChkServlet() {
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
		int result = uservice.checkId(request.getParameter("userId"));
		PrintWriter out = response.getWriter();
		
		// 오류발생 : -1, 가입성공 : 1, 가입실패 : 0, 기존회원이 있다면 : 2 (가장큰수(255))
//		if (result == 1) {
//			out.println(userId + "님 가입되었습니다. 환영합니다.");
//		} else if (result == 2) {
//			out.println("기존회원 id가 존재합니다.");
//		} else { // 오류발생 : -1, 가입실패 : 0, 그외 등등
//			out.println("예기치 못한 오류 발생. 다시 시도해주세요.");
//		}
		
		if (result > 0) {
			out.append("fail"); // 만약 dupIdChk()의 결과값이 0 이상이면 ‘fail’
		} else {
			out.append("ok"); // 결과값이 0 보다 크지 않으면, ‘ok’를 담아서 보낸다.
		}
		out.flush();
		out.close();
	}

}
