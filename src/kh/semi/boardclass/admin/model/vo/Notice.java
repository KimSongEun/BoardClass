package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class Notice {
	private int announceNo;
	private String userId;
	private String adminTitle;
	private String adminContent;
	private Date adminWrDate;
	private Date adminRwrDate;
	
	public Notice(){
		
	}
	
	

	public Notice(int announceNo, String userId, String adminTitle, String adminContent, Date adminWrDate,
			Date adminRwrDate) {
		super();
		this.announceNo = announceNo;
		this.userId = userId;
		this.adminTitle = adminTitle;
		this.adminContent = adminContent;
		this.adminWrDate = adminWrDate;
		this.adminRwrDate = adminRwrDate;
	}



	public int getAnnounceNo() {
		return announceNo;
	}

	public void setAnnounceNo(int announceNo) {
		this.announceNo = announceNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdminTitle() {
		return adminTitle;
	}

	public void setAdminTitle(String adminTitle) {
		this.adminTitle = adminTitle;
	}

	public String getAdminContent() {
		return adminContent;
	}

	public void setAdminContent(String adminContent) {
		this.adminContent = adminContent;
	}

	public Date getAdminWrDate() {
		return adminWrDate;
	}

	public void setAdminWrDate(Date adminWrDate) {
		this.adminWrDate = adminWrDate;
	}

	public Date getAdminRwrDate() {
		return adminRwrDate;
	}

	public void setAdminRwrDate(Date adminRwrDate) {
		this.adminRwrDate = adminRwrDate;
	}

	@Override
	public String toString() {
		return "Notice [announceNo=" + announceNo + ", userId=" + userId + ", adminTitle=" + adminTitle
				+ ", adminContent=" + adminContent + ", adminWrDate=" + adminWrDate + ", adminRwrDate=" + adminRwrDate + "]";
	}

	
}
