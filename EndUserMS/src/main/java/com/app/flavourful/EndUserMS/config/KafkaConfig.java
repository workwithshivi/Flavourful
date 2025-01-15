package com.app.flavourful.EndUserMS.config;


import com.app.flavourful.EndUserMS.constant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder
                .name(AppConstant.FLAVOURFUL_NEW_ORDER)
                .build();
    }
}
