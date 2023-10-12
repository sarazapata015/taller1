package co.edu.poli.appcourses.service;

import co.edu.poli.appcourses.persistence.entity.Customer;
import co.edu.poli.appcourses.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        LocalDate today = LocalDate.now();
        LocalDate birthdate = customer.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period age = Period.between(birthdate, today);

        if (age.getYears() < 18) {
            throw new IllegalArgumentException("El cliente debe ser mayor de 18 años.");
        }

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteAll(){
        customerRepository.deleteAll();
    }

}
