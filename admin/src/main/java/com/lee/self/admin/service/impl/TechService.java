package com.lee.self.admin.service.impl;

import com.lee.self.admin.service.ITechService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.common.vo.TechVO;
import com.lee.self.core.beans.Tech;
import com.lee.self.core.dao.TechReposity;
import com.lee.self.core.enums.SkillLevelEnum;
import com.qiniu.util.Json;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TechService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 16:50
 */
@Service
public class TechService implements ITechService {
    @Autowired
    private TechReposity techReposity;

    @Override
    public List<TechVO> getAll() {
        List<Tech> teches = techReposity.findAll();
        List<TechVO> techVOS = new ArrayList<>();
        for (Tech tech:teches
                ) {
            TechVO techVO = new TechVO();
            BeanUtils.copyProperties(tech, techVO);
            techVO.setLevel(SkillLevelEnum.valueOf(tech.getLevel()));
            techVOS.add(techVO);
        }
       return  techVOS;
    }

    @Override
    public JsonResult add(Tech tech) {
        techReposity.save(tech);
        return JsonResult.ok();
    }

    @Override
    public JsonResult update(Tech tech) {
        techReposity.saveAndFlush(tech);
        return JsonResult.ok();
    }

    @Override
    public List<TechVO> findRecent() {
        List<Tech> teches = techReposity.findRecent(10);
        List<TechVO> techVOS = new ArrayList<>();
        for (Tech tech:teches
                ) {
            TechVO techVO = new TechVO();
            BeanUtils.copyProperties(tech, techVO);
            techVO.setLevel(SkillLevelEnum.valueOf(tech.getLevel()));
            techVOS.add(techVO);
        }
        return  techVOS;
    }
}
