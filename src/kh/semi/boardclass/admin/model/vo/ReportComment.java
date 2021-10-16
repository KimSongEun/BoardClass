package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class ReportComment {
	private int reportCount;
	private int commentNo;
	private String boardTitle;
	private String commentContent;
	private String userId;
	private int userNo;
	private Date commentWriteDate;
	private Date commentRewriteDate;
	
	public ReportComment() {
	}

	public ReportComment(int reportCount, int commentNo, String boardTitle, String commentContent, String userId,
			int userNo, Date commentWriteDate, Date commentRewriteDate) {
		super();
		this.reportCount = reportCount;
		this.commentNo = commentNo;
		this.boardTitle = boardTitle;
		this.commentContent = commentContent;
		this.userId = userId;
		this.userNo = userNo;
		this.commentWriteDate = commentWriteDate;
		this.commentRewriteDate = commentRewriteDate;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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

	public Date getCommentWriteDate() {
		return commentWriteDate;
	}

	public void setCommentWriteDate(Date commentWriteDate) {
		this.commentWriteDate = commentWriteDate;
	}

	public Date getCommentRewriteDate() {
		return commentRewriteDate;
	}

	public void setCommentRewriteDate(Date commentRewriteDate) {
		this.commentRewriteDate = commentRewriteDate;
	}
	
	

}
