package kh.semi.boardclass.used.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.used.model.vo.Used;

public class UsedDao {

	public UsedDao() {
	}

	public ArrayList<Used> selectUsedList(Connection conn, int start, int end) {
		ArrayList<Used> volist = null;

		String sql = "select * from (select Rownum r, u.* from (select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY from used order by used_day desc) u) where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();

			volist = new ArrayList<Used>();
			if (rset.next()) {
				do {
					Used vo = new Used();
					vo.setUsedNo(rset.getInt("USED_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUsedTitle(rset.getString("USED_TITLE"));
					vo.setUsedPrice(rset.getInt("USED_PRICE"));
					vo.setUsedState(rset.getString("USED_STATE"));
					vo.setUsedChange(rset.getString("USED_CHANGE"));
					vo.setUsedExtype(rset.getString("USED_EXTYPE"));
					vo.setUsedInfo(rset.getString("USED_INFO"));
					vo.setUsedDay(rset.getString("USED_DAY"));
					vo.setUsedImg(rset.getString("USED_IMG"));
					vo.setUsedCategory(rset.getString("USED_CATEGORY"));
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

	public ArrayList<Used> selectCateUsedList(Connection conn, int start, int end, String cate) {
		ArrayList<Used> volist = null;

		String sql = "select * from (select Rownum r, u.* from (select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY from used where used_category like ? order by used_day desc) u) where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cate);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Used>();
			if (rset.next()) {
				do {
					Used vo = new Used();
					vo.setUsedNo(rset.getInt("USED_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUsedTitle(rset.getString("USED_TITLE"));
					vo.setUsedPrice(rset.getInt("USED_PRICE"));
					vo.setUsedState(rset.getString("USED_STATE"));
					vo.setUsedChange(rset.getString("USED_CHANGE"));
					vo.setUsedExtype(rset.getString("USED_EXTYPE"));
					vo.setUsedInfo(rset.getString("USED_INFO"));
					vo.setUsedDay(rset.getString("USED_DAY"));
					vo.setUsedImg(rset.getString("USED_IMG"));
					vo.setUsedCategory(rset.getString("USED_CATEGORY"));
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

	public int getUsedCount(Connection conn) {
		int result = -1;
		String sql = "select count(USED_NO) from USED";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
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

	public Used getUsedDetail(Connection conn, int usedNo) {
		Used vo = null;
		String sql = "select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY from used where USED_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				vo = new Used();
				vo.setUsedNo(rset.getInt(1));
				vo.setUserId(rset.getString(2));
				vo.setUsedTitle(rset.getString(3));
				vo.setUsedPrice(rset.getInt(4));
				vo.setUsedState(rset.getString(5));
				vo.setUsedChange(rset.getString(6));
				vo.setUsedExtype(rset.getString(7));
				vo.setUsedDay(rset.getString(8));
				vo.setUsedImg(rset.getString(9));
				vo.setUsedCategory(rset.getString(10));				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}

	public int insertUsed(Connection conn, Used vo) {
		int result = 0;
		String sql = "INSERT INTO USED VALUES (USED_NUM.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUsedTitle());
			pstmt.setInt(3, vo.getUsedPrice());
			pstmt.setString(4, vo.getUsedState());
			pstmt.setString(5, vo.getUsedChange());
			pstmt.setString(6, vo.getUsedExtype());
			pstmt.setString(7, vo.getUsedInfo());
			pstmt.setString(8, vo.getUsedImg());
			pstmt.setString(9, vo.getUsedCategory());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public void updateUsed(Connection conn, Used used) {

	}

	public int chatUset(Connection conn, Used used) {
		int result = 0;
		return result;
	}
}
