package org.cyklon.tryoutspringboot.Service;


import org.cyklon.tryoutspringboot.DTO.ProductDTO;
import org.cyklon.tryoutspringboot.Mapper.ProductMapper;
import org.cyklon.tryoutspringboot.Model.Product;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductDTO createProduct(ProductDTO productDTO){
        return productMapper.toDTO(productRepository
                .save(productMapper.toEntity(productDTO)));
    }

    public ProductDTO getProductById(Long id){
        return productMapper.toDTO(productRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Product not found")));
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().
                stream().map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO updateProduct(Long id ,ProductDTO productDTO){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName((productDTO.getName()));
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(productMapper.toEntity(productDTO).getCategory());
        product.setSupplier(productMapper.toEntity(productDTO).getSupplier());
        return productMapper.toDTO(productRepository.save(product));
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
