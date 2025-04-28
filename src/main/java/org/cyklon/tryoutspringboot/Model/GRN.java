package org.cyklon.tryoutspringboot.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="GRN")
@Getter
@Setter
public class GRN {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime receivedDate;

    private double total;

    @ManyToOne
    private Supplier supplier;

    @OneToMany(mappedBy = "grn" , cascade = CascadeType.ALL)
    private List<GRNItems> grnItems;

}
