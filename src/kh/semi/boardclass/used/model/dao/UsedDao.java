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

	public ArrayList<Used> selectUsedList(Connection conn) {
		ArrayList<Used> volist = null;

		String sql = "select USED_NO, USER_ID, USED_TITLE, USED_IMG from USED";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			volist = new ArrayList<Used>();
			if (rset.next())
				do {
					Used vo = new Used();
					vo.setUsedNo(rset.getInt("USED_NO"));
					vo.setUserId(rset.getString("USER_ID"));
					vo.setUsedTitle(rset.getString("USED_TITLE"));
					vo.setUsedImg(rset.getString("USED_IMG"));
				} while (rset.next());
			{
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

//	public int insertUsed(Connection conn, Used vo) {
//		int result = 0;
//		String sql = "INSERT INTO USED VALUES (USED_NUM.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,userId);
//			pstmt.setString(2,);
//			pstmt.setString(3,);
//			pstmt.setString(4,);
//			pstmt.setString(5,);
//			pstmt.setString(6,);
//			pstmt.setString(7,);
//			pstmt.setString(8,);
//			pstmt.setString(9,);
//			pstmt.setString(10,);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}

	public void updateUsed(Connection conn, Used used) {

	}

	public int chatUset(Connection conn, Used used) {
		int result = 0;
		return result;
	}
}
