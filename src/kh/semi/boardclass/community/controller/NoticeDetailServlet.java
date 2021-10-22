package kh.semi.boardclass.community.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.admin.model.service.AdminService;
import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.community.model.service.CommunityService;
import kh.semi.boardclass.community.model.vo.Board;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/cnoticedetail")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String announceNoStr = request.getParameter("announceNo");
		int announceNo = 0;
		try {
			announceNo = Integer.parseInt(announceNoStr);
		}catch( Exception e ) {
			e.printStackTrace();
			System.out.println("boardNoStr 숫자변환못함");
			response.sendRedirect("nmain");
			return;
		}
		
		Notice no = new Notice();
		no.setAnnounceNo(announceNo);
		
		String pageNum = request.getParameter("pageNum");

		Notice notice =  new AdminService().getNotice(announceNo);
		//Date date = notice.getAdminWrDate();
		
		request.setAttribute("announceNo", announceNo);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("notice", notice);
		//request.setAttribute("date", date);
		
		request.getRequestDispatcher("/WEB-INF/community/notice/NoticeContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
