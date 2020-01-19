package com.baeldung.spring.cloud.springcloudcontractconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Value("${endpoint}")
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }
}
