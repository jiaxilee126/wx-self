package com.lee.self.user.service.impl;

import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import com.lee.self.user.beans.User;
import com.lee.self.user.dao.UserReposity;
import com.lee.self.user.service.IUserService;
import com.lee.self.user.vo.ReqUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/19 11:11
 */
@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserReposity userReposity;

    @Override
    public JsonResult login(ReqUserVO userVO) {
        User old = userReposity.findByName(userVO.getUsername());
        if(old == null || !old.getPassword().equals(userVO.getPassword())) {
            return JsonResult.code(ResultCodeEnum.USERNAME_PASSWORD_MISMATCH);
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult list() {
        List<User> users = userReposity.findAll();
        log.info("users------>LENGTH==========="+users.size());
        return JsonResult.data(users);
    }

    @Override
    public User findByUsername(String username) {
        return  userReposity.findByName(username);
    }
}
