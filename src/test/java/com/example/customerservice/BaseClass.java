package com.example.customerservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@SpringBootTest(classes = CustomerServiceApplication.class)
public abstract class BaseClass {

    @Autowired
    private CustomerRestController customerRestController;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        Mockito.when(this.customerRepository.findAll())
                .thenReturn(Arrays.asList(new Customer(1, "Jane"),
                        new Customer(2, "Bin"),
                        new Customer(3, "Bob")));

        RestAssuredMockMvc.standaloneSetup(this.customerRestController);
    }
}
