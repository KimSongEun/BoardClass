package kh.semi.boardclass.review.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.boardclass.review.model.vo.Review;

public class ReviewDao {

	public ReviewDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Review> listReview(Connection conn, int currentPage) {
		ArrayList<Review> volist = null;
		return volist;
	}

	public void addLikeCount(Connection conn, int reviewLike) {
	
	}

	public int insertReview(Connection conn, Review review) {
		int result = 0;
		return result;
	}

	public int deleteReview(Connection conn, int reviewNo) {
		int result = 0;
		return result;
	}

	public int updateReview(Connection conn, Review review) {
		int result = 0;
		return result;
	}

}
