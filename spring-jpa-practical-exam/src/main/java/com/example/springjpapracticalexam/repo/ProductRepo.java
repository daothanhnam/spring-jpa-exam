package com.example.springjpapracticalexam.repo;

import com.example.springjpapracticalexam.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByProdName(String prodName);

}
