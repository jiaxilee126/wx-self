package com.lee.self.wxapi.service.impl;

import com.lee.self.common.result.JsonResult;
import com.lee.self.common.vo.TechVO;
import com.lee.self.core.beans.Tech;
import com.lee.self.core.dao.TechReposity;
import com.lee.self.core.enums.SkillLevelEnum;
import com.lee.self.wxapi.service.ITechService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TechService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/24 11:26
 */
@Service
public class TechService implements ITechService {
    @Autowired
    private TechReposity techReposity;
    @Override
    public JsonResult listAll() {
        List<Tech> teches = techReposity.findAll();
        List<TechVO> techVOS = new ArrayList<>();
        for (Tech tech:teches
             ) {
            TechVO techVO = new TechVO();
            BeanUtils.copyProperties(tech, techVO);
            techVO.setLevel(SkillLevelEnum.valueOf(tech.getLevel()));
            techVOS.add(techVO);
        }
        return JsonResult.data(techVOS);
    }
}
