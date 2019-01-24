package com.lee.self.wxapi.service;

import com.lee.self.common.result.JsonResult;

public interface IBlogService {
    JsonResult getById(Integer id);
    JsonResult getAll();
}
