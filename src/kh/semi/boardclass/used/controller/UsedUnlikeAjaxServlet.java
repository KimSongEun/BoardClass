package kh.semi.boardclass.used.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.user.model.vo.User;

@WebServlet("/usedunlike.ajax")
public class UsedUnlikeAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsedUnlikeAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		User loginSS = (User)request.getSession().getAttribute("userSession");
		if(loginSS == null) {
			System.out.println("로그아웃이 풀려서 메인으로 이동");
			request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
			return;
		}
		
		int usedNo = Integer.parseInt(request.getParameter("thisUsedNo"));
		String userId = request.getParameter("loginId");
		
		int result = new UsedService().deleteUsedLike(usedNo, userId);
		
		
		if(result == 0) {
			int secondResult = new UsedService().insertUsedLike(usedNo, userId);
			if(secondResult < 1) {
				System.out.println("찜등록 실패");
			}
			System.out.println("찜등록 성공");
		}
		
		System.out.println(result);
		
		out.print(result);
		out.flush();
		out.close();
	}

}
