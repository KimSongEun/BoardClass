package kh.semi.boardclass.used.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;

/**
 * Servlet implementation class UsedCreateServlet
 */
@WebServlet("/usedcreate")
public class UsedCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedCreateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String userId = (String)request.getSession().getAttribute(getServletInfo());
		if(userId == null) {
			userId = "테스트회원01";
		}
		String usedTitle = request.getParameter("usedTitle");
		String usedPrice = request.getParameter("usedPrice");
		String usedState = request.getParameter("usedState");
		String usedChange = request.getParameter("usedChange");
		String usedPay = request.getParameter("usedPay");
		String usedArea = request.getParameter("usedArea");
		String usedInfo = request.getParameter("usedInfo");
//		Date usedDay = request.getParameter("usedDay");
//		String usedImg
		
		Used vo = new Used(userId, usedTitle, usedPrice, usedState, usedChange, usedPay, usedArea, usedInfo);
//		int result = UsedService().insertUsed(vo);
//		if(result == 0) {
//			out.println("글 입력 안됨");
//		} else {
//			response.sendRedirect("");
//		}

		request.getRequestDispatcher("/WEB-INF/used/usedcreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
