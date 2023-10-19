package co.edu.poli.appcourses.persistence.controller;


import co.edu.poli.appcourses.persistence.entity.Delivery;
import co.edu.poli.appcourses.persistence.mapper.CustomerDTO;
import co.edu.poli.appcourses.persistence.mapper.DeliveryDTO;
import co.edu.poli.appcourses.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public DeliveryDTO save(@RequestBody DeliveryDTO deliveryDTO) {
        DeliveryDTO savedDeliveryDTO = deliveryService.saved(deliveryDTO);
        return savedDeliveryDTO;
    }

    @GetMapping("getAllDelivery")
        public List<DeliveryDTO> findAll () {
            return deliveryService.findAll();
        }


        @DeleteMapping("deleteAllDelivery")
        public void deleteAll () {
            deliveryService.deleteAll();
        }

    }

