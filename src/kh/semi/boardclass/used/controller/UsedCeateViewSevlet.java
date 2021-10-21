package kh.semi.boardclass.used.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.user.model.vo.User;

@WebServlet("/usedcreateview")
public class UsedCeateViewSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UsedCeateViewSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인이 안되면 진입불가
	      User loginSS = (User)request.getSession().getAttribute("userSession");
	      if(loginSS == null) {
	         System.out.println("로그인이 풀렸습니다.");//확인
	         request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
	         return;
	      }
	      request.getRequestDispatcher("/WEB-INF/used/usedcreateview.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
