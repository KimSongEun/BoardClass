package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class ReportUsed {
	private int reportCount;
	private int usedNo;
	private String usedTitle;
	private String userId;
	private int userNo;
	private Date usedDate;
	private int usedState;
	private int usedChange;
	private int usedExtype;
	private int usedPrice;
	private String usedCategory;
	
	public ReportUsed() {
	}



	public ReportUsed(int reportCount, int usedNo, String usedTitle, String userId, int userNo, Date usedDate,
			int usedState, int usedChange, int usedExtype, int usedPrice, String usedCategory) {
		super();
		this.reportCount = reportCount;
		this.usedNo = usedNo;
		this.usedTitle = usedTitle;
		this.userId = userId;
		this.userNo = userNo;
		this.usedDate = usedDate;
		this.usedState = usedState;
		this.usedChange = usedChange;
		this.usedExtype = usedExtype;
		this.usedPrice = usedPrice;
		this.usedCategory = usedCategory;
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
	
	

	public int getUsedState() {
		return usedState;
	}



	public void setUsedState(int usedState) {
		this.usedState = usedState;
	}



	public int getUsedChange() {
		return usedChange;
	}



	public void setUsedChange(int usedChange) {
		this.usedChange = usedChange;
	}



	public int getUsedExtype() {
		return usedExtype;
	}



	public void setUsedExtype(int usedExtype) {
		this.usedExtype = usedExtype;
	}



	public int getUsedPrice() {
		return usedPrice;
	}



	public void setUsedPrice(int usedPrice) {
		this.usedPrice = usedPrice;
	}



	public String getUsedCategory() {
		return usedCategory;
	}



	public void setUsedCategory(String usedCategory) {
		this.usedCategory = usedCategory;
	}



	@Override
	public String toString() {
		return "ReportUsed [reportCount=" + reportCount + ", usedNo=" + usedNo + ", usedTitle=" + usedTitle
				+ ", userId=" + userId + ", userNo=" + userNo + ", usedDate=" + usedDate + ", usedState=" + usedState
				+ ", usedChange=" + usedChange + ", usedExtype=" + usedExtype + ", usedPrice=" + usedPrice
				+ ", usedCategory=" + usedCategory + "]";
	}




	
}
