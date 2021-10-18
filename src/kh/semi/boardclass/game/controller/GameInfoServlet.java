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
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.used.model.vo.Used;

/**
 * Servlet implementation class GameInfoServlet
 */
@WebServlet("/GameInfo")
public class GameInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
        PrintWriter out=response.getWriter();    
        
        String name = request.getParameter("GAME_KONAME");
        
        Game vo = new GameService().InfoGame(name);
        ArrayList<Used> vo2 = new GameService().usedlist(name);
        
        
        String str = vo.getGamePlusImage();
        String[] str2 = str.split(","); 
        String str3 = vo.getGamePlus();
        String[] str4 = str3.split(","); 
        
        request.setAttribute("gamevolist", vo);
        request.setAttribute("usedvolist", vo2);
       
        request.setAttribute("str2", str2);
        request.setAttribute("str4", str4);
      
        
		request.getRequestDispatcher("/WEB-INF/game/gameinfo/GameInfo.jsp").forward(request, response);
		
    }
		
	    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
