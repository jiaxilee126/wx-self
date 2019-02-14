package com.lee.self.admin.controller;

import com.lee.self.admin.service.ITypeService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.core.beans.Type;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TypeController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 11:58
 */
@RestController
public class TypeController {

    private ITypeService typeService;

    @RequestMapping("/type/add")
    public JsonResult add(Type type) {
        return  typeService.add(type);
    }
}
