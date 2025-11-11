package com.devwork.springtest.database.service;

import com.devwork.springtest.database.domain.Store;
import com.devwork.springtest.database.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// db와 직접 연결되는 모델(레포지토리) 와 연결 되는 객체 mvc2 패턴의 컨트롤러와 비슷?
@Service
public class StoreService {

    // 의존성 주입 어노테이션
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getStoreList()
    {
        List<Store> storeList = storeRepository.getStoreList();
        return storeList;
    }
}
