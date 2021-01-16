package com.kafkaconsumerExample.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageReceiver {
	private final Logger logger = LoggerFactory.getLogger(KafkaMessageReceiver.class);
	
	@KafkaListener(topics = "Employees", groupId = "group_id")
	public void consumeMessage(String message){
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

}
