package com.lee.self.user.client;

import com.lee.self.common.result.JsonResult;
import com.lee.self.user.vo.ReqUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserClient
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/19 10:16
 */
@FeignClient(value = "userClient", fallback = UserClient.UserClientFallback.class)
public interface UserClient {

    @PostMapping("/user/login")
    public JsonResult login(ReqUserVO reqUserVO);

    @GetMapping("/user/all")
    public JsonResult list();

    static class UserClientFallback implements UserClient{
        @Override
        public JsonResult login(ReqUserVO reqUserVO) {
            return null;
        }

        @Override
        public JsonResult list() {
            return null;
        }
    }
}
