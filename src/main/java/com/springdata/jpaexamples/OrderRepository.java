package com.springdata.jpaexamples;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByOrderStatus(OrderStatus orderStatus);
    List<Order> findAllByOrderStatusIn(List<OrderStatus> orderStatusList);
    List <Order> findOrdersByLocalDateBetween(LocalDate after, LocalDate before);
    Order  findOrderByProductTypeContainsAndLocalDateAfter(String productType, LocalDate after);
    List<Order> findTop3ByOrderByProductType();


    //in sql-> select from orders o where o.orderStatus = "PENDING"
    //query made using JPQL language (enhanced SQL)
    @Query(value = "SELECT o FROM Order o WHERE o.orderStatus = :orderStatus", nativeQuery = false)
    List<Order> findAllOrdersByOrderStatus(@Param("orderStatus") OrderStatus orderStatus);

}
