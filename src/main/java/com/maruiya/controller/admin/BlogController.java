package com.maruiya.controller.admin;

import com.maruiya.Util.DateToStringUtil;
import com.maruiya.pojo.Blog;
import com.maruiya.service.BlogService;
import com.maruiya.service.TagService;
import com.maruiya.service.TypeService;
import com.maruiya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * @Author MaRuiYa
 */
@Controller
@RequestMapping("/admin123")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;
    @Autowired
    TypeService typeService;

    @Autowired
    UserService userService;

    @PostMapping("/addBlog")
    public String addBlog(Blog blog, HttpSession httpSession){
        //设置 博客状态
        blog.setStatus(1);
        //设置 用户id
        blog.setUserId(1);

        if (blog.isTop()){
            blog.setIsTop(1);
        }else {
            blog.setIsTop(0);
        }
        System.out.println("这是添加博客时的博客ID: "+blog.getId());
        if (blog.getId().equals("")){
            blog.setId(DateToStringUtil.getDateString());
            blogService.addBlog(blog);
        }else {
            blogService.updateBlog(blog);
        }
//        System.out.println("传入的博客信息"+blog);
        //设置 博客id
//        blog.setDescription("你猜");
//        System.out.println("输出blog提交信息"+blog);
//        System.out.println("置顶状态："+blog.isTop());
//        System.out.println(blog);
        return "redirect:/admin123/blogList";
    }

    @ResponseBody
    @PostMapping("/saveBlog")
    public String saveBlog(Blog blog){
        System.out.println(123123);
        System.out.println(0);
        blog.setStatus(0);
        if (blog.isTop()){
            blog.setIsTop(1);
        }else {
            blog.setIsTop(0);
        }
        blog.setUserId(1);
        System.out.println("测试添加时直接保存："+blog.getId());
        if (blog.getId().equals("")){
            blog.setId(DateToStringUtil.getDateString());
            blogService.addBlog(blog);
        }else {
            blogService.updateBlog(blog);
        }
//        return "redirect:/admin123/blogList";
        return "1";
    }

    @GetMapping("/blog/{id}/update")
    public String update(@PathVariable String id, Model model, Principal principal){
        Blog blog = blogService.queryBlogById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("type",typeService.queryTypes());
        model.addAttribute("tag", tagService.queryTags());
        model.addAttribute("usr", userService.getUserToShow(principal.getName()));
        if (blog.getIsTop() == 0){
            blog.setTop(false);
        }else {
            blog.setTop(true);
        }
        return "admin/blog-input";
    }

    @GetMapping("/blog/{id}/delete")
    public String delete(@PathVariable String id){
        blogService.deleteBlog(id);
        return "redirect:/admin123/blogList";
    }
}
