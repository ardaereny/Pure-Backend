package com.ardaeren.bulutmdtest.Service;

import com.ardaeren.bulutmdtest.Domain.Order;
import com.ardaeren.bulutmdtest.Mapper.OrderMapper;
import com.ardaeren.bulutmdtest.Repository.AppUserRepo;
import com.ardaeren.bulutmdtest.Repository.OrderRepo;
import com.ardaeren.bulutmdtest.Request.OrderRequest;
import com.ardaeren.bulutmdtest.Response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepo orderRepo;
    private final AppUserRepo appUserRepo;

    public OrderResponse addOrder(OrderRequest orderRequest) {
        Order newOrder = orderMapper.requestToOrder(orderRequest);
        Order savedOrder = orderRepo.save(newOrder);
        return orderMapper.orderToResponse(savedOrder);
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        return orders.stream().map(orderMapper::orderToResponse).toList();
    }

    public List<OrderResponse>  getAllOrdersByAppUserName(String appUserName) {
        List<Order> orders = orderRepo.findByUser(appUserRepo.findByName(appUserName));
        return orders.stream().map(orderMapper::orderToResponse).toList();
    }

}
