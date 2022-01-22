package com.abri.tech.orderservice.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class RestaurantResponse {
    @Schema(description = "Message related to order status")
    private String message;
    @Schema(description = "All the orders placed by the customer")
    private List<OrderDetailsResponse> orderDetailsResponse;
    @Schema(description = "Order updated or deleted by customer")
    private OrderResponse orderDetails;
}
