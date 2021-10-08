package kh.semi.boardclass.review.model.vo;

import java.sql.Date;

public class Review {

	private int reviewNo;
	private String reviewContent;
	private int reviewScore;
	private Date reviewDate;
	private int reviewLikeNo;
	private int gameNo;
	private String userId;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	
	public Review(int reviewNo, String reviewContent, int reviewScore, Date reviewDate, int reviewLikeNo, int gameNo,
			String userId) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.reviewDate = reviewDate;
		this.reviewLikeNo = reviewLikeNo;
		this.gameNo = gameNo;
		this.userId = userId;
	}



	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public int getReviewScore() {
		return reviewScore;
	}


	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}


	public Date getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}


	public int getReviewLikeNo() {
		return reviewLikeNo;
	}


	public void setReviewLikeNo(int reviewLikeNo) {
		this.reviewLikeNo = reviewLikeNo;
	}


	public int getGameNo() {
		return gameNo;
	}


	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
