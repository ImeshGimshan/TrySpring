package org.cyklon.tryoutspringboot.Controller;

import jakarta.validation.Valid;
import org.cyklon.tryoutspringboot.DTO.ProductDTO;
import org.cyklon.tryoutspringboot.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO createProduct (@Valid @RequestBody ProductDTO productDTO){
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
    public ProductDTO updateProduct (@PathVariable Long id,@Valid @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct (@PathVariable Long id){
        productService.delete(id);
    }
}