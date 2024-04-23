package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.exception.AddressNotFoundByThatId;
import com.Kwelekwele_Developer.Mafa.Online.Store.exception.EmailAlReadyInUse;
import com.Kwelekwele_Developer.Mafa.Online.Store.models.Address;
import com.Kwelekwele_Developer.Mafa.Online.Store.repository.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    //Methods

    @Override
    public List<Address> getCustomerAddresses(int customerId) {

        return addressDao.findAllByCustomerId(customerId);

    }

    @Override
    public List<Address> findAll() {

        return addressDao.findAll();
    }

    @Override
    public Address addAddress(Address address, int customerId) {

        return addressDao.save(address);
    }

    @Override
    public Address updateAddress(int addressId, Address updatedAddress) {
        return null;
    }

    @Override
    public Optional<Address> deleteAddress(int addressId) {

        Optional<Address> address = addressDao.findById(addressId);

        if (address.isPresent()) {

            addressDao.deleteById(addressId);

        } else {
            throw new AddressNotFoundByThatId("Address by that Id not found ......");
        }

        return address;
    }

    @Override
    public Optional<Address> getAddressById(int AddressId) {

        return addressDao.findById(AddressId);
    }

    @Override
    public List<Address> getAddressByCustomerEmail(String customerEmail) {

        List<Address> addressList = addressDao.findAll();

        List<Address> addresses = new ArrayList<>();

        for (int i = 0; i < addressList.size(); i++) {

            if (addressList.get(i).getCustomer().getEmail() == customerEmail) {

                addresses.add(addressList.get(i));
            } else {
                throw new EmailAlReadyInUse("Email not found in the Addresses");
            }

        }

        return addresses;
    }

}
