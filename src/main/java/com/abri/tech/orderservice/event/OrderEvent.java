package com.abri.tech.orderservice.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderEvent {
    private String orderId;
    private String menu;
}