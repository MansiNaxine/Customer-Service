package com.example.Customer_Service.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration
public class CustomerConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();

    }

}
