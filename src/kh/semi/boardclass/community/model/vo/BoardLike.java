package kh.semi.boardclass.community.model.vo;

public class BoardLike {
//	 BOARD_LIKE_NO NUMBER,
//	    BOARD_NO NUMBER,
//	    USER_ID VARCHAR2(20),
	private int boardLikeNo;
	private int boardNO;
	private String userId;



	public BoardLike() {
	}
	
	@Override
	public String toString() {
		return "BoardLike [boardLikeNo=" + boardLikeNo + ", boardNO=" + boardNO + ", userId=" + userId + "]";
	}

	public int getBoardLikeNo() {
		return boardLikeNo;
	}

	public void setBoardLikeNo(int boardLikeNo) {
		this.boardLikeNo = boardLikeNo;
	}

	public int getBoardNO() {
		return boardNO;
	}

	public void setBoardNO(int boardNO) {
		this.boardNO = boardNO;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
