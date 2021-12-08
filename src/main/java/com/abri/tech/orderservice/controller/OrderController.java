package com.abri.tech.orderservice.controller;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.response.OrderResponse;
import com.abri.tech.orderservice.response.RestaurantResponse;
import com.abri.tech.orderservice.service.RestaurantOrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Setter
@Getter
@Slf4j
public class OrderController implements OrderApi {

    private RestaurantOrderService restaurantOrderService;

    public ResponseEntity<OrderResponse> createNewOrder(@RequestBody RestaurantOrder restaurantOrder) {

        log.info("We received order from {} for {} ",
                restaurantOrder.getCustomerName(),
                restaurantOrder.getMenuName());

        var orderResponse = restaurantOrderService.saveOrder(restaurantOrder);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }


    public ResponseEntity<RestaurantResponse> getAllOrder() {
        var restaurantResponse = restaurantOrderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(restaurantResponse);
    }


    public ResponseEntity<RestaurantResponse> getOrder(@RequestParam(value="consumerName") String consumerName) {
        log.info("Restaurant Order for Customer Name {}", consumerName);
        var restaurantResponse = restaurantOrderService.getOrderForCustomer(consumerName);
        return  ResponseEntity.status(HttpStatus.OK).body(restaurantResponse);
    }

}
