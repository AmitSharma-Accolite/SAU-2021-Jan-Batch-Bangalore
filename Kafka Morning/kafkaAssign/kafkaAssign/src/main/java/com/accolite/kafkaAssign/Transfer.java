package com.accolite.kafkaAssign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


/*
 * Transfer data from BeforeTopic to AfterTopic 
 * 
 */
@Service
public class Transfer {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	 String Topic = "AfterPass";
	 
	 @KafkaListener(topics="BeforePass",groupId="beforepass")
	 void transfer(String message) {
		 kafkaTemplate.send(Topic,message);
	 }
}
