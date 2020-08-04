package com.maruiya.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maruiya.pojo.Blog;
import com.maruiya.pojo.Tag;
import com.maruiya.pojo.Type;
import com.maruiya.pojo.User;
import com.maruiya.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

/**
 * @Author MaRuiYa
 */
@Controller
@RequestMapping("/admin123")
public class AdminPageController {

    @Autowired
    TagService tagService;

    @Autowired
    TypeService typeService;

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @GetMapping("/blogList")
    public String blogList(@RequestParam(value = "page",required = false) Integer page, Model model, Principal principal){
        if (page==null){
            page=1;
        }
        PageHelper.startPage(page, 5);
        List<Blog> blogs = blogService.queryBlogs();
//        System.out.println(blogs.get(1).getTitle()+"=============="+blogs.get(1).getUpdateTime());
        PageInfo pageInfo = new PageInfo(blogs);
        model.addAttribute("page", pageInfo);
        model.addAttribute("type", typeService.queryTypes());
        User usr = userService.getUserToShow(principal.getName());
        System.out.println(usr);
        model.addAttribute("usr", usr);

        return "admin/blog-list";
    }


    @GetMapping("/blogInput")
    public String blogInput(Model model, Principal principal){
        model.addAttribute("type",typeService.queryTypes());
        model.addAttribute("tag", tagService.queryTags());
        model.addAttribute("blog", new Blog());
        User usr = userService.getUserToShow(principal.getName());
        model.addAttribute("usr", usr);
        return "admin/blog-input";
    }

    @GetMapping("/tagList")
    public String tagList(@RequestParam(value = "page",required = false) Integer page, Model model, Principal principal){
        if (page==null){
            page=1;
        }
        PageHelper.startPage(page, 5);
        List<Tag> tags = tagService.queryTags();
        PageInfo pageInfo = new PageInfo(tags);
        model.addAttribute("page", pageInfo);
        User usr = userService.getUserToShow(principal.getName());
        model.addAttribute("usr", usr);
        return "admin/tag-list";
    }

    @GetMapping("/tagInput")
    public String tagInput(Model model, Principal principal){
        model.addAttribute("tag", new Tag());
        User usr = userService.getUserToShow(principal.getName());
        model.addAttribute("usr", usr);
        return "admin/tag-input";
    }

    @GetMapping("/typeList")
    public String typeList(@RequestParam(value = "page",required = false) Integer page, Model model, Principal principal){
        if (page==null){
            page=1;
        }
        PageHelper.startPage(page, 5);
        List<Type> types = typeService.queryTypes();
        PageInfo pageInfo = new PageInfo(types);
        model.addAttribute("page", pageInfo);
        User usr = userService.getUserToShow(principal.getName());
        model.addAttribute("usr", usr);
        return "admin/type-list";
    }

    @GetMapping("/typeInput")
    public String typeInput(Model model, Principal principal){
        model.addAttribute("type", new Type());
        User usr = userService.getUserToShow(principal.getName());
        model.addAttribute("usr", usr);
        return "admin/type-input";
    }
}
