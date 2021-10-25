 package kh.semi.boardclass.community.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import kh.semi.boardclass.admin.model.vo.Notice;
import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.BoardReport;
import kh.semi.boardclass.community.model.vo.Comment;
import oracle.jdbc.proxy.annotation.Pre;

public class CommunityDao {

	public CommunityDao() {
		// TODO Auto-generated constructor stub
	}
public Board getBoard(Connection conn, int boardNo) {
	Board vo = null;
//	String sql = "select * from board where board_no =?";
	String sql = "SELECT BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT," 
			+ " TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE, TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, " 
			+ " BOARD_VIEW_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ, BOARD_IMG  FROM BOARD"
			+ " WHERE BOARD_NO = ?";
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		rset = pstmt.executeQuery();
		if (rset.next()) {
			vo = new Board();
			vo.setBoardNo(rset.getInt("board_no"));
			vo.setUserId(rset.getString("user_id"));
			vo.setBoardType(rset.getString("board_type"));
			vo.setBoardCategory(rset.getString("board_category"));
			vo.setBoardTitle(rset.getString("board_title"));
			vo.setBoardContent(rset.getString("board_content"));
			vo.setBoardWriteDate(rset.getString("board_write_date"));
			vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
			vo.setBoardViewCount(rset.getInt("board_view_count"));
			vo.setBoardReplyRef(rset.getInt("board_reply_ref"));
			vo.setBoardReplyLev(rset.getInt("board_reply_lev"));
			vo.setBoardReplySeq(rset.getInt("board_reply_seq"));
			vo.setBoardImg(rset.getString("board_img"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	return vo;
	}
	// category 별 글 개수 조회
	public int getBoardCount(Connection conn, String category) { 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = "SELECT COUNT(board_no) FROM BOARD where board_category = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	// 글 개수 조회
	public int getBoardCount(Connection conn) { 
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			int result = 0;
			String sql = "SELECT COUNT(board_no) FROM BOARD";
			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					result = rset.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
	// 전체 게시글 리스트 조회
	public ArrayList<Board> selectBoardList(Connection conn, int start, int end) {
	ArrayList<Board> volist = null;
	String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT, " + 
			" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE, TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, " + 
			" BOARD_VIEW_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ, BOARD_IMG, NVL(t4.comment_no,0) comment_no" + 
			" from (" + 
			"   select *  from " + 
			" (select Rownum r, t1.* from  (select * from board order by BOARD_REPLY_REF desc, BOARD_REPLY_SEQ asc) t1 ) t2" + 
			"	where r between ? and ? order by board_no desc" + 
			"    )t3 left outer join (SELECT COUNT(comment_no) comment_no, board_no FROM comt group by board_no) t4 using ( board_no ) ";
//	String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT," 
//				+ " TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE, TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE,"  
//				+ " BOARD_VIEW_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ, BOARD_IMG  from" 
//				+ "	 (select Rownum r, t1.* from  (select * from board order by BOARD_REPLY_REF desc, BOARD_REPLY_SEQ asc) t1 ) t2" 
//				+ "  where r between ? and ? order by board_no desc";
	
//	String sql = "select * from "
//			+ " (select Rownum r, t1.* from "
//			+ " (select * from board order by BOARD_REPLY_REF desc, BOARD_REPLY_SEQ asc) t1 ) t2 "
//			+ " where r between ? and ?";

	PreparedStatement pstmt = null;
	ResultSet rset = null;

	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rset = pstmt.executeQuery();
		volist = new ArrayList<Board>();
		if (rset.next()) {
			do {
				Board vo = new Board();
				vo.setBoardNo(rset.getInt("board_no"));
				vo.setUserId(rset.getString("user_id"));
				vo.setBoardType(rset.getString("board_type"));
				vo.setBoardCategory(rset.getString("board_category"));
				vo.setBoardTitle(rset.getString("board_title"));
				vo.setBoardContent(rset.getString("board_content"));
				vo.setBoardWriteDate(rset.getString("board_write_date"));
				vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
				vo.setBoardViewCount(rset.getInt("board_view_count"));
				vo.setBoardImg(rset.getString("board_img"));
				vo.setBoardReplyRef(rset.getInt("BOARD_REPLY_REF"));
				vo.setBoardReplyLev(rset.getInt("BOARD_REPLY_LEV"));
				vo.setBoardReplySeq(rset.getInt("BOARD_REPLY_SEQ"));
				vo.setCommentCount(rset.getInt("comment_no"));
				volist.add(vo);
			} while (rset.next());
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	return volist;
}

	
	// category별  게시글 리스트 조회
	public ArrayList<Board> selectBoardList(Connection conn, int start, int end, String category) {
		ArrayList<Board> volist = null;
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT," 
				+ 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE, TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, " 
				+ 	" BOARD_VIEW_COUNT, BOARD_IMG, NVL(t4.comment_no,0) AS comment_no "  
				+ 	" from (  select * from " 
				+ 	" (select Rownum r, t1.* from" 
				+ " (select * from board where board_category= ? ) t1 ) t2" 
				+ 	"  where r between ? and ? order by board_no desc)t3 left outer join (SELECT COUNT(comment_no) comment_no, board_no FROM comt group by board_no) t4 using ( board_no ) ";
//		String sql = "select * from " 
//				 +" (select Rownum r, t1.* from"
//				 +"(select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT," 
//				 +"	TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') AS BOARD_WRITE_DATE,"  
//				 +" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') AS BOARD_REWRITE_DATE," 
//				 +"	BOARD_VIEW_COUNT, BOARD_IMG from board where board_category= ? order by BOARD_REPLY_REF desc, BOARD_REPLY_SEQ asc) t1 ) t2"  
//				 +" where r between ? and ? order by board_no desc";
//		String sql = "SELECT BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT," + 
//				" TO_CHAR(BOARD_WRITE_DATE, 'YYYY/MM/DD') AS BOARD_WRITE_DATE, TO_CHAR(BOARD_REWRITE_DATE, 'YYYY/MM/DD'), AS BOARD_REWRITE_DATE" + 
//				" BOARD_VIEW_COUNT, BOARD_REPLY_REF, BOARD_REPLY_LEV, BOARD_REPLY_SEQ, BOARD_IMG  "
//				+ " FROM (SELECT ROWNUM R, T1.* FROM (SELECT * FROM BOARD ORDER BY BOARD_REPLY_REF DESC, BOARD_REPLY_SEQ ASC) T1) T2"
//				+ " WHERE R BETWEEN ? AND ?";
//		String sql = "select * from "
//				+ " (select Rownum r, t1.* from "
//				+ " (select * from board where board_category=? order by BOARD_REPLY_REF desc, BOARD_REPLY_SEQ asc) t1 ) t2 "
//				+ " where r between ? and ?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setCommentCount(rset.getInt("comment_no"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	// 게시글의 조회 수 1 상승
	public void readCount(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		//TODO
		String sql = "update board set board_view_count = board_view_count + 1 where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
	}
	public void updateCount (Connection conn, Board vo) {
		PreparedStatement pstmt = null;
		String sql = "update board set board_view_count = board_view_count + 1 where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBoardNo());
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
	}
	
	// 게시글 상세보기
	public Board selectBoardContent(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board vo = new Board();
		String sql = "select * from board where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
				if(rset.next()) {
				vo.setBoardNo(rset.getInt("board_no"));
				vo.setUserId(rset.getString("user_id"));
				vo.setBoardType(rset.getString("board_type"));
				vo.setBoardCategory(rset.getString("board_category"));
				vo.setBoardTitle(rset.getString("board_title"));
				vo.setBoardContent(rset.getString("board_content"));
				vo.setBoardWriteDate(rset.getString("board_write_date"));
				vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
				vo.setBoardViewCount(rset.getInt("board_view_count"));
				vo.setBoardImg(rset.getString("board_img"));
				}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return vo;
		
	}
	//best글 조회
	public ArrayList<Board> bestFreeView (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '자유게시판' order by board_view_count desc) a) "
				 + " where r between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestFreeViewone (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '자유게시판' order by board_view_count desc) a) "
				 + " where r = 1";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestFreeViewtwo (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '자유게시판' order by board_view_count desc) a) "
				 + " where r = 2";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestFreeViewthree (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '자유게시판' order by board_view_count desc) a) "
				 + " where r = 3";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestFreeViewfour (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '자유게시판' order by board_view_count desc) a) "
				 + " where r = 4";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestFreeViewfive (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '자유게시판' order by board_view_count desc) a) "
				 + " where r = 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	// 자유게시판 댓글
	public ArrayList<Board> bestFreeComt (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from (select rownum r, NVL(comment_no1,0) comment_count, a.*  from" + 
				" ( select * from (select * from board where board_category = '자유게시판' ) t1" + 
				" left outer join (SELECT COUNT(comment_no) comment_no1, board_no FROM comt group by board_no  order by comment_no1 desc ) t2 using ( board_no ))a" + 
				"  ) where r between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setComment_no(rset.getInt("comment_no"));
					vo.setCommentCount(rset.getInt("comment_count"));
					vo.setBoardRank(rset.getInt("r"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	//유저정보게시판
	public ArrayList<Board> bestUserViewOne (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '유저정보게시판' order by board_view_count desc) a) "
				 + " where r = 1";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserViewTwo (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '유저정보게시판' order by board_view_count desc) a) "
				 + " where r = 2";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserViewThree (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '유저정보게시판' order by board_view_count desc) a) "
				 + " where r = 3";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserViewFour (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '유저정보게시판' order by board_view_count desc) a) "
				 + " where r = 4";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserViewFive (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE,BOARD_CONTENT,"  
				 + 	" TO_CHAR(BOARD_WRITE_DATE, 'YY/MM/DD') as BOARD_WRITE_DATE," 
				 + 	" TO_CHAR(BOARD_REWRITE_DATE, 'YY/MM/DD') as BOARD_REWRITE_DATE, BOARD_VIEW_COUNT,board_img"
				 + 	"  from (select rownum r, a.* from (select * from board where board_category = '유저정보게시판' order by board_view_count desc) a) "
				 + " where r = 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	//유저정보게시판 댓글순
	public ArrayList<Board> bestUserComtOne (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from (select rownum r,a.*  from" + 
				" ( select * from (select * from board where board_category = '유저정보게시판' ) t1" + 
				" left outer join (SELECT COUNT(comment_no) comment_no, board_no FROM comt group by board_no  order by comment_no desc ) t2 using ( board_no ))a" + 
				"  ) where r = 1";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setCommentCount(rset.getInt("comment_no"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserComtTwo (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from (select rownum r,a.*  from" + 
				" ( select * from (select * from board where board_category = '유저정보게시판' ) t1" + 
				" left outer join (SELECT COUNT(comment_no) comment_no, board_no FROM comt group by board_no  order by comment_no desc ) t2 using ( board_no ))a" + 
				"  ) where r = 2";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setCommentCount(rset.getInt("comment_no"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserComtThree (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from (select rownum r,a.*  from" + 
				" ( select * from (select * from board where board_category = '유저정보게시판' ) t1" + 
				" left outer join (SELECT COUNT(comment_no) comment_no, board_no FROM comt group by board_no  order by comment_no desc ) t2 using ( board_no ))a" + 
				"  ) where r = 3";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setCommentCount(rset.getInt("comment_no"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserComtFour (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from (select rownum r,a.*  from" + 
				" ( select * from (select * from board where board_category = '유저정보게시판' ) t1" + 
				" left outer join (SELECT COUNT(comment_no) comment_no, board_no FROM comt group by board_no  order by comment_no desc ) t2 using ( board_no ))a" + 
				"  ) where r = 4";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setCommentCount(rset.getInt("comment_no"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Board> bestUserComtFive (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from (select rownum r,a.*  from" + 
				" ( select * from (select * from board where board_category = '유저정보게시판' ) t1" + 
				" left outer join (SELECT COUNT(comment_no) comment_no, board_no FROM comt group by board_no  order by comment_no desc ) t2 using ( board_no ))a" + 
				"  ) where r = 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("board_no"));
					vo.setUserId(rset.getString("user_id"));
					vo.setBoardType(rset.getString("board_type"));
					vo.setBoardCategory(rset.getString("board_category"));
					vo.setBoardTitle(rset.getString("board_title"));
					vo.setBoardContent(rset.getString("board_content"));
					vo.setBoardWriteDate(rset.getString("board_write_date"));
					vo.setBoardRewriteDate(rset.getString("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setCommentCount(rset.getInt("comment_no"));
					list.add(vo);
				}while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Board getFreeboard() {
		Board vo = null;
		return vo;
	}

	public Board getUserBoard() {
		Board vo = null;
		return vo;
	}

	public Board getGatheringBoard() {
		Board vo = null;
		return vo;
	}
	
	public int insertBoard(Connection conn, Board vo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE, BOARD_CONTENT," 
				+ 	" BOARD_WRITE_DATE, BOARD_VIEW_COUNT, BOARD_IMG)"  
				+ 	" VALUES (BOARD_NUM.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(SYSDATE, 'YYYY/MM/DD SS'), ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getBoardType()); // 사담/건의/질문
			pstmt.setString(3, vo.getBoardCategory()); // 자유게시판
			pstmt.setString(4, vo.getBoardTitle());
			pstmt.setString(5, vo.getBoardContent()); 
			pstmt.setInt(6, vo.getBoardViewCount());
			pstmt.setString(7, vo.getBoardImg());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateBoard(Connection conn, Board vo, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update board set board_title = ?, board_content = ?, board_type=?, board_category = ?, board_img = ? where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setString(3, vo.getBoardType());
			pstmt.setString(4, vo.getBoardCategory());
			pstmt.setString(5, vo.getBoardImg());
			pstmt.setInt(6, boardNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteBoard (Connection conn, int boardNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from board where board_No = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 자유게시판 글쓰기
	// 글쓰기 전 로그인 확인 , 카테고리, 라벨 추가
	public int insertFreeBoard(Connection conn, Board vo) {
		int result = -1;
		PreparedStatement pstmt = null;
//	    BOARD_REPLY_REF NUMBER, 
//	    BOARD_REPLY_LEV NUMBER, 
//	    BOARD_REPLY_SEQ NUMBER,
//		String sql = "insert into board values (board_num.nextval,?,?,?,?,?,SYSDATE, SYSDATE,?,?,?,?,?)";
		String sql =  "INSERT INTO BOARD (BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE, BOARD_CONTENT, "
				+ "BOARD_WRITE_DATE, BOARD_VIEW_COUNT, BOARD_IMG)"
				+ "VALUES (BOARD_NUM.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(SYSDATE, 'YYYY/MM/DD SS'), ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getBoardType()); // 사담/건의/질문
			pstmt.setString(3, "자유게시판"); // 자유게시판
			pstmt.setString(4, vo.getBoardTitle());
			pstmt.setString(5, vo.getBoardContent()); 
			pstmt.setInt(6, vo.getBoardViewCount());
			pstmt.setString(7, vo.getBoardImg());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	// 아이디 일치 확인 후 -> 수정 가능
	public int updateFreeBoard(Connection conn, Board vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update board set board_title = ?, board_content = ?, board_type=? where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setString(3, vo.getBoardType());
			pstmt.setInt(4, vo.getBoardNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	//아이디 일치후 삭제 가능
	public int deleteFreeBoard(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from board where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertUserBoard(Connection conn, Board vo) {
		int result = -1;
		PreparedStatement pstmt = null;
//	    BOARD_REPLY_REF NUMBER, 
//	    BOARD_REPLY_LEV NUMBER, 
//	    BOARD_REPLY_SEQ NUMBER,
//		String sql = "insert into board values (board_num.nextval,?,?,?,?,?,SYSDATE, SYSDATE,?,?,?,?,?)";
		String sql =  "INSERT INTO BOARD (BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE, BOARD_CONTENT, "
				+ "BOARD_WRITE_DATE, BOARD_VIEW_COUNT, BOARD_IMG)"
				+ "VALUES (BOARD_NUM.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(SYSDATE, 'YYYY/MM/DD SS'), ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getBoardType()); // 사담/건의/질문
			pstmt.setString(3, "유저정보게시판"); // 유저정보게시판
			pstmt.setString(4, vo.getBoardTitle());
			pstmt.setString(5, vo.getBoardContent()); 
			pstmt.setInt(6, vo.getBoardViewCount());
			pstmt.setString(7, vo.getBoardImg());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateUserBoard(Connection conn, Board vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update board set board_title = ?, board_content = ?, board_type=? where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setString(3, vo.getBoardType());
			pstmt.setInt(4, vo.getBoardNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteUserBoard() {
		int result = -1;
		return result;
	}
	
	//모임 정보 게시판
	public int insertGatheringBoard(Connection conn, Board vo) {
		int result = -1;
		PreparedStatement pstmt = null;
//	    BOARD_REPLY_REF NUMBER, 
//	    BOARD_REPLY_LEV NUMBER, 
//	    BOARD_REPLY_SEQ NUMBER,
//		String sql = "insert into board values (board_num.nextval,?,?,?,?,?,SYSDATE, SYSDATE,?,?,?,?,?)";
		String sql =  "INSERT INTO BOARD (BOARD_NO, USER_ID, BOARD_TYPE, BOARD_CATEGORY, BOARD_TITLE, BOARD_CONTENT, "
				+ "BOARD_WRITE_DATE, BOARD_VIEW_COUNT, BOARD_IMG)"
				+ "VALUES (BOARD_NUM.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(SYSDATE, 'YYYY/MM/DD SS'), ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getBoardType()); // 사담/건의/질문
			pstmt.setString(3, vo.getBoardCategory()); // 모임게시판
			pstmt.setString(4, vo.getBoardTitle());
			pstmt.setString(5, vo.getBoardContent()); 
			pstmt.setInt(6, vo.getBoardViewCount());
			pstmt.setString(7, vo.getBoardImg());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateGatheringBoard() {
		int result = -1;
		return result;
	}

	public int deleteGatheringBoard() {
		int result = -1;
		return result;
	}

	public int searchFreeBoardCount (Connection conn, String keyword, String field) {
		int result = 0;
		String sql = "SELECT COUNT(*) AS TOTAL FROM BOARD where "+ field+" like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> searchAllBoardUserId(Connection conn, String keyword, int start, int end) {
		ArrayList<Board> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		String sql = "select * from "
//				+ "(select Rownum r, t1.* from "
//				+ "(SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY,"
//				+ " B.BOARD_TITLE, B.BOARD_CONTENT, B.BOARD_WRITE_DATE, "
//				+ " B.BOARD_REWRITE_DATE, B.BOARD_IMG M.USER_NO FROM BOARD B "
//				+ " JOIN MEMBER M ON B.USER_ID = M.USER_ID "
//				+ " WHERE M.USER_ID like (?) ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
//		String sql = "select * from (   select Rownum r, t1.* from "
//				 + " (SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT," 
//				 + " B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE,BOARD_IMG FROM BOARD B " 
//				 + " JOIN MEMBER M ON B.USER_ID = M.USER_ID WHERE M.USER_ID like (?) "
//				 + " ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		String sql = "select * from (select * from (  select Rownum r, t1.* from" 
				+ "	 (SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT,\r\n" 
				+ "	 B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE,BOARD_IMG FROM BOARD B " 
				+ "	 JOIN MEMBER M ON B.USER_ID = M.USER_ID WHERE M.USER_ID like ?" 
				+ "	  ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ? ) where board_category ='자유게시판'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setBoardContent(rset.getString("BOARD_CONTENT"));
					vo.setBoardWriteDate(rset.getString("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getString("BOARD_REWRITE_DATE"));
					vo.setBoardImg(rset.getString("BOARD_IMG"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	
	public int getAllBoardUserIdCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM BOARD B "
				+ " JOIN MEMBER M ON B.USER_ID = M.USER_ID where M.USER_ID like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Board> searchAllBoardTitle(Connection conn, String keyword, int start, int end){
		ArrayList<Board> volist = null;
		String sql = "select * from (select * from (   select Rownum r, t1.* from "
				+ "(SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT,"
				+ " B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE,BOARD_IMG FROM BOARD B "
				+ " JOIN MEMBER M ON B.USER_ID = M.USER_ID "
				+ " WHERE  BOARD_TITLE like (?) ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?) where board_category ='자유게시판'";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setBoardContent(rset.getString("BOARD_CONTENT"));
					vo.setBoardWriteDate(rset.getString("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getString("BOARD_REWRITE_DATE"));
					vo.setBoardImg(rset.getString("BOARD_IMG"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	
	
	public int getAllBoardTitleCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID where BOARD_TITLE like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Board> searchAllBoardContent(Connection conn, String keyword, int start, int end){
		ArrayList<Board> volist = null;
		String sql = "select * from (   select Rownum r, t1.* from "
				+ "(SELECT B.USER_ID, B.BOARD_NO, B.BOARD_TYPE, B.BOARD_CATEGORY, B.BOARD_TITLE, B.BOARD_CONTENT,"
				+ " B.BOARD_WRITE_DATE, B.BOARD_REWRITE_DATE,BOARD_IMG FROM BOARD B "
				+ " JOIN MEMBER M ON B.USER_ID = M.USER_ID "
				+ " WHERE  BOARD_CONTENT like (?) ORDER BY BOARD_REWRITE_DATE DESC) t1) t2 where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Board>();
			if (rset.next()) {
				do {
					Board vo = new Board();
					vo.setBoardNo(rset.getInt("BOARD_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setBoardType(rset.getString("BOARD_TYPE"));
					vo.setBoardCategory(rset.getString("BOARD_CATEGORY"));
					vo.setBoardTitle(rset.getString("BOARD_TITLE"));
					vo.setBoardContent(rset.getString("BOARD_CONTENT"));
					vo.setBoardWriteDate(rset.getString("BOARD_WRITE_DATE"));
					vo.setBoardRewriteDate(rset.getString("BOARD_REWRITE_DATE"));
					vo.setBoardImg(rset.getString("BOARD_IMG"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}
	
	public int getAllBoardContentCount(Connection conn, String keyword) {
		int result = 0;
		String sql = "select count(*) as total FROM BOARD B JOIN MEMBER M ON B.USER_ID = M.USER_ID where BOARD_CONTENT like (?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}
	

	
	public ArrayList<Comment> selectComment(Connection conn, int boardNo) {
		ArrayList<Comment> volist = new ArrayList<Comment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select comment_no, board_no, user_id,comment_content," 
				+ "  TO_CHAR(COMMENT_WRITE_DATE, 'YY/MM/DD') AS COMMENT_WRITE_DATE," 
				+ "  TO_CHAR(COMMENT_REWRITE_DATE, 'YY/MM/DD') AS COMMENT_REWRITE_DATE ," 
				+ "  comment_img, COMMENT_REF, COMMENT_RE_STEP,COMMENT_RE_LEVEL" 
				+ " from COMT where board_no = ?"
				+ " order by COMMENT_REF desc, COMMENT_RE_STEP asc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					Comment comment = new Comment();
					comment.setCommentNo(rset.getInt("comment_no"));
					comment.setBoardNo(rset.getInt("board_no"));
					comment.setUserId(rset.getString("user_id"));
					comment.setCommentContent(rset.getString("Comment_content"));
					comment.setCommentWriteDate(rset.getString("comment_write_date"));
					comment.setCommentRewriteDate(rset.getString("comment_rewrite_Date"));
					comment.setCommentRef(rset.getInt("COMMENT_REF"));
					comment.setCommentReStep(rset.getInt("comment_re_step"));
					comment.setCommentReLevel(rset.getInt("comment_re_level"));
					comment.setCommentImg(rset.getString("comment_img"));
					volist.add(comment);
				}while (rset.next());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return volist;
	}

	public int insertComment(Connection conn, Comment comment, String userId ) {
		int commentRef = comment.getCommentRef();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sqlNextVal = "select COMMENT_NUM.nextval  from dual"; // commentNo 조회
		String sql = "Insert into COMT values(?, ?, ?, ?,SYSDATE,SYSDATE, ?, ?, ?, ?)";
		String sql2 = "update comt set comment_re_step = comment_re_step + 1 where comment_ref = ? and comment_re_step > ?";
		System.out.println("insert Dao:" +comment);
		System.out.println("sql: "+ sql);
		System.out.println("sql2: "+ sql2);
		try {
			int nextVal = 0;
			pstmt = conn.prepareStatement(sqlNextVal);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				nextVal = rset.getInt(1);
			}
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
			if(commentRef != 0) {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, comment.getCommentRef());
				pstmt.setInt(2, comment.getCommentReStep());
				pstmt.executeUpdate();
				JDBCTemplate.close(pstmt);
				
				comment.setCommentReStep(comment.getCommentReStep() + 1);
				comment.setCommentReLevel(comment.getCommentReLevel() + 1);
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nextVal);
			pstmt.setInt(2, comment.getBoardNo());
			pstmt.setString(3, comment.getUserId());
			pstmt.setString(4, comment.getCommentContent());
			pstmt.setString(5, comment.getCommentImg());
			if(commentRef != 0) {
				pstmt.setInt(6, commentRef);
			} else {
				pstmt.setInt(6, nextVal);
			}
			pstmt.setInt(7, comment.getCommentReStep());
			pstmt.setInt(8, comment.getCommentReLevel());
			System.out.println("최종 comment: " + comment);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateComment() {
		int result = -1;
		return result;
	}

	public int deleteComment(Connection conn, int commentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from comt where comment_No = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
				JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public void getRankFreeBoard() {

	}

	public void getRankUserBoard() {

	}

	public void getRankAllBoard() {

	}

	public int insertReportBoard(Connection conn,int boardNo, String userId  ) {
		int result = -1;
		PreparedStatement pstmt = null;
		// boardNo, user_id
		String sql = "insert into board_report values (BOARD_REPORT_NUM.nextval, ? , ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
	public int countBoardReport (Connection conn, int boardNo, String userId) {
		int result = -1;
		String sql = "select count(BOARD_REPORT_NO) from BOARD_REPORT where (BOARD_NO = ? and USER_ID = ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		
		}
		return result;
	}

	public int insertReportComment(Connection conn,int commentNo, String userId  ) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into comment_report values (COMMENT_REPORT_NUM.nextval, ? , ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int countReportComment (Connection conn, int commentNo, String userId) {
		int result = -1;
		String sql = "select count(COMMENT_REPORT_NO) from COMMENT_REPORT where (COMMENT_NO = ? and USER_ID = ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			pstmt.setString(2, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		
		}
		return result;
	}
	
	// 각 게시글에 좋아요 수 조회
	public int 	CountLikeBoard (Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT COUNT(BOARD_LIKE_NO) AS BOARD_LIKE_NO FROM BOARD_LIKE WHERE BOARD_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertLikeBoard(Connection conn, int boardNo, String userId) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into BOARD_LIKE VALUES (BOARD_LIKE_NUM.NEXTVAL, ? ,? )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteLikeBoard (Connection conn, int boardNo, String userId) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from BOARD_LIKE where (BOARD_NO = ? and USER_ID = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	

}
