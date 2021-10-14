package kh.semi.boardclass.user.model.vo;

public class User {
	private String userImage;
	private String userName;
	private String userNickname;
	private String userId;
	private String userPassword;
	private String userEmail;
	private int userPhone;
	private String userAddress;
	private char userType;
	private int userHistory;
	private int userNo;


	public User() {
	}


	

	public User(String userName, String userNickname, String userId, String userPassword, String userEmail,
			int userPhone, String userAddress) {
		super();
		this.userName = userName;
		this.userNickname = userNickname;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}

	public User(String userName, String userNickname, String userId, String userPassword, String userEmail,
			int userPhone, String userAddress, char userType, String userImage, int userHistory, int userNo) {
		super();
		this.userName = userName;
		this.userNickname = userNickname;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userType = userType;
		this.userImage = userImage;
		this.userHistory = userHistory;
		this.userNo = userNo;
	}

	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public int getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public char getUserType() {
		return userType;
	}


	public void setUserType(char userType) {
		this.userType = userType;
	}


	public String getUserImage() {
		return userImage;
	}


	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}


	public int getUserHistory() {
		return userHistory;
	}


	public void setUserHistory(int userHistory) {
		this.userHistory = userHistory;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
}
