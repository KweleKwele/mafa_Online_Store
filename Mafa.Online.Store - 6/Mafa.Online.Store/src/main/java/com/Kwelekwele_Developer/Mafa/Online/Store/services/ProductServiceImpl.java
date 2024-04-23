package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.exception.ProductAlreadyExists;
import com.Kwelekwele_Developer.Mafa.Online.Store.exception.ProductNotFound;
import com.Kwelekwele_Developer.Mafa.Online.Store.models.Product;
import com.Kwelekwele_Developer.Mafa.Online.Store.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    //injection of ProductDao
    @Autowired
    private ProductDao productDao;

    //productDao Constructor
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    //methods
    @Override
    public Product addProduct(Product product) {

        Optional<Product> optionalProduct = productDao.findById(product.getId());

        if (optionalProduct.isPresent()) {

            throw new ProductAlreadyExists("Product with Id Already exists......");

        } else {

            productDao.save(product);

        }

        return product;
    }

    @Override
    public List<Product> findAll() {

        return productDao.findAll();
    }

    @Override
    public Optional<Product> getProductById(int productId) {

        Optional<Product> tempProduct = productDao.findById(productId);

        if (tempProduct.isPresent()) {

            return tempProduct;

        } else {

            throw new ProductNotFound("Product with Id " + productId + " not found......");

        }

    }

    @Override
    public Optional<Product> deleteProduct(int productId) {
        Optional<Product> tempProduct = productDao.findById(productId);

        if (tempProduct.isPresent()) {

            productDao.deleteById(productId);

        } else {

            throw new ProductNotFound("Product with Id " + productId + " not found......");
        }

        return tempProduct;
    }

    @Override
    public Product upDateProduct(int productId, Product updatedProduct) {

        Optional<Product> tempProduct = productDao.findById(productId);

        if (tempProduct.isPresent()) {
            Product existingProduct = tempProduct.get();

            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setColor(updatedProduct.getColor());
            existingProduct.setDimension(updatedProduct.getDimension());
            existingProduct.setManufacture(updatedProduct.getManufacture());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setSpecification(updatedProduct.getSpecification());

            return productDao.save(existingProduct);

        } else {
            throw new ProductNotFound("Product not found with Id" + productId);
        }

    }
}
