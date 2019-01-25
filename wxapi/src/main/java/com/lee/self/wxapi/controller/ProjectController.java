package com.lee.self.wxapi.controller;

import com.lee.self.common.result.JsonResult;
import com.lee.self.wxapi.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/24 11:51
 */
@Api("项目经历接口")
@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @ApiOperation("获取所有项目的简介列表")
    @GetMapping("/all")
    public JsonResult getAll() {
        return projectService.getAll();
    }

    @GetMapping("{/id}")
    @ApiOperation("根据id获取项目具体内容")
    @ApiImplicitParam(name = "id", value = "项目id", paramType = "query", required = true, dataType = "Integer")
    public JsonResult getById(Integer id) {
        return projectService.getById(id);
    }

}
