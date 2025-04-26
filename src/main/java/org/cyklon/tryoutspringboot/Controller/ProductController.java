package org.cyklon.tryoutspringboot.Controller;

import lombok.RequiredArgsConstructor;
import org.cyklon.tryoutspringboot.DTO.ProductDTO;
import org.cyklon.tryoutspringboot.Model.Product;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.cyklon.tryoutspringboot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDTO createProduct (@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct (@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable Long id){
        productService.delete(id);
    }
}