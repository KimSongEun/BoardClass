package kh.semi.boardclass.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.boardclass.user.model.service.UserService;
import kh.semi.boardclass.user.model.vo.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteuser.do")
public class DeleteDoUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteDoUserServlet() {
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

		System.out.println("deleteuser 진입");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "upload/userprofile";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		// enctype="multipart/form-data" 로 전송되었는지 확인
		if (!ServletFileUpload.isMultipartContent(request))
			System.out.println("error");

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request, uploadPath, uploadSizeLimit, encType,
				new DefaultFileRenamePolicy());

		// 업로드 된 파일 이름 얻어오기
		String file = multi.getFilesystemName("uploadFile");
		String userImage = "/upload/userprofile/" + file;

		if (file == null) {
			// 업로드 실패 시
			userImage = "/upload/userprofile/user.png";
			System.out.println("업로드 실패");
		} else {
			// 업로드 성공 시
			userImage = "/upload/userprofile/" + file;
			System.out.println("업로드 성공");
		}

//		String userId = request.getParameter("userId");
//		String userPassword = request.getParameter("userPassword");

//		String userName = multi.getParameter("userName");
//		String userNickname = multi.getParameter("userNickname");
		String userId = multi.getParameter("userId");
		String userPassword = multi.getParameter("userPassword");
//		String userEmail = multi.getParameter("userEmail");
//		int userPhone = Integer.parseInt(multi.getParameter("userPhone"));
//		String userAddress = multi.getParameter("userAddress");
//		if (userAddress.isEmpty()) {
//			userAddress = "-";
//		}

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("userSession");
		UserService uservice = new UserService();
		

		System.out.println("userId" + userId);
		System.out.println("userPassword" + userPassword);

		
		System.out.println("deleteuser2 진입");
		if (user != null && user.getUserId().equals(userId)) { // 만약 ID 값이 기존값과 일치한다면 수정 실행		
			uservice.deleteUser(user);
			session.invalidate();
			System.out.println("회원탈퇴에 성공했습니다.");
			response.sendRedirect("main");

		} else {

		}


	}

}
