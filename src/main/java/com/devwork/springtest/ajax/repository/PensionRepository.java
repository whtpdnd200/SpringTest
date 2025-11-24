package com.devwork.springtest.ajax.repository;

import com.devwork.springtest.ajax.domain.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PensionRepository {

    public List<Booking> selectBookingList();

    public int deleteBooking(@Param("id") int id);

    public int insertBooking(Booking booking);

    public Booking selectBooking(@Param("name") String name, @Param("phoneNumber") String phoneNumber);
}
