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
 * Servlet implementation class AdUpdateServlet
 */
@WebServlet("/adupdate")
public class AdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String fileSavePath = "upload/ad";
		 int uploadSizeLimit = 10 * 1024 * 1024; 
		 String encType = "UTF-8";
		
		 if(!ServletFileUpload.isMultipartContent(request)) 
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
		int promotionNo = Integer.parseInt(multi.getParameter("no"));
		String img = "/upload/ad/" + file;
		if (file == null) {
			// 업로드 실패 시
			img = multi.getParameter("originimg");
			System.out.println("업로드 실패");
		} else {
			System.out.println("첨부파일명 : " + file);
			System.out.println("업로드 성공!!!");
		}
		int result = new AdminService().updateAd(title, content, img, promotionNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/ad/adalert.jsp");
		
		if(result>0) {
			request.setAttribute("msg", promotionNo + "번 광고 수정완료");
			request.setAttribute("loc", "adlist");
		}else {
			request.setAttribute("msg", "수정실패 ");
			request.setAttribute("loc", "adlist");
		}
			
			rd.forward(request, response);
			System.out.println(title);
			System.out.println(content);
			System.out.println(promotionNo);
			System.out.println(img);
	}

}
