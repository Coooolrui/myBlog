package com.maruiya.pojo;

import lombok.Data;
import java.util.Date;

/**
 * @Author MaRuiYa
 */
@Data
public class User {
    private Integer id;
    private String pic;
    private Date createTime;
    private Date update_time;
    private String qq;
    private String name;
    private String username;
    private String password;
    private String role;
}
