package co.edu.poli.appcourses.persistence.controller;


import co.edu.poli.appcourses.persistence.entity.Delivery;
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
    public Delivery save(Delivery delivery){ return deliveryService.save(delivery);}

    @GetMapping("getAllDelivery")
    public List<Delivery> findAll() {
        return deliveryService.findAll();
    }


    @DeleteMapping("deleteAllDelivery")
    public void deleteAll(){
        deliveryService.deleteAll();}


}
