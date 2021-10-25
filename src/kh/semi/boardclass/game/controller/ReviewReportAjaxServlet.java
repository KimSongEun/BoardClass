package kh.semi.boardclass.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.game.model.service.GameService;
import kh.semi.boardclass.game.model.vo.GameReview;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class GameSearchAjaxServlet
 */
@WebServlet("/reviewReport.ajax")
public class ReviewReportAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewReportAjaxServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		User loginSS = (User) request.getSession().getAttribute("userSession");
		if (loginSS == null) {
			System.out.println("로그아웃이 풀려서 메인으로 이동");
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}

		String userId = request.getParameter("loginId");
		
		try{
			int reviewNo = Integer.parseInt(request.getParameter("thisReviewNo"));
			int gameNo = Integer.parseInt(request.getParameter("thisGameNo"));
			
			
			int result = new GameService().countReviewReport(reviewNo, userId);
		
		int secondResult = -1;
		if(result < 1) {
			secondResult = new GameService().insertReivewReport(reviewNo, userId, gameNo);
			System.out.println("신고접수됨");
		} else {
			secondResult = 0;
			System.out.println("이미 신고접수됨");
		}

		System.out.println(secondResult);

		out.print(secondResult);
		out.flush();
		out.close();
	} catch (NumberFormatException ex) {
	} catch (Exception e) {

	}
	}
}
