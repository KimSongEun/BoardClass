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
import kh.semi.boardclass.user.model.vo.User;

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
		
		User loginSS = (User)request.getSession().getAttribute("userSession");
			if(loginSS == null) {
				System.out.println("로그아웃이 풀려서 메인으로 이동");
				request.getRequestDispatcher("/WEB-INF/error/loginAlert.jsp").forward(request, response);
				return;
			}

		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";
		if (!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect("view/error/Error.jsp");
		}
		ServletContext context = getServletContext();
		String fileSavePath = "used_img";
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);
		MultipartRequest multi = new MultipartRequest(request, uploadPath, uploadSizeLimit, encType,
				new DefaultFileRenamePolicy());

		String userId = loginSS.getUserId();
		String usedTitle = multi.getParameter("usedTitle");
		int	usedPrice = Integer.parseInt(multi.getParameter("usedPrice"));
		String usedState = multi.getParameter("usedState");
		String usedChange = multi.getParameter("usedChange");
		String usedExtype = multi.getParameter("usedExtype");
		String usedInfo = multi.getParameter("usedInfo");
		String usedImg = "used_img/" + multi.getFilesystemName("usedImg");
		String usedCategory = multi.getParameter("usedCategory");
		String usedKeyword = multi.getParameter("keyword");

		Used vo = new Used(userId, usedTitle, usedPrice, usedState, usedChange, usedExtype, usedInfo, usedImg, usedCategory, usedKeyword);
		int result = new UsedService().insertUsed(vo);
		if (result < 1) {
			System.out.println("글 입력 안됨");
		} else {
			System.out.println("글 입력 성공 - 그리고 main 이동");
			response.sendRedirect("usedmain");
			
		}
	}

}
