package com.lee.self.admin.controller;

import com.lee.self.admin.service.ITechService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import com.lee.self.common.vo.ReqTechVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TechController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 16:48
 */
@RestController
@RequestMapping("/tech")
@Slf4j
public class TechController {

    @Autowired
    private ITechService techService;

    @RequestMapping("/add")
    public JsonResult add(ReqTechVO techVO) {
        log.info("Req-ReqTechVo_>{}", techVO);
        if(techVO.volidate())
            return techService.add(techVO);
        return  JsonResult.code(ResultCodeEnum.PARAMETER_ERROR);
    }
}
