package com.lee.self.user.client;

import com.lee.self.common.result.JsonResult;
import com.lee.self.user.beans.User;
import com.lee.self.user.vo.ReqUserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserClientTest {

   @Autowired
    private UserClient userClient;

    @Test
    public void regetisy() {
        ReqUserVO userVO = new ReqUserVO();
        userVO.setUsername("lijiaxi");
        userVO.setPassword("12234");
        JsonResult jsonResult = userClient.login(userVO);
    }

    @Test
    public void findByName() {
        User user = userClient.getByUsername("zhangsan");
        System.out.println(user.getPassword());
    }
}