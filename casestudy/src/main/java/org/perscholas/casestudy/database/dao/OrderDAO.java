package org.perscholas.casestudy.database.dao;

import jakarta.transaction.Transactional;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
    @Query(
            value = "SELECT * FROM Order o WHERE o.Id = ?1",
            nativeQuery = true)
    Order findById(Integer id);

    @Query("SELECT o FROM Order o WHERE o.user.id = :id AND o.status = 'CART'")
    Order findByUser(int id);

    //Testing
    @Modifying
    @Transactional
    int deleteById(Integer id);
}
