package org.cyklon.tryoutspringboot.Mapper;

import org.cyklon.tryoutspringboot.DTO.ProductDTO;
import org.cyklon.tryoutspringboot.Model.Product;
import org.cyklon.tryoutspringboot.Repository.CategoryRepository;
import org.cyklon.tryoutspringboot.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public Product toEntity(ProductDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setBarcode(dto.getBarcode());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImageUrl());
        product.setQuantity(dto.getQuantity());
        product.setCategory(categoryRepository.findById(dto.getCategoryId()).orElse(null));
        product.setSupplier(supplierRepository.findById(dto.getSupplierId()).orElse(null));
        return product;
    }

    public ProductDTO toDTO(Product entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setBarcode(entity.getBarcode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setImageUrl(entity.getImageUrl());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setSupplierId(entity.getSupplier().getId());
        return dto;
    }
}
