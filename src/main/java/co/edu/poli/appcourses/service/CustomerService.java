package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Customer;
import co.edu.poli.appcourses.persistence.mapper.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO save(CustomerDTO customerDTO); // Cambio aquí
    List<CustomerDTO> findAll(); // Cambio aquí
    void deleteAll();
    void deleteCustomerById(Long customerId);



}
