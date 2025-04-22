package org.cyklon.tryoutspringboot.Repository;

import org.cyklon.tryoutspringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
