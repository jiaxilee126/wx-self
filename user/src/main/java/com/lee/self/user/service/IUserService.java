package com.lee.self.user.service;

import com.lee.self.common.result.JsonResult;
import com.lee.self.user.beans.User;
import com.lee.self.user.vo.ReqUserVO;

public interface IUserService {

    JsonResult login(ReqUserVO userVO);
    JsonResult list();

    User findByUsername(String username);
}
