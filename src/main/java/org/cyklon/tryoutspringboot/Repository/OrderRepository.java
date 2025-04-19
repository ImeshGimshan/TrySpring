package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
}
