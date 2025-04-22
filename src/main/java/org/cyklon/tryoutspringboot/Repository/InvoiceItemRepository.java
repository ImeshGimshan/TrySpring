package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
