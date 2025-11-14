package com.devwork.springtest.mvc.service;

import com.devwork.springtest.mvc.domain.Realtor;
import com.devwork.springtest.mvc.repository.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorService {

    @Autowired
    private RealtorRepository realtorRepository;

    public Realtor createRealtor(String office, String phoneNumber, String address, String grade) {
        Realtor realtor = new Realtor();
        realtor.setOffice(office);
        realtor.setPhoneNumber(phoneNumber);
        realtor.setAddress(address);
        realtor.setGrade(grade);
        int count = realtorRepository.insertRealtor(realtor);
        if(count != 1)
        {
            return null;
        }
        return getRealtorInfo(realtor.getId());
    }

    public Realtor getRealtorInfo(int id) {
        return realtorRepository.selectRealtorById(id);
    }
}
