package com.abri.tech.orderservice.controller;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.response.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    public ResponseEntity<OrderResponse> createNewOrder(@RequestBody RestaurantOrder restaurantOrder) {

        //ToDo : Need to implement business logic

        var orderResponse = OrderResponse.builder()
                .orderId(123)
                .orderDetails("Veg Burger Spicy")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

}
