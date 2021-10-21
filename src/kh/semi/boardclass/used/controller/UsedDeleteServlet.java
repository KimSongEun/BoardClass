package kh.semi.boardclass.used.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.user.model.vo.User;

@WebServlet("/useddelete")
public class UsedDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User loginSS = (User)request.getSession().getAttribute("userSession");
		if(loginSS == null) {
			System.out.println("로그아웃이 풀려서 메인으로 이동");
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		
		System.out.println("delete진입");
		int usedNo = Integer.parseInt(request.getParameter("usedNo"));
		int result = new UsedService().deleteUsed(usedNo);
		if (result < 1) {
			System.out.println("글 삭제 안됨-deleteError이동");
			request.getRequestDispatcher("/WEB-INF/error/deleteError.jsp").forward(request, response);
		} else {
			System.out.println("글 삭제 성공 - 그리고 main 이동");
			response.sendRedirect("usedmain");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
