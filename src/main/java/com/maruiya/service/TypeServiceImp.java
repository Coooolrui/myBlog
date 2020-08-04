package com.maruiya.service;

import com.maruiya.mapper.TypeMapper;
import com.maruiya.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Service
public class TypeServiceImp implements TypeService{

    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> queryTypes() {
        return typeMapper.queryTypes();
    }

    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public Type queryTypeById(int id) {
        return typeMapper.queryTypeById(id);
    }

    @Override
    public int deleteType(int id) {
        return typeMapper.deleteType(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }
}
