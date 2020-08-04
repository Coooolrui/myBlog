package com.maruiya.mapper;

import com.maruiya.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author MaRuiYa
 */
@Mapper
public interface UserMapper {
    User getUser(String username);
    User getUserToShow(String username);
}
