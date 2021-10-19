package kh.semi.boardclass.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.game.model.service.GameService;

@WebServlet("/gamematch.do")
public class GameMatchAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameMatchAjaxServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String matchKeyword = request.getParameter("matchKeyword");
		
		System.out.println("matchKeyword값은: " + matchKeyword);
		
		int matchresult = new GameService().matchList(matchKeyword);
		
		System.out.println(matchresult);
		
		out.print(matchresult);
		out.flush();
		out.close();
	}

}
