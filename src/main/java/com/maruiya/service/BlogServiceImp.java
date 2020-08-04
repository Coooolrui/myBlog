package com.maruiya.service;

import com.maruiya.mapper.BlogMapper;
import com.maruiya.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MaRuiYa
 */
@Service
public class BlogServiceImp implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public int addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }

    @Override
    public List<Blog> queryBlogs() {
        return blogMapper.queryBlogs();
    }

    @Override
    public Blog queryBlogById(String id) {
        return blogMapper.queryBlogById(id);
    }

    @Override
    public int deleteBlog(String id) {
        return blogMapper.deleteBlog(id);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public List<Blog> queryBlogsToShow() {
        return blogMapper.queryBlogsToShow();
    }

    @Override
    public Blog queryBlogToShowById(String id) {
        return blogMapper.queryBlogToShowById(id);
    }

    @Override
    public List<Blog> queryBlogToShowBykey(String key) {
        return blogMapper.queryBlogToShowBykey(key);
    }

    @Override
    public int addViewNum(String id) {
        return blogMapper.addViewNum(id);
    }

    @Override
    public List<Blog> queryBlogToShowHot() {
        return blogMapper.queryBlogToShowHot();
    }
}
