package kh.semi.boardclass.mypage.model.vo;


public class UserMyUsed {
	private int usedNo;
	private String userId;
	private String usedTitle;
	private int usedPrice;
	private String usedImg;
	private String usedCategory;
	private int usedLikeNo;
	
	
	public UserMyUsed() {
		// TODO Auto-generated constructor stub
	}


	public UserMyUsed(int usedNo, String userId, String usedTitle, int usedPrice, String usedImg, String usedCategory,
			int usedLikeNo) {
		super();
		this.usedNo = usedNo;
		this.userId = userId;
		this.usedTitle = usedTitle;
		this.usedPrice = usedPrice;
		this.usedImg = usedImg;
		this.usedCategory = usedCategory;
		this.usedLikeNo = usedLikeNo;
	}


	@Override
	public String toString() {
		return "UserMyUsed [usedNo=" + usedNo + ", userId=" + userId + ", usedTitle=" + usedTitle + ", usedPrice="
				+ usedPrice + ", usedImg=" + usedImg + ", usedCategory=" + usedCategory + ", usedLikeNo=" + usedLikeNo
				+ "]";
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


	public String getUsedTitle() {
		return usedTitle;
	}


	public void setUsedTitle(String usedTitle) {
		this.usedTitle = usedTitle;
	}


	public int getUsedPrice() {
		return usedPrice;
	}


	public void setUsedPrice(int usedPrice) {
		this.usedPrice = usedPrice;
	}


	public String getUsedImg() {
		return usedImg;
	}


	public void setUsedImg(String usedImg) {
		this.usedImg = usedImg;
	}


	public String getUsedCategory() {
		return usedCategory;
	}


	public void setUsedCategory(String usedCategory) {
		this.usedCategory = usedCategory;
	}


	public int getUsedLikeNo() {
		return usedLikeNo;
	}


	public void setUsedLikeNo(int usedLikeNo) {
		this.usedLikeNo = usedLikeNo;
	}

	
	
}
