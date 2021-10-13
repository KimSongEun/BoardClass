package kh.semi.boardclass.community.model.vo;

import java.sql.Date;

public class Board {
//	BOARD_NO NUMBER, 
//    USER_ID VARCHAR2(20), 
//    BOARD_TYPE	VARCHAR2(60) NOT NULL, 
//    BOARD_CATEGORY	VARCHAR2(30) NOT NULL, 
//    BOARD_TITLE	VARCHAR2(300) NOT NULL,
//    BOARD_CONTENT VARCHAR2(3000) NOT NULL, 
//    BOARD_WRITE_DATE TIMESTAMP NOT NULL, 
//    BOARD_REWRITE_DATE TIMESTAMP, 
//    BOARD_VIEW_COUNT NUMBER DEFAULT 0, 
//    BOARD_REPLY_REF NUMBER, 
//    BOARD_REPLY_LEV NUMBER, function
//    BOARD_REPLY_SEQ NUMBER,
//    BOARD_IMG VARCHAR2(100),
	private int boardNo;
	private String userId;
	private String boardType;
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private Date boardWriteDate;
	private Date boardRewriteDate;
	private int boardViewCount;
	private int boardReplyRef;
	private int boardReplyLev;
	private int boardReplySeq;
	private String boardImg;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int boardNo, String title, String content, String writer, String type, String category, int boardReplyRef, int boardReplyLev, int boardReplySeq) {
		super();
		this.boardNo =boardNo;
		this.boardTitle = title;
		this.boardContent = content;
		this.userId = writer;
		this.boardReplyRef = boardReplyRef;
		this.boardReplyLev = boardReplyLev;
		this.boardReplySeq = boardReplySeq;
		this.boardType = type;
		this.boardCategory = category;
	}



	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userId=" + userId + ", boardType=" + boardType + ", boardCategory="
				+ boardCategory + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardWriteDate="
				+ boardWriteDate + ", boardRewriteDate=" + boardRewriteDate + ", boardViewCount=" + boardViewCount
				+ ", boardReplyRef=" + boardReplyRef + ", boardReplyLev=" + boardReplyLev + ", boardReplySeq="
				+ boardReplySeq + ", boardImg=" + boardImg + "]";
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

	public int getBoardViewCount() {
		return boardViewCount;
	}

	public void setBoardViewCount(int boardViewCount) {
		this.boardViewCount = boardViewCount;
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

	public String getBoardImg() {
		return boardImg;
	}

	public void setBoardImg(String boardImg) {
		this.boardImg = boardImg;
	}

}
