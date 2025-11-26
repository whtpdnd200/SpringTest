package com.devwork.springtest.jpa;

import com.devwork.springtest.jpa.domain.Company;
import com.devwork.springtest.jpa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/jpa/test01")
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ResponseBody
    @GetMapping("/add")
    public List<Company> add() {

        List<Company> companyList = new ArrayList<>();

        companyList.add(companyService.createCompany("넥손", "컨텐츠 게임", "대기업", 3585));

        companyList.add(companyService.createCompany("버블팡", "여신 금융업", "대기업", 6834));

        return companyList;
    }


    @ResponseBody
    @GetMapping("/modify")
    public Company modifyCompany() {

        return companyService.updateCompany(8, "중소기업", 34);
    }

    @ResponseBody
    @GetMapping("/remove")
    public String removeCompany() {

        companyService.deleteCompany(8);

        return "실행 완료";
    }
}
