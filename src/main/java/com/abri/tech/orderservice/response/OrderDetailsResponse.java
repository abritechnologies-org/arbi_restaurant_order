package com.abri.tech.orderservice.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsResponse {

    @Schema(description = "Customer who placed the order")
    private String customerName;
    @Schema(description = "Order placed")
    private String menuName;
}
