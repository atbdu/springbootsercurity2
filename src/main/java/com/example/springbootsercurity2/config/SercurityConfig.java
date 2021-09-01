package com.example.springbootsercurity2.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll() //所有人都可以访问
                .antMatchers("/toIndex").hasRole("vip1")
                .and().formLogin().usernameParameter("zhangsan").passwordParameter("123456").successForwardUrl("/tologin"); //VIP1角色的人才可以访问
        //如果没有权限的话，会跳转到登录页面
        http.formLogin();
    }

    //认证的

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Rose").password("123456").roles("vip1");
    }
}
