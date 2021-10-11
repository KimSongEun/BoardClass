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
				user.setUserNum(rset.getInt("user_Num"));	
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
		int result = 0;
		return result;
	}
	
	public int agree(Connection conn, User user) {
		int result = 0;
		return result;
	}
	
	public int checkId(Connection conn, User user) {
		int result = 0;
		return result;
	}
	
	public int checkNick(Connection conn, User user) {
		int result = 0;
		return result;
	}
	
	public int searchId(Connection conn, User user) {
		int result = 0;
		return result;
	}
	
	public int searchPwd(Connection conn, User user) {
		int result = 0;
		return result;
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
	
	public ArrayList<User> checkUser(Connection conn, User user) {
		ArrayList<User> volist = null;
		return volist;
	}
	
	public int checkPwd(Connection conn, User user) {
		int result = 0;
		return result;
	}
	
	public int updateUser(Connection conn, User user) {
		int result = 0;
		return result;
	}
	
	public int deleteUser(Connection conn, User user) {
		int result = 0;
		return result;
	}
	
}
