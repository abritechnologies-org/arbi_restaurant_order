package com.abri.tech.orderservice.controller;

import com.abri.tech.orderservice.dto.RestaurantOrder;
import com.abri.tech.orderservice.response.OrderResponse;
import com.abri.tech.orderservice.response.RestaurantResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Restaurant order application")
@RequestMapping("/restaurant/v2")
@OpenAPIDefinition
public interface OrderApi {
    @Operation(summary = "Create a new order for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode= "500", description = "Internal Server Error"),
            @ApiResponse(responseCode= "200", description = "OK" )})
    @PostMapping("/createOrder")
    ResponseEntity<OrderResponse> createNewOrder(@RequestBody RestaurantOrder restaurantOrder);

    @Operation(summary = "Get all orders placed in the restaurant")
    @ApiResponses(value = {@ApiResponse(responseCode= "500", description = "Internal Server Error"),
            @ApiResponse(responseCode= "200", description = "OK")})
    @GetMapping("/getAllOrder")
    ResponseEntity<RestaurantResponse> getAllOrder();

    @Operation(summary = "Get latest order placed by customer")
    @ApiResponses(value = {@ApiResponse(responseCode= "500", description = "Internal Server Error"),
            @ApiResponse(responseCode= "200", description = "OK")})
    @GetMapping("/getOrder")
    ResponseEntity<RestaurantResponse> getOrder(
            @Parameter(description = "Customer name who placed the order",  required = true)
            @RequestParam(value= "customerName") String customerName);

    @Operation(summary = "Modify order for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode= "500", description = "Internal Server Error"),
            @ApiResponse(responseCode= "200", description = "OK")})
    @PutMapping("/modifyOrder")
    ResponseEntity<RestaurantResponse> modifyOrder(@RequestBody RestaurantOrder restaurantOrder);

    @Operation(summary = "Delete order for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode= "500", description = "Internal Server Error"),
            @ApiResponse(responseCode= "200", description = "OK")})
    @DeleteMapping("/deleteOrder")
    ResponseEntity<String> deleteOrder(@RequestBody String orderId);

}
