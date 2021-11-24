package com.abri.tech.orderservice.controller;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.response.OrderResponse;
import com.abri.tech.orderservice.service.RestaurantOrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Setter
@Getter
public class OrderController implements OrderApi {

    private RestaurantOrderService restaurantOrderService;

    public ResponseEntity<OrderResponse> createNewOrder(@RequestBody RestaurantOrder restaurantOrder) {

        restaurantOrderService.saveOrder(restaurantOrder);


        var orderResponse = OrderResponse.builder()
                .orderId(123)
                .orderDetails("Veg Burger Spicy")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

}
