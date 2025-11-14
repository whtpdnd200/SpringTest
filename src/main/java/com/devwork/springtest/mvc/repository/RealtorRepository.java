package com.devwork.springtest.mvc.repository;

import com.devwork.springtest.mvc.domain.Realtor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RealtorRepository {

    public int insertRealtor(Realtor realtor);

    public Realtor selectRealtorById(@Param("id") int id);
}
