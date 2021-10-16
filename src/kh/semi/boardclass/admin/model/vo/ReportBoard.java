package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class ReportBoard {
	private int reportCount;
	private int boardNo;
	private String boardType;
	private String boardCategory;
	private String boardTitle;
	private String userId;
	private int userNo;
	private Date boardWriteDate;
	private Date boardRewriteDate;
	
	public ReportBoard() {
	}


	public ReportBoard(int reportCount, int boardNo, String boardType, String boardCategory, String boardTitle,
			String userId, int userNo, Date boardWriteDate, Date boardRewriteDate) {
		super();
		this.reportCount = reportCount;
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardCategory = boardCategory;
		this.boardTitle = boardTitle;
		this.userId = userId;
		this.userNo = userNo;
		this.boardWriteDate = boardWriteDate;
		this.boardRewriteDate = boardRewriteDate;
	}


	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
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

	public Date getBoardWriteDate() {
		return boardWriteDate;
	}

	public void setBoardWriteDate(Date boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}

	public Date getBoardRewriteDate() {
		return boardRewriteDate;
	}

	public void setBoardRewriteDate(Date boardRewriteDate) {
		this.boardRewriteDate = boardRewriteDate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	@Override
	public String toString() {
		return "ReportBoard [reportCount=" + reportCount + ", boardNo=" + boardNo + ", boardType=" + boardType
				+ ", boardCategory=" + boardCategory + ", boardTitle=" + boardTitle + ", userId=" + userId + ", userNo="
				+ userNo + ", boardWriteDate=" + boardWriteDate + ", boardRewriteDate=" + boardRewriteDate + "]";
	}
	
	

}
