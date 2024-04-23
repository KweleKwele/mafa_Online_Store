package com.Kwelekwele_Developer.Mafa.Online.Store.repository;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    Customer findByEmail(String email);

    Customer findByUsername(String username);
}
