package com.lee.self.wxapi.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.lee.self.common.result.JsonResult;
import com.lee.self.wxapi.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

/**
 * @ClassName BlogController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/23 17:08
 */
@RestController
@RequestMapping("blog")
@Api("博文查询接口")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询博文", notes = "查询数据库中某个学生的信息")
    @ApiImplicitParam(name = "id", value = "博文id", paramType = "path", required = true, dataType = "Integer")
    public JsonResult getById(@PathVariable("id") Integer id) {
        return  blogService.getById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有的博文")
    public JsonResult getAll() {
        return  blogService.getAll();
    }

}
