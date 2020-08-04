package com.maruiya.mapper;

import com.maruiya.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Mapper
public interface TagMapper {
    List<Tag> queryTags();
    int addTag(Tag tag);
    Tag queryTagById(int id);
    int deleteTag(int id);
    int updateTag(Tag tag);
}
