package org.cyklon.tryoutspringboot.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="grnItems")
@Getter
@Setter
public class GRNItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantityReceived;
    private double unitCost;

    @ManyToOne
    private GRN grn;

    @ManyToOne
    private Product product;
}
