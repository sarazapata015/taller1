package co.edu.poli.appcourses.persistence.controller;
import co.edu.poli.appcourses.persistence.entity.Customer;
import co.edu.poli.appcourses.persistence.entity.Delivery;
import co.edu.poli.appcourses.persistence.mapper.CustomerDTO;
import co.edu.poli.appcourses.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @PostMapping
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO savedCustomerDTO = customerService.save(customerDTO);
        return savedCustomerDTO;
    }

    @GetMapping("getAllCustomer")
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    @DeleteMapping("deleteAllCustomer")
    public void deleteAll() {
        customerService.deleteAll();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok("Cliente eliminado con éxito");
    }
}
