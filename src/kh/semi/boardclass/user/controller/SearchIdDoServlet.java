package kh.semi.boardclass.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.user.model.service.UserService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class SearchIdDoServlet
 */
@WebServlet("/searchid.do")
public class SearchIdDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchIdDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("searchId 진입");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		// PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		System.out.println("userName:" + userName);
		String userEmail = request.getParameter("userEmail");
		System.out.println("userEmail:" + userEmail);
		int userPhone = Integer.parseInt(request.getParameter("userPhone"));
		System.out.println("userPhone:" + userPhone);

		UserService service = new UserService();
		User user = service.searchId(userName, userEmail, userPhone);

		if (user != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/searchIdaction.jsp");
			request.setAttribute("users", user);
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "정확한 정보를 입력해 주세요!");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/searchIdaction.jsp");
			rd.forward(request, response);
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
