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

	public int updateHistory(String userId) {

		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().updateHistory(conn, userId);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int countForTodayVisit(String userId) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new UserDao().countForTodayVisit(conn, userId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int signUp(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();

		// TODO:
		result = new UserDao().signUp(conn, user);
		// result = new UserDao().agree(conn, user);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	// ID 중복 체크를 위한 메소드
	public int checkId(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().checkId(conn, userId);
		return result;
	}

	// 닉네임 중복 체크를 위한 메소드
	public int checkNick(String userNickname) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().checkNick(conn, userNickname);
		return result;
	}

	public User searchId(String userName, String userEmail, int userPhone) {
		Connection conn = JDBCTemplate.getConnection();
		UserDao dao = new UserDao();
		User user = dao.searchId(conn, userName, userEmail, userPhone);
//		result = new UserDao().byEmail(conn, user);
//		result = new UserDao().byPhone(conn, user);

		JDBCTemplate.close(conn);
		return user;
	}

	public User searchPwd(String userName, String userId, String userEmail) {
		Connection conn = JDBCTemplate.getConnection();
		UserDao dao = new UserDao();
		User user = dao.searchPwd(conn, userName, userId, userEmail);
		// result = new UserDao().byEmail(conn, user);
		// result = new UserDao().byPhone(conn, user);
		JDBCTemplate.close(conn);
		return user;
	}

	public ArrayList<User> signUpComplete(User user) {
		ArrayList<User> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new UserDao().signUpComplete(conn, user);
		JDBCTemplate.close(conn);
		return volist;
	}

	public User checkUser(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		UserDao dao = new UserDao();
		User user = dao.checkUser(conn, userId);
		JDBCTemplate.close(conn);
		return user;
	}

	public int updateUser(User user) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new UserDao().updateUser(conn, user);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
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
