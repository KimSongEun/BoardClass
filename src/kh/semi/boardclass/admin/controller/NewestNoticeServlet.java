package kh.semi.boardclass.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.admin.model.vo.Notice;

/**
 * Servlet implementation class NewestAnnounceServlet
 */
@WebServlet("/newestnotice.do")
public class NewestNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewestNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		ArrayList<Notice> volist  = new AdminService().getNewestNotice();
		request.setAttribute("noticevolist", volist);
		request.getRequestDispatcher("/WEB-INF/admin/main/adminMain.jsp").forward(request, response);
		// 이렇게 하면.... main으로 바로 이동할수가 없고....
//		response.sendRedirect("adminmain");
		// 이렇게 하면.... 이 서블릿을 한번 들어왔다가 나가야하는디.....
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
