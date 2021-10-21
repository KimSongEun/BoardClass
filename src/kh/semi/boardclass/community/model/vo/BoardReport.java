package kh.semi.boardclass.community.model.vo;

public class BoardReport {

	private int boardReportNo;
	private int boardNo;
	private String userId;

	public BoardReport() {
	}

	
	
	@Override
	public String toString() {
		return "BoardReport [boardReportNo=" + boardReportNo + ", boardNo=" + boardNo + ", userId=" + userId + "]";
	}



	public int getBoardReportNo() {
		return boardReportNo;
	}

	public void setBoardReportNo(int boardReportNo) {
		this.boardReportNo = boardReportNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
