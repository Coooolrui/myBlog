package com.maruiya.service;

import com.maruiya.mapper.UserMapper;
import com.maruiya.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 */
@Service
public class UserServiceImp implements UserDetailsService, UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUser(username); //获得用户
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        //权限列表
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        System.out.println(user.getRole());
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public User getUserToShow(String username) {
        return userMapper.getUserToShow(username);
    }
}
