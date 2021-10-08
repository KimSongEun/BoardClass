package kh.semi.boardclass.admin.model.vo;

import java.sql.Date;

public class Banner {
	private int promotion;
	private String userId;
	private int promotionPlace;
	private String promotionTitle;
	private String promotionContent;
	private Date promotionDate;
	
	public Banner(){
		
	}
	
	public Banner(int promotion, String userId, int promotionPlace,String promotionTitle,String promotionContent,Date promotionDate){
		super();
		this.promotion = promotion;
		this.userId = userId;
		this.promotionPlace = promotionPlace;
		this.promotionTitle = promotionTitle;
		this.promotionContent = promotionContent;
		this.promotionDate = promotionDate;
	}
	
	public int getPromotion() {
		return promotion;
	}


	public void setPromotion(int promotion) {
		this.promotion = promotion;
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


	@Override
	public String toString() {
		return "Banner [promotion=" + promotion + ", userId=" + userId + ", promotionPlace=" + promotionPlace
				+ ", promotionTitle=" + promotionTitle + ", promotionContent=" + promotionContent + ", promotionDate="
				+ promotionDate + "]";
	}
	
	
}
