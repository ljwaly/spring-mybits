package com.ljw.spring.mybits.dao.entity;

import java.io.Serializable;

public class Vehicle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6789537500622543924L;
	
	private int id;
	private String type;
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
