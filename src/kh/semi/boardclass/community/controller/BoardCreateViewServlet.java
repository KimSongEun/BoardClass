package kh.semi.boardclass.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class BoardCreateViewServlet
 */
@WebServlet("/boardcreateview")
public class BoardCreateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCreateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User loginSS = (User)request.getSession().getAttribute("userSession");
	      if(loginSS == null) {
	         System.out.println("로그인이 풀렸습니다.");//확인
	         request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
	         return;
	      }
	      request.getRequestDispatcher("/WEB-INF/community/BoardCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
