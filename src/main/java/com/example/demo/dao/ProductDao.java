package com.example.demo.dao;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    Product insertProduct(Product product);

    List<Product> insertProducts(List<Product> products);

    List<Product> selectAllProducts();

    Optional<Product> selectProductById(int id);

    void deleteProductById(int id);

    Product updateProductById(int id, Product product);

    List<Product> selectProductsByGenderAndType(String gender, String type);
}
