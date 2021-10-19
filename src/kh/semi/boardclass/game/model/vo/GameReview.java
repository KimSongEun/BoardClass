package kh.semi.boardclass.game.model.vo;

import java.sql.Date;

public class GameReview {

	

	private int reviewNo;
	private String userId;
	private int gameNo;
	private String reviewContent;
	private int reviewScore;
	private Date reviewDate;
	
	public GameReview(){
		
	}
	public GameReview(String userId, int gameNo, String reviewContent, int reviewScore) {
		super();
		
		this.userId = userId;
		this.gameNo = gameNo;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		
	}
	public GameReview(int reviewNo, String userId, int gameNo, String reviewContent, int reviewScore, Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.gameNo = gameNo;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.reviewDate = reviewDate;
	}

	
	@Override
	public String toString() {
		return "GameReview [reviewNo=" + reviewNo + ", user_Id=" + userId + ", gameNo=" + gameNo + ", reviewContent="
				+ reviewContent + ", reviewScore=" + reviewScore + ", reviewDate=" + reviewDate + "]";
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getUser_Id() {
		return userId;
	}

	public void setUser_Id(String user_Id) {
		this.userId = user_Id;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
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
	
}