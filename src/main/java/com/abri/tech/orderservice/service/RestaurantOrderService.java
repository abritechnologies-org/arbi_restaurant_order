package com.abri.tech.orderservice.service;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.entity.Order;
import com.abri.tech.orderservice.repo.RestaurantOrderRepo;
import com.abri.tech.orderservice.response.OrderDetailsResponse;
import com.abri.tech.orderservice.response.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Setter
@Getter
@Service
@Slf4j
public class RestaurantOrderService {

    private RestaurantOrderRepo restaurantOrderRepo;

    public OrderResponse saveOrder(RestaurantOrder restaurantOrder){

        var order = new Order();
        BeanUtils.copyProperties(restaurantOrder,order);
        var savedOrder = restaurantOrderRepo.save(order);

        var orderResponse = new OrderResponse();
        orderResponse.setOrderId(savedOrder.getId());
        orderResponse.setOrderDetails("Hi " + restaurantOrder.getCustomerName().toUpperCase()+
                ", your order for " +savedOrder.getMenuName()+ " will be delivered in 30 minutes");
        return orderResponse;
    }

    public List<OrderDetailsResponse> getAllOrders(){

        var allOrders = restaurantOrderRepo.findAll();
        log.info("Received order details for {} orders",allOrders.size());
        return allOrders.stream().map(order -> {
            var orderDetailsResponse = new OrderDetailsResponse();
            BeanUtils.copyProperties(order,orderDetailsResponse);
            return orderDetailsResponse;
        }).collect(Collectors.toList());

    }
}
