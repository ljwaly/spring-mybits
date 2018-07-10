package com.ljw.spring.mybits.vo.response;

import java.util.List;
import java.util.Map;

import com.ljw.spring.mybits.vo.Response;



public class MyResponse<K,T> extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 679801195676560535L;

	
	private List<T> resultList;
	private Map<K,T> resultMap;
	
	
	
	

	@Override
	public String toString() {
		return "MyResponse [resultList=" + resultList + ", resultMap=" + resultMap + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((resultList == null) ? 0 : resultList.hashCode());
		result = prime * result + ((resultMap == null) ? 0 : resultMap.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		MyResponse other = (MyResponse) obj;
		if (resultList == null) {
			if (other.resultList != null)
				return false;
		} else if (!resultList.equals(other.resultList))
			return false;
		if (resultMap == null) {
			if (other.resultMap != null)
				return false;
		} else if (!resultMap.equals(other.resultMap))
			return false;
		return true;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public Map<K, T> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<K, T> resultMap) {
		this.resultMap = resultMap;
	}
	

	
	
}
