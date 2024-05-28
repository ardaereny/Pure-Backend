package com.ardaeren.bulutmdtest.Repository;

import com.ardaeren.bulutmdtest.Domain.AppUser;
import com.ardaeren.bulutmdtest.Domain.Order;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findByUser(AppUser user);
}
