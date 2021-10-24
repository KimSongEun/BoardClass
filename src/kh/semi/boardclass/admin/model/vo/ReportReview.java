package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class ReportReview {
	private int reportCount;
	private int reviewNo;
	private String gameKoName;
	private String reviewContent;
	private String userId;
	private int userNo;
	private Date reviewDate;
	private int gameNo;
	
	public ReportReview() {
	}


	public ReportReview(int reportCount, int reviewNo, String gameKoName, String reviewContent, String userId,
			int userNo, Date reviewDate, int gameNo) {
		super();
		this.reportCount = reportCount;
		this.reviewNo = reviewNo;
		this.gameKoName = gameKoName;
		this.reviewContent = reviewContent;
		this.userId = userId;
		this.userNo = userNo;
		this.reviewDate = reviewDate;
		this.gameNo = gameNo;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getGameKoName() {
		return gameKoName;
	}

	public void setGameKoName(String gameKoName) {
		this.gameKoName = gameKoName;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
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

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	@Override
	public String toString() {
		return "ReportReview [reportCount=" + reportCount + ", reviewNo=" + reviewNo + ", gameKoName=" + gameKoName
				+ ", reviewContent=" + reviewContent + ", userId=" + userId + ", userNo=" + userNo + ", reviewDate="
				+ reviewDate + ", gameNo=" + gameNo + "]";
	}


}
