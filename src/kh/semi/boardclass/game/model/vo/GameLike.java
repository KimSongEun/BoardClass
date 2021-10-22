package kh.semi.boardclass.game.model.vo;

public class GameLike {

	
	private int boardGameLikeNo;
	private String userId;
	private int gameNumber;
	
	

	public GameLike() {
		// TODO Auto-generated constructor stub
	}



	public GameLike(int boardGameLikeNo, String userId, int gameNo) {
		super();
		this.boardGameLikeNo = boardGameLikeNo;
		this.userId = userId;
		this.gameNumber = gameNo;
	}



	public int getBoardGameLikeNo() {
		return boardGameLikeNo;
	}



	public void setBoardGameLikeNo(int boardGameLikeNo) {
		this.boardGameLikeNo = boardGameLikeNo;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getGameNo() {
		return gameNumber;
	}



	public void setGameNo(int gameNo) {
		this.gameNumber = gameNo;
	}

	
}
