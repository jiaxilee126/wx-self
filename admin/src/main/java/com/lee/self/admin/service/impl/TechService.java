package com.lee.self.admin.service.impl;

import com.lee.self.admin.service.ITechService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import com.lee.self.common.vo.ReqTechVO;
import com.lee.self.common.vo.TechVO;
import com.lee.self.core.beans.Tech;
import com.lee.self.core.dao.TechReposity;
import com.lee.self.core.enums.SkillLevelEnum;
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

    @Autowired
    private QiniuService qiniuService;

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
    public JsonResult add(ReqTechVO techVO) {
        String icon = qiniuService.uploadImg(techVO.getFile()).getData().toString();
        Tech old = techReposity.findByTitle(techVO.getTitle());
        if(old != null)
            return JsonResult.code(ResultCodeEnum.NAME_EXIST);
        if(org.springframework.util.StringUtils.isEmpty(icon))
            return JsonResult.code(ResultCodeEnum.QINIU_EXECPTION);

        Tech tech = new Tech();
        tech.setContent(techVO.getDescription());
        tech.setIcon(icon);
        tech.setTitle(techVO.getTitle());
        tech.setLevel(techVO.getLevel());
        tech.setStatus(techVO.isStatus());

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
