package kh.semi.boardclass.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.used.model.vo.Used;

/**
 * Servlet implementation class UserDetailUsedListAjaxServlet
 */
@WebServlet("/userdetailused.ajax")
public class UserDetailUsedListAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailUsedListAjaxServlet() {
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
		
		System.out.println("/userdetailused.ajax 진입");
		
		String userId = request.getParameter("userId");
		
		PrintWriter out = response.getWriter();
		Map<String, Object> map1 = new HashMap<String, Object>();  
		
		ArrayList<Used> volist  = new AdminService().selectUserDetailUsedList(userId);
		System.out.println(volist);
		map1.put("usedvolist", volist);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String gsonStr = gson.toJson(map1);
		out.append(gsonStr);
		out.flush();
		out.close();
	}

}
