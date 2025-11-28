package com.devwork.springtest.jpa;

import com.devwork.springtest.jpa.domain.Employment;
import com.devwork.springtest.jpa.repository.EmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jpa/employment")
public class EmploymentController {


    @Autowired
    private EmploymentRepository employmentRepository;

    @ResponseBody
    @GetMapping("/info")
    public Optional<Employment> find() {

        return employmentRepository.findById(8);
    }

    @ResponseBody
    @GetMapping("/info-id")
    public List<Employment> findCompanyId(@RequestParam("companyId") int companyId) {

        return employmentRepository.findByCompanyId(companyId);
    }

    @ResponseBody
    @GetMapping("/info-where")
    public List<Employment> findColumn() {
        List<Employment> findList = new ArrayList<>();

        // findList = employmentRepository.findByPositionAndType("웹 back-end 개발자", "정규직");

        //findList = employmentRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);

        // findList = employmentRepository.findTop3ByTypeOrderBySalaryDesc("계약직");

        // findList = employmentRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);

        findList = employmentRepository.selectEmployment(LocalDate.of(2026,4,10), 8100, "정규직");
        return findList;
    }
}
