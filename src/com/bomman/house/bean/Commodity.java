package com.bomman.house.bean;

import java.io.Serializable;
import java.sql.Date;

public class Commodity implements Serializable{

	private static final long serialVersionUID = 101L;
	private int id;
	private String items;
	private double cost;
	private String buyer;
	private Date date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
