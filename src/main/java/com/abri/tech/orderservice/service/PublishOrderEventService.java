package com.abri.tech.orderservice.service;


import com.abri.tech.orderservice.event.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishOrderEventService {
    public OrderEvent publishEvent(){
        var orderEvent = new OrderEvent("123", "Pizza");
        return orderEvent;
    }
}
