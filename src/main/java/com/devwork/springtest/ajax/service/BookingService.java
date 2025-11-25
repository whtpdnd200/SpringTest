package com.devwork.springtest.ajax.service;

import com.devwork.springtest.ajax.domain.Booking;
import com.devwork.springtest.ajax.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookingList() {

        return bookingRepository.selectBookingList();
    }

    // 1이면 정상삭제(true), 1이 아니면 삭제안됨(false)
    public boolean deleteBooking(int id) {

        return bookingRepository.deleteBooking(id) == 1;
    }

    // 예약정보 인서트
    // 1이면 정상삽임(true), 1이 아니면 삽입안됨(false)
    public boolean insertBooking(Booking booking) {

        booking.setState("대기중");
        return bookingRepository.insertBooking(booking) == 1;
    }

    // 예약 정보 확인
    public Booking selectBooking(String name, String phoneNumber) {

        return bookingRepository.selectBooking(name, phoneNumber);
    }
}
