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
import kh.semi.boardclass.admin.model.vo.AllCommentUser;
import kh.semi.boardclass.admin.model.vo.Banner;

/**
 * Servlet implementation class AllCommentGetDetailServlet
 */
@WebServlet("/allboardgetdetail.ajax")
public class AllCommentGetDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCommentGetDetailServlet() {
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
		
		System.out.println("/allboardgetdetail.ajax 진입");
		String commentNo = request.getParameter("commentNo");
		System.out.println(commentNo);
		AllCommentUser vo = new AdminService().getAllCommentDetail(commentNo);
		System.out.println(vo.getCommentContent());
		String commentDetail = vo.getCommentContent();
		//ajax 데이터 처리
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8"); 
		new Gson().toJson(commentDetail, response.getWriter());
		out.flush();
		out.close();
	}

}
