package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Products, Long> {
}
