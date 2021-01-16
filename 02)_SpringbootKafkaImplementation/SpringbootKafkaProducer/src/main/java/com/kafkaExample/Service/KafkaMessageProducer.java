package com.kafkaExample.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

	private  static final Logger logger = LoggerFactory.getLogger(KafkaMessageProducer.class);
	public static final String TOPIC = "Employees";

	@Autowired
	private KafkaTemplate<String, String> ktemplate;

	public void sendMessage(String message) {
		logger.info(String.format("#### -> Producing message -> %s", message));
		this.ktemplate.send(TOPIC, message);
		
	}

}
