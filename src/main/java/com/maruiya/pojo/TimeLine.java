package com.maruiya.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author MaRuiYa
 */
@Data
public class TimeLine {
    private String id;
    private Integer userId;
    private Date time;
    private String description;
}
