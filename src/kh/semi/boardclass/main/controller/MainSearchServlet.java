package kh.semi.boardclass.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.game.model.service.GameService;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;

@WebServlet("/MainSearch")
public class MainSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cateSch = request.getParameter("selectSearch");
		String searchWord = request.getParameter("main_search");
		System.out.println("value값은"+cateSch);
		String str1 = "중고거래";
		String str2 = "보드게임";
		if(cateSch.equals(str1)) {
			System.out.println("중고거래진입");
			System.out.println("검색어는 : " + searchWord);
			ArrayList<Used> usedlist = new UsedService().selectUsedList(searchWord);
			System.out.println("usedlist: " + usedlist);
			request.setAttribute("usedlist", usedlist);
			request.getRequestDispatcher("/WEB-INF/index/mainsearch.jsp").forward(request, response);
		} else if(cateSch.equals(str2)) {
			System.out.println("보드게임진입");
			System.out.println("검색어는 : " + searchWord);
			ArrayList<Game> gamelist = new GameService().selectGame(searchWord);
			System.out.println("gamelist: " + gamelist);
			request.setAttribute("gamelist", gamelist);
			request.getRequestDispatcher("/WEB-INF/index/mainsearch.jsp").forward(request, response);
		} else {
			System.out.println("전체검색진입");
			System.out.println("검색어는 : " + searchWord);
			ArrayList<Used> usedlist = new UsedService().selectUsedList(searchWord);
			ArrayList<Game> gamelist = new GameService().selectGame(searchWord);
			System.out.println("usedlist: " + usedlist);
			System.out.println("gamelist: " + gamelist);
			request.setAttribute("usedlist", usedlist);
			request.setAttribute("gamelist", gamelist);
			request.getRequestDispatcher("/WEB-INF/index/mainsearch.jsp").forward(request, response);
		}
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
