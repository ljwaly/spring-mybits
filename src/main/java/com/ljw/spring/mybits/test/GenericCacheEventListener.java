package com.ljw.spring.mybits.test;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * this class listen the event of visitCache
 * 
 * @author wondertek
 * 
 */
public class GenericCacheEventListener implements CacheEventListener {
	protected Log log = LogFactory.getLog(getClass());

	public void dispose() {
	}

	public void notifyElementEvicted(Ehcache cache, Element element) {
		System.out.println("24:notifyElementUpdated:"+element.toString());
	}

	public void notifyElementExpired(Ehcache cache, Element element) {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyyMMdd hhmmssSSS");
		String format = sdf.format(new Date());
		
		System.out.println("34:"+format+":notifyElementExpired:"+element.toString());
		notifyElementEvicted(cache, element);
		//cache.remove(element.getKey());
	}

	public void notifyElementPut(Ehcache cache, Element element)
			throws CacheException {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyyMMdd hhmmssSSS");
		String format = sdf.format(new Date());
		System.out.println("43:"+format+":put:"+element.toString());
	}

	public void notifyElementRemoved(Ehcache cache, Element element)
			throws CacheException {
		System.out.println("48:notifyElementRemoved:"+element.toString());
		
	}

	public void notifyElementUpdated(Ehcache cache, Element element)
			throws CacheException {
		System.out.println("54:notifyElementUpdated:"+element.toString());
	}

	public void notifyRemoveAll(Ehcache cache) {
		
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}

}