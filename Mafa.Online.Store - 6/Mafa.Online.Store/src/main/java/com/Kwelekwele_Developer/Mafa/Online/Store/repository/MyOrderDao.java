package com.Kwelekwele_Developer.Mafa.Online.Store.repository;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.MyOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyOrderDao extends JpaRepository<MyOrders, Integer> {
}
