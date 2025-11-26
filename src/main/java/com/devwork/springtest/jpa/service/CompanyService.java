package com.devwork.springtest.jpa.service;

import com.devwork.springtest.jpa.domain.Company;
import com.devwork.springtest.jpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(String name, String business, String scale, int headcount) {

        Company company = Company.builder()
                .name(name)
                .business(business)
                .scale(scale)
                .headcount(headcount)
                .build();

        return companyRepository.save(company);
    }

    public Company updateCompany(int id, String scale, int headcount) {

        Optional<Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company = company.toBuilder()
                    .scale(scale)
                    .headcount(headcount)
                    .build();
            return companyRepository.save(company);
        } else {
            return null;
        }
    }

    public void deleteCompany(int id) {

        Optional<Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            companyRepository.delete(company);
        } else {

        }
    }
}
