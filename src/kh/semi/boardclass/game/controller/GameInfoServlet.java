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
import kh.semi.boardclass.user.model.vo.User;

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
        
		
        String gamenumstr = request.getParameter("GAME_NO");
		System.out.println("zz"+gamenumstr);
        int gamenum = 0;
        try{   
        	gamenum = Integer.parseInt(gamenumstr);       
        }catch(Exception e){
        	System.out.println("숫자 변환 실패 기본 값 0");
        }
		System.out.println("gamenum:"+gamenum);

        GameService service = new GameService();
        
        User loginSS = (User)request.getSession().getAttribute("userSession");
        String userId = null;
		int countlike = 0;		
		if(loginSS != null) {
			userId = loginSS.getUserId();
			countlike = new GameService().countGameLike(userId, gamenum);
		}
		
		int count = new GameService().getReviewCount(gamenum);
		
        // 게임 정보 읽기
        Game vo = service.InfoGame(gamenum);
        if(vo==null) {  // 게임 정보 읽지 못하면 게임리스트화면으로 이동
        	response.sendRedirect("GameAllList");
        	return;
        }
        
        // 게임정보가 있다면 이미지 구분하기
        String str = vo.getGamePlusImage();
        String[] str2 = str.split(","); 
        String str3 = vo.getGamePlus();
        String[] str4 = str3.split(","); 
        
        // 게임 관련 중고거래
        ArrayList<Used> vo2 = service.usedlist(vo.getGameKoName());
        
        // 게임 관련 리뷰 - 최신4개
		int startRnum = 1;   // 화면에 글
		int endRnum = 4;  // 화면에 글
        ArrayList<GameReview> gvo2 =service.selectReview(startRnum,endRnum,gamenum, userId);

        request.setAttribute("gamevo", vo);
        request.setAttribute("usedvolist", vo2);
        request.setAttribute("riviewvolist", gvo2);
    	request.setAttribute("likeresult", countlike);
    	request.setAttribute("reviewcount", count);
    	
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
