package kh.semi.boardclass.community.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.vo.Board;
import kh.semi.boardclass.community.model.vo.Comment;

public class CommunityDao {

	public CommunityDao() {
		// TODO Auto-generated constructor stub
	}
public Board getBoard(Connection conn, int boardNo) {
	Board vo = null;
	String sql = "select * from board where board_no = ?";
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
			vo.setBoardWriteDate(rset.getDate("board_write_date"));
			vo.setBoardRewriteDate(rset.getDate("board_rewrite_date"));
			vo.setBoardViewCount(rset.getInt("board_view_count"));
			vo.setBoardReplyLev(rset.getInt("board_reply_lev"));
			vo.setBoardReplyRef(rset.getInt("board_reply_ref"));
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

	String sql = "select * from "
			+ " (select Rownum r, t1.* from "
			+ " (select * from board order by BOARD_REPLY_REF desc, BOARD_REPLY_SEQ asc) t1 ) t2 "
			+ " where r between ? and ?";

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
				vo.setBoardWriteDate(rset.getDate("board_write_date"));
				vo.setBoardRewriteDate(rset.getDate("board_rewrite_date"));
				vo.setBoardViewCount(rset.getInt("board_view_count"));
				vo.setBoardImg(rset.getString("board_img"));
				vo.setBoardReplyRef(rset.getInt("BOARD_REPLY_REF"));
				vo.setBoardReplyLev(rset.getInt("BOARD_REPLY_LEV"));
				vo.setBoardReplySeq(rset.getInt("BOARD_REPLY_SEQ"));
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

		String sql = "select * from "
				+ " (select Rownum r, t1.* from "
				+ " (select * from board where board_category=? order by BOARD_REPLY_REF desc, BOARD_REPLY_SEQ asc) t1 ) t2 "
				+ " where r between ? and ?";

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
					vo.setBoardWriteDate(rset.getDate("board_write_date"));
					vo.setBoardRewriteDate(rset.getDate("board_rewrite_date"));
					vo.setBoardViewCount(rset.getInt("board_view_count"));
					vo.setBoardImg(rset.getString("board_img"));
					vo.setBoardReplyRef(rset.getInt("BOARD_REPLY_REF"));
					vo.setBoardReplyLev(rset.getInt("BOARD_REPLY_LEV"));
					vo.setBoardReplySeq(rset.getInt("BOARD_REPLY_SEQ"));
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
		String sql = "update board set board_view_count + 1 where board_no = ?";
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
				vo.setBoardWriteDate(rset.getDate("board_write_date"));
				vo.setBoardRewriteDate(rset.getDate("board_rewrite_date"));
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
//	
//	public ArrayList<Board> selectFreeBoardList(Connection conn, int start, int end, String category) {
//		ArrayList<Board> volist = null;
//		return volist;
//	}
//
//	public ArrayList<Board> selectUserBoardList() {
//		ArrayList<Board> volist = null;
//		return volist;
//	}
//
//	public ArrayList<Board> selectGatheringBoardList() {
//		ArrayList<Board> volist = null;
//		return volist;
//	}

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
	// 자유게시판 글쓰기
	// 글쓰기 전 로그인 확인 , 카테고리, 라벨 추가
	public int insertFreeBoard(Connection conn, Board vo) {
		int result = 0;
		PreparedStatement pstmt = null;
//	    BOARD_REPLY_REF NUMBER, 
//	    BOARD_REPLY_LEV NUMBER, 
//	    BOARD_REPLY_SEQ NUMBER,
		String sql = "insert into board values (board_num.nextval,?,?,?,?,?,SYSDATE, SYSDATE,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getBoardType()); // 사담/건의/질문
			pstmt.setString(3, vo.getBoardCategory()); // 자유게시판
			pstmt.setString(4, vo.getBoardTitle());
			pstmt.setString(5, vo.getBoardContent()); 
			pstmt.setInt(6, vo.getBoardViewCount());
			pstmt.setInt(7, vo.getBoardReplyRef());
			pstmt.setInt(8, vo.getBoardReplyLev());
			pstmt.setInt(9, vo.getBoardReplySeq());
			pstmt.setString(10, vo.getBoardImg());
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
		String sql = "update board set board_title = ?, board_content = ? where board_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setInt(3, vo.getBoardNo());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

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

	public int insertUserBoard() {
		int result = -1;
		return result;
	}

	public int updateUserBoard() {
		int result = -1;
		return result;
	}

	public int deleteUserBoard() {
		int result = -1;
		return result;
	}

	public int insertGatheringBoard() {
		int result = -1;
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

	public void searchFreeBoard() {

	}

	public void searchUserBoard() {

	}

	public void searchGatheringBoard() {

	}

	public ArrayList<Comment> selectComment() {
		ArrayList<Comment> volist = null;
		return volist;
	}

	public int insertComment() {
		int result = -1;
		return result;
	}

	public int updateComment() {
		int result = -1;
		return result;
	}

	public int deleteComment() {
		int result = -1;
		return result;
	}

	public void getRankFreeBoard() {

	}

	public void getRankUserBoard() {

	}

	public void getRankAllBoard() {

	}

	public int insertReportBoard() {
		int result = -1;
		return result;
	}

	public int insertReportComment() {
		int result = -1;
		return result;
	}

	public int insertLikeBoard() {
		int result = -1;
		return result;
	}

}
