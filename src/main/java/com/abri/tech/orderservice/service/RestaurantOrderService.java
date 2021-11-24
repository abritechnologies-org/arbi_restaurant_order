package com.abri.tech.orderservice.service;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.entity.Order;
import com.abri.tech.orderservice.repo.RestaurantOrderRepo;
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

    public RestaurantOrder saveOrder(RestaurantOrder restaurantOrder){

        var order = new Order();
        BeanUtils.copyProperties(restaurantOrder,order);
        var savedOrder = restaurantOrderRepo.save(order);
        var savedOrderDto = new RestaurantOrder();
        BeanUtils.copyProperties(savedOrder,savedOrderDto);
        return savedOrderDto;
    }
}
