package com.lee.self.wxapi.controller;

import com.lee.self.common.result.JsonResult;
import com.lee.self.user.client.UserClient;
import com.lee.self.user.vo.ReqUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/27 17:10
 */
@Controller
@Slf4j
public class TestController {
    @Autowired
    private UserClient userClient;

    @RequestMapping("/passport")
    public JsonResult login(ReqUserVO reqUserVO) {
        log.info("reqUserVO----->{}", reqUserVO.toString());
        return userClient.login(reqUserVO);
    }
}
