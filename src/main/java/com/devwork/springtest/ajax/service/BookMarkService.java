package com.devwork.springtest.ajax.service;

import com.devwork.springtest.ajax.domain.BookMark;
import com.devwork.springtest.ajax.repository.BookMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMarkService {

    @Autowired
    private BookMarkRepository bookMarkRepository;

    public int createBookMark(String title, String url) {

        return bookMarkRepository.insertBookMark(title, url);
    }

    public List<BookMark> getBookMarkList() {

        return bookMarkRepository.selectBookMarkList();
    }

    // 0이 아니면 중복(true), 0이면 중복이 아님(false)
    public boolean isDuplicateUrl(String url) {

        return bookMarkRepository.selectCountUrl(url) != 0;
    }

    // 1이면 삭제 완료(true), 1이 아니면 삭제 실패(false)
    public boolean deleteBookMarkById(int id) {

        return bookMarkRepository.deleteBookMarkById(id) == 1;
    }
}
