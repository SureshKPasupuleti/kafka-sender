package com.spring.kafka.sender;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableKafka
public class SenderConfig {
	@Bean
	public Map<String,Object> config(){
		Map<String,Object> conf=new HashMap<>();
		//conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "104.42.108.238:9092");
		conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "137.117.10.35:9092");
		conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return conf;
	}
	@Bean
	public ProducerFactory<String, String> producerFactory(){
		return new DefaultKafkaProducerFactory<>(config());
	}
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	@Bean
	public KafkaSender kafkaSender() {
		return new KafkaSender();
	}
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
