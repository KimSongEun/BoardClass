package kh.semi.boardclass.used.model.vo;

import java.sql.Date;

public class Used {
	
	private int used_num;
	private String user_id;
	private String used_title;
	private String used_price;
	private String used_state;
	private String used_change;
	private String used_pay;
	private String used_area;
	private String used_info;
	private Date used_day;
	private String used_img;

	public Used() {
	}

	public Used(int used_num, String user_id, String used_title, String used_price, String used_state,
			String used_change, String used_pay, String used_area, String used_info, Date used_day, String used_img) {
		super();
		this.used_num = used_num;
		this.user_id = user_id;
		this.used_title = used_title;
		this.used_price = used_price;
		this.used_state = used_state;
		this.used_change = used_change;
		this.used_pay = used_pay;
		this.used_area = used_area;
		this.used_info = used_info;
		this.used_day = used_day;
		this.used_img = used_img;
	}

	public int getUsed_num() {
		return used_num;
	}

	public void setUsed_num(int used_num) {
		this.used_num = used_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsed_title() {
		return used_title;
	}

	public void setUsed_title(String used_title) {
		this.used_title = used_title;
	}

	public String getUsed_price() {
		return used_price;
	}

	public void setUsed_price(String used_price) {
		this.used_price = used_price;
	}

	public String getUsed_state() {
		return used_state;
	}

	public void setUsed_state(String used_state) {
		this.used_state = used_state;
	}

	public String getUsed_change() {
		return used_change;
	}

	public void setUsed_change(String used_change) {
		this.used_change = used_change;
	}

	public String getUsed_pay() {
		return used_pay;
	}

	public void setUsed_pay(String used_pay) {
		this.used_pay = used_pay;
	}

	public String getUsed_area() {
		return used_area;
	}

	public void setUsed_area(String used_area) {
		this.used_area = used_area;
	}

	public String getUsed_info() {
		return used_info;
	}

	public void setUsed_info(String used_info) {
		this.used_info = used_info;
	}

	public Date getUsed_day() {
		return used_day;
	}

	public void setUsed_day(Date used_day) {
		this.used_day = used_day;
	}

	public String getUsed_img() {
		return used_img;
	}

	public void setUsed_img(String used_img) {
		this.used_img = used_img;
	}
	
	
	

}
