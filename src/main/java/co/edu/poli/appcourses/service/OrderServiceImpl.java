package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Delivery;
import co.edu.poli.appcourses.persistence.entity.Order;
import co.edu.poli.appcourses.persistence.mapper.OrderDTO;
import co.edu.poli.appcourses.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper; // Agrega ModelMapper

    @Override
    public OrderDTO saves(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDTO.class)) // Convierte las entidades a DTOs
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
