package kh.semi.boardclass.used.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;

@WebServlet("/usedinformation")
public class UsedInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedInformationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int usedNO = Integer.parseInt(request.getParameter("no"));
		Used vo = new UsedService().getUsedDetail(usedNO);
		
		request.setAttribute("used", vo);
		request.getRequestDispatcher("/WEB-INF/used/useddetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
