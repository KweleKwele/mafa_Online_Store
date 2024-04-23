package com.Kwelekwele_Developer.Mafa.Online.Store.repository;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
