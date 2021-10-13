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

		String fileSavePath = "upload/boardgame";
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

		String kotitle = multi.getParameter("kotitle");
		if (kotitle == null) {
			kotitle = "kotitle 재설정 필요";
		}
		String entitle = multi.getParameter("entitle");
		if (entitle == null) {
			entitle = "entitle 재설정 필요";
		}
		String category = multi.getParameter("category");
		if (category == null) {
			category = "category 재설정 필요";
		}
		String age = multi.getParameter("age");
		if (age == null) {
			age = "age 재설정 필요";
		}
		String player = multi.getParameter("player");
		if (player == null) {
			player = "player 재설정 필요";
		}
		String time = multi.getParameter("time");
		if (time == null) {
			time = "time 재설정 필요";
		}
		String priceString = multi.getParameter("price");
		int price = Integer.parseInt(priceString); // 숫자
		if (priceString == null) {
			price = 999;
		}
		String gradeString = multi.getParameter("grade");
		int grade = Integer.parseInt(priceString); // 숫자
		if (gradeString == null) {
			grade = 999;
		}
		String levelString = multi.getParameter("level");
		int level = Integer.parseInt(levelString); // 숫자
		if (levelString == null) {
			level = 999;
		}
		String designer = multi.getParameter("designer");
		if (designer == null) {
			designer = "designer 재설정 필요";
		}
		String writer = multi.getParameter("writer");
		if (writer == null) {
			writer = "writer 재설정 필요";
		}
		String brand = multi.getParameter("brand");
		if (brand == null) {
			brand = "brand 재설정 필요";
		}
		String releasedate = multi.getParameter("releasedate");
		if (releasedate == null) {
			releasedate = "releasedate 재설정 필요";
		}
		String language = multi.getParameter("language");
		if (language == null) {
			language = "language 재설정 필요";
		}
		String video = multi.getParameter("video");
		if (video == null) {
			video = "video 재설정 필요";
		}
		String plus = multi.getParameter("plus");
		if (plus == null) {
			plus = "plus 재설정 필요";
		}
		String image = "./upload/boardgame/" + fileImage;
		String ruleimage = "./upload/boardgame/" + fileRuleImage;
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
		int gameNo = Integer.parseInt(multi.getParameter("no"));
		int result = new AdminService().updateBoardGame(kotitle, entitle, category, age, player, time, price, grade, level, designer, writer, brand, releasedate, language, image, ruleimage, video, plus, gameNo);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/boardgame/boardgamealert.jsp");

		if (result > 0) {
			request.setAttribute("msg", gameNo + "번 광고 수정완료");
			request.setAttribute("loc", "boardgamelist");
		} else {
			request.setAttribute("msg", "수정실패 ");
			request.setAttribute("loc", "boardgamelist");
		}

		rd.forward(request, response);
	}

}
