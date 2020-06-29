package com.students.springbootstu.security.service;

import com.students.springbootstu.entity.TbStudent;
import com.students.springbootstu.entity.TbStupwd;
import com.students.springbootstu.service.TbStudentService;
import com.students.springbootstu.service.TbStupwdService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private TbStupwdService tbStupwdService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //username要对应html里面的表单提交name
        TbStupwd user = tbStupwdService.queryByStuAccount(username);

        if(user == null){
            throw new UsernameNotFoundException("userName not found");
        }
        //创建一个集合来放置权限
        Collection<GrantedAuthority> authorities = getAuthorities(user);
        //实例化一个userDetails对象
        UserDetails userDetails = new User(username, user.getStupwd(), true,true,true,true, authorities);

        return userDetails;
    }

    private Collection<GrantedAuthority> getAuthorities(TbStupwd user){
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        //注意：这里每个权限前面都要加ROLE_。否在最后验证不会通过
        authList.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
        return authList;
    }

}
