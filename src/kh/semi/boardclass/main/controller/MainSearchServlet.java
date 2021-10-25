package kh.semi.boardclass.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainSearch")
public class MainSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cateSch = request.getParameter("selectSearch");
		String searchWord = request.getParameter("main_search");
		if(cateSch == "보드게임") {
			request.setAttribute("searchWord", searchWord);
			request.getRequestDispatcher("GameAllList").forward(request, response);
		} else if(cateSch == "중고거래"){
			request.setAttribute("searchWord", searchWord);
			request.getRequestDispatcher("usedmain").forward(request, response);
		} else {
			response.sendRedirect("main");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
