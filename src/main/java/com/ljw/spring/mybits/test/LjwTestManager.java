package com.ljw.spring.mybits.test;



public class LjwTestManager extends GenericCacheManager<String, String>{

	
	private int i=0;
	private int j=10000;
//	public static void main(String[] args) {
//		LjwTestManager ljwTestManager = (LjwTestManager) PortalConstants.ctx.getBean("ljwTestManager");
//		String string = ljwTestManager.get("1");
//	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
	
}
