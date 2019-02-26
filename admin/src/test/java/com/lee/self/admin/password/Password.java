package com.lee.self.admin.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName Password
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/25 11:50
 */
public class Password {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
    }
}
