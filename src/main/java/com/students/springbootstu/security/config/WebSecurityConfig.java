package com.students.springbootstu.security.config;

import com.students.springbootstu.configuration.SwaggerConfig;
import com.students.springbootstu.security.handler.MyAuthenctiationFailureHandler;
import com.students.springbootstu.security.handler.MyAuthenticationSuccessHandler;
import com.students.springbootstu.security.handler.MyLoginUrlAuthenticationEntryPoint;
import com.students.springbootstu.security.handler.MyLogoutSuccessHandler;
import com.students.springbootstu.security.service.MyUserDetailService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * web相关安全配置
     */

    @Autowired
    //配置属性类
    private SecurityProperties securityProperties;

    @Autowired
    //用户账号权限验证类
    private MyUserDetailService myUserDetailService;

    @Autowired
    //注销成功处理器
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    //成功验证处理器
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //loginPage("/testlogin") 相当于一个普通请求。这里则需要发送到登陆页面
        //loginProcessingUrl("/login") 登陆页面表单提交的action.必须为post请求
        //defaultSuccessUrl("/index") 登陆成功后，发送这个请求
       http
               .authorizeRequests()
               //设置匿名访问的url
               .antMatchers(securityProperties.getAnonymous()).permitAll()
               //所有请求都要验证
               .anyRequest().authenticated()
               .and()
               .formLogin()
               //自定义登录页
               .loginPage(securityProperties.getLoginPage())
               .successHandler(myAuthenticationSuccessHandler)
               //用户验证失败处理
               .failureHandler(new MyAuthenctiationFailureHandler(securityProperties.getLoginPage()))
               //自定义登录请求 登录页面表单提交的action.必须为post请求
               .loginProcessingUrl(securityProperties.getLoginProcessingUrl())
               .permitAll()
               .and()
               .logout()
               .logoutSuccessHandler(myLogoutSuccessHandler)
               .permitAll()
               .and()
               .exceptionHandling()
               //自定义认证失败处理器
               .authenticationEntryPoint(new MyLoginUrlAuthenticationEntryPoint(securityProperties.getLoginPage()));



    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        String[] ignoringArray = securityProperties.getIgnoringArray();
        if(swaggerEnable && !StringUtils.isBlank(SwaggerConfig.ACCESS_PREFIX)){
            ignoringArray = ArrayUtils.addAll(ignoringArray,SwaggerConfig.ACCESS_PREFIX.split(","));
        }
        web.ignoring().antMatchers(ignoringArray);
    }

    /**
     * 声明密码加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
                // 配置密码加密方式，也可以不指定，默认就是BCryptPasswordEncoder
    }

}
