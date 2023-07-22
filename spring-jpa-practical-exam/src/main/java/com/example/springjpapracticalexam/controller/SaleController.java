package com.example.springjpapracticalexam.controller;

import com.example.springjpapracticalexam.entity.SaleEntity;
import com.example.springjpapracticalexam.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<SaleEntity> getListSale() {
        return saleService.getListSale();
    }

    @PostMapping("/create")
    public void createNewSale(@RequestBody SaleEntity saleEntity) throws Exception {
        saleService.createNewSale(saleEntity);
    }

    @DeleteMapping("/delete/{slNo}")
    public void deleteSaleById(@PathVariable Long slNo) throws Exception {
        saleService.deleteSaleById(slNo);
    }

    @PostMapping("/add-product-to-sale/prodId={prodId}/slNo={slNo}")
    public void addProductToSaleById(@PathVariable Long prodId ,@PathVariable Long slNo) throws Exception {
        saleService.addProductToSaleById(prodId, slNo);
    }
}
