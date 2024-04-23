package com.Kwelekwele_Developer.Mafa.Online.Store.repository;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

    List<Address> findAllByCustomerId(int customerId);


}
