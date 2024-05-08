package org.perscholas.casestudy.database.dao;

import jakarta.transaction.Transactional;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface UserDAO extends JpaRepository<User, Long> {
    User findById(Integer id);

    User findByEmailIgnoreCase(String email);

    //Testing
    @Modifying
    @Transactional
    int deleteByEmail(String email);
}
