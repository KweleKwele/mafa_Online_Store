package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.exception.*;
import com.Kwelekwele_Developer.Mafa.Online.Store.models.Address;
import com.Kwelekwele_Developer.Mafa.Online.Store.models.Customer;
import com.Kwelekwele_Developer.Mafa.Online.Store.repository.AddressDao;
import com.Kwelekwele_Developer.Mafa.Online.Store.repository.CustomerDao;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    //Injection
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    public CustomerServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    private EmailAlReadyInUse emailAlreadyInUse;

    //Constructor
    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {

        this.customerDao = customerDao;
    }

    @Override
    public Customer registerCustomer(Customer customer) {

        Customer newCustomer = new Customer();

        newCustomer.setUsername(customer.getUsername());
        newCustomer.setName(customer.getName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setSurname(customer.getSurname());
        newCustomer.setCellNumber(customer.getCellNumber());
        newCustomer.setPassword(customer.getPassword());

        for (int i = 0; i < customer.getAddressList().size(); i++) {

            customer.getAddressList().get(i).setCustomer(newCustomer);
            customer.getAddressList().add(customer.getAddressList().get(i));

        }

        Customer customerFoundByEmail = customerDao.findByEmail(newCustomer.getEmail());

        Customer customerFoundByUsername = customerDao.findByUsername(newCustomer.getUsername());

        if (customerFoundByEmail != null) {

            throw new EmailAlReadyInUse("Email Already in Use");

        } else if (customerFoundByUsername != null) {

            throw new UserNameAlreadyInUse("Username Already in Use");

        } else {

            customerDao.save(newCustomer);
        }
        return newCustomer;

    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {

        Optional<Customer> foundCustomer = customerDao.findById(id);

        if (foundCustomer.isPresent()) {

            Customer tempCustomer = foundCustomer.get();

            tempCustomer.setName(customer.getName());
            tempCustomer.setSurname(customer.getSurname());
            tempCustomer.setPassword(customer.getPassword());
            tempCustomer.setCellNumber(customer.getCellNumber());
            tempCustomer.setEmail(customer.getEmail());
            tempCustomer.setUsername(customer.getUsername());

            List<Address> updatedAddress = customer.getAddressList();

            if (updatedAddress != null && !updatedAddress.isEmpty()) {

                tempCustomer.getAddressList().clear();
                tempCustomer.getAddressList().addAll(updatedAddress);

            }

            return customerDao.save(tempCustomer);

        } else {
            throw new InvalidCustomerId("Customer not found with Id: " + id);
        }
    }

    @Override
    public Optional<Customer> deleteCustomer(int id) {
        Optional<Customer> tempCustomer = customerDao.findById(id);

        if (tempCustomer.isPresent()) {

            customerDao.deleteById(id);

        } else {
            throw new InvalidCustomerId("Invalid Customer Id....");
        }

        return tempCustomer;
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        Optional<Customer> tempCustomer = customerDao.findById(id);

        if (tempCustomer.isPresent()) {

            return tempCustomer;

        } else {
            throw new InvalidCustomerId("Invalid Customer Id....");
        }

    }

    @Override
    public Optional<Customer> getCustomerByUsername(String username) {

        Customer tempCustomer = customerDao.findByUsername(username);

        if (tempCustomer == null) {

            throw new InvalidUsername("Invalid Username");

        } else {

            return Optional.of(tempCustomer);
        }

    }

    public Optional<Customer> getCustomerByEmail(String email) {

        Customer tempCustomer = customerDao.findByEmail(email);

        if (tempCustomer == null) {

            throw new InvalidEmail("Invalid Email address");

        } else {

            return Optional.of(tempCustomer);
        }

    }

    @Override
    public List<Customer> findAll() {

        return customerDao.findAll();
    }
}
