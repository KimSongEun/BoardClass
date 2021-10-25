package kh.semi.boardclass.used.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.community.model.dao.CommunityDao;
import kh.semi.boardclass.used.model.vo.Used;

public class UsedDao {

	public UsedDao() {
	}

	public ArrayList<Used> selectUsedList(Connection conn, int start, int end, String search) {
		ArrayList<Used> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql1 = "select * from (select Rownum r, u.* from "
				+ "(select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, "
				+ " USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY, USED_KEYWORD "
				+ " from used order by used_day desc) u) " + " where r between ? and ?";

		String sql2 = "select * from (select Rownum r, u.* from "
				+ "(select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, "
				+ " USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY, USED_KEYWORD "
				+ " from used where ( USED_TITLE like ? or USED_INFO like ? )" + " order by used_day desc) u) "
				+ " where r between ? and ?";

		String sql = "";
		if (search != null && !search.equals("")) {
			sql = sql2;
		} else {
			sql = sql1;
		}

		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			if (search != null && !search.equals("")) {
				search = "%" + search + "%";
				pstmt.setString(++idx, search);
				pstmt.setString(++idx, search);
			}
			pstmt.setInt(++idx, start);
			pstmt.setInt(++idx, end);

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
					vo.setUsedKeyword(rset.getString("USED_KEYWORD"));
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

	public ArrayList<Used> selectUsedList(Connection conn, String searchWord) {
		ArrayList<Used> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY, USED_KEYWORD from USED where (USED_TITLE like ? or USED_INFO like ?) order by USED_DAY desc";
		try {
			pstmt = conn.prepareStatement(sql);
			searchWord = "%" + searchWord + "%";
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
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
					vo.setUsedKeyword(rset.getString("USED_KEYWORD"));
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

	public ArrayList<Used> selectCateUsedList(Connection conn, int start, int end, String cate, String search) {
		ArrayList<Used> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql1 = "select * from (select Rownum r, u.* from "
				+ "(select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, "
				+ " USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY, USED_KEYWORD "
				+ " from used " + " where used_category like ? " + " order by used_day desc) u) "
				+ " where r between ? and ?";

		String sql2 = "select * from (select Rownum r, u.* from "
				+ "(select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, "
				+ " USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY, USED_KEYWORD "
				+ " from used " + " where used_category like ? " + " and ( USED_TITLE like ? or USED_INFO like ? )"
				+ " order by used_day desc) u) " + " where r between ? and ?";

		String sql = "";
		if (search != null && !search.equals("")) {
			sql = sql2;
		} else {
			sql = sql1;
		}

		try {
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			pstmt.setString(++idx, cate);
			if (search != null && !search.equals("")) {
				search = "%" + search + "%";
				pstmt.setString(++idx, search);
				pstmt.setString(++idx, search);
			}
			pstmt.setInt(++idx, start);
			pstmt.setInt(++idx, end);

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
					vo.setUsedKeyword(rset.getString("USED_KEYWORD"));
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

	public ArrayList<Used> selectNewUsedList(Connection conn) {
		ArrayList<Used> volist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select ROWNUM, USED_NO, USED_TITLE, USED_PRICE, USED_IMG from (select USED_NO, USED_TITLE, USED_PRICE, USED_IMG from USED order by USED_DAY desc) where ROWNUM <= 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Used>();
			if (rset.next()) {
				do {
					Used vo = new Used();
					vo.setUsedNo(rset.getInt("USED_NO"));
					vo.setUsedTitle(rset.getString("USED_TITLE"));
					vo.setUsedPrice(rset.getInt("USED_PRICE"));
					vo.setUsedImg(rset.getString("USED_IMG"));
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

	public int getUsedCateCount(Connection conn, String cate) {
		int result = -1;
		String sql = "select count(USED_NO) from USED where USED_CATEGORY like ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		cate = "%" + cate + "%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cate);
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
		String sql = "select USED_NO, USER_ID, USED_TITLE, USED_PRICE, USED_STATE, USED_CHANGE, USED_EXTYPE, USED_INFO, TO_CHAR(USED_DAY, 'mm/dd hh24:mi') USED_DAY, USED_IMG, USED_CATEGORY, USED_KEYWORD, NVL(GAME_NO, 0) GAME_NO, GAME_KONAME, GAME_IMAGE from (select u.*, g.GAME_NO, g.GAME_KONAME, g.GAME_IMAGE from used u, boardgame g where u.USED_KEYWORD = g.GAME_KONAME(+)) where USED_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				vo = new Used();
				vo.setUsedNo(rset.getInt(1));
				vo.setUserId(rset.getString(2));
				vo.setUsedTitle(rset.getString(3));
				vo.setUsedPrice(rset.getInt(4));
				vo.setUsedState(rset.getString(5));
				vo.setUsedChange(rset.getString(6));
				vo.setUsedExtype(rset.getString(7));
				vo.setUsedInfo(rset.getString(8));
				vo.setUsedDay(rset.getString(9));
				vo.setUsedImg(rset.getString(10));
				vo.setUsedCategory(rset.getString(11));
				vo.setUsedKeyword(rset.getString(12));
				vo.setGameNo(rset.getInt(13));
				vo.setGameKoName(rset.getString(14));
				vo.setGameImage(rset.getString(15));
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
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO USED VALUES (USED_NUM.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
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
			pstmt.setString(10, vo.getUsedKeyword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateUsed(Connection conn, Used vo, int usedNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "UPDATE USED SET USED_TITLE=?, USED_PRICE=?, USED_STATE=?, USED_CHANGE=?, USED_EXTYPE=?, USED_INFO=?, USED_IMG=?, USED_CATEGORY=?, USED_KEYWORD=? WHERE USED_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getUsedTitle());
			pstmt.setInt(2, vo.getUsedPrice());
			pstmt.setString(3, vo.getUsedState());
			pstmt.setString(4, vo.getUsedChange());
			pstmt.setString(5, vo.getUsedExtype());
			pstmt.setString(6, vo.getUsedInfo());
			pstmt.setString(7, vo.getUsedImg());
			pstmt.setString(8, vo.getUsedCategory());
			pstmt.setString(9, vo.getUsedKeyword());
			pstmt.setInt(10, usedNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteUsed(Connection conn, int usedNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from USED where USED_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int countUsedLike(Connection conn, int usedNo, String userId) {
		int result = -1;
		String sql = "select count(USED_LIKE_NO) from USED_LIKE where (USED_NO = ? and USER_ID = ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
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

	public int deleteUsedLike(Connection conn, int usedNo, String userId) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from USED_LIKE where (USED_NO = ? and USER_ID = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertUsedLike(Connection conn, int usedNo, String userId) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into USED_LIKE values(USED_LIKE_NUM.nextval, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int countUsedReport(Connection conn, int usedNo, String userId) {
		int result = -1;
		String sql = "select count(BOARD_REPORT_NO) from USED_REPORT where (USED_NO = ? and USER_ID = ?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
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

	public int insertUsedReport(Connection conn, int usedNo, String userId) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "insert into USED_REPORT values(BOARD_REPORT_NUM.nextval, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usedNo);
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