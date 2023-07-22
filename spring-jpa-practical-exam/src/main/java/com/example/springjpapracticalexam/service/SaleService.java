package com.example.springjpapracticalexam.service;


import com.example.springjpapracticalexam.entity.SaleEntity;

import java.util.List;

public interface SaleService {

    List<SaleEntity> getListSale();

    void createNewSale(SaleEntity saleEntity) throws Exception;

    void deleteSaleById(Long slNo) throws Exception;

    void addProductToSaleById(Long prodId, Long slNo) throws Exception;
}
