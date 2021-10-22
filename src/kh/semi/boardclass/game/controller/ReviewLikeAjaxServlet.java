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
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class GameSearchAjaxServlet
 */
@WebServlet("/reviewLike.ajax")
public class ReviewLikeAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewLikeAjaxServlet() {
		super();
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
		
		try {
			int reviewNo = Integer.parseInt(request.getParameter("thisReviewNo"));
			 
			int gameNo = Integer.parseInt(request.getParameter("thisGameNo"));
			

			System.out.println("dd" + gameNo);
			int result = new GameService().deleteReviewLike(userId, reviewNo, gameNo);

			if (result == 0) {
				int secondResult = new GameService().insertReviewLike(userId, reviewNo, gameNo);
				if (secondResult < 1) {
					System.out.println("좋아요등록 실패");
				}
				System.out.println("좋아요등록 성공");
			}

			System.out.println("delete되었다면1이나온다:" + result);
			
			
			out.print(result);
			out.flush();
			out.close();
		} catch (NumberFormatException ex) {
		} catch (Exception e) {

		}
	}

}
