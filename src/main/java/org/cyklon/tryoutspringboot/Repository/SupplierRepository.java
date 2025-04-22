package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
