package kh.semi.boardclass.used.model.vo;

public class UsedLike {

	private int usedLikeNo;
	private int usedNum;
	private String userId;
	
	public UsedLike() {
	}

	public UsedLike(int usedLikeNo, int usedNum, String userId) {
		super();
		this.usedLikeNo = usedLikeNo;
		this.usedNum = usedNum;
		this.userId = userId;
	}

	public int getUsedLikeNo() {
		return usedLikeNo;
	}

	public void setUsedLikeNo(int usedLikeNo) {
		this.usedLikeNo = usedLikeNo;
	}

	public int getUsedNum() {
		return usedNum;
	}

	public void setUsedNum(int usedNum) {
		this.usedNum = usedNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
