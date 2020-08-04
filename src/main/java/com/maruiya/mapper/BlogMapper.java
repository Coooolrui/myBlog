package com.maruiya.mapper;

import com.maruiya.pojo.Blog;
import com.maruiya.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Mapper
public interface BlogMapper {
    //后台
    int addBlog(Blog blog);
    List<Blog> queryBlogs();
    Blog queryBlogById(String id);
    int updateBlog(Blog blog);
    int deleteBlog(String id);

    //前端
    List<Blog> queryBlogsToShow();
    Blog queryBlogToShowById(String id);
    List<Blog> queryBlogToShowBykey(String key);
    int addViewNum(String id);
    List<Blog> queryBlogToShowHot();


}
