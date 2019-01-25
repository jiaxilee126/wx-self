package com.lee.self.wxapi.controller;

import com.lee.self.common.result.JsonResult;
import com.lee.self.wxapi.service.IProgressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProgressController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/24 11:31
 */
@RestController
@Api("人生历程接口")
@RequestMapping("progress")
public class ProgressController {
    @Autowired
    private IProgressService progressService;

    @GetMapping("/all")
    @ApiOperation("获取所有的人生历程")
    public JsonResult getAll() {
        return progressService.listAll();
    }

}
