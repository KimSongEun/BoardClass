package kh.semi.boardclass.community.model.vo;

import java.sql.Date;

public class Board {

	private int boardNo;
	private String userId;
	private String boardType;
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private Date boardWriteDate;
	private Date boardRewriteDate;
	private int viewCount;
	private int boardReplyRef;
	private int boardReplyLev;
	private int boardReplySeq;

	public Board() {
		// TODO Auto-generated constructor stub
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

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getBoardReplyRef() {
		return boardReplyRef;
	}

	public void setBoardReplyRef(int boardReplyRef) {
		this.boardReplyRef = boardReplyRef;
	}

	public int getBoardReplyLev() {
		return boardReplyLev;
	}

	public void setBoardReplyLev(int boardReplyLev) {
		this.boardReplyLev = boardReplyLev;
	}

	public int getBoardReplySeq() {
		return boardReplySeq;
	}

	public void setBoardReplySeq(int boardReplySeq) {
		this.boardReplySeq = boardReplySeq;
	}

}
