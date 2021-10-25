package kh.semi.boardclass.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {

	public JDBCTemplate() {
	}
	
	public static Connection getConnection() {
		Connection conn = null;
			try {
				Context initContext = new InitialContext(); 
				Context envContext = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource) envContext.lookup("jdbc/bcmasterDclass");
				conn = ds.getConnection();
				
				if(conn != null) System.out.println("연결성공");
				else System.out.println("연결실패");
			}catch(Exception e) {
				e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement s) {
		try {
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet s) {
		try {
			if(s != null) s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setAutoCommit(Connection conn, boolean onOff) {
		try {
			conn.setAutoCommit(onOff);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
