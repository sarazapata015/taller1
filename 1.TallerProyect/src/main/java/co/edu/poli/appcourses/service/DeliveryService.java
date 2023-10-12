package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {

    Delivery save(Delivery delivery);

    List<Delivery> findAll();

    void deleteAll();

}
