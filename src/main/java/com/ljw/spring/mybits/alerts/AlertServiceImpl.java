package com.ljw.spring.mybits.alerts;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

import com.ljw.spring.mybits.domain.Spittle;

public class AlertServiceImpl implements AlertService{
	
	
	
	private JmsOperations jmsOperations;
	
	@Autowired
	public AlertServiceImpl(JmsOperations jmsOperations){//注入jms模板
		
		this.jmsOperations= jmsOperations;
	}
	
	

	public void sendSpittleAlert(final Spittle spittle) {
		//使用jms模板发送MQ消息队列，使用的是队列
		jmsOperations.send("spittle.alert.queue", new MessageCreator(){

			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(spittle);
			}
			
		});
		
	}

}
