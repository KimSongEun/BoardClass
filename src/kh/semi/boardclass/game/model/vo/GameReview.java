package kh.semi.boardclass.game.model.vo;

import java.sql.Date;

public class GameReview {

	

	private int reviewNo;
	private String userId;
	private int gameNo;
	private String reviewContent;
	private int reviewScore;
	private Date reviewDate;
	private int liked;
	
	public GameReview(){
		
	}
	public GameReview(String userId, int gameNo, String reviewContent, int reviewScore) {
		super();
		
		this.userId = userId;
		this.gameNo = gameNo;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		
	}
	public GameReview(int reviewNo, String userId, int gameNo, String reviewContent, int reviewScore, Date reviewDate,int liked) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.gameNo = gameNo;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.reviewDate = reviewDate;
		this.liked = liked;
		
	}

	
	

	@Override
	public String toString() {
		return "GameReview [reviewNo=" + reviewNo + ", userId=" + userId + ", gameNo=" + gameNo + ", reviewContent="
				+ reviewContent + ", reviewScore=" + reviewScore + ", reviewDate=" + reviewDate + ", liked=" + liked
				+ "]";
	}
	
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
