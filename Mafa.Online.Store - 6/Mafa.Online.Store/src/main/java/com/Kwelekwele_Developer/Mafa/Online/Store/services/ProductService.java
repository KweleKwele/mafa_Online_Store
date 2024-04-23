package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> findAll();

    Optional<Product> getProductById(int productId);

    Optional<Product> deleteProduct(int productId);

    Product upDateProduct(int productId, Product updatedProduct);




}
