package co.edu.poli.appcourses.persistence.controller;


import co.edu.poli.appcourses.persistence.entity.Customer;
import co.edu.poli.appcourses.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer){

        return customerService.save(customer);
    }

    @GetMapping("getAllCustomer")
    public List<Customer> findAll() {

        return customerService.findAll();
    }

    @DeleteMapping("deleteAllCustomer")
    public void deleteAll() { customerService.deleteAll(); }

}
