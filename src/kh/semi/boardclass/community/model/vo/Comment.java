package kh.semi.boardclass.community.model.vo;

import java.sql.Date;

public class Comment {
//	COMMENT_NO	NUMBER
//	BOARD_NO	NUMBER
//	USER_ID	VARCHAR2(20 BYTE)
//	COMMENT_CONTENT	VARCHAR2(300 BYTE)
//	COMMENT_WRITE_DATE	TIMESTAMP(6)
//	COMMENT_REWRITE_DATE	TIMESTAMP(6)
//	COMMENT_IMG	VARCHAR2(100 BYTE)
//	COMMENT_REF	NUMBER
//	COMMENT_RE_STEP	NUMBER
//	COMMENT_RE_LEVEL	NUMBER
	private int commentNo;
	private int boardNo;
	private String userId;
	private String commentContent;
	private String commentWriteDate;
	private String commentRewriteDate;
	private String commentImg;
	private int commentRef;
	private int commentReStep;
	private int commentReLevel;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", boardNo=" + boardNo + ", userId=" + userId + ", commentContent="
				+ commentContent + ", commentWriteDate=" + commentWriteDate + ", commentRewriteDate="
				+ commentRewriteDate + ", commentImg=" + commentImg + ", commentRef=" + commentRef + ", commentReStep="
				+ commentReStep + ", commentReLevel=" + commentReLevel + "]";
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentWriteDate() {
		return commentWriteDate;
	}

	public void setCommentWriteDate(String commentWriteDate) {
		this.commentWriteDate = commentWriteDate;
	}

	public String getCommentRewriteDate() {
		return commentRewriteDate;
	}

	public void setCommentRewriteDate(String commentRewriteDate) {
		this.commentRewriteDate = commentRewriteDate;
	}

	public String getCommentImg() {
		return commentImg;
	}

	public void setCommentImg(String commentImg) {
		this.commentImg = commentImg;
	}

	public int getCommentRef() {
		return commentRef;
	}

	public void setCommentRef(int commentRef) {
		this.commentRef = commentRef;
	}

	public int getCommentReStep() {
		return commentReStep;
	}

	public void setCommentReStep(int commentReStep) {
		this.commentReStep = commentReStep;
	}

	public int getCommentReLevel() {
		return commentReLevel;
	}

	public void setCommentReLevel(int commentReLevel) {
		this.commentReLevel = commentReLevel;
	}

}
