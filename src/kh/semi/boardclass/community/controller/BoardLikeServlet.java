package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.game.model.service.GameService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class BoardLikeServlet
 */
@WebServlet("/boardlike.ajax")
public class BoardLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		User loginSS = (User) request.getSession().getAttribute("userSession");
		if (loginSS == null) {
			System.out.println("로그아웃이 풀려서 메인으로 이동");
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		
			String userId = request.getParameter("loginId");
		
		try {
			int boardNo = Integer.parseInt(request.getParameter("thisBoardNo"));
			

			int result = new CommunityService().deleteLikeBoard(boardNo, userId);

			if (result == 0) {
				int secondResult = new CommunityService().insertLikeBoard(boardNo, userId);
				if (secondResult < 1) {
					System.out.println("좋아요 실패");
				}
				System.out.println("좋아요 성공");
			}

			System.out.println("delete되었다면1이나온다:" + result);
			
			
			out.print(result);
			out.flush();
			out.close();
		} catch (NumberFormatException ex) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
