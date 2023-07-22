package com.example.springjpapracticalexam.repo;

import com.example.springjpapracticalexam.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends JpaRepository<SaleEntity, Long> {
}
