package com.ljw.spring.mybits.cache;

import java.io.Serializable;

import org.apache.log4j.Logger;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


/**
 *
 * 创建缓存数据的父类
 * 可以从此类中获取缓存的
 * 
 * @author ljw
 *
 * @param <K> :标志id
 * @param <T> :缓存id对应的对象
 */


public abstract class BaseCacheManager<K extends Serializable, T> {

	protected Logger log = Logger.getLogger(getClass());

	/**
	 * 需要配置
	 * 缓存管理器
	 */
	protected CacheManager ehcacheManager;
	
	/**
	 * 缓存名称
	 */
	protected String ehcacheName;
	
	

	
	
	/**
	 * 需要配置
	 * 通过标志id获取缓存中的数据，优先从缓存中获取，
	 * 如果不成功，从实体存储（包含数据库和存储文件）中再次读取
	 * 
	 * @param id
	 * @return
	 */
	public T get(K id) {
		T result = null;
		Element element = null;
		Cache cache = null;

		//从缓存中获取数据
		if (ehcacheManager != null) {
			cache = ehcacheManager.getCache(ehcacheName);//从缓存中获取对应的数据
			
			if (cache != null) {
				try {
					element = cache.get(id);
					if (element != null) {
						result = (T) element.getObjectValue();
					}
				} catch (Exception e) {
					log.error(ehcacheName + ",id:" + id + ",ehcacheGetErr:" + e.getMessage());
				}
			}
		}
		
		//如果缓存中获取失败，从数据存储实体获取数据
		if (result == null) {
			result = getFromSource(id);
			
			//将从实体中获取到的数据进行缓存
			try {
				if (result != null && ehcacheManager != null && cache != null && element == null) {
					element = new Element(id, result);
					cache.put(element);
				}

			} catch (Exception e) {
				log.error(ehcacheName + ",id:" + id + ",ehcachePutErr:" + e.getMessage());
			}
		}
		return result;
	}

	
	/**
	 * 更新某一个缓存
	 * 
	 * @param id
	 * @param object
	 */
	public void update(K id, T object) {
		if (ehcacheManager != null && object != null) {
			Element element = new Element(id, object);
			if (ehcacheManager.getCache(ehcacheName) != null){
				ehcacheManager.getCache(ehcacheName).put(element);
			}
		}
	}

	/**
	 * 清除某一个缓存
	 * @param id
	 */
	public void remove(K id) {
		if (ehcacheManager != null) {
			if (ehcacheManager.getCache(ehcacheName) != null){
				ehcacheManager.getCache(ehcacheName).remove(id);
			}
		}
	}

	/**
	 * 清楚所有缓存
	 */
	public void flushEhCache() {
		if (ehcacheManager != null){
			ehcacheManager.clearAll();
		}
			
	}

	

	/**
	 * 从实体存储资源中获取对应标志id的对象
	 * 
	 * @param id
	 * @return
	 */
	public abstract T getFromSource(K id);

}
