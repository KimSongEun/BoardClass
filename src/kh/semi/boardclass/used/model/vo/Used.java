package kh.semi.boardclass.used.model.vo;

import java.sql.Date;

public class Used {

	private int usedNo;
	private String userId;
	private String usedTitle;
	private String usedPrice;
	private String usedState;
	private String usedChange;
	private String usedPay;
	private String usedArea;
	private String usedInfo;
	private Date usedDay;
	private String usedImg;

	public Used() {
	}

	public Used(int usedNo, String userId, String usedTitle, String usedPrice, String usedState, String usedChange,
			String usedPay, String usedArea, String usedInfo, Date usedDay, String usedImg) {
		this.usedNo = usedNo;
		this.userId = userId;
		this.usedTitle = usedTitle;
		this.usedPrice = usedPrice;
		this.usedState = usedState;
		this.usedChange = usedChange;
		this.usedPay = usedPay;
		this.usedArea = usedArea;
		this.usedInfo = usedInfo;
		this.usedDay = usedDay;
		this.usedImg = usedImg;
	}

	public Used(int usedNo, String userId, String usedTitle, String usedPrice, String usedState, String usedChange,
			String usedPay, String usedArea, String usedInfo, Date usedDay) {
		this.usedNo = usedNo;
		this.userId = userId;
		this.usedTitle = usedTitle;
		this.usedPrice = usedPrice;
		this.usedState = usedState;
		this.usedChange = usedChange;
		this.usedPay = usedPay;
		this.usedArea = usedArea;
		this.usedInfo = usedInfo;
		this.usedDay = usedDay;
	}
	
	public Used(String userId, String usedTitle, String usedPrice, String usedState, String usedChange,
			String usedPay, String usedArea, String usedInfo) {
		this.userId = userId;
		this.usedTitle = usedTitle;
		this.usedPrice = usedPrice;
		this.usedState = usedState;
		this.usedChange = usedChange;
		this.usedPay = usedPay;
		this.usedArea = usedArea;
		this.usedInfo = usedInfo;
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

	public String getUsedPrice() {
		return usedPrice;
	}

	public void setUsedPrice(String usedPrice) {
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

	public String getUsedPay() {
		return usedPay;
	}

	public void setUsedPay(String usedPay) {
		this.usedPay = usedPay;
	}

	public String getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(String usedArea) {
		this.usedArea = usedArea;
	}

	public String getUsedInfo() {
		return usedInfo;
	}

	public void setUsedInfo(String usedInfo) {
		this.usedInfo = usedInfo;
	}

	public Date getUsedDay() {
		return usedDay;
	}

	public void setUsedDay(Date usedDay) {
		this.usedDay = usedDay;
	}

	public String getUsedImg() {
		return usedImg;
	}

	public void setUsedImg(String usedImg) {
		this.usedImg = usedImg;
	}

}
