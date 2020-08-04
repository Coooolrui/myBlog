package com.maruiya.service;

import com.maruiya.pojo.TimeLine;

import java.util.List;

/**
 * @Author MaRuiYa
 */
public interface TimeLineService {
    int addTimeLine(TimeLine timeLine);
    List<TimeLine> queryTimeLines();
}
