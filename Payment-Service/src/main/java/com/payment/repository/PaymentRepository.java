package com.payment.repository;

import com.payment.entity.Payment;
import com.payment.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findAllByAuthId(int authId);
}
