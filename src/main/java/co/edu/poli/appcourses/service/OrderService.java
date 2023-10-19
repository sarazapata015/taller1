package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Order;
import co.edu.poli.appcourses.persistence.mapper.OrderDTO;


import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderDTO saves(OrderDTO orderDTO);
    List<OrderDTO> findAll();
    void deleteAll();
}
