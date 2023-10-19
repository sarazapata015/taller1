package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Delivery;
import co.edu.poli.appcourses.persistence.mapper.CustomerDTO;
import co.edu.poli.appcourses.persistence.mapper.DeliveryDTO;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {

    DeliveryDTO saved(DeliveryDTO deliveryDTO); // Cambio aquí
    List<DeliveryDTO> findAll(); // Cambio aquí
    void deleteAll();




}
