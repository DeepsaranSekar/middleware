package com.nuance.middleware.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.nuance.middleware.utility.InputOutputParam;

@Service
public class JsonKafkaProducer {

	
	@Value("${spring.kafka.topics}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, InputOutputParam> kafkaTemplateCustomJson;
//    private KafkaTemplate<String, String> kafkaTemplateString;
//    private KafkaTemplate<String, JSONObject> kafkaTemplateJSON;

    public JsonKafkaProducer(KafkaTemplate<String, InputOutputParam> kafkaTemplateCustomJson) {
        this.kafkaTemplateCustomJson = kafkaTemplateCustomJson;
//        this.kafkaTemplateString = kafkaTemplateString;
//        this.kafkaTemplateJSON = kafkaTemplateJSON;
    }

    public void sendMessage(InputOutputParam data){
        LOGGER.info(String.format("CustomJson Message sent -> %s", data.toString()));

        Message<InputOutputParam> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplateCustomJson.send(message);
    }
    
//    public void sendStringMessageToTopic(String message) {
//    	LOGGER.info(String.format("String Message sent -> %s", message));
//    	kafkaTemplateString.send(topicJsonName, message);
//	}
    
//    public void sendJSONMessageToTopic(JSONObject message) {
//    	LOGGER.info(String.format("JSON Message sent -> %s", message));
//    	LOGGER.info("topic : "+topicJsonName);
//    	kafkaTemplateJSON.send(topicJsonName, message);
//	}
    
}
