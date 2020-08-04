package com.maruiya.service;

import com.maruiya.pojo.Blog;

import java.util.List;

/**
 * @Author MaRuiYa
 */
public interface BlogService {
    int addBlog(Blog blog);
    List<Blog> queryBlogs();
    Blog queryBlogById(String id);
    int deleteBlog(String id);
    int updateBlog(Blog blog);

    //后台
    List<Blog> queryBlogsToShow();
    Blog queryBlogToShowById(String id);
    List<Blog> queryBlogToShowBykey(String key);
    int addViewNum(String id);
    List<Blog> queryBlogToShowHot();
}
