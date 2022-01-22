package com.abri.tech.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@Schema(description = "The restaurant order")
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOrder {

    @NonNull
    @Schema(description = "Order Id")
    private String orderId;
    @NonNull
    @Schema(description ="Customer  Name")
    private String customerName;
    @NonNull
    @Schema(description = "The food item that customer has ordered")
    private String menuName;

}
