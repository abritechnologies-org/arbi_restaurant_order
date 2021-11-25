package com.abri.tech.orderservice.service;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.entity.Order;
import com.abri.tech.orderservice.repo.RestaurantOrderRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Setter
@Getter
@Service
public class RestaurantOrderService {

    private RestaurantOrderRepo restaurantOrderRepo;

    public RestaurantOrder saveOrder(RestaurantOrder restaurantOrder){

        var order = new Order();
        //RestaurantOrder.java  ->  Order.java
        order.setCustomerName(restaurantOrder.getCustomerName());
        order.setMenuName(restaurantOrder.getMenuName());

        //BeanUtils.copyProperties(restaurantOrder,order);
        var savedOrder = restaurantOrderRepo.save(order);

        var savedOrderDto = new RestaurantOrder();
        savedOrderDto.setCustomerName(savedOrder.getCustomerName());
        savedOrderDto.setMenuName(savedOrder.getMenuName());

        //BeanUtils.copyProperties(savedOrder,savedOrderDto);
        return savedOrderDto;
    }
}
