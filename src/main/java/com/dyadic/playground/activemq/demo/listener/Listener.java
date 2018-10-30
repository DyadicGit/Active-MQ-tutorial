package com.dyadic.playground.activemq.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@JmsListener(destination = "${app.settings.activemq.sampleQ}")
	public void receiveQueue(String text) {
		System.out.println(text);
	}
}
