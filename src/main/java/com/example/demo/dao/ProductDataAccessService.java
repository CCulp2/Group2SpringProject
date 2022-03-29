package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository("MYSQL3")
public class ProductDataAccessService implements ProductDao {

    private final ProductRepository productRepository;

    public ProductDataAccessService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> selectAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> selectProductById(int id) {
        Optional<Product> productToReturn = productRepository.findById(id);
        return productToReturn;
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteAllById(Collections.singleton(id));
    }

    @Override
    public Product updateProductById(int id, Product product) {
        Product productToUpdate = productRepository.getById(id);
        productToUpdate.setProduct_name(product.getProduct_name());
        productToUpdate.setQuantity_in_stock(product.getQuantity_in_stock());
        productToUpdate.setUnit_price(product.getUnit_price());
        productToUpdate.setProductSize(product.getProductSize());
        productToUpdate.setProductGender(product.getProductGender());
        productToUpdate.setProduct_img_url(product.getProduct_img_url());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setType(product.getType());
        return productToUpdate;
    }

    @Override
    public List<Product> selectProductsByGenderAndType(String gender, String type) {
        gender = gender.toUpperCase(Locale.ROOT);
        type = type.toUpperCase(Locale.ROOT);
        List<Product> results = productRepository.findAllByProductGenderAndType(gender, type);
        return results;
    }

}
