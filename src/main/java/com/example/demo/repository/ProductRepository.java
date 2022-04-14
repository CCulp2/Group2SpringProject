package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

     List<Product> findAllByProductGenderAndType(String productGender, String type);
     List<Product> findAllByName(String product_Name);
     Product findFirstByName(String product_name);

     @Query("select distinct name from Product")
     List<String> findDistinctByName();

}
