package kh.semi.boardclass.admin.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.boardclass.admin.model.service.AdminService;

/**
 * Servlet implementation class AdMadeServlet
 */
@WebServlet("/admade")
public class AdMadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdMadeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String fileSavePath = "upload/ad";
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		if (!ServletFileUpload.isMultipartContent(request))
			System.out.println("error");

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request,
				uploadPath, 
				uploadSizeLimit,
				encType, 
				new DefaultFileRenamePolicy() 
		);

		String file = multi.getFilesystemName("uploadFile");

		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = (String) request.getSession().getAttribute("memberLoginInfo"); // TODO: 관리자계정 넣는 것에 따라서 바꾸기
		if (writer == null) {
			writer = "song"; // TODO: 임시 writer 설정
		}
		String img = "./upload/ad/" + file;
		if (file == null) {
			// 업로드 실패 시
			img = "썸네일 미등록";
			System.out.println("업로드 실패");
		} else {
			System.out.println("첨부파일명 : " + file);
			System.out.println("업로드 성공!!!");
		}
		int result = new AdminService().insertAd(title, content, writer, img);

		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(img);
		response.sendRedirect("adlist");
	}

}
