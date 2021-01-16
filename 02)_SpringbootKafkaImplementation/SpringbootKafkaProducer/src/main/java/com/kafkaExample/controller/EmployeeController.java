package com.kafkaExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaExample.Service.KafkaMessageProducer;
import com.kafkaExample.model.Employee;

@RestController
@RequestMapping("/kafka")
public class EmployeeController {
	
	@Autowired
	KafkaMessageProducer kafkaProducer;
	
	
	@PostMapping(value="/publish")
	public void sendMessageKafkaTopic(@RequestParam String message) {
		kafkaProducer.sendMessage(message);
	}

}
