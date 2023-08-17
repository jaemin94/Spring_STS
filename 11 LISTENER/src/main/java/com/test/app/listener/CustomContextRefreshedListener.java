package com.test.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


// ServletContextEvent
// ServletContextAttributeEvent
// RequestContextEvent


public class CustomContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("CustomContextRefreshedListener's onApplicationEvent" + event.getSource());
		
	}





}
