package kh.semi.boardclass.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.semi.boardclass.admin.model.service.AdminService;

/**
 * Servlet implementation class AdUpdateMainAjaxServlet
 */
@WebServlet("/adupdatemain.ajax")
public class AdUpdateMainAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdateMainAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("/adupdatemain.ajax 진입");
		int promotionNo = Integer.parseInt(request.getParameter("promotionNo"));
		int promotionPlace = Integer.parseInt(request.getParameter("promotionPlace"));
		int result = new AdminService().updateAdMain(promotionNo, promotionPlace);
		//ajax 데이터 처리
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8"); 
		new Gson().toJson(result, response.getWriter());
		out.flush();
		out.close();
	}

}
