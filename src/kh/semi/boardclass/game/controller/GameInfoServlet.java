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
        String gamenum = request.getParameter("GAME_NO");
        
        String reviewno1 = request.getParameter("REVIEW_NO");
        if(reviewno1 == null){
        	reviewno1 = "0";
        }
       
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
        
      
        GameReview gvo= new GameReview(id, gameno, content, score);    
        
        int result = new GameService().insertReview(gvo);
        if (result < 1) {
			System.out.println("글 입력 안됨");
		} else {
			System.out.println("글 입력 성공");
		}
        
        int update = new GameService().updateGrade(gameno);
    	
        if (update == 0) {
			System.out.println("평점 입력 안됨");
		} else {
			System.out.println("평점 입력 성공");
		}
        
        Game vo = new GameService().InfoGame(name);
        
        String str = vo.getGamePlusImage();
        
        String[] str2 = str.split(","); 
        String str3 = vo.getGamePlus();
        String[] str4 = str3.split(","); 
         
        ArrayList<Used> vo2 = new GameService().usedlist(name);
        
        
       
        
        final int PAGE_SIZE = 4;   // 한 페이지 당 글수
		final int PAGE_BLOCK = 1;   // 한 화면에 나타날 페이지 링크 수
		int bCount = 0;   // 총 글수
		int pageCount = 0; // 총 페이지수
		int startPage = 1;   // 화면에 나타날 시작페이지
		int endPage = 1;   // 화면에 나타날 마지막페이지
		int currentPage = 1;
		int startRnum = 1;   // 화면에 글
		int endRnum = 1;  // 화면에 글
		
		String pageNum = request.getParameter("pagenum");
		if(pageNum != null) {   // 눌려진 페이지가 있음.
			currentPage = Integer.parseInt(pageNum); // 눌려진 페이지
		}
		// 총 글수
		bCount = new GameService().getGameCount();
		// 총 페이지수 = (총글개수 / 페이지당글수) + (총글개수에서 페이지당글수로 나눈 나머지가 0이 아니라면 페이지개수를 1 증가)
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		//rownum 조건 계산
		startRnum = (currentPage-1) * PAGE_SIZE   + 1;   // 1//6//11/16//21
		endRnum = startRnum + PAGE_SIZE -1; 
		if(endRnum > bCount) endRnum=bCount;
		
		if(currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK -1)  * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK)  * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK -1; 
		if(endPage > pageCount) endPage=pageCount;
		
        try{   
        int gameno2 = Integer.parseInt(gamenum);
        ArrayList<GameReview> gvo2 = new GameService().selectReview(startRnum,endRnum,gameno2);
        request.setAttribute("riviewvolist", gvo2);
        }catch(Exception e){}
 
        try {
        int reviewno2 = Integer.parseInt(reviewno1);   
        GameReview vo3 = new GameService().InfoReview(reviewno2);
        System.out.println("a"+reviewno1);
        System.out.println("aa"+reviewno2);
        System.out.println("aaa"+vo3);
        request.setAttribute("reviewvolist", vo3);
        }catch(Exception e){}
       
        
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
