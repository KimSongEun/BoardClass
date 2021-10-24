package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class AllCommentUser {
	private int commentNo;
	private String boardTitle;
	private String commentContent;
	private String userId;
	private int userNo;
	private Date commentRewriteDate;
	private int boardNo;
	
	public AllCommentUser() {
	}


	public AllCommentUser(int commentNo, String boardTitle, String commentContent, String userId, int userNo,
			Date commentRewriteDate, int boardNo) {
		super();
		this.commentNo = commentNo;
		this.boardTitle = boardTitle;
		this.commentContent = commentContent;
		this.userId = userId;
		this.userNo = userNo;
		this.commentRewriteDate = commentRewriteDate;
		this.boardNo = boardNo;
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

	public Date getCommentRewriteDate() {
		return commentRewriteDate;
	}

	public void setCommentRewriteDate(Date commentRewriteDate) {
		this.commentRewriteDate = commentRewriteDate;
	}

	
	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	@Override
	public String toString() {
		return "AllCommentUser [commentNo=" + commentNo + ", boardTitle=" + boardTitle + ", commentContent="
				+ commentContent + ", userId=" + userId + ", userNo=" + userNo + ", commentRewriteDate="
				+ commentRewriteDate + ", boardNo=" + boardNo + "]";
	}



	
	
}
