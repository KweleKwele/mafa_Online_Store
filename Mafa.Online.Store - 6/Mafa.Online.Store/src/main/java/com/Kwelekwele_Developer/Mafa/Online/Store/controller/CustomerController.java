package com.Kwelekwele_Developer.Mafa.Online.Store.controller;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Customer;
import com.Kwelekwele_Developer.Mafa.Online.Store.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public Customer registerCustomer(@Valid @RequestBody Customer customer) {

         return customerService.registerCustomer(customer);

    }

    @GetMapping("/list_customers")
    public List<Customer> getAllCustomer() {

        return customerService.findAll();

    }

    @DeleteMapping("/delete/{customerId}")
    public Optional<Customer> deleteCustomer(@PathVariable Integer customerId) {

        return customerService.deleteCustomer(customerId);

    }

    @GetMapping("/foo/id/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable Integer customerId) {

        return customerService.getCustomerById(customerId);

    }

    @GetMapping("/foo/email/{customerEmail}")
    public Optional<Customer> getCustomerByEmail(@PathVariable String customerEmail) {

        return customerService.getCustomerByEmail(customerEmail);
    }

    @GetMapping("/foo/username/{customerUsername}")
    public Optional<Customer> getCustomerByUsername(@PathVariable String customerUsername) {

        return customerService.getCustomerByUsername(customerUsername);

    }

    @PutMapping("/update/{CustomerId}")
    public Customer updateCustomer(@PathVariable Integer CustomerId, @RequestBody Customer customer) {

        return customerService.updateCustomer(CustomerId, customer);

    }


}
