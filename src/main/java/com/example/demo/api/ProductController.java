package com.example.demo.api;


import com.example.demo.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {



    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PostMapping(path = "/addMultiple")
    @CrossOrigin
    public ResponseEntity<List<Product>> addProducts(@RequestBody Product[] products) {
        List<Product> productsToAdd = new ArrayList<Product>();
        for (Product prod : products) {
            productsToAdd.add(prod);
        }
        return new ResponseEntity<List<Product>>(productService.addProducts(productsToAdd), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProductById(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{id}")
    @CrossOrigin
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product productToUpdate) {
        productService.updateProduct(id, productToUpdate);
        return new ResponseEntity<Product>(productToUpdate, HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    @CrossOrigin
    public ResponseEntity<List<Product>> getProductsByGenderAndType(@RequestParam String gender, @RequestParam String type) {
        return new ResponseEntity<>(productService.getProductByGenderAndType(gender, type), HttpStatus.OK);
    }
}
