package kh.semi.boardclass.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.semi.boardclass.game.model.service.GameService;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class GameSearchAjaxServlet
 */
@WebServlet("/gameLike.ajax")
public class GameLikeAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameLikeAjaxServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		User loginSS = (User)request.getSession().getAttribute("userSession");
		if(loginSS == null) {
			System.out.println("로그아웃이 풀려서 메인으로 이동");
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		
		
		String userId = request.getParameter("loginId");
		try{
		int gameNo = Integer.parseInt(request.getParameter("thisGameNo"));
		System.out.println("dd"+gameNo);
		int result = new GameService().deleteGameLike(userId, gameNo);
		
		if(result == 0) {
			int secondResult = new GameService().insertGameLike(userId, gameNo);
			if(secondResult < 1) {
				System.out.println("찜등록 실패");
			}
			System.out.println("찜등록 성공");
		}
		
		System.out.println("delete되었다면1이나온다:"+result);
		
		out.print(result);
		out.flush();
		out.close();
		}catch (Exception e) {
		}
	}

}
