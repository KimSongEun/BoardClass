package kh.semi.boardclass.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.game.model.service.GameService;
import kh.semi.boardclass.game.model.vo.Game;
import kh.semi.boardclass.game.model.vo.GameReview;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class GameInfoServlet
 */
@WebServlet("/GameReview")
public class GameReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameReviewServlet() {
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
		
		// LOGIN 되지 않아도 보게 해야
		
        String gamenumstr = request.getParameter("GAME_NO");
		int gamenum = 0;
        try{   
        	gamenum = Integer.parseInt(gamenumstr);       
        }catch(Exception e){
        	System.out.println("숫자 변환 실패 기본 값 0");
        }
		System.out.println("GAME_NO:"+gamenum);
       
		User loginSS = (User)request.getSession().getAttribute("userSession");
		String userId=null;
		int countlike = 0;		
		if(loginSS != null) {
			userId = loginSS.getUserId();
			countlike = new GameService().countReviewLike(userId,gamenum);
		}
			
        final int PAGE_SIZE = 7;   // 한 페이지 당 글수
		final int PAGE_BLOCK = 10;   // 한 화면에 나타날 페이지 링크 수
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
		bCount = new GameService().getReviewCount(gamenum);
		
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
		
		
        
        ArrayList<GameReview> gvo2 = new GameService().selectReview(startRnum,endRnum,gamenum, userId);
        
        request.setAttribute("reviewvolist", gvo2);
        System.out.println("add"+gvo2);
        request.setAttribute("gameno", gamenum);
        request.setAttribute("likeresult", countlike);
        request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
        
		request.getRequestDispatcher("/WEB-INF/game/gameinfo/GameReview.jsp").forward(request, response);
    }
		
	    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
