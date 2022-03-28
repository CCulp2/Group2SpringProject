package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("MYSQL3") ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(Product product) {
        return productDao.insertProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDao.selectAllProducts();
    }

    public Optional<Product> getProductById(int id) {
        return productDao.selectProductById(id);
    }

    public void deleteProduct(int id) {
        productDao.deleteProductById(id);
    };

    public Product updateProduct(int id, Product newProduct) {
        return productDao.updateProductById(id, newProduct);
    }
}