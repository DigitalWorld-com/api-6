package com.digitalworlds.api6.base.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MapperConf {

    @Bean
    @Scope(value = "singleton")
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
