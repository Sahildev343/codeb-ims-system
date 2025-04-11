package com.itvedant.MISandInvoicingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.MISandInvoicingSystem.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}
