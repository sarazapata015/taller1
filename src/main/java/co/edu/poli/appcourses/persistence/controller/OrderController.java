package co.edu.poli.appcourses.persistence.controller;
import co.edu.poli.appcourses.persistence.entity.Order;
import co.edu.poli.appcourses.persistence.mapper.OrderDTO;
import co.edu.poli.appcourses.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<OrderDTO> saves(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrderDTO = orderService.saves(orderDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDTO);
    }


    @GetMapping("getAllOrder")
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @DeleteMapping("deleteAllOrder")
    public void deleteAll() {
        orderService.deleteAll();
    }
}

