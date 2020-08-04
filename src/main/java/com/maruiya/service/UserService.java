package com.maruiya.service;

import com.maruiya.pojo.User;

/**
 * @Author MaRuiYa
 * @Date 2020/8/3 11:09
 */
public interface UserService {
    User getUser(String username);
    User getUserToShow(String username);
}
