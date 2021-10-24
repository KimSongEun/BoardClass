package kh.semi.boardclass.mypage.model.vo;

public class MyGameReview {
	private int reviewNo;
	private int gameNumber;
	private String gameKoName;
	private String gameCategory;
	private String userId;
	private int reviewScore;
	private String gameImage;

	public MyGameReview() {
		// TODO Auto-generated constructor stub
	}

	public MyGameReview(int reviewNo, int gameNumber, String gameKoName, String gameCategory, String userId,
			int reviewScore, String gameImage) {
		super();
		this.reviewNo = reviewNo;
		this.gameNumber = gameNumber;
		this.gameKoName = gameKoName;
		this.gameCategory = gameCategory;
		this.userId = userId;
		this.reviewScore = reviewScore;
		this.gameImage = gameImage;
	}

	@Override
	public String toString() {
		return "MyGameReview [reviewNo=" + reviewNo + ", gameNumber=" + gameNumber + ", gameKoName=" + gameKoName
				+ ", gameCategory=" + gameCategory + ", userId=" + userId + ", reviewScore=" + reviewScore
				+ ", gameImage=" + gameImage + "]";
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public String getGameKoName() {
		return gameKoName;
	}

	public void setGameKoName(String gameKoName) {
		this.gameKoName = gameKoName;
	}

	public String getGameCategory() {
		return gameCategory;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

	
}
