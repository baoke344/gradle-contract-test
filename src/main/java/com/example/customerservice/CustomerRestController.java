package com.example.customerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@RestController
@AllArgsConstructor
public class CustomerRestController {

    private final CustomerRepository customerRepository;
    @GetMapping("/customers")
    public Collection<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
