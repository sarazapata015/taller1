package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Customer;
import co.edu.poli.appcourses.persistence.mapper.CustomerDTO;
import co.edu.poli.appcourses.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        LocalDate today = LocalDate.now();
        LocalDate birthdate = customer.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period age = Period.between(birthdate, today);

        if (age.getYears() < 18) {
            throw new IllegalArgumentException("El cliente debe ser mayor de 18 años.");
        }

        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll(){
        customerRepository.deleteAll();
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }
    }