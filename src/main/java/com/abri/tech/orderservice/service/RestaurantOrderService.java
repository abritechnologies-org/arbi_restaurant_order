package com.abri.tech.orderservice.service;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.entity.Order;
import com.abri.tech.orderservice.repo.RestaurantOrderRepo;
import com.abri.tech.orderservice.response.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Setter
@Getter
@Service
public class RestaurantOrderService {

    private RestaurantOrderRepo restaurantOrderRepo;

    public OrderResponse saveOrder(RestaurantOrder restaurantOrder){

        var order = new Order();
        BeanUtils.copyProperties(restaurantOrder,order);
        var savedOrder = restaurantOrderRepo.save(order);

        var orderResponse = new OrderResponse();
        orderResponse.setOrderId(savedOrder.getId());
        orderResponse.setOrderDetails(savedOrder.getMenuName()+ " will be delivered in 30 minutes");
        return orderResponse;
    }
}
