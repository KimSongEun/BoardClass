package kh.semi.boardclass.used.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.user.model.vo.User;

@WebServlet("/UsedGetUpdate")
public class UsedGetUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedGetUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User loginSS = (User)request.getSession().getAttribute("userSession");
		if(loginSS == null) {
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		
		int usedNo = Integer.parseInt(request.getParameter("usedNo"));
		Used vo = new UsedService().getUsedDetail(usedNo);
		
		request.setAttribute("used", vo);
		request.getRequestDispatcher("/WEB-INF/used/usedupdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
