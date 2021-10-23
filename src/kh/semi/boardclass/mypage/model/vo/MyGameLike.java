package kh.semi.boardclass.mypage.model.vo;


public class MyGameLike {
	private int boardGameLikeNo;
	private int gameNumber;
	private String gameKoName;
	private String gameCategory;
	private String userId;
	private int gameGrade;
	private String gameImage;

	public MyGameLike() {
		// TODO Auto-generated constructor stub
	}

	public MyGameLike(int boardGameLikeNo, int gameNumber, String gameKoName, String gameCategory, String userId,
			int gameGrade, String gameImage) {
		super();
		this.boardGameLikeNo = boardGameLikeNo;
		this.gameNumber = gameNumber;
		this.gameKoName = gameKoName;
		this.gameCategory = gameCategory;
		this.userId = userId;
		this.gameGrade = gameGrade;
		this.gameImage = gameImage;
	}

	@Override
	public String toString() {
		return "UserMyGame [boardGameLikeNo=" + boardGameLikeNo + ", gameNumber=" + gameNumber + ", gameKoName="
				+ gameKoName + ", gameCategory=" + gameCategory + ", userId=" + userId + ", gameGrade=" + gameGrade
				+ ", gameImage=" + gameImage + "]";
	}

	public int getBoardGameLikeNo() {
		return boardGameLikeNo;
	}

	public void setBoardGameLikeNo(int boardGameLikeNo) {
		this.boardGameLikeNo = boardGameLikeNo;
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

	public int getGameGrade() {
		return gameGrade;
	}

	public void setGameGrade(int gameGrade) {
		this.gameGrade = gameGrade;
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

}
