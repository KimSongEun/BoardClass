package kh.semi.boardclass.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.user.model.vo.User;

public class UserDao {

	public UserDao() {
	}

	public User login(Connection conn, String userId, String userPassword) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM member where user_Id=? and user_Password=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				user = new User();
				user.setUserId(rset.getString("user_Id"));
				user.setUserNo(rset.getInt("user_No"));
				user.setUserPassword(rset.getString("user_Password"));
				user.setUserName(rset.getString("user_Name"));
				user.setUserNickname(rset.getString("user_Nickname"));
				user.setUserEmail(rset.getString("user_Email"));
				user.setUserPhone(rset.getInt("user_Phone"));
				user.setUserAddress(rset.getString("user_Address"));
				user.setUserType(rset.getString("user_Type").charAt(0));
				user.setUserImage(rset.getString("user_Image"));
				user.setUserHistory(rset.getInt("user_History"));

			}
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return user;
	}

	public int updateHistory(Connection conn, String userId) {
		int result = 0;
		return result;
	}

	public int signUp(Connection conn, User user) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "insert into MEMBER(USER_IMAGE,USER_NAME,USER_NICKNAME,USER_ID, USER_PASSWORD,USER_EMAIL,USER_PHONE,USER_ADDRESS,USER_NO) VALUES(?,?,?, ?, ?,?, ?, ?, USER_NUM.nextval)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserImage());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserNickname());
			pstmt.setString(4, user.getUserId());
			pstmt.setString(5, user.getUserPassword());
			pstmt.setString(6, user.getUserEmail());
			pstmt.setInt(7, user.getUserPhone());
			pstmt.setString(8, user.getUserAddress());
			// executeupdate() 는 실행 결과를 반영된 행의 개수로 리턴하므로
			// 1 이상은 실행 성공, 0 이하(구문 에러 포함)는 실패이다.
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int agree(Connection conn, User user) {
		int result = 0;
		return result;
	}

	public int checkId(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) FROM MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1); // rset의 첫 컬럼의 숫자값을 가져온다
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int checkNick(Connection conn, String userNickname) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) FROM MEMBER WHERE USER_NICKNAME = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNickname);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1); // rset의 첫 컬럼의 숫자값을 가져온다
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public User searchId(Connection conn, String userName, String userEmail, int userPhone) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM member where USER_NAME=? and USER_EMAIL=? and USER_PHONE=?";
		User user = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setInt(3, userPhone);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				user = new User();
				user.setUserId(rset.getString("user_Id"));
				user.setUserNo(rset.getInt("user_No"));
				user.setUserPassword(rset.getString("user_Password"));
				user.setUserName(rset.getString("user_Name"));
				user.setUserNickname(rset.getString("user_Nickname"));
				user.setUserEmail(rset.getString("user_Email"));
				user.setUserPhone(rset.getInt("user_Phone"));
				user.setUserAddress(rset.getString("user_Address"));
				user.setUserType(rset.getString("user_Type").charAt(0));
				user.setUserImage(rset.getString("user_Image"));
				user.setUserHistory(rset.getInt("user_History"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return user;
	}

	public User searchPwd(Connection conn, String userName, String userId, String userEmail) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM member where USER_NAME=? and USER_ID=? and USER_EMAIL=?";
		User user = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userId);
			pstmt.setString(3, userEmail);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				user = new User();
				user.setUserId(rset.getString("user_Id"));
				user.setUserNo(rset.getInt("user_No"));
				user.setUserPassword(rset.getString("user_Password"));
				user.setUserName(rset.getString("user_Name"));
				user.setUserNickname(rset.getString("user_Nickname"));
				user.setUserEmail(rset.getString("user_Email"));
				user.setUserPhone(rset.getInt("user_Phone"));
				user.setUserAddress(rset.getString("user_Address"));
				user.setUserType(rset.getString("user_Type").charAt(0));
				user.setUserImage(rset.getString("user_Image"));
				user.setUserHistory(rset.getInt("user_History"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return user;
	}

	public int byEmail(Connection conn, User user) {
		int result = 0;
		return result;
	}

	public int byPhone(Connection conn, User user) {
		int result = 0;
		return result;
	}

	public ArrayList<User> signUpComplete(Connection conn, User user) {
		ArrayList<User> volist = null;
		return volist;
	}

	public User checkUser(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM member where USER_ID=?";
		User user = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				user = new User();
				user.setUserId(rset.getString("user_Id"));
				user.setUserNo(rset.getInt("user_No"));
				user.setUserPassword(rset.getString("user_Password"));
				user.setUserName(rset.getString("user_Name"));
				user.setUserNickname(rset.getString("user_Nickname"));
				user.setUserEmail(rset.getString("user_Email"));
				user.setUserPhone(rset.getInt("user_Phone"));
				user.setUserAddress(rset.getString("user_Address"));
				user.setUserType(rset.getString("user_Type").charAt(0));
				user.setUserImage(rset.getString("user_Image"));
				user.setUserHistory(rset.getInt("user_History"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return user;
	}

	public ArrayList<User> checkUser(Connection conn, User user) {
		ArrayList<User> volist = null;
		return volist;
	}

	public int checkPwd(Connection conn, User user) {
		int result = 0;
		return result;
	}

	public int updateUser(Connection conn, User user) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "update MEMBER set USER_IMAGE=?,USER_NAME=?,USER_NICKNAME=?, USER_PASSWORD=?,USER_EMAIL=?,USER_PHONE=?,USER_ADDRESS=? where USER_ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserImage());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserNickname());
			pstmt.setString(4, user.getUserPassword());
			pstmt.setString(5, user.getUserEmail());
			pstmt.setInt(6, user.getUserPhone());
			pstmt.setString(7, user.getUserAddress());
			pstmt.setString(8, user.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteUser(Connection conn, User user) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from MEMBER where USER_ID=? and USER_PASSWORD=?";		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPassword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

}
