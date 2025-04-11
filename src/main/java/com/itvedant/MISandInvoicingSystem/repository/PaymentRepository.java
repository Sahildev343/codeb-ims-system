package com.itvedant.MISandInvoicingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.MISandInvoicingSystem.entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
