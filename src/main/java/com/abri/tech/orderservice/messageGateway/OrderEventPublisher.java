package com.abri.tech.orderservice.messageGateway;


import com.abri.tech.orderservice.event.OrderEvent;
import com.abri.tech.orderservice.service.PublishOrderEventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@AllArgsConstructor
@Slf4j
@Configuration
public class OrderEventPublisher {

    private PublishOrderEventService publishOrderEventService;

    @Bean
    public Supplier<OrderEvent> publishNewOrderEvent() {


        return () -> {
            var newOrderEvent = publishOrderEventService.publishEvent();
            return newOrderEvent;
        };
    }

}
