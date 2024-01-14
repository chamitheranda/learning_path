package com.chamith.springbootkafkaconsmerexample.listener;

import com.chamith.springbootkafkaconsmerexample.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "Kafka_Example" , groupId= "group_id")
    protected void consume(String message){
        System.out.println("Consumer message : " + message);
    }

    @KafkaListener(topics = "Kafka_Example_json" , groupId = "group_json" ,
    containerFactory = "userKafkaListenerContainerFactory")
    public void consumerJson(User user){
        System.out.println("Consumed JSON Message : " + user);
    }
}
