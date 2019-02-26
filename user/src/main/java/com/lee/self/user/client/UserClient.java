package com.lee.self.user.client;

import com.lee.self.common.result.JsonResult;
import com.lee.self.user.beans.User;
import com.lee.self.user.vo.ReqUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserClient
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/19 10:16
 */
@FeignClient(value = "user")
        //, fallback = UserClient.UserClientFallback.class)
public interface UserClient {

    @PostMapping("/user/login")
    public JsonResult login(ReqUserVO reqUserVO);

    @GetMapping("/user/all")
    public JsonResult list();

    @GetMapping("/user/username")
    public User getByUsername(@RequestParam("username") String username);


   /* static class UserClientFallback implements UserClient{
        @Override
        public JsonResult login(ReqUserVO reqUserVO) {
            return null;
        }

        @Override
        public JsonResult list() {
            return null;
        }
    }*/
}
