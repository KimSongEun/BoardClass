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
import kh.semi.boardclass.game.model.vo.GameReview;
import kh.semi.boardclass.used.model.service.UsedService;
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
        
        String id =  "a";
        
        String gamen =   request.getParameter("no");
        if(gamen == null){
        	gamen = "0";
        }
        int gameno = Integer.parseInt(gamen);
        
        String content =  request.getParameter("REVIEW_CONTENT");
        
        String sco =   request.getParameter("rating");
        if(sco == null){
        	sco = "0";
        }
        int score = Integer.parseInt(sco);
        
        System.out.println(score);
        
        GameReview gvo= new GameReview(id, gameno, content, score);
        
        
        int result = new GameService().insertReview(gvo);
        if (result < 1) {
			System.out.println("글 입력 안됨");
		} else {
			System.out.println("글 입력 성공");
			//response.sendRedirect("GameInfo?GAME_KONAME=텔레스트레이션");

		}
        	
      
        
        
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
