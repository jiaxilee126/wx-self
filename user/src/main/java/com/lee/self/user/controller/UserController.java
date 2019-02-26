package com.lee.self.user.controller;

import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import com.lee.self.user.beans.User;
import com.lee.self.user.service.IUserService;
import com.lee.self.user.vo.ReqUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/19 8:37
 */
@RestController
@RequestMapping("/user")
@Api("用户接口")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

 /*   @PostMapping("/login")
    @ApiOperation(value = "用户登录接口", notes = "用户名密码登录")
    //@ApiImplicitParam(name = "reqUserVO", value = "登录请求", required = true, dataType = "ReqUserVO", paramType = "body")
    public JsonResult login(@ModelAttribute ReqUserVO reqUserVO) {
        log.info("Req_ReqUsrVo_>:{}", reqUserVO.toString());
        if(reqUserVO.volidate()) {
            return userService.login(reqUserVO);
        }
        return JsonResult.code(ResultCodeEnum.PARAMETER_ERROR);
    }*/
    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口", notes = "用户名密码登录")
    @ApiImplicitParam(name = "reqUserVO", value = "登录请求", required = true, dataType = "ReqUserVO", paramType = "body")
    public JsonResult login (@RequestBody ReqUserVO reqUserVO) {
        log.info("Req_ReqUsrVo_>:{}", reqUserVO.toString());
        if(reqUserVO.volidate()) {
            return userService.login(reqUserVO);
        }
        return JsonResult.code(ResultCodeEnum.PARAMETER_ERROR);
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有用户列表")
    public JsonResult list() {
        log.info("req_all");
        return userService.list();
    }

    @GetMapping("/username")
    @ApiOperation(value = "根据用户名获取用户信息", notes = "用户名获取用户信息")
    @ApiImplicitParam(name = "username", value = "用户信息请求", required = true, dataType = "String", paramType = "path")
    public User getByUsername(String username) {
        return userService.findByUsername(username);
    }
}
