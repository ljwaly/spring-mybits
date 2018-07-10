package com.ljw.spring.mybits.cache;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;




public class MyCacheManager {

	private static Logger logger = Logger.getLogger(MyCacheManager.class);
	
	
	private static final Map<Integer,String> myCacheMap= new HashMap<Integer,String>();
	
	public void init(){
		for (int i = 0; i < 20; i++) {
			myCacheMap.put(i, "value"+i);
		}
		logger.fatal("MyCacheManager init success!");
		String path = this.getClass().getResource("/ljw.txt").getPath();
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
	}

	public String getValue(Integer i) {
		return myCacheMap.get(i);
	}
	
	
}
