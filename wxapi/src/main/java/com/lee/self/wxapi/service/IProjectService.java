package com.lee.self.wxapi.service;

import com.lee.self.common.result.JsonResult;
import springfox.documentation.spring.web.json.Json;

/**
 * @ClassName ProjectService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/24 11:43
 */
public interface IProjectService {
    JsonResult getAll();
    JsonResult getById(Integer id);
}
