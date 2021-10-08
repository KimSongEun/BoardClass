package kh.semi.boardclass.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.common.JDBCTemplate;
import kh.semi.boardclass.review.model.dao.ReviewDao;
import kh.semi.boardclass.review.model.vo.Review;

public class ReviewService {

	public ReviewService() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Review> listReview(int currentPage) {
		ArrayList<Review> volist = null;
		Connection conn = JDBCTemplate.getConnection();
		volist = new ReviewDao().listReview(conn, currentPage);
		JDBCTemplate.close(conn);
		return volist;
	}

	public void addLikeCount(int reviewLike) {
		
	}

	public int insertReview(Review review) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new ReviewDao().insertReview(conn, review);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteReview(int reviewNo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new ReviewDao().deleteReview(conn, reviewNo);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateReview(Review review) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new ReviewDao().updateReview(conn, review);
		JDBCTemplate.close(conn);
		return result;
	}

}