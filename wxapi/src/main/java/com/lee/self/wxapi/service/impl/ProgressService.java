package com.lee.self.wxapi.service.impl;

import com.lee.self.common.result.JsonResult;
import com.lee.self.core.dao.ProgressReposity;
import com.lee.self.wxapi.service.IProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProgressService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/24 11:32
 */
@Service
public class ProgressService implements IProgressService {

    @Autowired
    private ProgressReposity progressReposity;

    @Override
    public JsonResult listAll() {
        return JsonResult.data(progressReposity.findAll());
    }
}
