package com.devwork.springtest.database.repository;

import com.devwork.springtest.database.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreRepository {

    public List<Store> getStoreList();
}
