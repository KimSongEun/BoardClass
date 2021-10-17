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
import kh.semi.boardclass.admin.model.vo.ReportReview;

/**
 * Servlet implementation class ReviewGetDetailServlet
 */
@WebServlet("/reviewgetdetail.ajax")
public class ReviewGetDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewGetDetailServlet() {
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
		
		System.out.println("/reviewgetdetail.ajax 진입");
		String reviewNo = request.getParameter("reviewNo");
		System.out.println(reviewNo);
		ReportReview vo = new AdminService().getReviewDetail(reviewNo);
		System.out.println(vo.getReviewContent());
		String reviewDetail = vo.getReviewContent();
		//ajax 데이터 처리
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8"); 
		new Gson().toJson(reviewDetail, response.getWriter());
		out.flush();
		out.close();
	}

}
