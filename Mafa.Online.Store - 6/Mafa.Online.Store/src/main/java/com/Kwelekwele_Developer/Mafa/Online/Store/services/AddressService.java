package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> getCustomerAddresses(int customerId);

    List<Address> findAll();

    Address addAddress(Address address, int CustomerId);

    Address updateAddress(int addressId, Address updatedAddress);

    Optional<Address> deleteAddress(int addressId);

    Optional<Address> getAddressById(int AddressId);

    List<Address> getAddressByCustomerEmail(String customerEmail);

}
