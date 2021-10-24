package kh.semi.boardclass.game.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.game.model.service.GameService;
import kh.semi.boardclass.game.model.vo.GameReview;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class GameInfoServlet
 */
@WebServlet("/GameInsertReview")
public class GameInsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameInsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		        
        String name = request.getParameter("GAME_KONAME");
        
        System.out.println("yoo : name깨져? "+name);
        
        String gamen =   request.getParameter("no");
        if(gamen == null){
        	gamen = "0";
        }
        int gameno = Integer.parseInt(gamen);
        
        User loginSS = (User)request.getSession().getAttribute("userSession");
		String userId=null;
		
		int countlike = 0;		
		if(loginSS != null) {
			userId = loginSS.getUserId();
			countlike = new GameService().countReviewLike(userId,gameno);
		}
        
        String content =  request.getParameter("REVIEW_CONTENT");
        
        String sco =   request.getParameter("rating");
        if(sco == null){
        	sco = "0";
        }
        int score = Integer.parseInt(sco);
        
      
        GameReview gvo= new GameReview(userId, gameno, content, score);    
      
        
        int update = new GameService().updateGrade(gameno);
    	
        if (update == 0) {
			System.out.println("평점 입력 안됨");
		} else {
			System.out.println("평점 입력 성공");
		}
        
        int result = new GameService().insertReview(gvo);
        if (result < 1) {
			System.out.println("글 입력 안됨");
		} else {
			System.out.println("글 입력 성공");
			
		}

       // request.setAttribute("name", name);
        //request.setAttribute("gamenum", gameno);
        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/GameInfo");
//        dispatcher.forward(request, response);
		response.sendRedirect("GameInfo?GAME_NO="+gameno);
    }
		
	    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
