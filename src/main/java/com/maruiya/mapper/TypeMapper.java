package com.maruiya.mapper;

import com.maruiya.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Mapper
public interface TypeMapper {
    List<Type> queryTypes();
    int addType(Type type);
    Type queryTypeById(int id);
    int deleteType(int id);
    int updateType(Type type);
}
