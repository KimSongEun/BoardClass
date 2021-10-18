package kh.semi.boardclass.admin.model.vo;

public class AdminUser {
	private String userId;
	private int userNo;
	private int boardCount;
	private int comtCount;
	private int userHistory;
	
	public AdminUser() {
	}

	public AdminUser(String userId, int userNo, int boardCount, int comtCount, int userHistory) {
		super();
		this.userId = userId;
		this.userNo = userNo;
		this.boardCount = boardCount;
		this.comtCount = comtCount;
		this.userHistory = userHistory;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getComtCount() {
		return comtCount;
	}

	public void setComtCount(int comtCount) {
		this.comtCount = comtCount;
	}

	public int getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(int userHistory) {
		this.userHistory = userHistory;
	}

	@Override
	public String toString() {
		return "AdminMember [userId=" + userId + ", userNo=" + userNo + ", boardCount=" + boardCount + ", comtCount="
				+ comtCount + ", userHistory=" + userHistory + "]";
	}
	
	
}
