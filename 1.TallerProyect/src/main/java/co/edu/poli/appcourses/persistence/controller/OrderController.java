package co.edu.poli.appcourses.persistence.controller;
import co.edu.poli.appcourses.persistence.entity.Order;
import co.edu.poli.appcourses.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order save(@RequestBody Order order){ return orderService.save(order);}

    @GetMapping("getAllOrder")
    public List<Order> findAll() {
    return orderService.findAll();
    }

    @DeleteMapping("deleteAllOrder")
    public void deleteAll(){ orderService.deleteAll();}

}
