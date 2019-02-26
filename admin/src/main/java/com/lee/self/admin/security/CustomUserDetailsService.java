package com.lee.self.admin.security;

import com.lee.self.user.beans.User;
import com.lee.self.user.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CustomUserDetailsService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/25 8:31
 */
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            log.info("yonghumin不存在。。。。。。。。。。。。。。");
            throw new UsernameNotFoundException("用户名不存在");

        }
        User user = userClient.getByUsername(username);
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword("$2a$10$9tigYrYX69lNyGkpYYc84.K6vZCS9nEeWEqEJqt/L5jrGlYC7XsPu");
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        return new CustomSecurityUser(username, user.getPassword(),
                true, // 是否可用
                true, // 是否过期
                true, // 证书不过期为true
                true, // 账户未锁定为true
                authorities,user.getUsername());

    }
}
