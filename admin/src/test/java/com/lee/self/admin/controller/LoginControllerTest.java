package com.lee.self.admin.controller;

import com.lee.self.common.result.JsonResult;
import com.lee.self.user.client.UserClient;
import com.lee.self.user.vo.ReqUserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoginControllerTest {

    @Autowired
    private UserClient userClient;

    @Test
    public void registor() {

        ReqUserVO userVO = new ReqUserVO();
        userVO.setUsername("lijiaxi");
        userVO.setPassword("12234");
        JsonResult jsonResult = userClient.login(userVO);
        log.info("result --->{}" ,jsonResult.toString());

        System.out.println(userClient);
    }

}