package com.devwork.springtest.ajax.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMarkRepository {

    public int insertBookMark(@Param("title") String title, @Param("url") String url);
}
