package com.ljw.spring.mybits.cache.son;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ljw.spring.mybits.cache.BaseCacheManager;
import com.ljw.spring.mybits.dao.EmpDao;
import com.ljw.spring.mybits.dao.entity.Empe;

import net.sf.ehcache.CacheManager;


/**
 * 测试数据库提取数据
 * 
 * 
 * @author PC
 *
 */
@Component
public class FirstCacheManager extends BaseCacheManager<String, Empe>{

	@Value("First")
	private String cacheName;
	
	@Autowired
	private EmpDao empDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@PostConstruct
	public void init(){
		ehcacheManager = cacheManager;
		ehcacheName = cacheName;
	} 
	
	
	@Override
	public Empe getFromSource(String id) {
		System.out.println("真实查找id="+id);
		Empe emp = empDao.findById(Integer.parseInt(id));
		
		
		return emp;
	}

}
