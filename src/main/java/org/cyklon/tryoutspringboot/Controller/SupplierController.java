package org.cyklon.tryoutspringboot.Controller;

import jakarta.validation.Valid;
import org.cyklon.tryoutspringboot.DTO.SupplierDTO;
import org.cyklon.tryoutspringboot.Service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    public final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public SupplierDTO createSupplier(@Valid @RequestBody SupplierDTO supplierDTO){
        return supplierService.createSupplier(supplierDTO);
    }

    @GetMapping
    public List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDTO getSupplierById(@PathVariable Long id){
        return supplierService.getSupplierById(id);
    }

    @PutMapping("/{id}")
    public SupplierDTO updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDTO supplierDTO){
        return supplierService.updateSupplier(id, supplierDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id){
        supplierService.deleteSupplier(id);
    }
}
