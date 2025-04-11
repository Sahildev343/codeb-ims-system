package com.itvedant.MISandInvoicingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.MISandInvoicingSystem.entity.Brand;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
