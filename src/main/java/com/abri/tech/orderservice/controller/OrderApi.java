package com.abri.tech.orderservice.controller;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.response.OrderResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/restaurant/v2")
@Tag(name="Restaurant order application")
@Api(tags = "Restaurant order application")
public interface OrderApi {
    @ApiOperation(value = "Create a new order for a customer")
    @ApiResponses(value = {@ApiResponse(code= 500, message = "Internal Server Error"),
            @ApiResponse(code= 200, message = "OK", response = String.class)})
    @PostMapping("/createOrder")
    ResponseEntity<OrderResponse> createNewOrder(@RequestBody RestaurantOrder restaurantOrder);

}
