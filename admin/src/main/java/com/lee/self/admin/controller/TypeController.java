package com.lee.self.admin.controller;

import com.lee.self.admin.service.ITypeService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import com.lee.self.common.vo.ReqTypeVO;
import com.lee.self.core.beans.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TypeController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 11:58
 */
@RestController
@Slf4j
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @RequestMapping("/type/add")
    public JsonResult add(ReqTypeVO type) {
        log.info("req_TypeControll:type_>{}",type.toString());
        if(type.volidate()){
            return typeService.add(type);
        }else {
            return JsonResult.code(ResultCodeEnum.PARAMETER_ERROR);
        }
    }
}
