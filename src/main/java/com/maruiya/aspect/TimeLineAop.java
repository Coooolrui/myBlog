package com.maruiya.aspect;

import com.maruiya.Util.DateToStringUtil;
import com.maruiya.pojo.Blog;
import com.maruiya.pojo.TimeLine;
import com.maruiya.service.BlogService;
import com.maruiya.service.TimeLineService;
import com.maruiya.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * @Author MaRuiYa
 */
@Component
@Aspect
public class TimeLineAop {

    @Autowired
    TimeLineService timeLineService;

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @Before("execution (* com.maruiya.controller.admin.BlogController.addBlog(..))")
    public void beforeAdd(JoinPoint joinPoint){
        TimeLine timeLine = new TimeLine();
        List<Object> result = Arrays.asList(joinPoint.getArgs());

        System.out.println(result);

        Blog blog = (Blog) result.get(0);

        //设置userid
        Principal principal = (Principal) result.get(1);
        blog.setUserId(userService.getUser(principal.getName()).getId());

        if (blog.getId().equals("")){
            timeLine.setDescription("欢迎《"+blog.getTitle()+"》的到来");
        }else {
            timeLine.setDescription("《"+blog.getTitle()+"》"+"更加完善啦！");
        }
        timeLine.setId(DateToStringUtil.getDateString());
        timeLine.setUserId(blog.getUserId());

        timeLineService.addTimeLine(timeLine);
        System.out.println("加入时间线");
    }

    @Before("execution (* com.maruiya.controller.admin.BlogController.saveBlog(..))")
    public void beforeSave(JoinPoint joinPoint){
        TimeLine timeLine = new TimeLine();
        List<Object> result = Arrays.asList(joinPoint.getArgs());

        Blog blog = (Blog) result.get(0);

        //设置userid
        Principal principal = (Principal) result.get(1);
        blog.setUserId(userService.getUser(principal.getName()).getId());

        timeLine.setDescription("将《"+blog.getTitle()+"》保存为草稿");

        timeLine.setId(DateToStringUtil.getDateString());
        timeLine.setUserId(blog.getUserId());

        timeLineService.addTimeLine(timeLine);
        System.out.println("加入时间线");
    }



    @Before("execution (* com.maruiya.controller.admin.BlogController.delete(..))")
    public void beforeDelete(JoinPoint joinPoint){
        TimeLine timeLine = new TimeLine();
        List<Object> result = Arrays.asList(joinPoint.getArgs());

        Blog blog = blogService.queryBlogById((String) result.get(0));

        timeLine.setDescription("《"+blog.getTitle()+"》"+"和大家说拜拜啦！");
        timeLine.setId(DateToStringUtil.getDateString());
        timeLine.setUserId(blog.getUserId());

        timeLineService.addTimeLine(timeLine);
        System.out.println("加入时间线");
    }

}
