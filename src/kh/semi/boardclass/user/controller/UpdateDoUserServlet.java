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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateuser.do")
public class UpdateDoUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/signupservlet 진입");
		response.setCharacterEncoding("UTF-8");
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
		String userImage = "./upload/userprofile/" + file;
		if (file == null) {
			userImage = multi.getParameter("image");
			System.out.println("업로드 실패");
		} else {
			// 업로드 성공 시
			System.out.println("업로드 성공");
		}
		if (userImage == null) {
			userImage = multi.getParameter("image");
		}

		String userName = multi.getParameter("userName");
		String userNickname = multi.getParameter("userNickname");
		String userId = multi.getParameter("userId");
		String userPassword = multi.getParameter("userPassword");
		String userEmail = multi.getParameter("userEmail");
		int userPhone = Integer.parseInt(multi.getParameter("userPhone"));
		String userAddress = multi.getParameter("userAddress");
		if(userAddress.isEmpty()) {
			userAddress = multi.getParameter("address");
		}
		System.out.println(userId);
		System.out.println(userImage);
		System.out.println(userAddress);
		
		HttpSession session = request.getSession(false);
		User m = (User) session.getAttribute("userSession");
		UserService uservice = new UserService();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/alert.jsp");
		if (m != null && m.getUserId().equals(userId)) { // 만약 ID 값이 기존값과 일치한다면 수정 실행
			m.setUserPassword(userPassword);	
			m.setUserName(userName);
			m.setUserNickname(userNickname);
			m.setUserEmail(userEmail);
			m.setUserPhone(userPhone);
			m.setUserAddress(userAddress);
			m.setUserImage(userImage);
			
			if (uservice.updateUser(m) > 0) {
				session.setAttribute("userSession", m);
				request.setAttribute("msg", "회원정보 수정에 성공했습니다!");
				request.setAttribute("loc", "usermain");
			} else {
				out.append("<script>alert('회원 정보 수정 오류!\n'+'관리자에게 문의하세요!');</script>");
			}
		} else {
			request.setAttribute("msg", "회원정보 수정에 실패했습니다");
		request.setAttribute("loc", "usermain");
		}
		rd.forward(request, response);
		out.flush();
		out.close();
	
	}

}
