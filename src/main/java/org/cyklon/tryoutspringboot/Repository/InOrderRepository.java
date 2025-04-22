package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.InOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InOrderRepository extends JpaRepository<InOrder, Long> {
}
