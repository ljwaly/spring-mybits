package com.ljw.spring.mybits.alerts;

import com.ljw.spring.mybits.domain.Spittle;


/**
 * 使用JMS发送消息
 * @author PC
 *
 */
public interface AlertService {

	/**
	 * 发送一个spttle
	 * @param spittle
	 */
	void sendSpittleAlert(Spittle spittle);
}
