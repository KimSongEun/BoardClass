package kh.semi.boardclass.used.model.vo;

public class Used {

	private int usedNo;
	private String userId;
	private String usedTitle;
	private int usedPrice;
	private String usedState;
	private String usedChange;
	private String usedExtype;
	private String usedInfo;
	private String usedDay;
	private String usedImg;
	private String usedCategory;
	private String usedKeyword;

	public Used() {
	}

	public Used(int usedNo, String userId, String usedTitle, int usedPrice, String usedState, String usedChange,
			String usedExtype, String usedInfo, String usedDay, String usedImg, String usedCategory,
			String usedKeyword) {
		super();
		this.usedNo = usedNo;
		this.userId = userId;
		this.usedTitle = usedTitle;
		this.usedPrice = usedPrice;
		this.usedState = usedState;
		this.usedChange = usedChange;
		this.usedExtype = usedExtype;
		this.usedInfo = usedInfo;
		this.usedDay = usedDay;
		this.usedImg = usedImg;
		this.usedCategory = usedCategory;
		this.usedKeyword = usedKeyword;
	}

	public Used(String userId, String usedTitle, int usedPrice, String usedState, String usedChange, String usedExtype,
			String usedInfo, String usedImg, String usedCategory, String usedKeyword) {
		super();
		this.userId = userId;
		this.usedTitle = usedTitle;
		this.usedPrice = usedPrice;
		this.usedState = usedState;
		this.usedChange = usedChange;
		this.usedExtype = usedExtype;
		this.usedInfo = usedInfo;
		this.usedImg = usedImg;
		this.usedCategory = usedCategory;
		this.usedKeyword = usedKeyword;
	}
	
	

	public Used(String usedTitle, int usedPrice, String usedState, String usedChange, String usedExtype,
			String usedInfo, String usedImg, String usedCategory, String usedKeyword) {
		super();
		this.usedTitle = usedTitle;
		this.usedPrice = usedPrice;
		this.usedState = usedState;
		this.usedChange = usedChange;
		this.usedExtype = usedExtype;
		this.usedInfo = usedInfo;
		this.usedImg = usedImg;
		this.usedCategory = usedCategory;
		this.usedKeyword = usedKeyword;
	}

	@Override
	public String toString() {
		return "Used [usedNo=" + usedNo + ", userId=" + userId + ", usedTitle=" + usedTitle + ", usedPrice=" + usedPrice
				+ ", usedState=" + usedState + ", usedChange=" + usedChange + ", usedExtype=" + usedExtype
				+ ", usedInfo=" + usedInfo + ", usedDay=" + usedDay + ", usedImg=" + usedImg + ", usedCategory="
				+ usedCategory + ", usedKeyword=" + usedKeyword + "]";
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

	public String getUsedState() {
		return usedState;
	}

	public void setUsedState(String usedState) {
		this.usedState = usedState;
	}

	public String getUsedChange() {
		return usedChange;
	}

	public void setUsedChange(String usedChange) {
		this.usedChange = usedChange;
	}

	public String getUsedExtype() {
		return usedExtype;
	}

	public void setUsedExtype(String usedExtype) {
		this.usedExtype = usedExtype;
	}

	public String getUsedInfo() {
		return usedInfo;
	}

	public void setUsedInfo(String usedInfo) {
		this.usedInfo = usedInfo;
	}

	public String getUsedDay() {
		return usedDay;
	}

	public void setUsedDay(String usedDay) {
		this.usedDay = usedDay;
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

	public String getUsedKeyword() {
		return usedKeyword;
	}

	public void setUsedKeyword(String usedKeyword) {
		this.usedKeyword = usedKeyword;
	}

}
