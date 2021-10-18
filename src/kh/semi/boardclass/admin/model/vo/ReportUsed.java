package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class ReportUsed {
	private int reportCount;
	private int usedNo;
	private String usedTitle;
	private String userId;
	private int userNo;
	private Date usedDate;
	
	public ReportUsed() {
	}

	public ReportUsed(int reportCount, int usedNo, String usedTitle, String userId, int userNo, Date usedDate) {
		super();
		this.reportCount = reportCount;
		this.usedNo = usedNo;
		this.usedTitle = usedTitle;
		this.userId = userId;
		this.userNo = userNo;
		this.usedDate = usedDate;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public int getUsedNo() {
		return usedNo;
	}

	public void setUsedNo(int usedNo) {
		this.usedNo = usedNo;
	}

	public String getUsedTitle() {
		return usedTitle;
	}

	public void setUsedTitle(String usedTitle) {
		this.usedTitle = usedTitle;
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

	public Date getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}

	
}
