package com.abri.tech.orderservice.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    @NonNull
    @Schema(description = "The order id for the customer's order")
    private Long orderId;
    @NonNull
    @Schema(description = "The order details")
    private String orderDetails;
}
