package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

     List<Product> findAllByProductGenderAndType(String productGender, String type);
     List<Product> findDistinctByProduct_name();
     List<Product> findProductByProduct_name(String productName);
}
