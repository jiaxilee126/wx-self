package com.lee.self.admin.controller;

import com.lee.self.admin.service.IBlogService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import com.lee.self.common.vo.ReqBlogVO;
import com.lee.self.common.vo.ReqTypeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BlogController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/16 11:23
 */
@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @RequestMapping("/publish")
    public JsonResult publish(ReqBlogVO blog) {
        log.info("req:publish>reqBlogVO:{}", blog.toString());
        if(blog.validate()){
            return blogService.save(blog);
        }
        return  JsonResult.code(ResultCodeEnum.PARAMETER_ERROR);
    }
}
