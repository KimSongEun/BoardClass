package kh.semi.boardclass.community.model.vo;

import java.sql.Date;

public class Comment {
//	  COMMENT_NO NUMBER,
//	    BOARD_NO NUMBER,
//	    USER_ID VARCHAR2(20),
//	    COMMENT_CONTENT VARCHAR(300) NOT NULL,
//	    COMMENT_WRITE_DATE TIMESTAMP NOT NULL,
//	    COMMENT_REWRITE_DATE TIMESTAMP,
//	    COMMENT_IMG VARCHAR2(100),
	private int commentNo;
	private int boardNo;
	private String userId;
	private String commentContent;
	private String commentWriteDate;
	private String commentRewriteDate;
	

	public Comment() {
		// TODO Auto-generated constructor stub
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

}
