package com.ardaeren.bulutmdtest.Response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {

    private Long orderId;

    private String appUserName;

    private String recipeName;

    private String recipePrice;

}
