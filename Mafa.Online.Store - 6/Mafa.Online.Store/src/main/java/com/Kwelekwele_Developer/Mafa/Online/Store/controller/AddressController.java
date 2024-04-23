package com.Kwelekwele_Developer.Mafa.Online.Store.controller;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Address;
import com.Kwelekwele_Developer.Mafa.Online.Store.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/list_addresses")
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @RequestMapping("/cal/{customerId}")
    public List<Address> getCustomerAddresses(@PathVariable Integer customerId) {

        return addressService.getCustomerAddresses(customerId);

    }

    @PostMapping("/add/Address/{customerId}")
    public Address addAddress(@Valid @RequestBody Address address, Integer customerId) {

        return addressService.addAddress(address, customerId);
    }

    @PutMapping("/update/{address_id}")
    public Address updateAddress (@PathVariable("id") Integer address_id , @RequestBody Address upDatedAddress) {

        return addressService.updateAddress(address_id, upDatedAddress);

    }

    @DeleteMapping("/delete/{addressId}")
    public Optional<Address> deleteAddress(@PathVariable Integer addressId) {

        return addressService.deleteAddress(addressId);

    }

    @RequestMapping("/address/{address_id}")
    Optional<Address> getAddressById(@PathVariable Integer address_id) {

        return addressService.getAddressById(address_id);

    }

    @RequestMapping("/customer/addresses/{customer_email}")
    List<Address> getCustomerAddresses(@PathVariable String customer_email) {

        return addressService.getAddressByCustomerEmail(customer_email);
    }

}
