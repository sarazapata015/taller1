package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Delivery;
import co.edu.poli.appcourses.persistence.entity.Order;
import co.edu.poli.appcourses.persistence.mapper.DeliveryDTO;
import co.edu.poli.appcourses.persistence.repository.CustomerRepository;
import co.edu.poli.appcourses.persistence.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;

    @Override
    public DeliveryDTO saved(DeliveryDTO deliveryDTO) {
        Delivery delivery = modelMapper.map(deliveryDTO, Delivery.class);

        if (delivery.getDuracion() >= 1 && delivery.getDuracion() <= 60) {
            deliveryRepository.save(delivery);
            return modelMapper.map(delivery, DeliveryDTO.class);
        }
        throw new IllegalArgumentException("La duración debe estar entre 1 y 60.");
    }

    @Override
    public List<DeliveryDTO> findAll() {
        List<Delivery> deliveries = deliveryRepository.findAll();

        return deliveries.stream()
                .map(delivery -> modelMapper.map(delivery, DeliveryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        deliveryRepository.deleteAll();
    }
}
