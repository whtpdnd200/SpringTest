package com.devwork.springtest.ajax.repository;

import com.devwork.springtest.ajax.domain.BookMark;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMarkRepository {

    public int insertBookMark(@Param("title") String title, @Param("url") String url);

    public List<BookMark> selectBookMarkList();

    public int selectCountUrl(@Param("url") String url);

    public int deleteBookMarkById(@Param("id") int id);

}
