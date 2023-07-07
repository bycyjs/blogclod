package com.bycyjs.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("pattern")
public class Cyclostyle {
    private String dateformat;
}
