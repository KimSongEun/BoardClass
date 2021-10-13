package kh.semi.boardclass.used.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;

/**
 * Servlet implementation class UsedCreateServlet
 */
@WebServlet("/usedcreate")
public class UsedCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedCreateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String userId = (String) request.getSession().getAttribute(getServletInfo());
		if (userId == null) {
			userId = "테스트회원01";
		}
		String usedTitle = request.getParameter("usedTitle");
		String usedPrice = request.getParameter("usedPrice");
		String usedState = request.getParameter("usedState");
		String usedChange = request.getParameter("usedChange");
		String usedPay = request.getParameter("usedPay");
		String usedArea = request.getParameter("usedArea");
		String usedInfo = request.getParameter("usedInfo");
		String fileSavePath = "used_img";
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		if (!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect("/WEB-INF/used/imguploaderror.jsp");
		}
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);
		MultipartRequest multi = new MultipartRequest(request, uploadPath, uploadSizeLimit, encType,
				new DefaultFileRenamePolicy());
		String usedImg = multi.getFilesystemName("usedImg");

		Used vo = new Used(userId, usedTitle, usedPrice, usedState, usedChange, usedPay, usedArea, usedInfo, usedImg);
		int result = new UsedService().insertUsed(vo);
		if (result == 0) {
			out.println("글 입력 안됨");
		} else {
			response.sendRedirect("usedmain");
		}
	}

}
