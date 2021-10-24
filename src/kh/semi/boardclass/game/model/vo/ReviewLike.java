package kh.semi.boardclass.game.model.vo;

public class ReviewLike {

	
	private int reviewGameLikeNo;
	private String userId;
	private int reviewNo;
	private int gameNo;
	

	public ReviewLike() {
		// TODO Auto-generated constructor stub
	}

	




	@Override
	public String toString() {
		return "ReviewLike [reviewGameLikeNo=" + reviewGameLikeNo + ", userId=" + userId + ", reviewNo=" + reviewNo
				+ ", gameNo=" + gameNo + "]";
	}






	public int getGameNo() {
		return gameNo;
	}



	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}



	public int getReviewGameLikeNo() {
		return reviewGameLikeNo;
	}



	public void setReviewGameLikeNo(int reviewGameLikeNo) {
		this.reviewGameLikeNo = reviewGameLikeNo;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getReviewNo() {
		return reviewNo;
	}



	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}



	
	
}
