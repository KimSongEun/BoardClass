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
import kh.semi.boardclass.admin.model.vo.ReportBoard;
import kh.semi.boardclass.admin.model.vo.ReportComment;
import kh.semi.boardclass.admin.model.vo.ReportReview;
import kh.semi.boardclass.admin.model.vo.ReportUsed;

/**
 * Servlet implementation class OpenView
 */
@WebServlet("/adminmain")
public class GoToAdminMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToAdminMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<Notice> noticevolist  = new AdminService().getNewestNotice();
		request.setAttribute("noticevolist", noticevolist);
		
		ArrayList<ReportBoard> reportboardvolist  = new AdminService().selectNewestReportBoardList();
		request.setAttribute("reportboardvolist", reportboardvolist);
		
		ArrayList<ReportComment> reportcommentvolist  = new AdminService().selectNewestReportCommentList();
		request.setAttribute("reportcommentvolist", reportcommentvolist);
		
		ArrayList<ReportReview> reportreviewvolist  = new AdminService().selectNewestReportReviewList();
		request.setAttribute("reportreviewvolist", reportreviewvolist);
		
		ArrayList<ReportUsed> reportusedvolist  = new AdminService().selectNewestReportUsedList();
		request.setAttribute("reportusedvolist", reportusedvolist);
		
		String viewPage = "/WEB-INF/admin/main/adminMain.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
