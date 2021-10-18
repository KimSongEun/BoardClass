package kh.semi.boardclass.admin.model.vo;

public class AdminUser {
	private String userId;
	private int userNo;
	private int boardCount;
	private int comtCount;
	private int reviewCount;
	private int usedCount;
	private int userHistory;
	
	public AdminUser() {
	}

	

	public AdminUser(String userId, int userNo, int boardCount, int comtCount, int reviewCount, int usedCount,
			int userHistory) {
		super();
		this.userId = userId;
		this.userNo = userNo;
		this.boardCount = boardCount;
		this.comtCount = comtCount;
		this.reviewCount = reviewCount;
		this.usedCount = usedCount;
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
	
	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}


	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}



	@Override
	public String toString() {
		return "AdminUser [userId=" + userId + ", userNo=" + userNo + ", boardCount=" + boardCount + ", comtCount="
				+ comtCount + ", reviewCount=" + reviewCount + ", usedCount=" + usedCount + ", userHistory="
				+ userHistory + "]";
	}




	
	
}
