package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventroyRepository extends JpaRepository<Inventory, Long> {
}
