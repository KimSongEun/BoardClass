package kh.semi.boardclass.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class BoardgameUpdateServlet
 */
@WebServlet("/boardgameupdate")
public class BoardgameUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardgameUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

		String fileSavePath = "game_img";
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		if (!ServletFileUpload.isMultipartContent(request))
			System.out.println("error");

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request, uploadPath, uploadSizeLimit, encType,
				new DefaultFileRenamePolicy());

		String fileImage = multi.getFilesystemName("uploadFileImage");
		String fileRuleImage = multi.getFilesystemName("uploadFileRuleImage");
		String filePlusImage = multi.getFilesystemName("uploadFilePlusImage");

		String kotitle = multi.getParameter("kotitle");
		String entitle = multi.getParameter("entitle");
		if (entitle.isEmpty()) {
			entitle = "영어상품명 등록 x";
		}
		String category = multi.getParameter("category");
		String age = multi.getParameter("age");
		String player = multi.getParameter("player");
		String time = multi.getParameter("time");
		String priceString = multi.getParameter("price");
		if(priceString.isEmpty()) {
			priceString = "0";
		}
		int price = Integer.parseInt(priceString); // 숫자
		if (priceString.isEmpty()) {
			price = 0;
		}
		String gradeString = multi.getParameter("grade");
		if(gradeString.isEmpty()) {
			gradeString = "0";
		}
		int grade = Integer.parseInt(gradeString); // 숫자
		if (gradeString.isEmpty()) {
			grade = 0;
		}
		String levelString = multi.getParameter("level");
		if(levelString.isEmpty()) {
			levelString = "0";
		}
		int level = Integer.parseInt(levelString); // 숫자
		if (levelString.isEmpty()) {
			level = 0;
		}
		String designer = multi.getParameter("designer");
		String writer = multi.getParameter("writer");
		String brand = multi.getParameter("brand");
		String releasedate = multi.getParameter("releasedate");
		String language = multi.getParameter("language");
		String video = multi.getParameter("video");
		if (video.isEmpty()) {
			System.out.println("비었어 원래껄로해!");
			video = multi.getParameter("originvideo");
		}
		String plus = multi.getParameter("plus");
		if (plus == null) {
			plus = "plus 재설정 필요";
		}
		String image = "./game_img/" + fileImage;
		String ruleimage = "./game_img/" + fileRuleImage;
		String plusImage = "./game_img/" + filePlusImage;
		if (fileImage == null) {
			// 업로드 실패 시
			image = multi.getParameter("originimage");
			System.out.println("이미지 업로드 실패");
		} else {
			System.out.println("첨부파일명 : " + fileImage);
			System.out.println("이미지 업로드 성공!!!");
		}
		if (fileRuleImage == null) {
			// 업로드 실패 시
			ruleimage = multi.getParameter("originruleimage");
			System.out.println("규칙서 이미지 업로드 실패");
		} else {
			System.out.println("첨부파일명 : " + fileRuleImage);
			System.out.println("규칙서 이미지 업로드 성공!!!");
		}
		if (filePlusImage == null) {
			// 업로드 실패 시
			plusImage = multi.getParameter("originplusimage");
			System.out.println("확장판 이미지 업로드 실패");
		} else {
			System.out.println("첨부파일명 : " + filePlusImage);
			System.out.println("확장판 이미지 업로드 성공!!!");
		}
		if (image == null) {
			image = multi.getParameter("originimage");
		}
		if(ruleimage == null) {
			ruleimage = multi.getParameter("originruleimage");
		}
		if(plusImage == null) {
			plusImage = multi.getParameter("originplusimage");
		}
		
		int gameNo = Integer.parseInt(multi.getParameter("no"));
		int result = new AdminService().updateBoardGame(kotitle, entitle, category, age, player, time, price, grade, level, designer, writer, brand, releasedate, language, image, ruleimage, video, plus, plusImage, gameNo);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/boardgame/boardgamealert.jsp");

		if (result > 0) {
			request.setAttribute("msg", gameNo + "번 보드게임 수정완료");
			request.setAttribute("loc", "boardgamelist");
		} else {
			request.setAttribute("msg", "수정실패 ");
			request.setAttribute("loc", "boardgamelist");
		}
		rd.forward(request, response);
		

		System.out.println("수정된 비디오 값 : " + multi.getParameter("video"));
		System.out.println("원래 비디오 값 : " + multi.getParameter("originvideo"));
	}

}
