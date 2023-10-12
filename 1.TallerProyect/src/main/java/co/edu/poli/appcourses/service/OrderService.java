package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Order;


import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order save(Order order);
    List<Order> findAll();
    void deleteAll();
}
