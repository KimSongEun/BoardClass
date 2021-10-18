package kh.semi.boardclass.used.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.used.model.service.UsedService;

@WebServlet("/useddelete")
public class UsedDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("delete진입");
		int usedNo = Integer.parseInt(request.getParameter("usedNo"));
		int result = new UsedService().deleteUsed(usedNo);
		if (result < 1) {
			System.out.println("글 삭제 안됨");
		} else {
			System.out.println("글 삭제 성공 - 그리고 main 이동");
			response.sendRedirect("usedmain");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
