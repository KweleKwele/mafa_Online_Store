package com.Kwelekwele_Developer.Mafa.Online.Store.controller;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.Product;
import com.Kwelekwele_Developer.Mafa.Online.Store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping("/create")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    @GetMapping("/list")
    public List<Product> findAll() {

        return productService.findAll();

    }

    @GetMapping("id/{productId}")
    public Optional<Product> getProductById(@PathVariable Integer productId) {

        return productService.getProductById(productId);

    }

    @DeleteMapping("/delete/{productId}")
    public Optional<Product> deleteProduct(@PathVariable Integer productId) {

        return productService.deleteProduct(productId);

    }

    @PutMapping("/update/{productId}")
    public Product updateProduct(@PathVariable Integer productId, @RequestBody Product updatedProduct) {

        return productService.upDateProduct(productId, updatedProduct);

    }


}
