package com.itvedant.MISandInvoicingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.MISandInvoicingSystem.entity.SubZone;



@Repository
public interface SubZoneRepository extends JpaRepository<SubZone, Integer> {
 
}
