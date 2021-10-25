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
@WebServlet("/GameFamilyList")
public class GameFamilyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameFamilyListServlet() {
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
    	
        
		final int PAGE_SIZE = 10;   // 한 페이지 당 글수
		final int PAGE_BLOCK = 5;   // 한 화면에 나타날 페이지 링크 수
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
		String cate = "가족";
		// 총 글수
		bCount = new GameService().getGameCount(cate);
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
		
		

		String search = request.getParameter("search");
		System.out.println("검색어는 : " + search);

		String sort = request.getParameter("sort");
		if(sort == null) {
			sort = "0";
		}
		// DB에서 값 읽어오기
		if(sort == "0") {
		ArrayList<Game> volist = new GameService().selectCateGameList(startRnum,endRnum,cate,search);
		request.setAttribute("gamevolist", volist);
		}else if(sort.equals("GameLevelList")) {
			ArrayList<Game> volist = new GameService().selectLevelGameList(startRnum,endRnum,cate, search);
			request.setAttribute("gamevolist", volist);
		} else if(sort.equals("GameGradeList")) {
			ArrayList<Game> volist = new GameService().selectGradeGameList(startRnum,endRnum,cate, search);
			request.setAttribute("gamevolist", volist);
		}else if(sort.equals("GameGradeDescList")) {
			ArrayList<Game> volist = new GameService().selectGradeDescGameList(startRnum,endRnum,cate, search);
			request.setAttribute("gamevolist", volist);
		}else if(sort.equals("GameSortList")) {
			ArrayList<Game> volist = new GameService().selectSortGameList(startRnum,endRnum,cate, search);
			request.setAttribute("gamevolist", volist);
		}
		
//		String sort1 = request.getParameter("sort1");
//		String s1 = "8세";
//		String s2 = "12세";
//		String s3 = "13세";
//		String s4 = "14세";
//		
//		if(sort1 == null) {
//			sort1 = "0";
//		}
//		if(sort1 == "0") {
//			ArrayList<Game> volist = new GameService().selectCateGameList(startRnum,endRnum,cate,search);
//			request.setAttribute("gamevolist", volist);
//			}else if(sort1.equals("eight")) {
//				ArrayList<Game> volist = new GameService().selectAgeGameList(startRnum,endRnum,cate, s1);
//				request.setAttribute("gamevolist", volist);
//			} else if(sort1.equals("twelve")) {
//				ArrayList<Game> volist = new GameService().selectAgeGameList(startRnum,endRnum,cate, s2);
//				request.setAttribute("gamevolist", volist);
//			}else if(sort1.equals("thirteen")) {
//				ArrayList<Game> volist = new GameService().selectAgeGameList(startRnum,endRnum,cate, s3);
//				request.setAttribute("gamevolist", volist);
//			}else if(sort1.equals("fourteen")) {
//				ArrayList<Game> volist = new GameService().selectAgeGameList(startRnum,endRnum,cate, s4);
//				request.setAttribute("gamevolist", volist);
//			}
		
		// Data 전달을 위해서 request에 셋
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		request.getRequestDispatcher("/WEB-INF/game/gamelist/GameFamilyList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
