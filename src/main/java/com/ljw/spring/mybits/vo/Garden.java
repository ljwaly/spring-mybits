package com.ljw.spring.mybits.vo;

import java.io.Serializable;

public class Garden implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4583114273911218184L;
	
	private String gardenName;
	private String area;
	private Flower flower;
	
	
	
	
	
	public Garden() {
	}
	
	public Garden(Flower flower) {
		this.flower = flower;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((flower == null) ? 0 : flower.hashCode());
		result = prime * result + ((gardenName == null) ? 0 : gardenName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garden other = (Garden) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (flower == null) {
			if (other.flower != null)
				return false;
		} else if (!flower.equals(other.flower))
			return false;
		if (gardenName == null) {
			if (other.gardenName != null)
				return false;
		} else if (!gardenName.equals(other.gardenName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Garden [gardenName=" + gardenName + ", area=" + area + ", flower=" + flower + "]";
	}
	public String getGardenName() {
		return gardenName;
	}
	public void setGardenName(String gardenName) {
		this.gardenName = gardenName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Flower getFlower() {
		return flower;
	}
	public void setFlower(Flower flower) {
		this.flower = flower;
	}
	
	
	
	
}
