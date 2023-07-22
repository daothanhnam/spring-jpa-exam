package com.example.springjpapracticalexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long slNo;
    private Long salesmanId;
    private String salesmanName;
    private String dos;
    @ManyToOne
    private ProductEntity productEntity;
}
