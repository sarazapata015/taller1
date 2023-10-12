package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Delivery;
import co.edu.poli.appcourses.persistence.entity.Order;
import co.edu.poli.appcourses.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public Order save(Order order) { return orderRepository.save(order);
    }
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    @Override
    public void deleteAll(){
        orderRepository.deleteAll();
    }

}
