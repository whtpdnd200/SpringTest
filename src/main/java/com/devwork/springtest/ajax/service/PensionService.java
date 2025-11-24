package com.devwork.springtest.ajax.service;

import com.devwork.springtest.ajax.domain.Booking;
import com.devwork.springtest.ajax.repository.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PensionService {

    @Autowired
    private PensionRepository pensionRepository;

    public List<Booking> getBookingList() {

        return pensionRepository.selectBookingList();
    }

    // 1이면 정상삭제(true), 1이 아니면 삭제안됨(false)
    public boolean deleteBooking(int id) {

        return pensionRepository.deleteBooking(id) == 1;
    }

    // 예약정보 인서트
    // 1이면 정상삽임(true), 1이 아니면 삽입안됨(false)
    public boolean insertBooking(Booking booking) {

        return pensionRepository.insertBooking(booking) == 1;
    }
}
