package com.devwork.springtest.mvc.service;

import com.devwork.springtest.mvc.domain.Realtor;
import com.devwork.springtest.mvc.repository.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorService {

    @Autowired
    private RealtorRepository realtorRepository;

    public int createRealtor(Realtor realtor) {
        return realtorRepository.insertRealtor(realtor);
    }

    public Realtor getRealtorInfo(int id) {
        return realtorRepository.selectRealtorById(id);
    }
}
