package com.lee.self.gateway.controller;

import com.lee.self.common.result.JsonResult;
import com.lee.self.user.client.UserClient;
import com.lee.self.user.vo.ReqUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/19 16:35
 */
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private UserClient userClient;

    @RequestMapping("/passport")
    public JsonResult login(ReqUserVO reqUserVO) {
        return userClient.login(reqUserVO);
    }


}
