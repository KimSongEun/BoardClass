package kh.semi.boardclass.user.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.user.model.dao.UserDao;
import kh.semi.boardclass.user.model.vo.User;

public class UserService {

	public UserService() {
	}
	
	public User login(String userId, String userPassword) {
		Connection conn = JDBCTemplate.getConnection();
		User user = new UserDao().login(conn, userId, userPassword);
		// TODO:
		
		// result = new UserDao().updateHistory(conn, userId);
		
		JDBCTemplate.close(conn);
		return user;
	}
	
	public int signUp(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		
		// TODO:
		result = new UserDao().signUp(conn, user);
		result = new UserDao().agree(conn, user);
		result = new UserDao().checkId(conn, user);
		result = new UserDao().checkNick(conn, user);
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int searchId(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		
		// TODO:
		result = new UserDao().searchId(conn, user);
		result = new UserDao().byEmail(conn, user);
		result = new UserDao().byPhone(conn, user);
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int searchPwd(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		
		// TODO:
		result = new UserDao().searchPwd(conn, user);
		result = new UserDao().byEmail(conn, user);
		result = new UserDao().byPhone(conn, user);
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<User> signUpComplete(User user) {
		ArrayList<User> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new UserDao().signUpComplete(conn, user);
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<User> checkUser(User user) {
		ArrayList<User> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		
		// TODO:
		volist = new UserDao().checkUser(conn, user);
		int result = new UserDao().checkPwd(conn, user);
		
		JDBCTemplate.close(conn);
		return volist;
	}
	
	public int updateUser(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new UserDao().updateUser(conn, user);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteUser(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new UserDao().deleteUser(conn, user);
		JDBCTemplate.close(conn);
		return result;
	}
}
