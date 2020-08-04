package com.maruiya.mapper;

import com.maruiya.pojo.TimeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Mapper
public interface TimeLineMapper {
    int addTimeLine(TimeLine timeLine);
    List<TimeLine> queryTimeLines();
}
