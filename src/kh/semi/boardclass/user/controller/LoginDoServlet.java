package kh.semi.boardclass.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.semi.boardclass.user.model.service.UserService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class LoginDoServlet
 */
@WebServlet("/login.do")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoServlet() {
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
		System.out.println("/login 진입");

		response.setContentType("application/json;charset=UTF-8");
		UserService mservice = new UserService();
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		System.out.println("userId: " + userId);
		System.out.println("userPassword: " + userPassword);

		PrintWriter out = response.getWriter();

		Gson gob = new GsonBuilder().setPrettyPrinting().create(); // console창에 이쁘게 보이는 것
//		Gson gob = new GsonBuilder().create();

		String gobStr = "";

		List<User> voList = new ArrayList<User>();
		User user = mservice.login(userId, userPassword);
		if (user != null) { // 로그인 성공
			System.out.println("로그인성공");
			HttpSession session = request.getSession();
			session.setAttribute("userSession", user);

			voList.add(user);
			voList.add(user);

			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("result", "ok");
			map2.put("user_Name", user.getUserName());
			map2.put("memberInfo", user);

			gobStr = gob.toJson(map2);

		} else { // 로그인 실패
			System.out.println("로그인실패");
			// 예시 1
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("result", "fail");
			gobStr = gob.toJson(map2);
		}
		System.out.println("gobStr: " + gobStr);
		out.println(gobStr);
		out.flush();
		out.close();
		
	}

}
