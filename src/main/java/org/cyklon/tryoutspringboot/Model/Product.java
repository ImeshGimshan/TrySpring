package org.cyklon.tryoutspringboot.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private Long barcode;

    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonManagedReference
    private Category category;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    @JsonManagedReference
    private Supplier supplier;
}
