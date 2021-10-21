package kh.semi.boardclass.used.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.used.model.vo.UsedLike;
import kh.semi.boardclass.user.model.vo.User;

@WebServlet("/usedinformation")
public class UsedInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedInformationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User loginSS = (User)request.getSession().getAttribute("userSession");
		int usedNo = Integer.parseInt(request.getParameter("no"));
		Used vo = new UsedService().getUsedDetail(usedNo);
		
		int countlike = 0;		
		if(loginSS != null) {
			String userId = loginSS.getUserId();
			countlike = new UsedService().countUsedLike(usedNo, userId);
		}
		
		int countreport = 0;
		if(loginSS != null) {
			String userId = loginSS.getUserId();
			countreport = new UsedService().countUsedReport(usedNo, userId);
		}
		
		System.out.println("countlike="+countlike);
		System.out.println("countreport="+countreport);
		System.out.println("vo="+vo);
		
		request.setAttribute("reportresult", countreport);
		request.setAttribute("likeresult", countlike);
		request.setAttribute("used", vo);
		request.getRequestDispatcher("/WEB-INF/used/useddetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
