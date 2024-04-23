package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer registerCustomer(Customer customer);

    Customer updateCustomer(int id, Customer customer);

    Optional<Customer> deleteCustomer(int id);

    Optional<Customer> getCustomerById(int id);

    List<Customer> findAll();

    Optional<Customer> getCustomerByEmail(String email);

    Optional<Customer> getCustomerByUsername(String username);

}
