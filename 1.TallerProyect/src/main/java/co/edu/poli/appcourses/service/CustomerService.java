package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    List<Customer> findAll();
    void deleteAll();




}
