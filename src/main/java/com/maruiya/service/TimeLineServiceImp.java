package com.maruiya.service;

import com.maruiya.mapper.TimeLineMapper;
import com.maruiya.pojo.TimeLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Service
public class TimeLineServiceImp implements TimeLineService {

    @Autowired
    TimeLineMapper timeLineMapper;

    @Override
    public int addTimeLine(TimeLine timeLine) {
        return timeLineMapper.addTimeLine(timeLine);
    }

    @Override
    public List<TimeLine> queryTimeLines() {
        return timeLineMapper.queryTimeLines();
    }
}
