package com.lee.self.admin.client;

import com.lee.self.common.result.JsonResult;
import com.lee.self.common.vo.ReqBlogVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName AdminClient
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/21 16:36
 */
@FeignClient(value = "admin")
public interface AdminClient {

    @RequestMapping("/blog/publish")
    public JsonResult publish(ReqBlogVO blog) ;
}
