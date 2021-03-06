package kh.semi.boardclass.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/searchpwd.do")
public class SearchPwdDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwdDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("searchPwd 진입");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		System.out.println("userName:" + userName);
		System.out.println("userId:" + userId);
		System.out.println("userEmail:" + userEmail);


		UserService service = new UserService();
		 User user = service.searchPwd(userName,userId, userEmail);


		if (user != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/searchPwdaction.jsp");
			request.setAttribute("users", user);
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "정확한 정보를 입력해 주세요!");
			request.setAttribute("loc", "/");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/searchPwdaction.jsp");
			rd.forward(request, response);
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
