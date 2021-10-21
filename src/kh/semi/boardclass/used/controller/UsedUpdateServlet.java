package kh.semi.boardclass.used.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.boardclass.used.model.dao.UsedDao;
import kh.semi.boardclass.used.model.service.UsedService;
import kh.semi.boardclass.used.model.vo.Used;
import kh.semi.boardclass.user.model.vo.User;

@WebServlet("/usedupdate")
public class UsedUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsedUpdateServlet() {
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
		
		System.out.println("수정본 받아서 등록하는 페이지 진입");
		
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
		
		String usedTitle = multi.getParameter("usedTitle");
		int	usedPrice = Integer.parseInt(multi.getParameter("usedPrice"));
		String usedState = multi.getParameter("usedState");
		String usedChange = multi.getParameter("usedChange");
		String usedExtype = multi.getParameter("usedExtype");
		String usedInfo = multi.getParameter("usedInfo");
		String usedImg = "used_img/" + multi.getFilesystemName("usedImg");
		String usedCategory = multi.getParameter("usedCategory");
		String usedKeyword = multi.getParameter("keyword");
		int usedNo = Integer.parseInt(multi.getParameter("usedNo"));
		
		Used vo = new Used(usedTitle, usedPrice, usedState, usedChange, usedExtype, usedInfo, usedImg, usedCategory, usedKeyword);
		
		int result = new UsedService().updateUsed(vo, usedNo);
		
		if (result < 1) {
			System.out.println("글 수정 안됨");
			response.sendRedirect("usedmain");
		} else {
			System.out.println("글 입력 성공 - 상세보기");
			response.sendRedirect(request.getContextPath() + "/usedinformation?no=" + usedNo);
		}
	}

}
