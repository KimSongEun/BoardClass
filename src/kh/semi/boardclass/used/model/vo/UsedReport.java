package kh.semi.boardclass.used.model.vo;

public class UsedReport {
	
	private int boardReportNo;
	private int usedNo;
	private String userID;
	
	public UsedReport() {
		super();
	}
	
	public UsedReport(int boardReportNo, int usedNo, String userID) {
		super();
		this.boardReportNo = boardReportNo;
		this.usedNo = usedNo;
		this.userID = userID;
	}

	public UsedReport(int usedNo, String userID) {
		super();
		this.usedNo = usedNo;
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "UsedReport [boardReportNo=" + boardReportNo + ", usedNo=" + usedNo + ", userID=" + userID + "]";
	}

	public int getBoardReportNo() {
		return boardReportNo;
	}

	public void setBoardReportNo(int boardReportNo) {
		this.boardReportNo = boardReportNo;
	}

	public int getUsedNo() {
		return usedNo;
	}

	public void setUsedNo(int usedNo) {
		this.usedNo = usedNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
