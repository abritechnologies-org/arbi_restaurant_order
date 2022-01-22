package com.abri.tech.orderservice.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@Getter
@Setter
public class OrderProperties {

    @Value("${message:Hello default}")
    public String message;
}
