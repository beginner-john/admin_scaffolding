package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.entity.model.SystemRole;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/31 15:41
 */
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Iterator<SystemRole> iterator =  user.getRoleList().iterator();
        while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next().getRoleCode()));
        }
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),collection);
    }
}
