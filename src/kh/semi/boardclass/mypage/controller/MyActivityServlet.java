package kh.semi.boardclass.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.semi.boardclass.mypage.model.service.MyPageService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class MyActivityServlet
 */
@WebServlet("/myactivity")
public class MyActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyActivityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

//		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String userId = ((User) session.getAttribute("user")).getUserId();
		System.out.println(userId);
		
		
		int BoardGameLike = new MyPageService().getMyBoardGameListCount(userId);
		System.out.println("찜한 보드게임 수 : " + BoardGameLike);
		
		int MyTradeList = new MyPageService().getMyTradeListCount(userId);
		System.out.println("판매 게시글 수 : " + MyTradeList);
		
		int MyTradeLike = new MyPageService().getMyLikeTradeListCount(userId);
		System.out.println("찜한 중고거래 수 : " + MyTradeLike);
		
		int MyBoardCount = new MyPageService().getMyBoardCount(userId);
		System.out.println("커뮤니티 작성글 수 : " + MyBoardCount);
		
		int MyBoardComtCount = new MyPageService().getMyBoardComtCount(userId);
		System.out.println("커뮤니티 댓글 작성 수 : " + MyBoardComtCount);
		

		request.setAttribute("BoardGameLike", BoardGameLike);
		request.setAttribute("MyTradeList", MyTradeList);
		request.setAttribute("MyTradeLike", MyTradeLike);
		request.setAttribute("MyBoardCount", MyBoardCount);
		request.setAttribute("MyBoardComtCount", MyBoardComtCount);
		
		
		
		request.getRequestDispatcher("/WEB-INF/mypage/myActivity.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
