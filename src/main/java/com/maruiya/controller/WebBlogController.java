package com.maruiya.controller;

import com.maruiya.pojo.Blog;
import com.maruiya.service.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Author MaRuiYa
 */
@Controller
@RequestMapping("/maruiya")
public class WebBlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/search")
    public String search(@Param("key") String key, Model model){
        System.out.println("搜索的关键字是："+key);
        model.addAttribute("blogs", blogService.queryBlogToShowBykey(key));
        return "blog::article";
    }

}
