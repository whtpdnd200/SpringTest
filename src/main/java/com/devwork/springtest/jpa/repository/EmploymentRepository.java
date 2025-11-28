package com.devwork.springtest.jpa.repository;

import com.devwork.springtest.jpa.domain.Employment;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Integer> {

    public List<Employment> findByCompanyId(int companyId);

    public List<Employment> findByPositionAndType(String position, String type);

    public List<Employment> findByTypeOrSalaryGreaterThanEqual(String type, int salary);

    public List<Employment> findTop3ByTypeOrderBySalaryDesc(String type);

    public List<Employment> findByRegionAndSalaryBetween(String region, int prevSalary, int nextSalary);

    @Query(value = "SELECT * FROM `employment` WHERE `deadline` > :deadLine AND `salary` >= :salary AND `type` = :type ORDER BY `salary` DESC", nativeQuery = true)
    public List<Employment> selectEmployment(@Param("deadLine") LocalDate deadLine, @Param("salary") int salary, @Param("type") String type);
}