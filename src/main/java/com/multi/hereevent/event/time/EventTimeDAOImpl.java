package com.multi.hereevent.event.time;

import com.multi.hereevent.dto.EventTimeDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventTimeDAOImpl implements EventTimeDAO {
    private final SqlSession sqlSession;

    @Override
    public int insertEventTimeList(List<EventTimeDTO> eventTimeList) {
        return sqlSession.insert("com.multi.hereevent.event.time.insertEventTimeList", eventTimeList);
    }

    @Override
    public EventTimeDTO getEventTimeByEventNoAndDay(int event_no, String day) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("event_no",event_no);
        param.put("day",day);
        return sqlSession.selectOne("com.multi.hereevent.event.time.getEventTimeByEventNo", param);
    }
}
