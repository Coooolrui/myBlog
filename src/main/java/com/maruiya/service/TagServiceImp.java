package com.maruiya.service;

import com.maruiya.mapper.TagMapper;
import com.maruiya.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Service
public class TagServiceImp implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> queryTags() {
        return tagMapper.queryTags();
    }

    @Override
    public int addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    public Tag queryTagById(int id) {
        return tagMapper.queryTagById(id);
    }

    @Override
    public int deleteTag(int id) {
        return tagMapper.deleteTag(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }
}
