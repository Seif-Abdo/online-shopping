package org.perscholas.casestudy.database.dao;

import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByProduct(Product product);

    @Query("SELECT od FROM OrderDetail od WHERE od.order.id = :orderId AND od.product.id = :productId")
    OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId);

    List<OrderDetail> findByOrderId(Integer orderId);
}
