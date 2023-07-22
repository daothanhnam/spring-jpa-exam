package com.example.springjpapracticalexam.service.impl;

import com.example.springjpapracticalexam.entity.ProductEntity;
import com.example.springjpapracticalexam.entity.SaleEntity;
import com.example.springjpapracticalexam.repo.ProductRepo;
import com.example.springjpapracticalexam.repo.SaleRepo;
import com.example.springjpapracticalexam.service.SaleService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepo saleRepo;
    private final ProductRepo productRepo;

    @Autowired
    public SaleServiceImpl(SaleRepo saleRepo, ProductRepo productRepo) {
        this.saleRepo = saleRepo;
        this.productRepo = productRepo;
    }

    @Override
    public List<SaleEntity> getListSale() {
        return saleRepo.findAll();
    }

    @Override
    public void createNewSale(SaleEntity saleEntity) throws Exception {

        if (ObjectUtils.isEmpty(saleEntity)) {
            throw new Exception("saleEntity is null");
        }

        saleRepo.save(saleEntity);
    }

    @Override
    public void deleteSaleById(Long slNo) throws Exception {
        if (ObjectUtils.isEmpty(slNo)) {
            throw new Exception("slNo is empty!");
        }

        saleRepo.deleteById(slNo);

    }

    @Override
    public void addProductToSaleById(Long prodId, Long slNo) throws Exception {
        Optional<ProductEntity> productOptional = productRepo.findById(prodId);
        Optional<SaleEntity> saleOptional = saleRepo.findById(slNo);

        if (!productOptional.isPresent() || !saleOptional.isPresent()) {
            throw new Exception("product hoac sale khong ton tai");
        }

        ProductEntity product = productOptional.get();
        SaleEntity sale = saleOptional.get();

        sale.setProductEntity(product);
        saleRepo.save(sale);
    }
}
