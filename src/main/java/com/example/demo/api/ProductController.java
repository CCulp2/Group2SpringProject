package com.example.demo.api;


import com.example.demo.service.ProductService;
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

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
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
}
