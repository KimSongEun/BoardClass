package kh.semi.boardclass.mypage.model.vo;

import java.sql.Date;

public class UserMyComt {
	private int boardNo;
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private String userId;
	private String boardWriteDate;
	private int boardViewCount;
	private int commentNo;
	private String commentContent;
	private String commentWriteDate;
	private int commentRef;
	private int commentReStep;
	private int commentReLevel;
	
	public UserMyComt() {
		// TODO Auto-generated constructor stub
	}

	

	public UserMyComt(int boardNo, String boardCategory, String boardTitle, String boardContent, String userId,
			String boardWriteDate, int boardViewCount, int commentNo, String commentContent, String commentWriteDate,
			int commentRef, int commentReStep, int commentReLevel) {
		super();
		this.boardNo = boardNo;
		this.boardCategory = boardCategory;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.userId = userId;
		this.boardWriteDate = boardWriteDate;
		this.boardViewCount = boardViewCount;
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentWriteDate = commentWriteDate;
		this.commentRef = commentRef;
		this.commentReStep = commentReStep;
		this.commentReLevel = commentReLevel;
	}



	@Override
	public String toString() {
		return "UserMyComt [boardNo=" + boardNo + ", boardCategory=" + boardCategory + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", userId=" + userId + ", boardWriteDate=" + boardWriteDate
				+ ", boardViewCount=" + boardViewCount + ", commentNo=" + commentNo + ", commentContent="
				+ commentContent + ", commentWriteDate=" + commentWriteDate + ", commentRef=" + commentRef
				+ ", commentReStep=" + commentReStep + ", commentReLevel=" + commentReLevel + "]";
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



	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoardWriteDate() {
		return boardWriteDate;
	}

	public void setBoardWriteDate(String boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}

	public int getBoardViewCount() {
		return boardViewCount;
	}

	public void setBoardViewCount(int boardViewCount) {
		this.boardViewCount = boardViewCount;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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

	public int getCommentReLevel() {
		return commentReLevel;
	}

	public void setCommentReLevel(int commentReLevel) {
		this.commentReLevel = commentReLevel;
	}



	
	
}
