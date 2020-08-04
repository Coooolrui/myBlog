package com.maruiya.config;

import com.maruiya.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author MaRuiYa
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceImp userServiceImp;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/maruiya/**").permitAll()
                .antMatchers("/admin123/**").authenticated()
//                .antMatchers("/admin123/**").hasRole("ROLE_ADMIN")
                .and()
                .formLogin()
                .loginPage("/toLogin")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/admin123/blogList")
                .failureUrl("/toLogin")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/maruiya/blog")
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .sessionManagement()
                .invalidSessionUrl("/maruiya/blog");
        http.csrf().disable();
    }
//
//    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("maruiya").password(new BCryptPasswordEncoder().encode("123456")).roles("maruiya");
        auth.userDetailsService(userServiceImp).passwordEncoder(new BCryptPasswordEncoder());
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder();
        //加密"123"
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }
}
