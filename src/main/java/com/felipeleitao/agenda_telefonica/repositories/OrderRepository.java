package com.felipeleitao.agenda_telefonica.repositories;

import com.felipeleitao.agenda_telefonica.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
