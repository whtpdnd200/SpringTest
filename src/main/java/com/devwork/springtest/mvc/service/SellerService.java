package com.devwork.springtest.mvc.service;

import com.devwork.springtest.mvc.domain.Seller;
import com.devwork.springtest.mvc.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public int createUser(String name, String image, double temperature) {
        return sellerRepository.insertSeller(name, image, temperature);
    }

    public Seller getSeller(Integer id) {
        if(id != null && sellerRepository.selectSellerById(id) != null)
        {
            return sellerRepository.selectSellerById(id);
        }
        return sellerRepository.selectLastSeller();
    }
}
