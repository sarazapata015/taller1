package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Delivery;
import co.edu.poli.appcourses.persistence.entity.Order;
import co.edu.poli.appcourses.persistence.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private  final DeliveryRepository deliveryRepository;
    @Override
    public Delivery save(Delivery delivery){
        if (delivery.getDuracion() >= 1 && delivery.getDuracion() <= 60) {
            deliveryRepository.save(delivery);
            return delivery;
        }
        return null;
    }
    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public void deleteAll(){
        deliveryRepository.deleteAll();
    }

}
