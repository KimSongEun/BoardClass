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
 * Servlet implementation class BoardgameMadeServlet
 */
@WebServlet("/boardgamemade")
public class BoardgameMadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardgameMadeServlet() {
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

		MultipartRequest multi = new MultipartRequest(request,
				uploadPath, 
				uploadSizeLimit,
				encType, 
				new DefaultFileRenamePolicy() 
		);

		String fileImage = multi.getFilesystemName("uploadFileImage");
		String fileRuleImage = multi.getFilesystemName("uploadFileRuleImage");
		String filePlusImage = multi.getFilesystemName("uploadFilePlusImage");

		String kotitle = multi.getParameter("kotitle");
		String entitle = multi.getParameter("entitle");
		if (entitle.isEmpty()) {
			entitle = "??????????????? ?????? x";
		}
		String category = multi.getParameter("category");
		String age = multi.getParameter("age");
		String player = multi.getParameter("player");
		String time = multi.getParameter("time");
		String priceString = multi.getParameter("price");
		if(priceString.isEmpty()) {
			priceString = "0";
		}
		int price = Integer.parseInt(priceString); // ??????
		if (priceString.isEmpty()) {
			price = 0;
		}
		String gradeString = multi.getParameter("grade");
		if(gradeString.isEmpty()) {
			gradeString = "0";
		}
		int grade = Integer.parseInt(gradeString); // ??????
		if (gradeString.isEmpty()) {
			grade = 0;
		}
		String levelString = multi.getParameter("level");
		if(levelString.isEmpty()) {
			levelString = "0";
		}
		int level = Integer.parseInt(levelString); // ??????
		if (levelString.isEmpty()) {
			level = 0;
		}
		String designer = multi.getParameter("designer");
		String writer = multi.getParameter("writer");
		String brand = multi.getParameter("brand");
		String releasedate = multi.getParameter("releasedate");
		String language = multi.getParameter("language");
		String video = multi.getParameter("video");
		String plus = multi.getParameter("plus");
		if (plus.isEmpty()) {
			plus = "0";
		}
		String image = "/game_img/" + fileImage;
		String ruleimage = "/game_img/" + fileRuleImage;
		String plusImage = "/game_img/" + filePlusImage;
		if (fileImage == null) {
			// ????????? ?????? ???
			image = "????????? ?????????";
			System.out.println("????????? ????????? ??????");
		} else {
			System.out.println("??????????????? : " + fileImage);
			System.out.println("????????? ????????? ??????!!!");
		}
		if (fileRuleImage == null) {
			// ????????? ?????? ???
			ruleimage = "????????? ?????????";
			System.out.println("????????? ????????? ????????? ??????");
		} else {
			System.out.println("??????????????? : " + fileRuleImage);
			System.out.println("????????? ????????? ????????? ??????!!!");
		}
		if (filePlusImage == null) {
			// ????????? ?????? ???
			plusImage = "0";
			System.out.println("?????????????????? ????????? ??????");
		} else {
			System.out.println("??????????????? : " + filePlusImage);
			System.out.println("????????? ????????? ????????? ??????!!!");
		}
		int result = new AdminService().insertBoardGame(kotitle, entitle, category, age, player, time, price, grade, level, designer, writer, brand, releasedate, language, image, ruleimage, video, plus, plusImage);
		
		System.out.println(plus);
		
		response.sendRedirect("boardgamelist");
	}

}
