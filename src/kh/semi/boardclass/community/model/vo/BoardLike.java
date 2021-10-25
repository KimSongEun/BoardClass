package kh.semi.boardclass.community.model.vo;

public class BoardLike {
//	 BOARD_LIKE_NO NUMBER,
//	    BOARD_NO NUMBER,
//	    USER_ID VARCHAR2(20),
	private int boardLikeNo;
	private int boardNo;
	private String userId;
	private int likecount;


	public BoardLike() {
	}
	
	public BoardLike(int boardLikeNo, int boardNo, String userId) {
		super();
		this.boardLikeNo = boardLikeNo;
		this.boardNo = boardNo;
		this.userId = userId;
	}
	
	public BoardLike(int boardLikeNo, String userId) {
		super();
		this.boardLikeNo = boardLikeNo;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "BoardLike [boardLikeNo=" + boardLikeNo + ", boardNO=" + boardNo + ", userId=" + userId + "]";
	}

	public int getBoardLikeNo() {
		return boardLikeNo;
	}

	public void setBoardLikeNo(int boardLikeNo) {
		this.boardLikeNo = boardLikeNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

}
