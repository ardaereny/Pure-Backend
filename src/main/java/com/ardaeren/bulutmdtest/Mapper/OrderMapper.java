package com.ardaeren.bulutmdtest.Mapper;

import com.ardaeren.bulutmdtest.Domain.Order;
import com.ardaeren.bulutmdtest.Repository.AppUserRepo;
import com.ardaeren.bulutmdtest.Repository.RecipeRepo;
import com.ardaeren.bulutmdtest.Request.OrderRequest;
import com.ardaeren.bulutmdtest.Response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderMapper {

    private final RecipeRepo recipeRepo;
    private final AppUserRepo appUserRepo;


    public Order requestToOrder(OrderRequest orderRequest) {

        return Order.builder()
                .user(appUserRepo.findByName(orderRequest.getAppUserName()))
                .recipe(recipeRepo.findByName(orderRequest.getRecipeName()))
                .build();

    }

    public OrderResponse orderToResponse(Order order) {
        return OrderResponse.builder()
                .recipeName(order.getRecipe().getName())
                .orderId(order.getId())
                .appUserName(order.getUser().getName())
                .recipePrice(order.getRecipe().getPrice())
                .build();
    }

}
