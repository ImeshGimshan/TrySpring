package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
