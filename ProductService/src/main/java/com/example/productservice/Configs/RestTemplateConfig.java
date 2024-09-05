package com.example.productservice.Configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration///This is a configuration file and I need this configuration throughout my project.
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate(){
       return new RestTemplateBuilder().build();
    }

}
