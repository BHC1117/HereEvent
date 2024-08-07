package com.multi.hereevent.reserve;

import com.multi.hereevent.dto.ReserveDTO;

import java.util.Map;

public interface ReserveDAO {
    int getReserveLimitByEventId(int event_no);
    int getReservedCountByEventId(Map<String, Object> params);
    void insertReservation(Map<String, Object> reservationInfo);
    int deleteReservation(Map<String, Object> params);
    void updateReservation(Map<String, Object> params);
    ReserveDTO selectReserve(Map<String, Object> params);
}
