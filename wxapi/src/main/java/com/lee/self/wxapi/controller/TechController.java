package com.lee.self.wxapi.controller;

import com.lee.self.common.result.JsonResult;
import com.lee.self.wxapi.service.ITechService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TechController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/24 11:24
 */
@RestController
@RequestMapping("tech")
@Api("技能查询接口")
public class TechController {

    @Autowired
    private ITechService techService;

    @GetMapping("/all")
    @ApiOperation("获取所有的技能接口")
    public JsonResult getAll(){
        return  techService.listAll();
    }
}
