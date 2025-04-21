package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
