package com.maruiya.service;

import com.maruiya.pojo.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MaRuiYa
 */
public interface TagService {
    List<Tag> queryTags();
    int addTag(Tag tag);
    Tag queryTagById(int id);
    int deleteTag(int id);
    int updateTag(Tag tag);
}
