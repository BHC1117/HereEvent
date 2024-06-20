package com.multi.hereevent.event;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.ReserveDTO;
import com.multi.hereevent.dto.ReserveDTO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface EventService {
    //관리자페이지
    //행사 등록
    public int insertEvent(EventDTO event);
    //행사 수정
    public int updateEvent(EventDTO event);
    //행사 삭제
    public int deleteEvent(int event_no);

    //행사이름 검색
    public List<EventDTO> searchEvent(String keyword);
    //전체 팝업 조회
    public List<EventDTO> getAllEvent();

    //별점 높은순 10순위 리스트
    public List<EventDTO> getListByStarRank();
    //카테고리별 조회
    public List<EventDTO> selectEventByCategoryNo(int category_no);

    //오픈예정 행사
    public List<EventDTO> getOpenEvent();
    //예약,대기 높은순 10순위 리스트
    public List<EventDTO> getPopularEvent();


    //세부페이지
    public EventDTO getEventDetails(int event_no);
    //event image
    EventDTO getEventImage(int event_no);
    //예약하기
    public int insertReserve(ReserveDTO reservation);
    public ReserveDTO checkReserveOrder(int event_no, Date reserve_date, Time reserve_time);
    // 크롤링
    public int insertCrawlingEvent(EventDTO event);
    public int selectEventNoByEventName(String eventName);
}
