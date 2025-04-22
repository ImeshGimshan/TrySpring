package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
