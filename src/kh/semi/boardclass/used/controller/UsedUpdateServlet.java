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
		String usedImg = "./used_img/" + multi.getFilesystemName("usedImg");
		String usedCategory = multi.getParameter("usedCategory");
		String usedKeyword = multi.getParameter("keyword");
		int usedNo = Integer.parseInt(request.getParameter("usedNo"));
		
		Used vo = new Used(usedTitle, usedPrice, usedState, usedChange, usedExtype, usedInfo, usedImg, usedCategory, usedKeyword);
		
		int result = new UsedService().updateUsed(vo, usedNo);
		
		if (result < 1) {
			System.out.println("글 입력 안됨");
			response.sendRedirect("usedmain");
		} else {
			System.out.println("글 입력 성공 - 그리고 main 이동");
			response.sendRedirect(request.getContextPath() + "/useddetail?usedNo=" + usedNo);
		}
	}

}
