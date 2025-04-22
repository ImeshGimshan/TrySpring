package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
