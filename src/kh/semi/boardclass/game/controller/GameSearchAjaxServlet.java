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

/**
 * Servlet implementation class GameSearchAjaxServlet
 */
@WebServlet("/gamesearch.do")
public class GameSearchAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameSearchAjaxServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String searchResult = "";
		String searchKeyword = request.getParameter("searchKeyword");

		System.out.println("searchKeyword 값은 : " + searchKeyword);

		List<Game> volist = new GameService().searchList(searchKeyword);

		System.out.println("volist : " + volist);

		Gson gson = new GsonBuilder().create();
		searchResult = gson.toJson(volist);

		System.out.println("searchResult : " + searchResult);

		out.print(searchResult);
		out.flush();
		out.close();

	}

}
