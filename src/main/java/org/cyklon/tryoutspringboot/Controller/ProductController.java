package org.cyklon.tryoutspringboot.Controller;

import lombok.RequiredArgsConstructor;
import org.cyklon.tryoutspringboot.Model.Product;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return  ResponseEntity.of(productRepository.findById(id));
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
