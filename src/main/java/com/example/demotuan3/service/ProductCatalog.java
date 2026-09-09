package com.example.demotuan3.service;
import jakarta.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.example.demotuan3.model.Product;
@ApplicationScoped
public class ProductCatalog {
    private final List<Product> products = List.of(
            new Product(1, "Laptop", new BigDecimal("1500.00")),
            new Product(2, "Keyboard", new BigDecimal("80.00")),
            new Product(3, "Mouse", new BigDecimal("40.00"))
    );
    public List<Product> findAll() {
        return products;
    }
    public Optional<Product> findById(long id) {
        return products.stream().filter(product -> product.getId()  == id).findFirst();
    }
}
