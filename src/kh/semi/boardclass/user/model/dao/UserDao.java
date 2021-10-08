package kh.semi.boardclass.user.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.user.model.vo.User;

public class UserDao {

	public UserDao() {
	}

	public int login(Connection conn, String userId, String userPassword) {
		int result = 0;
		return result;
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
