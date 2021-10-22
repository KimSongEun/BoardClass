package kh.semi.boardclass.user.model.vo;

import java.sql.Date;

public class TodayVisit {
	private int visitCount;
	private Date visitDate;
	private String userId;
	
	public TodayVisit() {
	}

	public TodayVisit(int visitCount, Date visitDate, String userId) {
		super();
		this.visitCount = visitCount;
		this.visitDate = visitDate;
		this.userId = userId;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
