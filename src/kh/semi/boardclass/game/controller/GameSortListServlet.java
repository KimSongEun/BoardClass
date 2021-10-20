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

/**
 * Servlet implementation class GameListServlet
 */
@WebServlet("/GameSortList")
public class GameSortListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameSortListServlet() {
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
    	
        
		final int PAGE_SIZE = 10;   
		final int PAGE_BLOCK = 3;   
		int bCount = 0;   
		int pageCount = 0; 
		int startPage = 1;  
		int endPage = 1;  
		int currentPage = 1;
		int startRnum = 1;   
		int endRnum = 1;  
		
		String pageNum = request.getParameter("pagenum");
		if(pageNum != null) {   
			currentPage = Integer.parseInt(pageNum);
		}
		
		bCount = new GameService().getGameCount();
		
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		
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
		
		String search = request.getParameter("search");
		System.out.println("검색어는 : " + search);

		
		// DB에서 값 읽어오기
		ArrayList<Game> volist = new GameService().selectSortGameList(startRnum,endRnum, search);
		
		
		request.setAttribute("gamevolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		request.getRequestDispatcher("/WEB-INF/game/gamelist/GameSortList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
