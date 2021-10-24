package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class Banner {
	private int promotionNo;
	private String userId;
	private int promotionPlace;
	private String promotionTitle;
	private String promotionContent;
	private Date promotionDate;
	private String promotionImg;
	private int rownum;
	private String promotionURL;
	
	public Banner(){
		
	}
	

	public Banner(int promotionNo, String userId, int promotionPlace, String promotionTitle, String promotionContent,
			Date promotionDate, String promotionImg, int rownum, String promotionURL) {
		super();
		this.promotionNo = promotionNo;
		this.userId = userId;
		this.promotionPlace = promotionPlace;
		this.promotionTitle = promotionTitle;
		this.promotionContent = promotionContent;
		this.promotionDate = promotionDate;
		this.promotionImg = promotionImg;
		this.rownum = rownum;
		this.promotionURL = promotionURL;
	}


	public int getPromotionNo() {
		return promotionNo;
	}


	public void setPromotionNo(int promotionNo) {
		this.promotionNo = promotionNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getPromotionPlace() {
		return promotionPlace;
	}


	public void setPromotionPlace(int promotionPlace) {
		this.promotionPlace = promotionPlace;
	}


	public String getPromotionTitle() {
		return promotionTitle;
	}


	public void setPromotionTitle(String promotionTitle) {
		this.promotionTitle = promotionTitle;
	}


	public String getPromotionContent() {
		return promotionContent;
	}


	public void setPromotionContent(String promotionContent) {
		this.promotionContent = promotionContent;
	}


	public Date getPromotionDate() {
		return promotionDate;
	}


	public void setPromotionDate(Date promotionDate) {
		this.promotionDate = promotionDate;
	}
	

	public String getPromotionImg() {
		return promotionImg;
	}

	public void setPromotionImg(String promotionImg) {
		this.promotionImg = promotionImg;
	}
	

	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
	}


	public String getPromotionURL() {
		return promotionURL;
	}


	public void setPromotionURL(String promotionURL) {
		this.promotionURL = promotionURL;
	}


	@Override
	public String toString() {
		return "Banner [promotionNo=" + promotionNo + ", userId=" + userId + ", promotionPlace=" + promotionPlace
				+ ", promotionTitle=" + promotionTitle + ", promotionContent=" + promotionContent + ", promotionDate="
				+ promotionDate + ", promotionImg=" + promotionImg + ", rownum=" + rownum + ", promotionURL="
				+ promotionURL + "]";
	}
	
}
