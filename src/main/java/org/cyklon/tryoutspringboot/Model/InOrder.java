package org.cyklon.tryoutspringboot.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="inorder")
@Getter
@Setter
public class InOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private GRN grn;

    @ManyToOne
    private Product product;

    private int quantityReceived;
    private double unitCost;
}
