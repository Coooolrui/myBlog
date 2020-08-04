package com.maruiya.service;

import com.maruiya.pojo.Tag;
import com.maruiya.pojo.Type;

import java.util.List;

/**
 * @Author MaRuiYa
 */
public interface TypeService {
    List<Type> queryTypes();
    int addType(Type type);
    Type queryTypeById(int id);
    int deleteType(int id);
    int updateType(Type type);
}
