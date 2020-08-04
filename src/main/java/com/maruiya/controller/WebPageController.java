package com.maruiya.controller;

import com.maruiya.Util.TimeLineByTypeUtil;
import com.maruiya.pojo.Blog;
import com.maruiya.pojo.Tag;
import com.maruiya.pojo.TimeLine;
import com.maruiya.pojo.User;
import com.maruiya.service.BlogService;
import com.maruiya.service.TagService;
import com.maruiya.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;


/**
 * @Author MaRuiYa
 */
@Controller
@RequestMapping("/maruiya")
public class WebPageController {

    @Autowired
    BlogService blogService;
    @Autowired
    TagService tagService;
    @Autowired
    TimeLineService timeLineService;

    @GetMapping({"/index", "/index.html"})
    public String index(Model model){
        List<Blog> hotBlogs = blogService.queryBlogToShowHot();
        model.addAttribute("hotBlogs", hotBlogs);
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        List<Blog> blogs = blogService.queryBlogsToShow();
        List<Blog> hotBlogs = blogService.queryBlogToShowHot();
        List<Tag> tags = tagService.queryTags();
        model.addAttribute("blogs", blogs);
        model.addAttribute("tags", tags);
        model.addAttribute("hotBlogs", hotBlogs);
        return "blog";
    }
    @GetMapping("/filling")
    public String filling(Model model){
        model.addAttribute("timelines", TimeLineByTypeUtil.getTimeLineByType(timeLineService.queryTimeLines()));
        return "filling";
    }
    @GetMapping("/link")
    public String link(){
        return "link";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable String id, Model model){
        Blog blog = blogService.queryBlogToShowById(id);
        System.out.println(blog);
        blogService.addViewNum(blog.getId());
        model.addAttribute("blog", blog);
        return "read";
    }
}

@Controller
class IndexController{

    @Autowired
    BlogService blogService;

    @GetMapping({"/", "/index", "/index.html", "/maruiya"})
    public String index(Model model){
        List<Blog> hotBlogs = blogService.queryBlogToShowHot();
        model.addAttribute("hotBlogs", hotBlogs);
        return "index";
    }
}
