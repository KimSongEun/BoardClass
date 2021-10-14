package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class AllBoardUser {
	private int boardNo;
	private String userId;
	private String boardType;
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private Date boardWriteDate;
	private Date boardRewriteDate;
	private int userNo;
	
	public AllBoardUser() {
	}

	public AllBoardUser(int boardNo, String userId, String boardType, String boardCategory, String boardTitle,
			String boardContent, Date boardWriteDate, Date boardRewriteDate, int userNo) {
		super();
		this.boardNo = boardNo;
		this.userId = userId;
		this.boardType = boardType;
		this.boardCategory = boardCategory;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriteDate = boardWriteDate;
		this.boardRewriteDate = boardRewriteDate;
		this.userNo = userNo;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "AllBoardUser [boardNo=" + boardNo + ", userId=" + userId + ", boardType=" + boardType
				+ ", boardCategory=" + boardCategory + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriteDate=" + boardWriteDate + ", boardRewriteDate=" + boardRewriteDate + ", userNo=" + userNo
				+ "]";
	}
	
	
}
