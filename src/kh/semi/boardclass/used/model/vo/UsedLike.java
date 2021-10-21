package kh.semi.boardclass.used.model.vo;

public class UsedLike {

	private int usedLikeNo;
	private int usedNo;
	private String userId;
	
	public UsedLike() {
		super();
	}
	
	public UsedLike(int usedLikeNo, int usedNo, String userId) {
		super();
		this.usedLikeNo = usedLikeNo;
		this.usedNo = usedNo;
		this.userId = userId;
	}
	public UsedLike(int usedNo, String userId) {
		super();
		this.usedNo = usedNo;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "UsedLike [usedLikeNo=" + usedLikeNo + ", usedNo=" + usedNo + ", userId=" + userId + "]";
	}

	public int getUsedLikeNo() {
		return usedLikeNo;
	}

	public void setUsedLikeNo(int usedLikeNo) {
		this.usedLikeNo = usedLikeNo;
	}

	public int getUsedNo() {
		return usedNo;
	}

	public void setUsedNo(int usedNo) {
		this.usedNo = usedNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
