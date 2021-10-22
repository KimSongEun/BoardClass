package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class CommunityBoardReportServlet
 */
@WebServlet("/boardreport.ajax")
public class CommunityBoardReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityBoardReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
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
		
		int boardNo = Integer.parseInt(request.getParameter("thisBoardNo"));
		String userId = request.getParameter("loginId");
		
		int result = new CommunityService().CountBoardReport(boardNo, userId);
		
		int secondResult = -1;
		if(result < 1) {
			secondResult = new CommunityService().insertReportBoard(boardNo, userId);
			System.out.println("신고접수됨");
		} else {
			secondResult = 0;
			System.out.println("이미 신고접수됨");
		}
		
		System.out.println(secondResult);

		out.print(secondResult);
		out.flush();
		out.close();
		
	}

}
