package com.guishengran.learning.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "hystrix")
public class HyStrixProperties {
    private int timeoutInMillions;
}
