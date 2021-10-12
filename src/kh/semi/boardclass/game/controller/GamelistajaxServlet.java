package kh.semi.boardclass.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class GameCatogoryServlet
 */
@WebServlet("/gamelist.ajax")
public class GamelistajaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamelistajaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	      
	      String gameImage = request.getParameter("GMAE_IMAGE");
	      String gameKoName = request.getParameter("GAME_KONAME");
	      String gameLevel = request.getParameter("GAME_LEVEL");
	   
	      int gameLevelInt = 0;
	     
	      
	      try {
	    	 gameLevelInt = Integer.parseInt(gameLevel);
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	         System.out.println("숫자로 변환하지 못했음.");
	         //
	         out.println("오류발생");
	         out.flush();
	         out.close();
	         return;
	      }
	      
	      Game gamevo = new Game();
	      gamevo.setGameImage(gameImage);
	      gamevo.setGameKoName(gameKoName);
	      gamevo.setGameLevel(gameLevelInt);
	     
	      
	      ArrayList<Game> volist = new GameService().selectGame(gameKoName);
	      request.setAttribute("gamevolist", gamevo);
	      Gson gson = new GsonBuilder().create();
	      String jsonListVo = gson.toJson(volist);
	      out.print(jsonListVo);
	      out.flush();
	      out.close();
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
