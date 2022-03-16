package com.example.demo.dao;

import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("MYSQL3")
public class ProductDataAccessService implements ProductDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product insertProduct(Product product) {
        String sql = "insert into Products(product_id, product_name, quantity_in_stock, unit_price, Sexcategory_sex_id, Sizecategory_size_id, product_img_url)  values" +
                "('" + product.getProduct_id() +"'" +
                ", '" + product.getProduct_name() +"'" +
                ", '" + product.getQuantity_in_stock() +"'" +
                ", '" + product.getUnit_price() +"'" +
                ", '" + product.getSexcategory_sex_id() +"'" +
                ", '" + product.getSizecategory_size_id() +"'" +
                ", '" + product.getProduct_img_url() + "');";
        jdbcTemplate.update(sql);
        return null;
    }

    @Override
    public List<Product> selectAllProducts() {
        String sql = "select product_id, product_name, quantity_in_stock, unit_price, Sexcategory_sex_id, Sizecategory_size_id, product_img_url from Products;";
        List<Product> products = jdbcTemplate.query(sql, (resultSet, i) -> {
            int product_id = resultSet.getInt("product_id");
            String product_name = resultSet.getString("product_name");
            int quantity_in_stock = resultSet.getInt("quantity_in_stock");
            double unit_price = resultSet.getDouble("unit_price");
            int Sexcategory_sex_id = resultSet.getInt("Sexcategory_sex_id");
            int Sizecategory_size_id = resultSet.getInt("Sizecategory_size_id");
            String product_img_url = resultSet.getString("product_img_url");
            return new Product(product_id, product_name, quantity_in_stock, unit_price, Sexcategory_sex_id, Sizecategory_size_id, product_img_url);
        });
        return products;

    }

    @Override
    public Optional<Product> selectProductById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteProductById(int id) {

    }

    @Override
    public Product updateProductById(int id, Product product) {
        return null;
    }
}
