package com.maruiya.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author MaRuiYa
 */
@Data
public class Blog {
    private String id;
    private Integer userId;
    private String title;
    private String content;
    private String description;
    private String firstPic;
    private Integer typeId;
    private Integer tagId;
    private Integer status;
    private Integer views;
    private boolean top;
    private Integer isTop;
    private Date createTime;
    private Date updateTime;

    private Type type;
    private Tag tag;
    private String userName;
}
