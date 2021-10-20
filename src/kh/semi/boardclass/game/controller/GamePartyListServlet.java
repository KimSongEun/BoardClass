package kh.semi.boardclass.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.boardclass.game.model.service.GameService;
import kh.semi.boardclass.game.model.vo.Game;

/**
 * Servlet implementation class GameListServlet
 */
@WebServlet("/GamePartyList")
public class GamePartyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamePartyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();    
    	
        
		final int PAGE_SIZE = 10;   // �� ������ �� �ۼ�
		final int PAGE_BLOCK = 3;   // �� ȭ�鿡 ��Ÿ�� ������ ��ũ ��
		int bCount = 0;   // �� �ۼ�
		int pageCount = 0; // �� ��������
		int startPage = 1;   // ȭ�鿡 ��Ÿ�� ����������
		int endPage = 1;   // ȭ�鿡 ��Ÿ�� ������������
		int currentPage = 1;
		int startRnum = 1;   // ȭ�鿡 ��
		int endRnum = 1;  // ȭ�鿡 ��
		
		String pageNum = request.getParameter("pagenum");
		if(pageNum != null) {   // ������ �������� ����.
			currentPage = Integer.parseInt(pageNum); // ������ ������
		}
		// �� �ۼ�
		bCount = new GameService().getGameCount();
		// �� �������� = (�ѱ۰��� / ��������ۼ�) + (�ѱ۰������� ��������ۼ��� ���� �������� 0�� �ƴ϶�� ������������ 1 ����)
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0 : 1);
		//rownum ���� ���
		startRnum = (currentPage-1) * PAGE_SIZE   + 1;   // 1//6//11/16//21
		endRnum = startRnum + PAGE_SIZE -1; 
		if(endRnum > bCount) endRnum=bCount;
		
		if(currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK -1)  * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK)  * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK -1; 
		if(endPage > pageCount) endPage=pageCount;
		
		String cate = "파티";
		String search = request.getParameter("search");
		System.out.println("검색어는 : " + search);

		
		// DB에서 값 읽어오기
		ArrayList<Game> volist = new GameService().selectCateGameList(startRnum,endRnum,cate,search);
		// Data ������ ���ؼ� request�� ��
		request.setAttribute("gamevolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		request.getRequestDispatcher("/WEB-INF/game/gamelist/GamePartyList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
