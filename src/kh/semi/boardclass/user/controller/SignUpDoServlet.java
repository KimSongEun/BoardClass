package kh.semi.boardclass.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.user.model.service.UserService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class SignUpDoServlet
 */
@WebServlet("/signup.do")
public class SignUpDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/signupservlet 진입");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String userImage = request.getParameter("userImage");
		String userName = request.getParameter("userName");
		String userNickname = request.getParameter("userNickname");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		int userPhone = Integer.parseInt(request.getParameter("userPhone"));
		String userAddress = request.getParameter("userAddress");

		// 화면 데이터를 vo에 싣기
		User user = new User(userImage, userName, userNickname, userId, userPassword, userEmail, userPhone, userAddress);

		// vo를 가지고 회원가입하러 Dao로 출발
		UserService uservice = new UserService();
		int result = uservice.signUp(user);

		System.out.println(user);
		System.out.println(userName);
		System.out.println("image"+userImage);
		System.out.println(result);

		if (result == 1) {
			System.out.println(userId + "님 가입되었습니다. 환영합니다.");
			request.getSession().setAttribute("messageType", "성공 메시지");
			request.getSession().setAttribute("messageContent", "회원가입에 성공했습니다.");
			// out.println(userId + "님 가입되었습니다. 환영합니다.");
			// response.sendRedirect("signUp.jsp");
			response.sendRedirect("usermain");
		} else {
			System.out.println("회원가입 실패");
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다.");
			// out.println(userId + "님 가입되었습니다. 환영합니다.");
			// response.sendRedirect("signUp.jsp");
			request.getRequestDispatcher("/WEB-INF/user/signUp.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
