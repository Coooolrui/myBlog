package com.maruiya.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author MaRuiYa
 */
@Controller
public class LoginController {

    @GetMapping("/toLogin")
    public String login(){
        return "admin/login";
    }

//    @PostMapping("/loginPush")
//    public String loginPush(User user){
//        System.out.println(user.getUsername()+user.getPassword());
//        String pw = userService.getUser(user.getUsername());
//        System.out.println(pw);
//        System.out.println(MD5Util.getMD(user.getPassword()));
//        if (MD5Util.getMD(user.getPassword()).equals(pw)){
//            System.out.println("登录成功");
//            return "forward:/admin123/blogList";
//        }else{
//            System.out.println("登录失败");
//            return "forward:/admin123/login";
//        }
////        return MD5Util.getMD(user.getPassword()).equals(pw);
//    }
}
